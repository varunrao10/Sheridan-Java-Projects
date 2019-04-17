/*
  	By Varun Rao
 	Description: Client Object
*/

package sheridan.college.assignments.model;
import java.io.Serializable;

public class Client implements Serializable {
	private int clientID;
	private String clientName;
	private String creditCard;
	
	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	

}
