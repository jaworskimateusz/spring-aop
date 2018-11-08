package spring.aop.run;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.aop.config.Config;
import spring.aop.dao.AccountDAO;
import spring.aop.dao.MembershipDAO;

public class MainApplication {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean(MembershipDAO.class);
		
		accountDAO.setServiceCode("007");
		accountDAO.getServiceCode();
		
		accountDAO.addAccount(new Account(), true);
		membershipDAO.addMember();
		context.close();
	}

}
