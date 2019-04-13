// Name: Varun Rao  Student Number: 991498928
package sheridan.college.assignments.DAO;

import java.sql.*;
import java.util.ArrayList;

import sheridan.college.assignments.DBManager;
import sheridan.college.assignments.model.Player;

public class PlayerDAO {
	private DBManager dbConnect = new DBManager();

	public ArrayList<Player> GetPlayers(String team) {

		//Player Array List
		ArrayList<Player> playerList = new ArrayList<Player>();

		// Access player fields from the database and add them to the  player array list
		try {

			String sql = "Select PlayerID, PlayerName, PlayerAddress, PlayerRole, Active, player.TeamID "
					+ "From hockeyleague.player  " + "INNER JOIN hockeyleague.team  ON player.TeamID = team.TeamID "
					+ "WHERE team.TeamName = '" + team + "'";

			ResultSet rst = dbConnect.executeQuery(sql);

			while (rst.next()) {
				Player p = new Player();
				p.setPlayerID(rst.getInt(1));
				p.setPlayerName(rst.getString(2));
				p.setPlayerAddress(rst.getString(3));
				p.setPlayerRole(rst.getString(4));
				p.setActive(rst.getBoolean(5));
				p.setTeamID(rst.getInt(6));
				playerList.add(p);
			}
		}

		catch (SQLException e) {
			System.out.println("Error when trying to execute query" + e.getMessage());
		}

		return playerList;
	}

	//Called when the user clicks add, which will access the database, 
	public boolean AddPlayer(Player p, String teamName) {

		try {
			ResultSet rst = dbConnect
					//Set the new players ID to 1 if it is null, otherwise the next ID number afterwards
					.executeQuery("select IFNULL(max(PlayerID)+1,1) as PlayerID FROM hockeyleague.player"); 
			rst.next();
			p.setPlayerID(rst.getInt(1));

			rst = dbConnect.executeQuery("select TeamID FROM hockeyleague.team where TeamName = '" + teamName + "'");
			rst.next();
			p.setTeamID(rst.getInt(1));

			//Insert the data from the Player Object into the database
			String insertSQL = "Insert into hockeyleague.player(PlayerID,PlayerName,PlayerAddress,PlayerRole,Active,TeamID) values("
					+ p.getPlayerID() + ",'" + p.getPlayerName() + "','" + p.getPlayerAddress() + "','"
					+ p.getPlayerRole() + "'," + p.isActive() + "," + p.getTeamID() + ")";
			dbConnect.executeUpdate(insertSQL);

		}

		catch (SQLException e) {
			System.out.println("Error when trying to execute query" + e.getMessage());
		}

		return true;
	}

	//When in EditPlayer, you click save, calls this function which updates the database
	public boolean SavePlayer(Player p, String teamName) {

		String updateSQL = "Update hockeyleague.player" + " Set PlayerName = '" + p.getPlayerName() + "',"
				+ "PlayerAddress = '" + p.getPlayerAddress() + "'," + "PlayerRole = '" + p.getPlayerRole() + "',"
				+ "Active = " + p.isActive() +  " WHERE PlayerID = " + p.getPlayerID();

		dbConnect.executeUpdate(updateSQL);
		return true;
	}
	
	//When in EditPlayer, you click delete, calls this function which updates the database
	public boolean DeletePlayer(String playerName, String teamName) {

		String deleteSQL = "delete  FROM hockeyleague.player" +
		" Where PlayerName = '"+playerName +"'"+
		" AND TeamID = (Select TeamID from hockeyleague.team where TeamName = '" + teamName +"')";
				
		dbConnect.executeUpdate(deleteSQL);
		return true;
	}

	//Gets the entire player object, 
	public Player GetPlayer(String playerName, String teamName) {

		Player p = new Player();

		try {

			String sql = "Select PlayerID, PlayerName, PlayerAddress, PlayerRole, Active, player.TeamID "
					+ "From hockeyleague.player  " + "INNER JOIN hockeyleague.team  ON player.TeamID = team.TeamID "
					+ "WHERE team.TeamName = '" + teamName + "' " + "AND player.PlayerName = '" + playerName + "' ";

			ResultSet rst = dbConnect.executeQuery(sql);

			rst.next();

			p.setPlayerID(rst.getInt(1));
			p.setPlayerName(rst.getString(2));
			p.setPlayerAddress(rst.getString(3));
			p.setPlayerRole(rst.getString(4));
			p.setActive(rst.getBoolean(5));
			p.setTeamID(rst.getInt(6));

		}

		catch (SQLException e) {
			System.out.println("Error when trying to execute query" + e.getMessage());
		}

		return p;

	}
}
