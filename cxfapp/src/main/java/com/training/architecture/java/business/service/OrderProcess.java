package com.training.architecture.java.business.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.training.architecture.java.domain.to.Order;

@WebService
public interface OrderProcess {

	@WebMethod
	String processOrder(Order order);
}
