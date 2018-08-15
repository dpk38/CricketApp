package io.ztech.cricketapp.constants;

public class Queries {
	private Queries() {}
	
	public static final String INSERT_USER = "insert into user (first_name, last_name, user_name, password) values (?, ?, ?, ?)";
	public static final String INSERT_PLAYER = "insert into player (team_id, first_name, last_name, user_id) values (?, ?, ?, ?)";
	public static final String INSERT_TEAM = "insert into team (team_name, user_id) values (?, ?)";
	
	public static final String FETCH_TEAMS = "select team_id, team_name from team where user_id = ?";
	public static final String FETCH_TEAM_PLAYERS = "select team_id, player_id, first_name, last_name from player where team_id = ?";
	public static final String FETCH_USER = "select * from user where user_name = ?";
	public static final String FETCH_RECENT_TEAM_ID = "select team_id from team order by team_id desc limit 1"; 
	
	public static final String SEARCH_USER = "select count(*) from user where user_name = ?";
	public static final String SEARCH_TEAM = "select count(*) from team where team_id = ? and user_id = ?";
	public static final String SEARCH_PLAYER = "select count(*) from player where player_id = ? and user_id = ?";
	
	public static final String UPDATE_TEAM_NAME = "update team set team_name = ? where team_id = ?";
	public static final String UPDATE_PLAYER_TEAM = "update player set team_id = ? where player_id = ?";
	public static final String UPDATE_PLAYER_FIRST_NAME = "update player set first_name = ? where player_id = ?";
	public static final String UPDATE_PLAYER_LAST_NAME = "update player set last_name = ? where player_id = ?";
	
	public static final String ADD_PLAYER_TO_TEAM = "insert into player (team_id, first_name, last_name, user_id) values (?, ?, ?, ?)";
	
	public static final String DELETE_PLAYER = "delete from player where team_id = ? and player_id = ?";
}
