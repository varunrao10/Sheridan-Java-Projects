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

public class GpaCalculator extends HttpServlet {

	public GpaCalculator() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Get a handle to the Session object
		HttpSession sess = request.getSession();
		ArrayList marks = (ArrayList) sess.getAttribute("GradeList");
		double totalCredits = (double) sess.getAttribute("TotalCredits");
		double totalWeightedGradePoint = 0;
		
		//Loop  that Displays the Grade picked and adds a counter to the TotalWeightedGradePoint for the Gpa Calculation
		for (int i = 0; i < marks.size(); i++) {
			String currentMark = (String) marks.get(i);
			currentMark = currentMark.substring(0,2);
			
			if (currentMark.equals("A+")) {
				totalWeightedGradePoint = totalWeightedGradePoint + 4;
			} 
			
			else if (currentMark.equals("A ")) {
				totalWeightedGradePoint = totalWeightedGradePoint + 4;
			}

			else if (currentMark.equals("B+")) {
				totalWeightedGradePoint = totalWeightedGradePoint + 3.5;
			}

			else if (currentMark.equals("B ")) {
				totalWeightedGradePoint = totalWeightedGradePoint + 3;
			}

			else if (currentMark.equals("C+")) {
				totalWeightedGradePoint = totalWeightedGradePoint + 2;
			}

			else if (currentMark.equals("C ")) {
				totalWeightedGradePoint = totalWeightedGradePoint + 2;
			}

			else if (currentMark.equals("D ")) {
				totalWeightedGradePoint = totalWeightedGradePoint + 1;
			}

			else if (currentMark.equals("F ")) {
				totalWeightedGradePoint = totalWeightedGradePoint + 0;
			}
			
		}
		
		//Gpa Calculation
		double GPA = (totalWeightedGradePoint *3)/totalCredits;
		String academicStanding = "";
		
		//Checks what the student qualifies as by comparing Gpa to the ranges below
		if(GPA <= 4 && GPA >= 3.80)
			academicStanding = "Sheridan Scholar";
		
		else if(GPA < 3.79 && GPA >= 3.50)
			academicStanding = "Honours";
			
		else if(GPA < 3.49 && GPA >= 2)
				academicStanding = "Good";
		
		else if(GPA < 1.99 && GPA >= 1.80)
			academicStanding = "Conditional Pass";
		
		else if(GPA < 1.79 && GPA >= 1.20)
			academicStanding = "Academic Probation";
		
		else if(GPA < 1.1 && GPA >= 0)
			academicStanding = "Cannot continue";
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");

		out.println("<head>");
		out.println  ("<title>Varun_Rao_AcademicStandingCalculator</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> Grades</h1>"); 
		out.println("<ul>");
		for (int i = 0; i < marks.size(); i++) {
			out.println(" <li>" + marks.get(i)+"</li>");
		}
		 
		out.println("  </ul>"); 
		out.println("<h1>Your Academic Standing is " + academicStanding + "</h1>"); 
		out.println("<a href=\"index.html\">Start Over</a>"); 
		out.println("</body>");
		out.println("</html>");
		
		sess.removeAttribute("GradeList");
		sess.removeAttribute("TotalCredits");
		
	}

}