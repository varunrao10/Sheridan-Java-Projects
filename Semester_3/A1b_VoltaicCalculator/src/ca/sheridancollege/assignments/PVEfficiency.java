
package ca.sheridancollege.assignments;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PVEfficiency extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String html= "<html><head><meta http-equiv=\"refresh\" content=\"1; URL=https://photovoltaic-software.com/pvgis.php\"><meta name=\"keywords\" content=\"automatic redirection\"></head><body></body></html>";
		PrintWriter out = response.getWriter();	
		out.write(html);

        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doGet(request,response);
	}

}



