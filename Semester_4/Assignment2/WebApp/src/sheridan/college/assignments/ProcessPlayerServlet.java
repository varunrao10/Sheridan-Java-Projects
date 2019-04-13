// Name: Varun Rao  Student Number: 991498928
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
import sheridan.college.assignments.model.Team;


public class ProcessPlayerServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		
		String teamName = (String)sess.getAttribute("team");
		String action =(String)request.getParameter("Action");


		//We know control is coming from Addplayer.jsp
		if(action.equals("add")) {
			
			String playerName = request.getParameter("playerName");
			String playerAddress = request.getParameter("playerAddress");
			String playerRole = request.getParameter("playerRole");
			String playerActive = request.getParameter("playerActive");
			
			Player p = new Player();
			p.setPlayerName(playerName);
			p.setPlayerAddress(playerAddress);
			p.setPlayerRole(playerRole);
			
			if(playerActive == null)
				p.setActive(false);
			
			else if(playerActive.equals("on"))
				p.setActive(true);
						
			else
				p.setActive(false);
			
			PlayerDAO pDAO = new PlayerDAO(); 
			pDAO.AddPlayer(p,teamName);
			
			ArrayList<Player> playerList = pDAO.GetPlayers(teamName);
			sess.setAttribute("players", playerList);
			
			response.sendRedirect("ListPlayers");
			
		}
		
		//We know the control is coming from listplayers.jsp
		else if(action.equals("edit")){
			
			String playerName = request.getParameter("playerName");
			PlayerDAO pDAO = new PlayerDAO();
			Player p = pDAO.GetPlayer(playerName, teamName);
			
			sess.setAttribute("player", p);
			response.sendRedirect("EditPlayer");
			
			
		}
		//We know the control is coming from listplayers.jsp
		else if(action.equals("delete")) {
			String playerName = request.getParameter("playerName");
			
			PlayerDAO pDAO = new PlayerDAO();
			pDAO.DeletePlayer(playerName, teamName);
			
			ArrayList<Player> playerList = pDAO.GetPlayers(teamName);
			sess.setAttribute("players", playerList);
			
			response.sendRedirect("ListPlayers");
			
		}
		
		//We know the control is coming from editplayer.jsp
		else if(action.equals("save")) {
			String playerName = request.getParameter("playerName");
			String playerAddress = request.getParameter("playerAddress");
			String playerRole = request.getParameter("playerRole");
			String playerActive = request.getParameter("playerActive");
			
			Player p = (Player)sess.getAttribute("player");
			p.setPlayerName(playerName);
			p.setPlayerAddress(playerAddress);
			p.setPlayerRole(playerRole);
			
			if(playerActive == null)
				p.setActive(false);
			
			else if(playerActive.equals("on"))
				p.setActive(true);
						
			else
				p.setActive(false);
			
			PlayerDAO pDAO = new PlayerDAO(); 
			pDAO.SavePlayer(p,teamName);
			
			ArrayList<Player> playerList = pDAO.GetPlayers(teamName);
			sess.setAttribute("players", playerList);
			
			response.sendRedirect("ListPlayers");
		}
	}
}
