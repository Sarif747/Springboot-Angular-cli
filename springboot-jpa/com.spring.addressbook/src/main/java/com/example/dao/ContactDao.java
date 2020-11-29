package com.example.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Contact;

@Repository
public interface ContactDao extends JpaRepository<Contact, Integer> {

	
 	 
	}

	
