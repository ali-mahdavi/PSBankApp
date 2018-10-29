package com.ps.springmvc.psbankApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class PSBankLoggingAspect {
	private Logger logger = Logger.getLogger(getClass().getName());

	// @pointCut where should be applied

	@Pointcut("execution (* com.ps.springmvc.psbankApp.controllers.*.*(..))")
	private void forControllersPackage() {

	}

	@Pointcut("execution (* com.ps.springmvc.psbankApp.services.*.*(..))")
	private void forServicesPackage() {

	}

	@Pointcut("execution (* com.ps.springmvc.psbankApp.dao.*.*(..))")
	private void forDAOPackage() {

	}

	@Pointcut("forControllersPackage() || forServicesPackage() || forDAOPackage()")
	private void forApplication() {

	}
// Advice what action to be taken and when to 
	@Before("forApplication()")
	public void before(JoinPoint joinPoint) {
		String methodname = joinPoint.getSignature().toShortString();
		logger.info("Information : in @Before advice : calling the method :" + methodname);
	}

	@AfterReturning(pointcut = "forApplication()", returning = "result")
	public void afterReturning(JoinPoint joinpoint, Object result) {
		String methodname = joinpoint.getSignature().toShortString();
		logger.info("Info : @AfterReturning : from Method: " + methodname);
		logger.info("Info : data returned by method " + result);
	}
 
}
