package io.ztech.cricketapp.controller;

import io.ztech.cricketapp.beans.Player;
import io.ztech.cricketapp.beans.Team;
import io.ztech.cricketapp.beans.User;
import io.ztech.cricketapp.constants.Regex;
import io.ztech.cricketapp.constants.UserMessages;
import io.ztech.cricketapp.delegate.TeamManager;
import io.ztech.cricketapp.exceptions.InvalidNameException;

public class TeamController {

	TeamManager teamManager;
	Validator validator;

	public TeamController() {
		teamManager = new TeamManager();
		validator = new Validator();
	}

	public void displayTeams(User user) {
		//teamManager.displayTeams(user);
	}

	public void createTeam(Team newTeam) throws InvalidNameException {
		for (Player player : newTeam.getPlayers()) {
			if (!(validator.validateInput(Regex.nameRegex, player.getFirstName(), UserMessages.INVALID_FIRST_NAME)
					&& validator.validateInput(Regex.nameRegex, player.getLastName(), UserMessages.INVALID_LAST_NAME))) {
				throw new InvalidNameException(UserMessages.INVALID_NAME_EXCEPTION);
			}
		}
		teamManager.createTeam(newTeam);
	}
}
