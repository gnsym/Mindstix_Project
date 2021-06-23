package com.gnsym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnsym.entity.ResponseBody;
import com.gnsym.entity.TransactionMaster;
import com.gnsym.service.TransactionService;

@RestController
public class MainController {
	@Autowired
	TransactionService transactionService;

	@PostMapping("transaction")
	ResponseEntity<ResponseBody<TransactionMaster>> addTransaction(@RequestBody TransactionMaster transactionMaster){
		ResponseBody< TransactionMaster> responseBody=new ResponseBody<TransactionMaster>();
		if (transactionMaster == null) {
			responseBody.setStatusCode(404);
			responseBody.setMessage("Error! request can not be null.");
		} else {
			responseBody=transactionService.saveData(transactionMaster);			
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}
}
