package io.ztech.cricketapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import io.ztech.cricketapp.beans.Player;
import io.ztech.cricketapp.beans.Team;
import io.ztech.cricketapp.beans.User;
import io.ztech.cricketapp.constants.Queries;
import io.ztech.cricketapp.dbutils.Connector;

public class CricketDAO {
	Connector connector;

	public CricketDAO() {
		connector = new Connector();
	}

	public void insertUser(User user) {
		PreparedStatement ps = null;
		Connection con = connector.openConnection();
		
		try {
			ps = con.prepareStatement(Queries.INSERT_USER);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUserName());
			ps.setString(4, user.getPassword());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Exception caught at insertUser(): " + e);
		} finally {
			connector.closeConnection(con, null, ps);
		}
	}
	
	public void insertPlayer(Player player) {
		PreparedStatement ps = null;
		Connection con = connector.openConnection();
		
		try {
			ps = con.prepareStatement(Queries.INSERT_PLAYER);
			ps.setInt(1, player.getTeamId());
			ps.setString(2, player.getFirstName());
			ps.setString(3, player.getLastName());
			ps.setInt(4, player.getUser().getUserId());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Exception caught at insertPlayer(): " + e);
		} finally {
			connector.closeConnection(con, null, ps);
		}
	}
	
	public void insertTeam(Team team) {
		PreparedStatement ps = null;
		Connection con = connector.openConnection();
		
		try {
			ps = con.prepareStatement(Queries.INSERT_TEAM);
			ps.setString(1, team.getTeamName());
			ps.setInt(2, team.getUser().getUserId());
			ps.execute();
			for (Player player : team.getPlayers()) {
				player.setTeamId(getRecentTeamId());
				insertPlayer(player);
			}
		} catch (SQLException e) {
			System.out.println("Exception caught at insertTeam(): " + e);
		} finally {
			connector.closeConnection(con, null, ps);
		}
	}
	
	public int getRecentTeamId() {
		PreparedStatement ps = null;
		Connection con = connector.openConnection();
		ResultSet rs = null;
		int teamId = 0;
		
		try {
			ps = con.prepareStatement(Queries.FETCH_RECENT_TEAM_ID);
			rs = ps.executeQuery();
			rs.next();
			teamId = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("Exception caught at insertTeam(): " + e);
		} finally {
			connector.closeConnection(con, null, ps);
		}
		return teamId;
	}
	
	public ArrayList<Team> fetchTeams() {
		PreparedStatement ps = null;
		Connection con = connector.openConnection();
		ResultSet rs = null;
		ArrayList<Team> teamList = new ArrayList<>();

		try {
			ps = con.prepareStatement(Queries.FETCH_TEAMS);
			rs = ps.executeQuery();
			while (rs.next()) {
				Team newTeam = new Team();
				newTeam.setTeamId(rs.getInt("team_id"));
				newTeam.setTeamName(rs.getString("team_name"));
				teamList.add(newTeam);
			}
		} catch (SQLException e) {
			System.out.println("Exception caught at fetchTeams(): " + e);
		} finally {
			connector.closeConnection(con, rs, ps);
		}
		return teamList;
	}
	
	public boolean searchUser(User user) {
		PreparedStatement ps = null;
		Connection con = connector.openConnection();
		ResultSet rs = null;
		boolean flag = false;
		
		try {
			ps = con.prepareStatement(Queries.SEARCH_USER);
			ps.setString(1, user.getUserName());
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == 0) {
					flag = false;
				} else {
					flag = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Exception caught at searchUser(): " + e);
		} finally {
			connector.closeConnection(con, rs, ps);
		}
		return flag;
	}
	
	public User fetchUser(User user) {
		PreparedStatement ps = null;
		Connection con = connector.openConnection();
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(Queries.FETCH_USER);
			ps.setString(1, user.getUserName());
			rs = ps.executeQuery();
			while (rs.next()) {
				String password = rs.getString("password"); 
				if (user.getPassword().equals(password)) {
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setUserId(rs.getInt("user_id"));
					return user;
				}
			}
		} catch (SQLException e) {
			System.out.println("Exception caught at searchUser(): " + e);
		} finally {
			connector.closeConnection(con, rs, ps);
		}
		return null;
	}
}
