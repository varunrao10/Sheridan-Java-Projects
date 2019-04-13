package sheridan.college.assignments.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import sheridan.college.assignments.model.Client;

public class ClientDAO {
	private DBManager dbConnect = new DBManager();
	
	public boolean AddClient(Client c) {

		try {
			ResultSet rst = dbConnect
					.executeQuery("select IFNULL(max(ClientID)+1,1) as ClientID FROM bookingsys.client"); 
			rst.next();
			c.setClientID(rst.getInt(1));

		
			
			String insertSQL = "Insert into bookingsys.client(ClientID, ClientName, CreditCard) values("
					+ c.getClientID() + ",'" + c.getClientName() + "','" + c.getCreditCard() + "')";
			dbConnect.executeUpdate(insertSQL);

		}

		catch (SQLException e) {
			System.out.println("Error when trying to execute query" + e.getMessage());
		}

		return true;
	}

}
