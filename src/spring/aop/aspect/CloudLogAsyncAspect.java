package spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAsyncAspect {

	@Before("spring.aop.aspect.AopExpressions.whitoutGettersAndSetters()")
	public void logToCloudAsync() {
		System.out.println("\n>>Logging to Cloud");
	}
	
}
