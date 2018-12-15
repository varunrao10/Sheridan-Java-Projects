package ca.sheridancollege.assignments;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HybridCar extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		String brand = req.getParameter("brand");
		String model = req.getParameter("model");
		String effidx = req.getParameter("effidx");
		
		if (brand.isEmpty() || model.isEmpty() || effidx.isEmpty())
		{
			//Case where one or more fields are empty
			RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
			resp.setContentType("text/html");
			out.println("<font color = red> Please fill all the fields</font>");
			rd.include(req, resp);
		}

		else {
			// Case USER entered all fields/attributes
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		}

	}

}

