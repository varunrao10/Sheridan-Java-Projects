package ca.sheridancollege.assignments;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReusableRocket extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		String h = req.getParameter("height");
		String w  = req.getParameter("weight");
		String reuse = req.getParameter("reuse");
		
		if (name.isEmpty() || h.isEmpty() || w.isEmpty()|| reuse.isEmpty())
		{
			//Case where one or more fields are empty
			RequestDispatcher rd = req.getRequestDispatcher("rocketregistration.jsp");
			resp.setContentType("text/html");
			out.println("<font color = red> Please fill all the fields</font>");
			rd.include(req, resp);
		}

		else {
			// Case USER entered all fields/attributes
			RequestDispatcher rd = req.getRequestDispatcher("rockethome.jsp");
			rd.forward(req, resp);
		}

	}

}

