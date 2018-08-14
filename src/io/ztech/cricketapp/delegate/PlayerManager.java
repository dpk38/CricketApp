package io.ztech.cricketapp.delegate;

import java.util.Scanner;

import io.ztech.cricketapp.beans.Player;
import io.ztech.cricketapp.constants.UserMessages;
import io.ztech.cricketapp.dao.CricketDAO;

public class PlayerManager {
	
	Scanner scanner;
	CricketDAO dao;
	
	public PlayerManager() {
		scanner = new Scanner(System.in);
		dao = new CricketDAO();
	}
	
	public void createPlayer() {
		Player newPlayer = new Player();
		System.out.print(UserMessages.ENTER_TEAM_NAME);
		newPlayer.setPlayerName(scanner.nextLine());
		System.out.print(UserMessages.ENTER_LINE_UP);
		newPlayer.setLineUp(scanner.nextInt());
		scanner.nextLine();
	}
}
