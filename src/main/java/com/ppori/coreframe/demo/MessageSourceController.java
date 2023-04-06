package com.ppori.coreframe.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name="데모 추가 메시지소스")
@RestController
@Slf4j
public class MessageSourceController {
	@Autowired
	MessageSourceAccessor messageSource;
	
	@GetMapping(value="/customMssageSource")
	public String customMessageSource() {
		
		String value1 = messageSource.getMessage("CODE0002", new String[] {"[바인딩변수A]","[바인딩변수B]"});
		log.info("Code=CODE0002,  Value=" + value1);
		return value1;
	}
}
