package com.gnsym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnsym.entity.Customer;
import com.gnsym.entity.ResponseBody;
import com.gnsym.entity.TransactionMaster;
import com.gnsym.service.CustomerService;

@RestController
public class MainController {
	@Autowired
	CustomerService customerService;

	@GetMapping(path = "customer/{email}")
	ResponseEntity<ResponseBody<Customer>> getCustomerHandler(@PathVariable("email") String email) {

		ResponseBody<Customer> responseBody = new ResponseBody<Customer>();
		Customer customer = customerService.getUserByEmail(email);
		if (customer == null) {
			responseBody.setStatusCode(404);
			responseBody.setMessage("Error! No customer found with this email.");
		} else {
			responseBody.setStatusCode(0);
			responseBody.setMessage("Success! data found.");
			responseBody.setResponse(customer);
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);

	}
	
	@PostMapping(path = "customer/add")
	ResponseEntity<ResponseBody<Customer>> addCustomerHandler(@RequestBody Customer customer) {

		ResponseBody<Customer> responseBody = new ResponseBody<Customer>();		
		if (customer == null) {
			responseBody.setStatusCode(404);
			responseBody.setMessage("Error! request can not be null.");
		} else {
			customer=customerService.saveData(customer);
			responseBody.setStatusCode(0);
			responseBody.setMessage("Success! Customer added into database.");
			responseBody.setResponse(customer);
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);

	}
	
	
	
	
}
