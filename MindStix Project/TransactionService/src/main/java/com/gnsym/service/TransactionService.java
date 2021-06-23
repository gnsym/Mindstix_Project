package com.gnsym.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnsym.config.MessageConfigure;
import com.gnsym.controller.CustomerRestServiceController;
import com.gnsym.entity.Customer;
import com.gnsym.entity.ResponseBody;
import com.gnsym.entity.TransactionMaster;
import com.gnsym.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	CustomerRestServiceController customerRestServiceController;

	@Autowired
	RabbitTemplate rabbitTemplate;

	public ResponseBody<TransactionMaster> saveData(TransactionMaster transactionMaster) {
		ResponseBody<TransactionMaster> responseBody = new ResponseBody<TransactionMaster>();
		Customer customer = getCustomer(transactionMaster.getEmail().trim());
		if (customer != null) {
			String type = transactionMaster.getType().trim().toLowerCase();
			if (type.equalsIgnoreCase("debit")) {
				if (customer.getBalance() < transactionMaster.getAmount()) {
					responseBody.setStatusCode(501);
					responseBody.setMessage("Error! account balance is lower than debit amount.");
					responseBody.setResponse(null);
					return responseBody;
				}

			}
			if (type.contains("debit") || type.contains("credit")) {
				transactionMaster.setAccountId(customer.getAccountId());
				transactionMaster.setEmail(customer.getEmail());
				responseBody.setResponse(transactionRepository.save(transactionMaster));
				responseBody.setStatusCode(0);
				responseBody.setMessage("Success! transation successfully completed.");
				sendTransactionToCustomer(responseBody.getResponse());
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

	private void sendTransactionToCustomer(TransactionMaster response) {
		rabbitTemplate.convertAndSend(MessageConfigure.TRANSACTION_EXCHANGE, MessageConfigure.TRANSACTION_ROUTING,
				response);

	}

	Customer getCustomer(String email) {
		ResponseBody<Customer> responseBody = customerRestServiceController.getCustomer(email);
		/*
		 * ResponseEntity<ResponseBody<Customer>>
		 * responseBody=restTemplate.exchange("http://customer-service/customer/"+email,
		 * HttpMethod.GET, null,new ParameterizedTypeReference<ResponseBody<Customer>>()
		 * { });
		 */
		Customer customer = (Customer) responseBody.getResponse();
		return customer;
	}

}
