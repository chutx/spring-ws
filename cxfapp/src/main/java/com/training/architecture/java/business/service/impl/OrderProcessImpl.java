package com.training.architecture.java.business.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.training.architecture.java.business.service.OrderProcess;
import com.training.architecture.java.domain.to.Order;

@WebService
public class OrderProcessImpl implements OrderProcess {

	@WebMethod
	public String processOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}
