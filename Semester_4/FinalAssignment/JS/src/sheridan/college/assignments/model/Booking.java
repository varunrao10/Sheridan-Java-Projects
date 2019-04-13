package sheridan.college.assignments.model;
import java.util.Date;

import java.io.Serializable;

public class Booking implements Serializable {
	private int BookingID;
	private int HallID;
	private int ClientID;
	private Date Date = new Date();
	public int getBookingID() {
		return BookingID;
	}
	
	public void setBookingID(int bookingID) {
		BookingID = bookingID;
	}
	public int getHallID() {
		return HallID;
	}
	public void setHallID(int hallID) {
		HallID = hallID;
	}
	public int getClientID() {
		return ClientID;
	}
	public void setClientID(int clientID) {
		ClientID = clientID;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
}
