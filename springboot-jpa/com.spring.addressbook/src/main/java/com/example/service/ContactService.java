package com.example.service;

import java.util.List;
import com.example.model.Contact;


public interface ContactService {

	 List<Contact> getAllContacts();
	 Contact getContactById(int id);
	 void addContact(Contact contact);
	 void updateContact(Contact contact, int id);
	 void deleteContact(int id);
	
}
