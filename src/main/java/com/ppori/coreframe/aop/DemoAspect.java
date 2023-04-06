package com.ppori.coreframe.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class DemoAspect {
    
    //demo 패키지의 모든 클래스에 적용함
    @Around("execution(* com.ppori.coreframe.demo..*.*(..))")
    public Object aroundPrint(ProceedingJoinPoint pjp) throws Throwable {
        log.debug("##### @Around_start - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        Object result = pjp.proceed();
        log.debug("##### @Around_finished - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
		return result;
    }
    
    @Before("execution(* com.ppori.coreframe.demo..*.*(..))")
    public void before1(JoinPoint pjp) {
        log.debug("##### @Before");
    }
    
    @After("execution(* com.ppori.coreframe.demo..*.*(..))")
    public void after1(JoinPoint pjp) {
        log.debug("##### @After");
    }
}
