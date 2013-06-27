package com.training.architecture.java.business.service.impl;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.WebServiceContext;

import com.training.architecture.java.business.service.OrderProcess;
import com.training.architecture.java.domain.to.Order;

@WebService(serviceName = "OrderProcessService", portName = "OrderProcessPort", 
		name = "OrderProcess", endpointInterface = "com.training.architecture.java.business.service.OrderProcess")
@SOAPBinding(style=Style.DOCUMENT, parameterStyle=ParameterStyle.BARE)
public class OrderProcessImpl implements OrderProcess {

	@Resource
	private WebServiceContext wsc;
	
	@WebMethod
	public String processOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}
