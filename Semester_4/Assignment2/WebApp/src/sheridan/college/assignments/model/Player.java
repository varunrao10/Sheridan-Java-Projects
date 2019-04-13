// Name: Varun Rao  Student Number: 991498928
package sheridan.college.assignments.model;

import java.io.Serializable;

public class Player implements Serializable {
	private int playerID;
	private String playerName;
	private String playerAddress;
	private String playerRole;
	private boolean active;
	private int TeamID;

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerAddress() {
		return playerAddress;
	}

	public void setPlayerAddress(String playerAddress) {
		this.playerAddress = playerAddress;
	}

	public String getPlayerRole() {
		return playerRole;
	}

	public void setPlayerRole(String playerRole) {
		this.playerRole = playerRole;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean isActive) {
		this.active = isActive;
	}

	public int getTeamID() {
		return TeamID;
	}

	public void setTeamID(int teamID) {
		TeamID = teamID;
	}

	public Player() {

	}

}
