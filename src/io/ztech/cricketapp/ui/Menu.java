package io.ztech.cricketapp.ui;

import java.util.Scanner;

import io.ztech.cricketapp.beans.User;
import io.ztech.cricketapp.constants.EditTeamOptions;
import io.ztech.cricketapp.constants.MainMenuOptions;
import io.ztech.cricketapp.constants.MatchMenuOptions;
import io.ztech.cricketapp.constants.PlayerMenuOptions;
import io.ztech.cricketapp.constants.TeamMenuOptions;
import io.ztech.cricketapp.constants.UserMessages;
import io.ztech.cricketapp.controller.TeamController;

public class Menu {
	
	Scanner scanner;
	TeamHandler teamHandler;
	TeamController teamController;
	User user;
	
	public Menu(User user) {
		scanner = new Scanner(System.in);
		teamHandler = new TeamHandler();
		teamController = new TeamController();
		this.user = user;
	}
	
	public void showMainMenu() {
		System.out.println();
		System.out.print(UserMessages.MAIN_MENU);
		MainMenuOptions option = MainMenuOptions.values()[scanner.nextInt() - 1];
		scanner.nextLine();
		do {
			switch (option) {
			case MATCHES:
				showMatchMenu();
				break;
			case TEAMS:
				showTeamMenu();
				break;
			case PLAYERS:
				showPlayerMenu();
				break;
			case EXIT:
				return;
			default:
				System.out.println(UserMessages.INVALID_CHOICE);
			}
			System.out.print(UserMessages.CONTINUE);
		} while (Character.toLowerCase(scanner.next().charAt(0)) == 'y');
	}
	
	public void showMatchMenu() {
		System.out.print(UserMessages.MATCH_MENU);
		MatchMenuOptions option = MatchMenuOptions.values()[scanner.nextInt() - 1];
		scanner.nextLine();
		do {
			switch (option) {
			case PLAY_MATCH:
				//MatchService.playMatch();
				break;
			case VIEW_MATCHES:
				//MatchService.displayMatches();
				break;
			case EDIT_MATCH:
				//MatchService.editMatch();
				break;
			case CREATE_MATCH:
				//MatchService.createMatch();
				break;
			default:
				System.out.println(UserMessages.INVALID_CHOICE);
			}
			System.out.print(UserMessages.CONTINUE);
		} while (Character.toLowerCase(scanner.next().charAt(0)) == 'y');
	}
	
	public void showTeamMenu() {
		System.out.print(UserMessages.TEAM_MENU);
		TeamMenuOptions option = TeamMenuOptions.values()[scanner.nextInt() - 1];
		scanner.nextLine();
		switch (option) {
		case VIEW_TEAMS:
			teamController.displayTeams(user);
			break;
		case EDIT_TEAM:
			showEditTeamMenu();
			break;
		case CREATE_TEAM:
			teamHandler.createTeam(user);
			break;
		default:
			System.out.println(UserMessages.INVALID_CHOICE);
		}
	}
	
	public void showPlayerMenu() {
		System.out.print(UserMessages.PLAYER_MENU);
		PlayerMenuOptions option = PlayerMenuOptions.values()[scanner.nextInt() - 1];
		scanner.nextLine();
		do {
			switch (option) {
			case VIEW_PLAYERS:
				//PlayerController.displayPlayer();
				break;
			case EDIT_PLAYER:
				//PlayerController.editPlayer();
				break;
			case CREATE_PLAYER:
				
				break;
			default:
				System.out.println(UserMessages.INVALID_CHOICE);
			}
			System.out.print(UserMessages.CONTINUE);
		} while (Character.toLowerCase(scanner.next().charAt(0)) == 'y');
	}
	
	public void showEditTeamMenu() {
		System.out.print(UserMessages.EDIT_TEAM_MENU);
		EditTeamOptions option = EditTeamOptions.values()[scanner.nextInt() - 1];
		scanner.nextLine();
		do {
			switch (option) {
			case CHANGE_NAME:
				teamHandler.editTeamName(user);
				break;
			case ADD_PLAYER:
				teamHandler.addNewPlayer(user);
				break;
			case REMOVE_PLAYER:
				teamHandler.removePlayer(user);
				break;
			default:
				System.out.println(UserMessages.INVALID_CHOICE);
			}
			System.out.print(UserMessages.FURTHER_CHANGES);
		} while (Character.toLowerCase(scanner.next().charAt(0)) == 'y');	
	}
}
