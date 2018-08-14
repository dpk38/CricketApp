package io.ztech.cricketapp.ui;

import java.util.Scanner;

import io.ztech.cricketapp.beans.Player;
import io.ztech.cricketapp.beans.User;
import io.ztech.cricketapp.constants.UserMessages;

public class PlayerHandler {
	Scanner scanner;
	
	public PlayerHandler() {
		scanner = new Scanner(System.in);
	}
	
	public void createPlayer(User user) {
		Player newPlayer = new Player();
		newPlayer.setUser(user);
		getPlayerDetails(newPlayer);
		System.out.print(UserMessages.ENTER_TEAM_ID);
		newPlayer.setTeamId(scanner.nextInt());
		scanner.nextLine();
	}
	
	public void getPlayerDetails(Player newPlayer) {
		System.out.print(UserMessages.ENTER_FIRST_NAME);
		newPlayer.setFirstName(scanner.nextLine());
		System.out.print(UserMessages.ENTER_LAST_NAME);
		newPlayer.setLastName(scanner.nextLine());
	}
}
