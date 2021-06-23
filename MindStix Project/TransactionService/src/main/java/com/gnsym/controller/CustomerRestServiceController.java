package com.gnsym.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gnsym.entity.Customer;
import com.gnsym.entity.ResponseBody;

@FeignClient("customer-service")
public interface CustomerRestServiceController {
	
	@GetMapping(path = "/customer/{email}")
	ResponseBody<Customer> getCustomer(@PathVariable("email") String email);		
	

}
