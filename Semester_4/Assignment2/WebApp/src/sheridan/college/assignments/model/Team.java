// Name: Varun Rao  Student Number: 991498928
package sheridan.college.assignments.model;

import java.io.Serializable;

public class Team implements Serializable {
	private int teamID;
	private String teamName;
	
	public Team() {
		
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int tID) {
		teamID = tID;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String tName) {
		teamName = tName;
	}
}
