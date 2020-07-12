package com.example.demo.contract.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.contract.model.Contact;

public interface ContactRepository extends MongoRepository<Contact, String>{
	Contact findBy_id(ObjectId _id);
}
