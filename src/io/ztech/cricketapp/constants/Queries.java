package io.ztech.cricketapp.constants;

public class Queries {
	private Queries() {}
	
	public static final String INSERT_USER = "insert into user (first_name, last_name, user_name, password) values (?, ?, ?, ?)";
	public static final String INSERT_PLAYER = "insert into player (team_id, first_name, last_name, user_id) values (?, ?, ?, ?)";
	public static final String INSERT_TEAM = "insert into team (team_name, user_id) values (?, ?)";
	public static final String FETCH_TEAMS = "select team_id, team_name from team";
	public static final String FETCH_USER = "select * from user where user_name = ?";
	public static final String FETCH_RECENT_TEAM_ID = "select team_id from team order by team_id desc limit 1"; 
	public static final String SEARCH_USER = "select count(*) from user where user_name = ?";
}
