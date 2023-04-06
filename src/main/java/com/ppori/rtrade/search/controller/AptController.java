package com.ppori.rtrade.search.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ppori.rtrade.domain.Apt;
import com.ppori.rtrade.search.service.AptService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name="AptController DEMO 컨트롤러")
@RestController
@Slf4j
public class AptController {

	@Autowired
	AptService aptService;
	
	@Operation(summary = "getApt 메소드")
	@RequestMapping(path="/selectApt", method=RequestMethod.GET)
	public String select1() {
		Apt a1 = new Apt();
		a1.setStreetAdd("서울시 강동구");
		
		Apt apt = aptService.getApt(a1);
		return "okay";
	}
	
	@Operation(summary = "getAptList 메소드")
	@RequestMapping(path="/selectAptList", method=RequestMethod.GET)
	public String selectList() {
		ArrayList<Apt> apts = aptService.getAptList(new Apt());
		for(Apt apt:apts) {
			log.info("apt = " + apt.getAptComplex());
		}
		return "okay";
	}

}
