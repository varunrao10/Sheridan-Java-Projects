package ca.sheridancollege.assignments;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class VolumeCalc2 extends HttpServlet {

	public VolumeCalc2() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String h = request.getParameter("height");
		String w = request.getParameter("width");
		String d = request.getParameter("depth");
		
		Calculation c = new Calculation();
		
	
		String url = "results.jsp?"+c.CalculateVolume(h, w, d);
		
		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}