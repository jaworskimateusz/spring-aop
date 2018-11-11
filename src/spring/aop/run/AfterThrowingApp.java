package spring.aop.run;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.aop.config.Config;
import spring.aop.dao.AccountDAO;

public class AfterThrowingApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		List<Account> accounts = null;
		try {
			accounts = accountDAO.findAccounts(true);
		} catch(Exception e) {
			System.out.println("\nMain: exception occured: " + e);
		}
		context.close();
	}

}
