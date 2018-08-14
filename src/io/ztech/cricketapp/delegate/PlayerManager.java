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
}
