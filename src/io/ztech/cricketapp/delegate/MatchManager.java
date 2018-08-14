package io.ztech.cricketapp.delegate;

import java.util.Scanner;

import io.ztech.cricketapp.beans.Player;
import io.ztech.cricketapp.constants.MainMenuOptions;
import io.ztech.cricketapp.constants.UserMessages;
import io.ztech.cricketapp.dao.CricketDAO;

public class MatchManager {
	
	Scanner scanner;
	CricketDAO dao;
	
	public MatchManager() {
		scanner = new Scanner(System.in);
		dao = new CricketDAO();
	}
	
	public void createMatch() {
		
	}
}
