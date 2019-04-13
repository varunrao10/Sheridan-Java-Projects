// Name: Varun Rao  Student Number: 991498928
package sheridan.college.assignments.DAO;

import java.sql.*;
import java.util.ArrayList;

import sheridan.college.assignments.DBManager;
import sheridan.college.assignments.model.Team;

public class TeamDAO {
	private DBManager dbConnect = new DBManager();

	public ArrayList<Team> GetTeams() {

		//Team Array List 
		ArrayList<Team> teamList = new ArrayList<Team>();

		//Connect to database get TeamID and TeamName values and use while loop to set the values, add to team list array
		try {
			ResultSet rst = dbConnect.executeQuery("Select TeamID,TeamName From Team");

			while (rst.next()) {
				Team t = new Team();
				t.setTeamID(rst.getInt(1));
				t.setTeamName(rst.getString(2));
				
				teamList.add(t);
			}
		}

		catch (SQLException e) {
			System.out.println("Error when trying to execute query"+ e.getMessage());
		}
		
		return teamList;
	}
}
