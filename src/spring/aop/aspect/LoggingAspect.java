package spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

	@Before("spring.aop.aspect.AopExpressions.whitoutGettersAndSetters()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n>>Logging");
	}
}
