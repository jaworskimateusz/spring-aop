package spring.aop.run;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.aop.config.Config;
import spring.aop.dao.TeamDAO;

public class MainAppTraining {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class);
		TeamDAO teamDAO = context.getBean(TeamDAO.class);
		teamDAO.addTeam();
		System.out.println(teamDAO.setTeamLeader("Jack"));
	}

}
