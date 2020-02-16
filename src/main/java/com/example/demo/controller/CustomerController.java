package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerInterface;

@Controller
public class CustomerController {

	@Autowired
	CustomerInterface repository;
	
	@ResponseBody
	@RequestMapping("/mongosave")
	public String saveData(@RequestBody Customer customer) {
		repository.save(customer);
		return "saved";
		
	}
	
	@ResponseBody
	@RequestMapping("/mongofind")
	public List<Customer> findData() {
		List<Customer> c=repository.findAll();
		for(Customer c1:c) {
			List<Customer> c2=new ArrayList<Customer>();
			c2.add(c1);
			System.out.println(c2);
		}
		return c;
	}	
	
	@ResponseBody
	@RequestMapping("/mongofindByFirstname")
	public Customer findData1(@RequestParam("firstName") String firstname) {
		return repository.findByFirstName(firstname);
				
	}
	
	@ResponseBody
	@RequestMapping("/mongofindByLastname/{lastName}")
	public List<Customer> findData2(@PathVariable("lastName") String lastname) {
		for(Customer c:repository.findByLastName(lastname)) {
			List<Customer> c2=new ArrayList<Customer>();
			c2.add(c);
			System.out.println(c2);
		}
		return repository.findByLastName(lastname);
				
	}
	
}
