package ca.sheridancollege.assignments;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class VolumeCalc3 extends HttpServlet {

	public VolumeCalc3() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/results2.jsp");
        dispatcher.include(request, response);
        
	}



}