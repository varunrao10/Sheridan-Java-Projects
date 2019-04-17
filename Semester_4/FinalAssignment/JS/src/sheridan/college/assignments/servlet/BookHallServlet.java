/*
 * By Varun Rao 
 * Description: BookHallServlet
 */


package sheridan.college.assignments.servlet;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sheridan.college.assignments.DAO.BookingDAO;
import sheridan.college.assignments.DAO.ClientDAO;
import sheridan.college.assignments.DAO.HallDAO;
import sheridan.college.assignments.model.Booking;


public class BookHallServlet extends HttpServlet {

    public BookHallServlet() {
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get a hold of Session object
		HttpSession sess = request.getSession();
		
		String buttonSubmit = request.getParameter("Submit");
		
		HallDAO hDAO = new HallDAO();
		ClientDAO cDAO = new ClientDAO();
		
		//Coming here from firstscreen
		if(buttonSubmit == null) {
				Map hallMap =  hDAO.GetHalls();
				sess.setAttribute("halls", hallMap);
				
				Map clientMap =  cDAO.GetClients();
				sess.setAttribute("clients", clientMap);
		}
		
		//Coming from bookhall.jsp
		else{	
			String clientSelected = request.getParameter("ClientSelection");
			String hallSelected = request.getParameter("HallSelection");
			String bookingDatestr = request.getParameter("BookingDate");
			
			//Converting bookingDate to date type
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date bookingDate = null;
			
			try {
				 bookingDate = sdf.parse(bookingDatestr);
			}
			
			catch(Exception e) {
				System.out.println("Error when parsing date" + e.getMessage());
			}
			
			int cID = cDAO.GetClientID(clientSelected);
			int hID = hDAO.GetHallID(hallSelected);
			
			Booking b = new Booking();
			b.setClientID(cID);
			b.setHallID(hID);
			b.setBookingDate(bookingDate);
			
			BookingDAO bDAO = new BookingDAO();
			
			String message = "booking done successfully";
			
			try {
				bDAO.AddBooking(b);
			}
			
			catch(Exception e) {
				message = "booking already exists, please try on a different date";
			}
	
			sess.setAttribute("message", message);
		}
		
		response.sendRedirect("BookHall.jsp");
	}

}
