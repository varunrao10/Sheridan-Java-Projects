package sheridan.ejava.assignments;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VolumeCalc")
public class VolumeCalc extends HttpServlet {
	
	public VolumeCalc() {
    
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Requests variables from our form
		String h = request.getParameter("height");
		String w = request.getParameter("width");
		String d = request.getParameter("depth");
		String numerator = request.getParameter("numerator");
		String denominator = request.getParameter("denominator");
		
	
		//Calls the calculation class, parses and sets the attributes to integer 
		Calculation c = new Calculation();
		int Volume = c.CalcVolume(Integer.parseInt(h) , Integer.parseInt(w), Integer.parseInt(d));
		request.setAttribute("Volume", Volume);
		request.setAttribute("numerator", Integer.parseInt(numerator));
		request.setAttribute("denominator", Integer.parseInt(denominator) );
		
		
		//Set another 2 attributes with the numerator and denominator
		request.getRequestDispatcher("/VolumeResults.jsp").forward(request, response);
	
	}
}
