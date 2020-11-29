package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import com.example.model.Contact;
import com.example.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping({"/api"})
public class ContactController 
{

	@Autowired
	 private ContactService contactService;
	 	 
	
	 @RequestMapping("/addNewContact")
	 public void addNewContact(Model model) {
	  model.addAttribute("employee",new Contact());
	 }
	 
	 
	 @RequestMapping("/addContactDetails")
	 public void addContactDetails(@ModelAttribute("contact") Contact contact, BindingResult result, Model model){
	  
	  if(result.hasErrors()){
		model.addAttribute("successMsg", "Data is incorrect");
	  }
	  else{
	   contactService.addContact(contact);
	   model.addAttribute("successMsg", "Data Inserted Successfully");
	  }
	 }
	 
	  @RequestMapping("/getAllContacts")
	  public void getContactList(Model model) {
	  List<Contact> contactList = new ArrayList<Contact>();
	  contactList= contactService.getAllContacts();
	  model.addAttribute("contactList",contactList);
	 }
	 
	 @RequestMapping(value="/contact", method=RequestMethod.GET)
	  public void Contact(Model model, @RequestParam("id") int id) {
	  Contact contact  = contactService.getContactById(id);
	  model.addAttribute("contactData",contact);
	 
	 }
	 
	 @RequestMapping("/updateContact")
	  public void updateContact(Model model, @RequestParam("id") int id) {
      Contact contact = contactService.getContactById(id);
	  model.addAttribute("contactDetails", contact);
	 } 
	 @RequestMapping("/updateContactDetails")
	 public void updateContactDetail(@ModelAttribute("contact") Contact contact, BindingResult result, Model model){ 
	  if(result.hasErrors()){
	  model.addAttribute("successMsg", "Contact details are incorrect or data already exits");
	  }
	  else{
	   contactService.updateContact(contact, contact.getId());
	   model.addAttribute("successMsg", "Contact Updated Successfully");   

	  }
	 }
	 
	  @RequestMapping("/deleteContact")
	  public void deleteContact(Model model, @RequestParam("id") int id) {
	  contactService.deleteContact(id);
	  model.addAttribute("successMsg", "Contact Deleted Successfully");
	 
	 } 
	}	