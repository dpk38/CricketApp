package io.ztech.cricketapp.delegate;

import java.util.ArrayList;
import java.util.Scanner;

import io.ztech.cricketapp.beans.Player;
import io.ztech.cricketapp.beans.Team;
import io.ztech.cricketapp.beans.User;
import io.ztech.cricketapp.constants.UserMessages;
import io.ztech.cricketapp.dao.CricketDAO;

public class TeamManager {
	Scanner scanner;
	PlayerManager playerManager;
	CricketDAO dao;
	
	public TeamManager() {
		scanner = new Scanner(System.in);
		playerManager = new PlayerManager();
		dao = new CricketDAO();
	}
	
	public void displayTeams(User user) {
		ArrayList<Team> teamList = dao.fetchTeams(user);
		for (Team team : teamList) {
			System.out.println(UserMessages.TEAM_TABLE);
			System.out.println(team.getTeamId() + "\t" + team.getTeamName());
			playerManager.printPlayerDetails(team);
		}
	}
	
	public void createTeam(Team newTeam) {
		dao.insertTeam(newTeam);
	}
	
	public void updateTeamName(int teamId, String newTeamName) {
		dao.updateTeamName(teamId, newTeamName);
	}
	
	public boolean searchTeam(int teamId, User user) {
		return dao.searchTeam(user, teamId);
	}
	
	public void addNewPlayer(Player newPlayer) {
		dao.insertPlayer(newPlayer);
	}
	
	public Team fetchTeam(int teamId) {
		return dao.fetchTeam(teamId);
	}
}
