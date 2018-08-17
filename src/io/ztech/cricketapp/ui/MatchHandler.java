package io.ztech.cricketapp.ui;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import io.ztech.cricketapp.beans.BallStats;
import io.ztech.cricketapp.beans.LineUp;
import io.ztech.cricketapp.beans.Match;
import io.ztech.cricketapp.beans.Player;
import io.ztech.cricketapp.beans.Team;
import io.ztech.cricketapp.beans.User;
import io.ztech.cricketapp.constants.Regex;
import io.ztech.cricketapp.constants.UserMessages;
import io.ztech.cricketapp.controller.MatchController;
import io.ztech.cricketapp.controller.TeamController;
import io.ztech.cricketapp.controller.Validator;

public class MatchHandler {
	
	Scanner scanner;
	Validator validator;
	PlayerHandler playerHandler;
	TeamController teamController;
	MatchController matchController;
	
	public MatchHandler() {
		scanner = new Scanner(System.in);
		playerHandler = new PlayerHandler();
		teamController = new TeamController();
		matchController = new MatchController();
		validator = new Validator();
	}
	
	public void createMatch(User user) {
		Match newMatch = new Match();
		System.out.println(UserMessages.SELECT_TWO_TEAMS);
		int teamAid = playerHandler.chooseTeam(user);
		int teamBid = playerHandler.chooseTeam(user);
		Team teamA = teamController.fetchTeam(teamAid);
		Team teamB = teamController.fetchTeam(teamBid);
		
		newMatch.setUser(user);
		newMatch.setTeamA(teamA);
		newMatch.setTeamB(teamB);
		newMatch.setTeamALineUp(getLineUp(teamA));
		newMatch.setTeamBLineUp(getLineUp(teamB));
		scanner.nextLine();	
		newMatch.setStatus("scheduled");
		String date;
		char retry;
		do {
			retry = 'n';
			System.out.println(UserMessages.ENTER_MATCH_DATE);
			date = scanner.nextLine();
			if (!(validator.validateInput(Regex.dateRegex, date, UserMessages.INVALID_DATE))) {
				retry = 'y';
			}
		} while (retry == 'y');
		Date matchDate = Date.valueOf(date);
		newMatch.setMatchDate(matchDate);
		matchController.setMatch(newMatch);
	}
	
	public LineUp getLineUp(Team team) {
		LineUp lineUp = new LineUp();
		lineUp.setTeamId(team.getTeamId());
		System.out.print(UserMessages.NUMBER_OF_PLAYERS + team.getTeamName());
		int numberOfPlayers = scanner.nextInt();
		System.out.println(UserMessages.ENTER_LINE_UP + team.getTeamName());
		ArrayList<Integer> order = new ArrayList<Integer>();
		for (int i = 0; i < numberOfPlayers; i++) {
			order.add(scanner.nextInt());
		}
		lineUp.setPlayerId(order);
		return lineUp;
	}

	public void playMatch(User user) {
		Team battingTeam, bowlingTeam;
		ArrayList<Integer> batsmen, bowlers;
		int onStrike, offStrike, bowler, totalScore = 0;
		float overCount = 0;
		
		int matchId = chooseMatch(user);
		Match match = matchController.fetchMatch(matchId);
		
		match.setStatus("ongoing");
		match.setTossWonBy(tossCoin(match));
		System.out.println(UserMessages.CHOSE_TO_BAT);
		int battingTeamId = scanner.nextInt();
		scanner.nextLine();
		if (battingTeamId == match.getTeamA().getTeamId()) {
			battingTeam = match.getTeamA();
			batsmen = match.getTeamALineUp().getPlayerId();
			bowlingTeam = match.getTeamB();
			bowlers = match.getTeamBLineUp().getPlayerId();
		} else {
			battingTeam = match.getTeamB();
			batsmen = match.getTeamBLineUp().getPlayerId();
			bowlingTeam = match.getTeamA();
			bowlers = match.getTeamALineUp().getPlayerId();
		}
		showPlayers(batsmen);
		System.out.println(UserMessages.CHOOSE_ONSTRIKE);
		onStrike = choosePlayer(match, battingTeam);
		System.out.println(UserMessages.CHOOSE_OFFSTRIKE);
		offStrike = choosePlayer(match, battingTeam);
		showPlayers(bowlers);
		System.out.println(UserMessages.CHOOSE_BOWLER);
		bowler = choosePlayer(match, bowlingTeam);
		
		while (!batsmen.isEmpty() && overCount < 20.0) {
			int score = 0;
			boolean wicketTaken = false;
			System.out.print(UserMessages.BALL_PLAYED);
			switch (scanner.nextInt()) {
			case 1:
				score = 1;
				break;
			case 2:
				score = 2;
				break;
			case 3:
				score = 3;
				break;
			case 4:
				score = 4;
				break;
			case 5:
				score = 5;
				break;
			case 6:
				score = 6;
				break;
			case 7:
				score = 0;
				wicketTaken = true;
				break;
			}
			totalScore += score;
			BallStats ballStats = new BallStats(matchId, battingTeam.getTeamId(), bowlingTeam.getTeamId(), bowler, onStrike, score, wicketTaken);
			matchController.insertBallStats(ballStats);
			if (score % 2 != 0) {
				int tempPlayer = onStrike;
				onStrike = offStrike;
				offStrike = tempPlayer;
			}
			if (wicketTaken) {
				batsmen.remove((Integer) onStrike);
				if (batsmen.isEmpty()) {
					System.out.println("All the batsmen are knocked out! Your team's total score is " + totalScore);
					break;
				}
				showPlayers(batsmen);
				System.out.println(UserMessages.CHOOSE_ONSTRIKE);
				onStrike = choosePlayer(match, battingTeam);
			}
			overCount += 0.1;
			if (((int) (overCount * 10)) % 10 == 7) {
				overCount += 0.3;
				int tempBowler = bowler;
				bowlers.remove((Integer) bowler);
				showPlayers(bowlers);
				System.out.println(UserMessages.CHOOSE_BOWLER);
				bowler = choosePlayer(match, bowlingTeam);
				bowlers.add(tempBowler);
			}
		}
	}
	
	public int chooseMatch(User user) {
		int matchId;
		do {
			matchController.displayMatches(user);
			System.out.print(UserMessages.CHOOSE_MATCH);
			matchId = scanner.nextInt();
			scanner.nextLine();
			if (matchController.searchMatch(user, matchId)) {
				break;
			} else {
				System.out.println(UserMessages.NO_SUCH_MATCH);
			}
		} while (true);
		return matchId;
	}
	
	public int tossCoin(Match match) {
		Random random = new Random();
		if (random.nextInt(2) == 0) {
			System.out.println();
			System.out.println(UserMessages.TOSS_RESULT + match.getTeamA().getTeamId());
			return match.getTeamA().getTeamId();
		} else {
			System.out.println(UserMessages.TOSS_RESULT + match.getTeamB().getTeamId());
			return match.getTeamB().getTeamId();
		}
	}
	
	public int choosePlayer(Match match, Team team) {
		int retry, id;
		do {
			retry = 'n';
			id = scanner.nextInt();
			scanner.nextLine();
			if (team.getTeamId() == match.getTeamA().getTeamId()) {
				if (!(match.getTeamALineUp().getPlayerId().contains(id))) {
					System.out.print(UserMessages.INVALID_PLAYER);
					retry = 'y';
				}
			} else {
				if (!(match.getTeamBLineUp().getPlayerId().contains(id))) {
					System.out.print(UserMessages.INVALID_PLAYER);
					retry = 'y';
				}
			}
		} while (retry == 'y');
		return id;
	}

	public void showPlayers(ArrayList<Integer> players) {
		ArrayList<Player> playerList = matchController.fetchPlayers(players);
		System.out.println(UserMessages.PLAYER_NAME_TABLE);
		for (Player player : playerList) {
			System.out.println(player.getPlayerId() + "\t" + player.getFirstName() + "\t" + player.getLastName());
		}
	}
}