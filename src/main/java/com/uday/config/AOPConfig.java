package com.uday.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AOPConfig {

	Logger log = LoggerFactory.getLogger(AOPConfig.class);

	@Around("@annotation(com.uday.config.ExecutionTime)")
	public Object trackTime(ProceedingJoinPoint pjp) throws Throwable {
		long stratTime=System.currentTimeMillis();
		Object obj=pjp.proceed();
		long endTime=System.currentTimeMillis();
		log.info(" time taken to execute the method "+pjp.getSignature()+": is "+(endTime-stratTime));
		System.out.println(" time taken to execute the method "+pjp.getSignature()+": is "+(endTime-stratTime));
		return obj;
	}
}
