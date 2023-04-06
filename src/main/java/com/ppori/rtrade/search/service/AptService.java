package com.ppori.rtrade.search.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppori.rtrade.domain.Apt;
import com.ppori.rtrade.search.repository.AptRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AptService {
	@Autowired
	AptRepository aptRepository;
	
	public Apt getApt(Apt apt) {
		Apt apt2 = aptRepository.getApt(apt);
		log.info("############### apt=" + apt.getStreetAdd() + ", " + apt.getStreetName());
		return apt2;
	}
	public ArrayList<Apt> getAptList(Apt apt) {
		return aptRepository.getAptList(apt);
	}
}
