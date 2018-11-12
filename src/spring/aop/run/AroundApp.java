package spring.aop.run;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.aop.config.Config;
import spring.aop.service.TrafficFortuneService;

public class AroundApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		TrafficFortuneService trafficFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		System.out.println("\nMain: AroundApp");
		System.out.println("\nFortune: " + trafficFortuneService.getFortune());
		//while using System.out.println() it is not sync with spring
		//-> first the context will being closed, and then System.out.println("Finished");
		context.close();
	}

}
