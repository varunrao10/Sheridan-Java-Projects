package ca.sheridancollege.assignments;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class VolumeCalc extends HttpServlet {

	public VolumeCalc() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String h = request.getParameter("height");
		String w = request.getParameter("width");
		String d = request.getParameter("depth");
		
		int volume = Integer.parseInt(h) * Integer.parseInt(w) * Integer.parseInt(d);
		String url = "results.jsp?height="+ h + "&width="+ w + "&depth=" +d + "&volume=" +volume;
		
		response.sendRedirect(url);
	}



}