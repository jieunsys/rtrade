package com.ppori.rtrade.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.Data;

@Data
public class Apt {
	String streetAdd;
	String streetNo;
	String streetNo1;
	String streetNo2;
	String aptComplex;
	BigDecimal expSize;
	String contractYymm;
	String contractDd;
	BigInteger price;
	int floorNo;
	String builtYear;
	String streetName;
	String reasonDate;
	String tradeType;
	String dealerAdd;
	String sidoCode;
}
