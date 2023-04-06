package com.ppori.coreframe.config.logging;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestLoggingClient {

	public static void main2(String[] args) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		
		String json="<<<THIS IS BODY>>>";
		log.info("########## REQUEST = " + json);
		
		HttpEntity<?> entity = new HttpEntity<>(json, headers);
		
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_HTML));
		restTemplate.getMessageConverters().add(converter);
		
		String response =  restTemplate.postForObject("http://localhost:8081/loggingDemo1", entity, String.class);
		
		log.info("########## RESPONSE = " + response);

	}

}
