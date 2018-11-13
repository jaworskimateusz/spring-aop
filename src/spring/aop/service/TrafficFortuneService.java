package spring.aop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneService {

	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Expct heavy traffic this morning.";
	}

	public String getFortune(boolean b) {
		if(b) {
			throw new RuntimeException("Major accident! Crash on the highway");
		}
		return this.getFortune();
	}
}
