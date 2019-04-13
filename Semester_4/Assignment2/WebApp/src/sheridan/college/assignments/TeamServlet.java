// Name: Varun Rao  Student Number: 991498928
package sheridan.college.assignments;
import java.sql.*;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sheridan.college.assignments.DAO.TeamDAO;
import sheridan.college.assignments.model.Team;

//The starting point of the application
public class TeamServlet extends HttpServlet {
	
	
	private ArrayList<Team> teamList = new ArrayList<Team>();
	
    public TeamServlet() {
    	
    }
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TeamDAO tDAO = new TeamDAO();
		teamList = tDAO.GetTeams();
		
		HttpSession sess = request.getSession();
		
		sess.setAttribute("teams", teamList);
		
		response.sendRedirect("ShowTeams");
		
		
	}

}
