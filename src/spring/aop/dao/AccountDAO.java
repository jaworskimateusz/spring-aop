package spring.aop.dao;

import org.springframework.stereotype.Component;

import spring.aop.run.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + " Adding an account..\n");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + " doWork()");
		return false;
	}

	public String getName() {
		System.out.println("getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("getServiceCode()");
		this.doWork();
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("setSericeCode()");
		this.serviceCode = serviceCode;
	}
	

}
