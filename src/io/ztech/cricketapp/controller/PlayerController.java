package io.ztech.cricketapp.controller;

import io.ztech.cricketapp.beans.User;
import io.ztech.cricketapp.constants.Queries;
import io.ztech.cricketapp.delegate.PlayerManager;

public class PlayerController {

	PlayerManager playerManager;
	
	public PlayerController() {
		playerManager = new PlayerManager();
	}
	
	public boolean searchPlayer(int playerId, User user) {
		return playerManager.searchPlayer(playerId, user);
	}
	
	public void removePlayer(int teamId, int playerId) {
		playerManager.removePlayer(teamId, playerId);
	}
	
	public void displayPlayer(User user) {
		playerManager.displayPlayer(user);
	}
	
	public void updateTeamId(int teamId, int playerId) {
		playerManager.updateTeamId(teamId, playerId);
	}
	
	public void updatePlayerName(int playerId, String newName, String query) {
		playerManager.updatePlayerName(playerId, newName, query);
	}
}
