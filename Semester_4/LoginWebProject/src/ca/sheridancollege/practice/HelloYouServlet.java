package ca.sheridancollege.practice;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloYouServlet extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		String resume = request.getParameter("resume");
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();
        out.print("Name:" + "  " + name + "<br/>");
        out.print("Number" + " " + number + "<br/>");
        out.print("Resume" + " " + resume + "<br/>");
        
		
		/*String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();
        if(username.equals(password)) {
        	out.print("Access Granted");
        }
        else 
        	out.print("Access Denied");
		 */          
	}
}

