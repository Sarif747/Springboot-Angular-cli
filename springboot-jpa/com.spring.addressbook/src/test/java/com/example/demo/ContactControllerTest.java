package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import com.example.model.Contact;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllContacts() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/contacts",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetContactById() {
		Contact employee = restTemplate.getForObject(getRootUrl() + "/contacts/1", Contact.class);
		System.out.println(employee.getFirstname());
		assertNotNull(employee);
	}

	@Test
	public void testCreateContact() {
		Contact contact = new Contact();
		contact.setEmailid("admin@gmail.com");
		contact.setFirstname("Arif");
		contact.setLastname("Shaik");

		ResponseEntity<Contact> postResponse = restTemplate.postForEntity(getRootUrl() + "/contacts", contact, Contact.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateContact() {
		int id = 1;
		Contact contact = restTemplate.getForObject(getRootUrl() + "/contacts/" + id, Contact.class);
		contact.setFirstname("Arif1");
		contact.setLastname("Shaik1");

		restTemplate.put(getRootUrl() + "/contacts/" + id, contact);

		Contact updatedContact = restTemplate.getForObject(getRootUrl() + "/contacts/" + id,Contact.class);
		assertNotNull(updatedContact);
	}

	@Test
	public void testDeleteContact() {
		int id = 2;
		Contact contact = restTemplate.getForObject(getRootUrl() + "/contacts/" + id, Contact.class);
		assertNotNull(contact);

		restTemplate.delete(getRootUrl() + "/contacts/" + id);

		try {
			contact = restTemplate.getForObject(getRootUrl() + "/contacts/" + id,Contact.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}

