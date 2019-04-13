package sheridan.college.assignments.model;

import java.io.Serializable;

public class Hall implements Serializable {
	private int hallID;
	private String hallName;
	
	public int getHallID() {
		return hallID;
	}
	
	public void setHallID(int hID) {
		hallID = hID;
	}
	public String getHallName() {
		return hallName;
	}
	public void setHallName(String hName) {
		hallName = hName;
	}
}
