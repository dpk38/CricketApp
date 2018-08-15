package io.ztech.cricketapp.ui;

import java.util.Scanner;

import io.ztech.cricketapp.beans.Player;
import io.ztech.cricketapp.beans.User;
import io.ztech.cricketapp.constants.UserMessages;
import io.ztech.cricketapp.controller.PlayerController;

public class PlayerHandler {
	Scanner scanner;
	PlayerController playerController;
	
	public PlayerHandler() {
		scanner = new Scanner(System.in);
		playerController = new PlayerController();
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
	
	public int choosePlayer(User user) {
		int playerId;
		do {
			System.out.print(UserMessages.CHOOSE_PLAYER);
			playerId = scanner.nextInt();
			scanner.nextLine();
			if (playerController.searchPlayer(playerId, user)) {
				break;
			} else {
				System.out.println(UserMessages.NO_SUCH_PLAYER);
			}
		} while (true);
		return playerId;
	}
}
