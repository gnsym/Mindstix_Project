package com.gnsym.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gnsym.controller.MainController;
import com.gnsym.entity.TransactionMaster;
import com.gnsym.service.CustomerService;

@Component
public class MessageListener {
		
	@Autowired
	CustomerService customerService;
	
	@RabbitListener(queues = MessageConfigure.TRANSACTION_QUEUE)
	public void listener(TransactionMaster transactionMaster) {
		if(transactionMaster!=null)
		   customerService.updateBalance(transactionMaster);
	}

}
