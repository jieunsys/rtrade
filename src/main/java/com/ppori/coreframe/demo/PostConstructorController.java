package com.ppori.coreframe.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class PostConstructorController {
	
	@PostConstruct
	public void post1() {
		System.out.println("########################## post1()");
		
	}
	
	@PreDestroy
	public void re1() {
		System.out.println("########################## pre1()");
	}
}
