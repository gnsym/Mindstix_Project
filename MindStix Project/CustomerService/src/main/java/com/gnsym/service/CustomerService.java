package com.gnsym.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnsym.entity.Customer;
import com.gnsym.entity.ResponseBody;
import com.gnsym.entity.TransactionMaster;
import com.gnsym.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	public Customer getUserByEmail(String email) {
		Optional<Customer> data = customerRepository.findByEmail(email);
		if (data.isPresent())
			return data.get();
		return null;
	}

	public Customer saveData(Customer customer) {
		customer.setBalance(0);
		return customerRepository.save(customer);

	}

	public ResponseBody<Customer> updateBalance(TransactionMaster transactionMaster) {
		Optional<Customer> data = customerRepository.findById(transactionMaster.getAccountId());
		ResponseBody<Customer> responseBody = new ResponseBody<Customer>();
		if (data.isPresent()) {
			String type = transactionMaster.getType().trim().toLowerCase();
			if (type.contains("debit") || type.contains("credit")) {
				Customer customer = data.get();
				if (type.equalsIgnoreCase("debit")) {
					if (customer.getBalance() < transactionMaster.getAmount()) {
						responseBody.setStatusCode(501);
						responseBody.setMessage("Error! account balance is lower than debit amount.");
						responseBody.setResponse(customer);
						return responseBody;
					} else
						customer.setBalance(customer.getBalance() - transactionMaster.getAmount());
				} else if (type.equalsIgnoreCase("credit")) {
					customer.setBalance(customer.getBalance() + transactionMaster.getAmount());
				}
				responseBody.setResponse(customerRepository.save(customer));
				return responseBody;
			} else {
				responseBody.setStatusCode(501);
				responseBody.setMessage("Error! transaction type is not valid.");
				responseBody.setResponse(null);
				return responseBody;
			}
		}

		responseBody.setStatusCode(404);
		responseBody.setMessage("Error! account not exist.");
		return responseBody;

	}

}
