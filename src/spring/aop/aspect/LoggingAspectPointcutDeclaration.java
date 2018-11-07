package spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectPointcutDeclaration {
	
	@Pointcut("execution(* spring.aop.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("execution(* spring.aop.dao.*.get*())")
	private void getter() {}
	
	@Pointcut("execution(* spring.aop.dao.*.set*())")
	private void setter() {}

	@Before("forDAOPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n>>Executing @Before advice on addAccount()");
	}
	
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	private void whitoutGettersAndSetters() {}
	
	@Before("whitoutGettersAndSetters()")
	public void performApiAnalytic() {
		System.out.println("\n>> Performing API");
	}
}
