package spring.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAO {
	
	public void addMember() {
		System.out.println(getClass() + " Adding membership account..\n");
	}

}
