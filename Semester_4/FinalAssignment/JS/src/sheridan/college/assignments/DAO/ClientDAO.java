package sheridan.college.assignments.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import sheridan.college.assignments.model.Client;
import sheridan.college.assignments.model.Hall;

public class ClientDAO {
	private DBManager dbConnect = new DBManager();
	
	public Map GetClients() {

		//Client Array List
		Map clientList = new HashMap();

		try {
			String sql = "Select ClientID, ClientName, CreditCard from bookingsys.client";

			ResultSet rst = dbConnect.executeQuery(sql);

			while (rst.next()) {
				Client c = new Client();
				int clientID = rst.getInt(1);
				String clientName = rst.getString(2);
				String creditCard = rst.getString(3);
				
				c.setClientID(clientID);
				c.setClientName(clientName);
				c.setCreditCard(creditCard);
				clientList.put(clientID,c);
			}
		}

		catch (SQLException e) {
			System.out.println("Error when trying to execute query" + e.getMessage());
		}

		return clientList;
	}
	
	public int GetClientID(String clientName) {
		int clientID = -1;
		try {
			ResultSet rst = dbConnect
					.executeQuery("select ClientID From bookingsys.client Where ClientName = '" + clientName + "'"); 
			rst.next();
			clientID = rst.getInt(1);
		}

		catch (SQLException e) {
			System.out.println("Error when trying to execute query" + e.getMessage());
		}
		return clientID;
	}
	
	public boolean AddClient(Client c) throws Exception {

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
