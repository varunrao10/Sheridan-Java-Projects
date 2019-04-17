package sheridan.college.assignments.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sheridan.college.assignments.DAO.HallDAO;
import sheridan.college.assignments.model.Hall;


public class HallAdminServlet extends HttpServlet {
	
 
    public HallAdminServlet() {
   
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		String hallName = request.getParameter("HallName");
		String hallID = request.getParameter("HallID");
		String hallAction = request.getParameter("HallButton");
		HallDAO hDAO = new HallDAO();
		
		if(hallName == null) {
			Map hallMap =  hDAO.GetHalls();
			sess.setAttribute("halls", hallMap);
		}
		
		else {
			
			Map hallMap = (HashMap) sess.getAttribute("halls");
			
			if(hallAction.equals("Add")) {
				Hall h = new Hall();
				h.setHallName(hallName);
				int nextIndex = hallMap.size() + 1;
				h.setHallID(nextIndex);
				hallMap.put(nextIndex, h);
				try {
				hDAO.AddHall(h);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			else if(hallAction.equals("Edit")) {
				int hID = Integer.parseInt(hallID);
				Hall h = (Hall) hallMap.get(hID);
				h.setHallName(hallName);
				try {
				hDAO.SaveHall(h);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			else {
				int hID = Integer.parseInt(hallID);
				Hall h = (Hall) hallMap.get(hID);
				try {
				hDAO.DeleteHall(h);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				hallMap.remove(hID);
				
			}
			
		}
		
		response.sendRedirect("HallAdmin.jsp");
	}

}
