package io.ztech.cricketapp.delegate;

import java.util.ArrayList;
import java.util.Scanner;

import io.ztech.cricketapp.beans.Player;
import io.ztech.cricketapp.beans.Team;
import io.ztech.cricketapp.constants.UserMessages;
import io.ztech.cricketapp.dao.CricketDAO;

public class TeamManager {
	Scanner scanner;
	CricketDAO dao;
	
	public TeamManager() {
		scanner = new Scanner(System.in);
		dao = new CricketDAO();
	}
	
	public void displayTeams() {
		System.out.println(UserMessages.TEAM_TABLE);
		ArrayList<Team> teamList = dao.fetchTeams();
		for (Team team : teamList) {
			System.out.println(team.getTeamId() + "\t" + team.getTeamName());
			ArrayList<Player> playerList = dao.fetchTeamPlayers(team.getTeamId());
			System.out.println(UserMessages.PLAYER_TABLE);
			for (Player player : playerList) {
				System.out.println(player.getPlayerId() + "\t" + player.getFirstName() + "\t" + player.getLastName());
			}
		}
	}
	
	public void createTeam(Team newTeam) {
		dao.insertTeam(newTeam);
	}
}