package io.ztech.cricketapp.beans;

import java.util.ArrayList;
import java.sql.Date;

import io.ztech.cricketapp.constants.MatchResult;

public class Match {
	int matchId;
	User user;
	Date matchDate;
	Team teamA, teamB;
	ArrayList<Integer> teamALineUp, teamBLineUp;
	String status;
	int tossWonBy;
	MatchResult matchResult;
	
	public Match() {
		teamALineUp = new ArrayList<>();
		teamBLineUp = new ArrayList<>();
	}
	public ArrayList<Integer> getTeamALineUp() {
		return teamALineUp;
	}
	public void setTeamALineUp(ArrayList<Integer> teamALineUp) {
		this.teamALineUp = teamALineUp;
	}
	public ArrayList<Integer> getTeamBLineUp() {
		return teamBLineUp;
	}
	public void setTeamBLineUp(ArrayList<Integer> teamBLineUp) {
		this.teamBLineUp = teamBLineUp;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public MatchResult getMatchResult() {
		return matchResult;
	}
	public void setMatchResult(MatchResult matchResult) {
		this.matchResult = matchResult;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public Team getTeamA() {
		return teamA;
	}
	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}
	public Team getTeamB() {
		return teamB;
	}
	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}
	public int getTossWonBy() {
		return tossWonBy;
	}
	public void setTossWonBy(int tossWonBy) {
		this.tossWonBy = tossWonBy;
	}
	public Date getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
