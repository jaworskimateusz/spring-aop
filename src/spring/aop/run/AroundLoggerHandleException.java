package spring.aop.run;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.aop.config.Config;
import spring.aop.service.TrafficFortuneService;

public class AroundLoggerHandleException {

	private static Logger logger =
			Logger.getLogger(AroundLoggerHandleException.class.getName());

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		TrafficFortuneService trafficFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		logger.info("\nMain: AroundApp");
		logger.info("\nFortune: " + trafficFortuneService.getFortune(true));
		logger.info("Finished.");
		context.close();
	}

}
