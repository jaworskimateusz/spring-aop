package spring.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class TeamDAO {
	
	public void addTeam() {
		System.out.println(getClass() + " Adding new team..\n");
	}
	
	public String setTeamLeader(String name) {
		return "New team leader is: " + name;
	}
}
