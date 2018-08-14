package io.ztech.cricketapp.beans;

import java.util.ArrayList;

public class Team {
	int teamId;
	String teamName;
	ArrayList<Player> players;
	
	public Team() {
		players = new ArrayList<Player>();
	}
	

	public int getTeamId() {
		return teamId;
	}


	public String getTeamName() {
		return teamName;
	}


	public ArrayList<Player> getPlayers() {
		return players;
	}


	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public void addPlayer(Player newPlayer) {
		players.add(newPlayer);
	}
}
