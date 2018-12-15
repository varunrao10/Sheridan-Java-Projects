package ca.sheridancollege.controllers;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {

	public Hello() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Date today = new Date();
		out.println("<html> " + "<body>" + "<h1>Welcome to Java 3 Servlet</h1>"

				+ "<br>" + "<h2>Varun Rao 55555555</h2>" + "</br>" + "<br>" + today + "</br>" + "<br>"
				+ "Sheridan College - Davis Campus" + "</br>" + "<br>" + "7899 McLaughlin Road" + "</br>" + "<br>"
				+ "Brampton, Ontario" + "</br>" + "<br>" + "L6Y 5H9</body>" + "</br>" + "</html>");

		response.setContentType("text/html");
		response.getWriter().append("<h1>Hello World Servlet!</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Date today = new Date();
		out.println("<html> " + "<body>" + "<h1>Welcome to Java 3 Servlet</h1>"
				+ "<h2>Varun Rao 991498928</h2>" + "<br/>" + "Username : " + request.getParameter("username") + "<br/>" + today + "<br/>" 
				+ "Sheridan College - Davis Campus" + "<br/>" + "7899 McLaughlin Road" + "<br/>"
				+ "Brampton, Ontario" + "<br/>"  + "L6Y 5H9 </body>" + "</html>");

		response.setContentType("text/html");
		out.append("<h1>Hello World Servlet!</h1>");

	}

}