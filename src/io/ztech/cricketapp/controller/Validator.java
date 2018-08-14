package io.ztech.cricketapp.controller;

import java.util.regex.Pattern;

public class Validator {
	public Validator() {
		
	}
	
	public boolean validateInput(String input, String regex) {
		if (Pattern.matches(regex, input)) {
			return true;
		}
		return false;
	}
}
