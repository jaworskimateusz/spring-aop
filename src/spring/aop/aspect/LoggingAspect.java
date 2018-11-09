package spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import spring.aop.run.Account;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

	@Before("spring.aop.aspect.AopExpressions.whitoutGettersAndSetters()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n>>Logging");
		
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		System.out.println("Method: " + methodSignature);
		Object [] args = joinPoint.getArgs();
		for(Object arg : args) {
			System.out.println(arg);
			if(arg instanceof Account) {
				System.out.println("Account name: " + ((Account)arg).getName());
			}
		}
		
	}
}
