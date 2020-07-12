package com.example.demo.contract.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.contract.model.Contact;
import com.example.demo.contract.repository.ContactRepository;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	ContactRepository contactRepository;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Contact> getAllContacts(){
		return contactRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Contact getContactById(@PathVariable("id") ObjectId _id){
		return contactRepository.findBy_id(_id);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)  
	public Contact createContact(@Valid @RequestBody Contact contact) {  
	    contact.set_id(ObjectId.get());  
	    contactRepository.save(contact);  
	    return contact;  
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
	public void modifyContact(@Valid @RequestBody Contact contact, @PathVariable("id") ObjectId id) {
		contact.set_id(id);
		contactRepository.save(contact);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)  
	public void deleteContact(@PathVariable ObjectId id) {  
	    contactRepository.delete(contactRepository.findBy_id(id));  
	}
}
