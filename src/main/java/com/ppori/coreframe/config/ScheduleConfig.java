package com.ppori.coreframe.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ScheduleConfig {

//	@Scheduled(fixedDelay = 3000) // 3초 간격 무한실행
	public void scheduleFixedDelayTask() throws InterruptedException {
	    log.info("##### Fixed delay task - {}", System.currentTimeMillis() / 1000);
	}
	
	/**
	 * 크론 표현식에서는 6~7 자리 가 사용됩니다.
	 * cron = "* * * * * *"
	 * *       *        *        *       *       *      *
	 * 초       분        시       일       월      요일    년도(생략가능)
	 * 
		cron = "0 0/5 * * * *"			<!-- 5분 마다 실행 ex) 00:05, 00:10. 00:15.... -->
		cron = "0 0 0/1 * * *"			<!-- 1시간 마다 실행 ex) 01:00, 02:00, 03:00.... -->
		cron = "0 0 18 * * *"			<!-- 매일 오후 18시마다 실행 ex) 18:00 -->
		cron = "0 0 18 * * * 2018"		<!-- 2018년도만 매일 오후 18시마다 실행 ex) 18:00 -->
		cron = "0 0/5 18 * * *"			<!-- 매일 오후 18시00분-18시55분 사이에 5분 간격으로 실행 ex) 18:00, 18:05.....18:55 -->
		cron = "0 0/5 9,18 * * *"		<!-- 매일 오후 9시00분-9시55분, 18시00분-18시55분 사이에 5분 간격으로 실행  -->
		cron = "0 0/5 9-18 * * *"		<!-- 매일 오후 9시00분-18시55분 사이에 5분 간격으로 실행  -->
		cron = "0 0 0 1 * *"			<!-- 매달 1일 00시에 실행 -->
		cron = "0 30 10 ? 3 MON-FRI"	<!-- 매년 3월내 월-금요일 10시 30분에만 실행 -->
		cron = "0 0 10 L * ?"			<!-- 매월 마지막날 저녁 10시에 실행 -->
	 */
	@Scheduled(cron = "0 0/5 * * * *")
	public void scheduleTaskUsingCronExpression() {
	    long now = System.currentTimeMillis() / 1000;
	    log.debug("##### schedule tasks using cron jobs - {}", now);
	}	
}
