package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.ContactDao;
import com.example.model.Contact;

public class ContactServiceImp implements ContactService {
	
	 @Autowired
	 private ContactDao cantactDao;
	 
	 @Override
	 public List<Contact> getAllContacts() {
	  return cantactDao.findAll();
	 }
	 @Override
	 public Contact getContactById(int id) {
	  return cantactDao.getOne(id);
	 }
	 @Override
	 public void addContact(Contact contact) {
	 }

	 @Override
	 public void updateContact(Contact contact, int id) {
		 cantactDao.save(contact);
	 }

	 @Override
	 public void deleteContact(int id) {
		 cantactDao.deleteById(id);
	 }
	 
	}
