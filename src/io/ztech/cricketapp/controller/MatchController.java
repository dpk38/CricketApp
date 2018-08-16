package io.ztech.cricketapp.controller;

import io.ztech.cricketapp.beans.Match;
import io.ztech.cricketapp.beans.User;
import io.ztech.cricketapp.delegate.MatchManager;

public class MatchController {
	
	MatchManager matchManager;
	
	public MatchController() {
		matchManager = new MatchManager();
	}
	
	public void setMatch(Match newMatch) {
		matchManager.setMatch(newMatch);
	}
	
	public void displayMatches(User user) {
		matchManager.displayMatches(user);
	}
	
	public boolean searchMatch(User user, int matchId) {
		return matchManager.searchMatch(user, matchId);
	}
	
	public Match fetchMatch(int matchId) {
		return matchManager.fetchMatch(matchId);
	}
}
