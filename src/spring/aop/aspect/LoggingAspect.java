package spring.aop.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import spring.aop.run.Account;
import spring.aop.run.AroundLoggerApp;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
	private Logger logger =
			Logger.getLogger(AroundLoggerApp.class.getName());

	@Before("spring.aop.aspect.AopExpressions.whitoutGettersAndSetters()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		logger.info("\n>>Logging");
		
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		logger.info("Method: " + methodSignature);
		Object [] args = joinPoint.getArgs();
		for(Object arg : args) {
			//logger.info only logs String items
			logger.info(arg.toString());
			if(arg instanceof Account) {
				logger.info("Account name: " + ((Account)arg).getName());
			}
		}
		
	}
	
	@AfterReturning(pointcut="execution(* spring.aop.dao.AccountDAO.findAccounts(..))",
					returning="result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint joinPoint, List<Account> result) {
			logger.info("\n>>Aspect: AfterReturninig method >> " +
			joinPoint.getSignature().toShortString());
			
			logger.info(">>Result: " + result + "\n");
			convertNameToUpperCase(result);
			logger.info(">>Result after modified: " + result + "\n");
	}
	
	@AfterThrowing(pointcut="execution(* spring.aop.dao.AccountDAO.findAccounts(..))",
				   throwing="exception")
	public void afterThrowingFundAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
		logger.info(">>@AfterThrowing: " + joinPoint.getSignature().toShortString());
		logger.info("The exception is: " + exception);
	}
	
	@After("execution(* spring.aop.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		logger.info("\n>>@After method");
	}
	/*
	@Around("execution(* spring.aop.service.TrafficFortuneService.getFortune(..))")
	public Object aroundGeetFortune(ProceedingJoinPoint proceedingJoinPoint )
		   throws Throwable {
		logger.info(">>@Around method on: " + proceedingJoinPoint.getSignature().toString());
		long start = System.currentTimeMillis();
		//handle to target method-> proceedingJoinPoint  execute the target method->proceed()
		Object result = proceedingJoinPoint.proceed();
		long end = System.currentTimeMillis();
		logger.info("\nDuration: " + (end - start)/1000.0 + " seconds.");
		return result;
	}
	*/
	
	@Around("execution(* spring.aop.service.TrafficFortuneService.getFortune(..))")
	public Object aroundGeetFortune(ProceedingJoinPoint proceedingJoinPoint )
		   throws Throwable {
		logger.info(">>@Around method on: " + proceedingJoinPoint.getSignature().toString());
		long start = System.currentTimeMillis();
		//handle to target method-> proceedingJoinPoint  execute the target method->proceed()
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			logger.warning(e.getMessage());
			// the exception was never thrown to the Main Appliation
			result = "Little problem but no wories, I will rescue you!";
			
			//in this case the exception is thrown to the Main Application
			//throw e;
		}
		long end = System.currentTimeMillis();
		logger.info("\nDuration: " + (end - start)/1000.0 + " seconds.");
		return result;
	}
	
	private void convertNameToUpperCase(List<Account> result) {
		for(Account account: result) {
			account.setName(account.getName().toUpperCase());
		}
	}
}
