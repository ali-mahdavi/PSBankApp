package com.ps.springmvc.psbankApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.ps.springmvc.psbankApp.dao.AccountDAO;
import com.ps.springmvc.psbankApp.model.Account;

@Aspect
@Component
public class AccountAspect {
	private Logger logger = Logger.getLogger(getClass().getName());
	@Before("execution (* com.ps.springmvc.psbankApp.dao.AccountDAOImpl.saveAccount(..))")
	public void validateAccount(JoinPoint joinPoint){
		System.out.println("Method: validateAccount is being proccessed.");
		Object []args=joinPoint.getArgs();
		Account account=(Account)args[0];
		AccountDAO accountDao=(AccountDAO)joinPoint.getTarget();
		int accountNo=account.getAccountnumber();
		if(accountDao.getAccount(accountNo)!=null){
			throw new RuntimeException("Account with account number "+accountNo+" is already axist" );
		}
	}
}
