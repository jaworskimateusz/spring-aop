package spring.aop.run;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.aop.config.Config;
import spring.aop.dao.AccountDAO;

public class AfterReturningApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		List<Account> accounts = accountDAO.findAccounts();
		displayAccounts(accounts);
		context.close();
	}
	
	private static void displayAccounts(List<Account> accounts) {
		System.out.println(">>Main: After returninig");
		System.out.println(accounts + "\n");
	}

}
