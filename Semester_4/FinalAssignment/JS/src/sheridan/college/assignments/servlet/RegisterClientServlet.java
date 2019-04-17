/*
  	By Varun Rao
 	Description: Register Client Servlet
*/

package sheridan.college.assignments.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.ha.backend.Sender;

import sheridan.college.assignments.DAO.ClientDAO;
import sheridan.college.assignments.model.Client;

public class RegisterClientServlet extends HttpServlet {
	
    public RegisterClientServlet() {
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get hold of Session Object
		HttpSession sess = request.getSession();
		
		//Create New Client Object and Get Session Parameters from RegisterClient jsp
		Client c = new Client();
		c.setClientName(request.getParameter("ClientName"));
		c.setCreditCard(request.getParameter("CreditCard"));
		
		//Make a new object of ClientDAO and use the AddClient method to interact with database
		ClientDAO cDAO = new ClientDAO();
		try {
			cDAO.AddClient(c);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		response.sendRedirect("FirstScreen.jsp");
		
		
	}

}
