package com.example.demo.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerDemo {

	
	public static List<Customer> getSortedList(List<Customer> CustList) {
	    return CustList.stream().sorted(Comparator.comparing(Customer::getLastName)).collect(Collectors.toList());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Customer> c=new ArrayList<Customer>();
		Customer c1= new Customer("9", "jashan", "sidhu");
		Customer c2= new Customer("10", "jashan", "gupta");
		Customer c3= new Customer("11", "jashan", "deep");

		c.add(c1);
		c.add(c2);
		c.add(c3);
		getSortedList(c).forEach(System.out::println);;
		
	}

}
