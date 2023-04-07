package com.ppori.rtrade.search.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ppori.rtrade.domain.Apt;
import com.ppori.rtrade.search.service.AptService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name="AptController DEMO 컨트롤러")
@Controller
@Slf4j
public class AptController {

	@Autowired
	AptService aptService;
	
	@Operation(summary = "INPUT_REQ")
	@RequestMapping(value="/inputReq", method=RequestMethod.GET)
	public String inputReq() {
		return "thyme/input_req";
	}	

	@Operation(summary = "getApt 메소드")
	@GetMapping(value="/apt")
	public String getApt(Model model) {
		List<Apt> aptList = aptService.getAptList(new Apt());
		
		model.addAttribute("aptList", aptList);

		return "thyme/input_req";
	}	

	@Operation(summary = "postApt 메소드")
	@PostMapping(value="/apt")
	public String postApt(Model model) {
		List<Apt> aptList = aptService.getAptList(new Apt());
		
		model.addAttribute("aptList", aptList);

		return "thyme/input_req";
	}	

}
