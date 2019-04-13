package sheridan.college.assignments.model;

import java.io.Serializable;

public class Client implements Serializable {
	private int ClientID;
	private String ClientName;
	private String CreditCard;
	public int getClientID() {
		return ClientID;
	}
	
	public void setClientID(int clientID) {
		ClientID = clientID;
	}
	public String getClientName() {
		return ClientName;
	}
	public void setClientName(String clientName) {
		ClientName = clientName;
	}
	public String getCreditCard() {
		return CreditCard;
	}
	public void setCreditCard(String creditCard) {
		CreditCard = creditCard;
	}
}
