package io.ztech.cricketapp.controller;

import io.ztech.cricketapp.beans.User;
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
}
