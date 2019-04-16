package sheridan.college.assignments.model;
import java.util.Date;

import java.io.Serializable;

public class Booking implements Serializable {
	private int bookingID;
	private int hallID;
	private int clientID;
	private Date bookingDate = new Date();
	
	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	public int getHallID() {
		return hallID;
	}
	public void setHallID(int hallID) {
		this.hallID = hallID;
	}
	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

}
