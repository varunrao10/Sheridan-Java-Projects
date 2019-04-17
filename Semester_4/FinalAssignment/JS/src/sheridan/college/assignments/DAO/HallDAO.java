/*
 * By Varun Rao
 * Description: HallDAO
 */
package sheridan.college.assignments.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import sheridan.college.assignments.model.Hall;

public class HallDAO {
	private DBManager dbConnect = new DBManager();
	
	public Map GetHalls() {

		//Hall Array List
		Map hallList = new HashMap();

		try {
			
			String sql = "Select HallID, HallName From bookingsys.hall";

			ResultSet rst = dbConnect.executeQuery(sql);

			while (rst.next()) {
				Hall h = new Hall();
				int hallID = rst.getInt(1);
				String hallName = rst.getString(2);

				h.setHallID(hallID);
				h.setHallName(hallName);
				hallList.put(hallID,h);
			}
		}

		catch (SQLException e) {
			System.out.println("Error when trying to execute query" + e.getMessage());
		}

		return hallList;
	}
	
	public boolean AddHall(Hall h) throws Exception {

		try {
			//Get The Next HallID
			ResultSet rst = dbConnect
					.executeQuery("select IFNULL(max(HallID)+1,1) as HallID FROM bookingsys.hall"); 
			rst.next();
			h.setHallID(rst.getInt(1));

			String insertSQL = "Insert into bookingsys.hall(HallID, HallName) values("
					+ h.getHallID() + ",'" + h.getHallName() + "')";
			dbConnect.executeUpdate(insertSQL);
		}

		catch (SQLException e) {
			System.out.println("Error when trying to execute query" + e.getMessage());
		}
		return true;
	}
	
	public int GetHallID(String hallName) {
		int hallID = -1;
		try {
			ResultSet rst = dbConnect
					.executeQuery("select HallID From bookingsys.hall Where HallName = '" + hallName + "'"); 
			rst.next();
			hallID = rst.getInt(1);
		}

		catch (SQLException e) {
			System.out.println("Error when trying to execute query" + e.getMessage());
		}
		return hallID;
	}
	
	public boolean SaveHall(Hall h) throws Exception {

		String updateSQL = "Update bookingsys.hall SET HallName = '" + h.getHallName()	+ "' Where hallID = " + h.getHallID();
		dbConnect.executeUpdate(updateSQL);

		return true;
	}
	
	public boolean DeleteHall(Hall h) throws Exception {

		String deleteSQL = "Delete from bookingsys.hall  Where HallID = " + h.getHallID();
		dbConnect.executeUpdate(deleteSQL);

		return true;
	}

}
