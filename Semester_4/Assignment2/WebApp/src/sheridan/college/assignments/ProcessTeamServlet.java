package sheridan.college.assignments;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sheridan.college.assignments.DAO.PlayerDAO;
import sheridan.college.assignments.DAO.TeamDAO;
import sheridan.college.assignments.model.Player;
//Name: Varun Rao  Student Number: 991498928
public class ProcessTeamServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String team =(String)request.getParameter("teamSelect");
		String action =(String)request.getParameter("Action");
		
		HttpSession sess = request.getSession();
		sess.setAttribute("team", team);
		
		if(action.equals("add")) {
			
			response.sendRedirect("AddPlayer");
		}
		
		//You clicked on edit on the home page
		else {
			
			PlayerDAO pDAO = new PlayerDAO();
			ArrayList<Player> players = pDAO.GetPlayers(team);
			
			sess.setAttribute("players", players);
			
			
			
			response.sendRedirect("ListPlayers");
		}
	}
}
