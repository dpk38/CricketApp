package io.ztech.cricketapp.ui;

import java.util.Scanner;

import io.ztech.cricketapp.beans.Player;
import io.ztech.cricketapp.beans.User;
import io.ztech.cricketapp.constants.Queries;
import io.ztech.cricketapp.constants.UserMessages;
import io.ztech.cricketapp.controller.PlayerController;
import io.ztech.cricketapp.controller.TeamController;
import io.ztech.cricketapp.exceptions.InvalidNameException;

public class PlayerHandler {
	Scanner scanner;
	PlayerController playerController;
	TeamController teamController;
	
	public PlayerHandler() {
		scanner = new Scanner(System.in);
		playerController = new PlayerController();
		teamController = new TeamController();
	}
	
	public void addNewPlayer(User user) {
		int teamId = chooseTeam(user);
		char retry;
		do {
			retry = 'n';
			Player newPlayer = new Player();
			newPlayer.setTeamId(teamId);
			newPlayer.setUser(user);
			try {
				getPlayerDetails(newPlayer);
				teamController.addNewPlayer(newPlayer);
			} catch (InvalidNameException e) {
				System.out.println(e);
				retry = 'y';
			}
		} while (retry == 'y');
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
	
	public void editPlayer(User user, String field) {
		if (field.equals("team")) {
			System.out.println(UserMessages.SELECT_NEW_TEAM_ID);
			int teamId = chooseTeam(user);
			int playerId = choosePlayer(user);
			playerController.updateTeamId(teamId, playerId);
		} else {
			teamController.displayTeams(user);
			int playerId = choosePlayer(user);
			System.out.print(UserMessages.ENTER_NEW_NAME);
			String newName = scanner.nextLine();
			if (field.equals("fname")) {
				playerController.updatePlayerName(playerId, newName, Queries.UPDATE_PLAYER_FIRST_NAME);
			} else {
				playerController.updatePlayerName(playerId, newName, Queries.UPDATE_PLAYER_LAST_NAME);
			}
		}
	}
	
	public int chooseTeam(User user) {
		int teamId;
		do {
			teamController.displayTeams(user);
			System.out.print(UserMessages.CHOOSE_TEAM);
			teamId = scanner.nextInt();
			scanner.nextLine();
			if (teamController.searchTeam(teamId, user)) {
				break;
			} else {
				System.out.println(UserMessages.NO_SUCH_TEAM);
			}
		} while (true);
		return teamId;
	}
}
