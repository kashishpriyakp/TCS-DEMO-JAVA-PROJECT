package com.tcs.restcontroller;


import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.model.Customer;


@RestController
public class CustomerController {
	
	//This method is returing simple helloworld after hitting the url /helloworld
	@RequestMapping( method = RequestMethod.GET,value = "/helloWorld")
	
		public String helloWorld() {
			
			
			return "Hello World";
		}
		
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/details")
	
	
	
	@ResponseBody
	 public Customer details(){
		//Hard Coded value inside the customer object
		Customer c1=new Customer();
		c1.setCustomerId(101);
		c1.setCustomerName("abc");
		c1.setCustomerAddress("xyz");
			
		
		return c1;
		   
	}

	
	
	
}
