package com.gnsym.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gnsym.entity.ResponseBody;

@RestController
public class ServiceFallbackController {
	@GetMapping(path = "/customer")
	ResponseEntity<ResponseBody<String>> getCustomerFallbackHandler() {

		ResponseBody<String> responseBody = new ResponseBody<String>();
		responseBody.setStatusCode(404);
	    responseBody.setMessage("Error! Customer-Service is not working.");
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);

	}
	
	@PostMapping(path = "/customer")
	ResponseEntity<ResponseBody<String>> getCustomerFallbackPostHandler() {

		ResponseBody<String> responseBody = new ResponseBody<String>();
		responseBody.setStatusCode(404);
	    responseBody.setMessage("Error! Customer-Service is not working.");
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);

	}
	
	@PostMapping(path = "/transaction-fallback")
	ResponseEntity<ResponseBody<String>> getTransactionFallbackPostHandler() {

		ResponseBody<String> responseBody = new ResponseBody<String>();
		responseBody.setStatusCode(404);
	    responseBody.setMessage("Error! Transaction-Service is not working.");
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);

	}	
	
}
