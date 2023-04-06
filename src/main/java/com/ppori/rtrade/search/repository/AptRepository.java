package com.ppori.rtrade.search.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ppori.rtrade.domain.Apt;

@Repository(value = "com.ppori.rtrade.search.repository.AptRepository")
public interface AptRepository {
	
	Apt getApt(Apt apt);
	ArrayList<Apt> getAptList(Apt apt);
//	void insert1(Member member);
	
}
