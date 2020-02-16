package com.example.demo.model;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CustomerInterface extends MongoRepository<Customer, String>{
	public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
   
}
