package com.mycompany.hr.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import com.mycompany.hr.service.HumanResourceService;
import com.training.architecture.java.ws.domain.HolidayRequest;
import com.training.architecture.java.ws.domain.HolidayType;

@Endpoint
public class HumanResourceEndpoint  {

	@Autowired
	private HumanResourceService humanResourceService;
	
	private static final String NAMESPACE_URI = "http://mycompany.com/hr/schemas";
	
	private final static Logger logger = LoggerFactory.getLogger(HumanResourceEndpoint.class);
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="HolidayRequest")
	public void handleHolidayRequest(@RequestPayload HolidayRequest holidayRequest){
		logger.info("HolidayRequest ========= " +holidayRequest);
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="SecondRequest")
	public void handleHolidayRequestTwo(@RequestPayload HolidayType holidayType){
		logger.debug("HolidayRequest ========= " +holidayType);
	}
}
