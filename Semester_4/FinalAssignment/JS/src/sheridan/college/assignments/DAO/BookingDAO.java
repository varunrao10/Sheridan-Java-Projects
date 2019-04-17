/*
 *
 */

package sheridan.college.assignments.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import sheridan.college.assignments.model.Booking;
import sheridan.college.assignments.model.Client;
import sheridan.college.assignments.model.Hall;

public class BookingDAO {
	private DBManager dbConnect = new DBManager();
	
	public boolean AddBooking(Booking b) throws Exception {

		try {
			ResultSet rst = dbConnect
					.executeQuery("select IFNULL(max(BookingID)+1,1) as BookingID FROM bookingsys.booking"); 
			rst.next();
			b.setBookingID(rst.getInt(1));

			Date bDate = b.getBookingDate();
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");  
			String strDate = dateFormat.format(bDate); 
	
			String insertSQL = "insert into bookingsys.booking (BookingID, HallID, ClientID, BookingDate) VALUES ("
					+ b.getBookingID() + "," + b.getHallID() + "," + b.getClientID() + ",STR_TO_DATE('" + strDate + "', '%m/%d/%Y')" + ")";
			System.out.println(insertSQL);
			dbConnect.executeUpdate(insertSQL);

		}

		catch (SQLException e) {
			System.out.println("Error when trying to execute query" + e.getMessage());
			throw new Exception("Error when trying to execute query" + e.getMessage());
		}

		return true;
	}

	
}
