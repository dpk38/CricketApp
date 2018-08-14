package io.ztech.cricketapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import io.ztech.cricketapp.beans.Team;
import io.ztech.cricketapp.constants.Queries;
import io.ztech.cricketapp.dbutils.Connector;

public class CricketDAO {
	Connector connector;

	public CricketDAO() {
		connector = new Connector();
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
}
