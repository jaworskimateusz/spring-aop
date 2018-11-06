package spring.aop.dao;

import org.springframework.stereotype.Component;

import spring.aop.run.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + " Adding an account..\n");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + " doWork()");
		return false;
	}

}
