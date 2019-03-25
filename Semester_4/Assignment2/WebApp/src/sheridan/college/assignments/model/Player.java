package sheridan.college.assignments.model;

import java.io.Serializable;

public class Player implements Serializable {
	private int PlayerID;
	private String PlayerName;

	public int getPlayerID() {
		return PlayerID;
	}

	public void setPlayerID(int playerID) {
		PlayerID = playerID;
	}

	public String getPlayerName() {
		return PlayerName;
	}

	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}

	public int getTeamID() {
		return TeamID;
	}

	public void setTeamID(int teamID) {
		TeamID = teamID;
	}

	private int TeamID;

	public Player() {

	}

}
