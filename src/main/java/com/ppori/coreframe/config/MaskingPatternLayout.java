package com.ppori.coreframe.config;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class MaskingPatternLayout extends PatternLayout {
	public void addMaskPattern(String maskPattern) {
		
	}
	
	@Override
	public String doLayout(ILoggingEvent event) {
		return maskMessage(super.doLayout(event));
	}
	
	private String maskMessage(String message) {
		if(1==1) return message;
		String dst = null;
		
		dst = message.replaceAll("([0-9]{6})-([1-4]{1})([0-9]{6})", "$1-$2******"); // 주민번호: 숫자6자리-1~4한자리숫자6자리 정보중 마지막6자리를 *으로 변경
		dst = dst.replaceAll("(\\d{4})-(\\d{4})-(\\d{4})-(\\d{4})", "$1-****-****-$4"); //카드번호 4글자 기준 형식에 맞춰서 가운데 부분만 ****으로 변경 $1, $4의 경우 앞의 정규식 () 기준 문장의 순서를 의미 합니다. ()가 4개로 구성 되어 있어 $1, $2, $3, $4로 정의 할 수 있습니다.
		dst = dst.replaceAll("-[0-9]{4}-", "-****-"); // 전화번호 -으로 시작하고 4자리 숫자-으로 끝나는 문장을 -****- 으로 변경
		dst = dst.replaceAll("[a-z,A-Z,0-9]+@", "******@"); // 이메일  @이 마지막에 포함된 문장을 *****@으로 변경
		dst = dst.replaceAll("(M[0-9]{4})([0-9]{4})", "$1****"); // 여권번호 - M으로 시작하고(^인자를 넣으면 진짜 문장의 시작값 이어야 해서 처리 안함) 숫자로된 4자리와 이어진 숫자4자리의 문장의 경우 뒤의 숫자4자리를 ****으로 변경
		dst = dst.replaceAll("([A-Z])([A-Z])\\s([0-9]{4})([0-9]{3})", "$1* $3***"); // 여권번호2 - 영문2글자로 시작하고 가운데 공백 숫자7자리인 정보를 영문+영문 숫자4+숫자3 기준으로 나눠서 2,4마스킹
		dst = dst.replaceAll("([가-힣]{2})(\\d{1})(\\d{1})-(\\d{4})(\\d{2})-(\\d{1})(\\d{1})", "$1$2*-$4**-*$7"); //운전면허번호 한글2자리+숫자1자리+숫자1자리-숫자4자리+숫자2자리-숫자1자리+숫자1자리 에 맞는 정보를 치환 [0-9]는 너무 길어 지니까 \\d 로 사용
		return dst;
	}
}
