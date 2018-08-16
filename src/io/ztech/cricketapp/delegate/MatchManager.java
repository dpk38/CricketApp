package io.ztech.cricketapp.delegate;

import java.util.ArrayList;
import java.util.Scanner;

import io.ztech.cricketapp.beans.Match;
import io.ztech.cricketapp.beans.User;
import io.ztech.cricketapp.constants.UserMessages;
import io.ztech.cricketapp.dao.CricketDAO;

public class MatchManager {

	Scanner scanner;
	CricketDAO dao;

	public MatchManager() {
		scanner = new Scanner(System.in);
		dao = new CricketDAO();
	}

	public void setMatch(Match newMatch) {
		dao.insertMatch(newMatch);
	}

	public void displayMatches(User user) {
		ArrayList<Match> matchList = dao.fetchMatches(user);
		System.out.println(UserMessages.MATCH_TABLE);
		for (Match match : matchList) {
			System.out.println(match.getMatchId() + "\t" + match.getMatchDate() + "\t" + match.getTeamA().getTeamId()
					+ "\t" + match.getTeamB().getTeamId() + "\t" + match.getStatus() + "\t" + match.getTossWonBy()
					+ "\t" + match.getMatchResult());
		}
	}
	
	public boolean searchMatch(User user, int matchId) {
		return dao.searchMatch(user, matchId);
	}
	
	public Match fetchMatch(int matchId) {
		return dao.fetchMatch(matchId);
	}
}
