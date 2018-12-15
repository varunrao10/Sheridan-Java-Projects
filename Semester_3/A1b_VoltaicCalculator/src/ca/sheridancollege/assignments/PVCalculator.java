	package ca.sheridancollege.assignments;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PVCalculator extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pvtech = request.getParameter("pvtech");
		String capacity = request.getParameter("capacity");
		String estsyslosses = request.getParameter("estsyslosses");
		
		PrintWriter out = response.getWriter();
		
		if ((pvtech == null) || (pvtech.equals("")) || 
			(capacity == null) || (capacity.equals("")) || 
			(estsyslosses == null) || (estsyslosses.equals("")) ){
				out.append("<h3 style='color:red;'>Please enter all REQUIRED field.The PV Calculator will be unable to determine the efficiency of the system</h3>");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.html");
		        dispatcher.include(request, response);	
		}
		else {
			response.sendRedirect("PVEfficiency");
		}
		
		
		
		
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doGet(request,response);
	}

}

