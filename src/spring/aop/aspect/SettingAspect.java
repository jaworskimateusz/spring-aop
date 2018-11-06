package spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SettingAspect {

	@Before("execution(* set*(String))")
	public void checkSetting() {
		System.out.println(">>Correct.");
	}
}
