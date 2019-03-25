// Name: Varun Rao  Student Number: 991498928

package sheridan.college.assignments;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AcademicStandingServlet extends HttpServlet {

	public AcademicStandingServlet() {
	}

	protected void doPost(HttpServletRequest request1, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sess = request1.getSession();
		String caller = request1.getParameter("caller");
		
		//Very first time when coming from index.html
  		if(caller.equals("index.html")) {
			ArrayList marks = new ArrayList<String>();
			double totalCredits = 0;
			sess.setAttribute("GradeList", marks);
			sess.setAttribute("TotalCredits", totalCredits);
			
		}
		else {
			
			String gradeSelection = request1.getParameter("grades");
				
			//The user has selected marks and pressed next
			ArrayList marks = (ArrayList)sess.getAttribute("GradeList");
			double totalCredits = (double)sess.getAttribute("TotalCredits");
			
			marks.add(gradeSelection);
			totalCredits = totalCredits +3;
			sess.setAttribute("TotalCredits", totalCredits);

		}
		
		response.setContentType("text/html");
		
		//Print Write Options to the html page so user can select the grades that they got.
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Academic Stnading Entry</title></head>");
		out.println("<body>");
		out.println("<h1>Sheridan Academic Standing Calculator</h1>");
		out.println("<form action=\"AcademicStandingServlet\" method=\"post\">");
		out.println("<select name = \"grades\">");
		out.println("<option value=\"A+ (90-100%)\">A+ (90-100%)</option>");
		out.println("<option value=\"A (80-89%)\">A (80-89%)</option>");
		out.println("<option value=\"B+ (75-79%)\">B+ (75-79%)</option>");
		out.println("<option value=\"B (70-74%)\">B (70-74%)</option>");
		out.println("<option value=\"C+ (65-69%)\">C+ (65-69%)</option>");
		out.println("<option value=\"C (60-64%)\">C (60-64%)</option>");
		out.println("<option value=\"D (50-59%)\">D (50-59%)</option>");
		out.println("<option value=\"F (0-49%)\">F (0-49%)</option>");
		out.println("</select>");
		
		//Makes sure when inputting a grade the second time that it always goes to the else statement
		out.println("<input type = \"hidden\" name = \"caller\"  value = \"AcademicStandingServlet\"/>");
		out.println("<input type=\"submit\" value=\"Next\">");
		out.println("</form>");

		//Create form that redirects to GpaCalculator when clicked
		out.println("<form action=\"GpaCalculator\" method=\"post\">");
		out.println("<input type=\"submit\" value=\"Done\">");
		out.println("</form>");
		
		out.println("</body>");
		out.println("</html>");
		
		
		
	}
}