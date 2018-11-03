package com;

import java.util.NoSuchElementException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestControllerAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CounterService counterService;

	@Before("execution(public * com.api.rest.*Controller.*(..))")
	public void logBeforeRestCall(JoinPoint pjp) throws Throwable {
		logger.info(":::::AOP Before REST call:::::" + pjp);
	}

	@AfterReturning("execution(public * com.api.rest.*Controller.createPerson*(..))")
	public void afterCallingCreatePerson(JoinPoint pjp) {
		logger.info(":::::AOP @AfterReturning Create REST call:::::" + pjp);
		counterService
				.increment("com.api.rest.PersonController.createPerson");
	}

	@AfterReturning("execution(public * com.api.rest.*Controller.getAllPersons*(..))")
	public void afterCallinggetAllPersons(JoinPoint pjp) {
		logger.info(":::::AOP @AfterReturning getAllPerson REST call:::::"
				+ pjp);

		counterService
				.increment("com.api.rest.PersonController.getAllPersons");
	}

	@AfterReturning("execution(public * com.api.rest.*Controller.getPerson*(..))")
	public void afterCallinggetPersons(JoinPoint pjp) {
		logger.info(":::::AOP @AfterReturning getPerson REST call:::::" + pjp);
		counterService
				.increment("com.api.rest.PersonController.getPerson");
	}

	@AfterReturning("execution(public * com.api.rest.*Controller.updatePerson*(..))")
	public void afterCallingupdatePerson(JoinPoint pjp) {
		logger.info(":::::AOP @AfterReturning update Person REST call:::::"
				+ pjp);
		counterService
				.increment("com.api.rest.PersonController.updatePerson");
	}
	
	@AfterReturning("execution(public * com.api.rest.*Controller.deletePerson*(..))")
	public void afterCallingDeletePerson(JoinPoint pjp) {
		logger.info(":::::AOP @AfterReturning delete Person REST call:::::"
				+ pjp);
		counterService
				.increment("com.api.rest.PersonController.deletePerson");
	}

	@AfterThrowing(pointcut = "execution(public * com.api.rest.*Controller.*(..))", throwing = "e")
	public void afterPersonThrowsException(NoSuchElementException e) {
		counterService.increment("counter.errors.Person.controller");
	}
}
