package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {
			

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		String name = req.getParameter("fullname");
		String addr = req.getParameter("address");
		String age = req.getParameter("age");
		String qual = req.getParameter("qual");
		String percent = req.getParameter("percent");
		String year = req.getParameter("yop");

		if (name.isEmpty() || addr.isEmpty() || age.isEmpty() || qual.isEmpty() || percent.isEmpty()
				|| year.isEmpty()) 
		{
			//Case where one or more fields are empty
			RequestDispatcher rd = req.getRequestDispatcher("Registration.jsp");
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
