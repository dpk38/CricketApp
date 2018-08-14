package io.ztech.cricketapp.ui;

import java.util.Scanner;

import io.ztech.cricketapp.beans.Player;
import io.ztech.cricketapp.beans.Team;
import io.ztech.cricketapp.beans.User;
import io.ztech.cricketapp.constants.UserMessages;
import io.ztech.cricketapp.controller.TeamController;
import io.ztech.cricketapp.exceptions.InvalidNameException;

public class TeamHandler {
	Scanner scanner;
	PlayerHandler playerHandler;
	TeamController teamController;
	
	public TeamHandler() {
		scanner = new Scanner(System.in);
		playerHandler = new PlayerHandler();
		teamController = new TeamController();
	}
	
	public void createTeam(User user) {
		char retry;
		do {
			retry = 'n';
			try {
				Team newTeam = new Team();
				newTeam.setUser(user);
				System.out.print(UserMessages.ENTER_TEAM_NAME);
				newTeam.setTeamName(scanner.nextLine());
				System.out.print(UserMessages.CREATING_PLAYERS);
				char choice;
				do {
					Player newPlayer = new Player();
					newPlayer.setUser(user);
					playerHandler.getPlayerDetails(newPlayer);
					newTeam.addPlayer(newPlayer);
					System.out.print(UserMessages.ADD_ANOTHER);
					choice = scanner.nextLine().charAt(0);
				} while (Character.toLowerCase(choice) == 'y');
				teamController.createTeam(newTeam);
			} catch(InvalidNameException e) {
				System.out.println(e);
				retry = 'y';
			}
		} while (retry == 'y');
	}
}
