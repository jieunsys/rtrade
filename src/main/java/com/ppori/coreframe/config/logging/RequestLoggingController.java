package com.ppori.coreframe.config.logging;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RequestLoggingController {
	
	@RequestMapping(path="/loggingDemo1", method=RequestMethod.POST)
	public String loggingDemo(@RequestBody String reqBody) {
		log.info("########## CONTROLLER REQ = " + reqBody);
		
		String resBody = "NEW_RESPONSE_CREATED";
		
		log.info("########## CONTROLLER_RES = " + resBody);
		
		return resBody;
	}
}
