package spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution(* spring.aop.dao.*.*(..))")
	public void forDAOPackage() {}
	
	@Pointcut("execution(* spring.aop.dao.*.get*())")
	public void getter() {}
	
	@Pointcut("execution(* spring.aop.dao.*.set*())")
	public void setter() {}
	
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void whitoutGettersAndSetters() {}

}
