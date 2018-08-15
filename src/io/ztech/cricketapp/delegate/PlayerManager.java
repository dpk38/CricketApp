package io.ztech.cricketapp.delegate;

import java.util.Scanner;

import io.ztech.cricketapp.beans.Player;
import io.ztech.cricketapp.beans.User;
import io.ztech.cricketapp.constants.UserMessages;
import io.ztech.cricketapp.dao.CricketDAO;

public class PlayerManager {
	
	Scanner scanner;
	CricketDAO dao;
	
	public PlayerManager() {
		scanner = new Scanner(System.in);
		dao = new CricketDAO();
	}
	
	public boolean searchPlayer(int playerId, User user) {
		return dao.searchPlayer(user, playerId);
	}
	
	public void removePlayer(int teamId, int playerId) {
		dao.deletePlayer(teamId, playerId);
	}
}
