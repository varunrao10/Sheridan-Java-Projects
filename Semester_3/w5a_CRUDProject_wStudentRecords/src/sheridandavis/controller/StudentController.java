package sheridandavis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sheridandavis.dao.StudentDAO;
import sheridandavis.dao.StudentDAOImplementation;
import sheridandavis.model.Student;

public class StudentController extends HttpServlet {

	private StudentDAO dao;
	private String gpastr;
	private double gpadbl;
	private static final long serialversionUID = 7878L;
	public static final String LIST_STUDENT = "/listStudent.jsp";
	public static final String INSERT_OR_EDIT = "/student.jsp";
	public static final String LIST_STUDENTS_FROM_PROGRAM = "/listStudentsInProgram.jsp";
	public static final String LIST_STUDENTS_WITH_GPA = "/listStudentsWithGPA.jsp";
	
	public StudentController() {
		dao = new StudentDAOImplementation();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")) {
			forward = LIST_STUDENT;
			int studentId = Integer.parseInt(request.getParameter("studentId"));
			
			dao.deleteStudent(studentId);
			request.setAttribute("students",  dao.getAllStudents());;
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int studentId = Integer.parseInt(request.getParameter("studentId"));
			
			Student student = dao.getStudentById(studentId);
			request.setAttribute("student", student);
		} else if (action.equalsIgnoreCase("insert")) {
			forward = INSERT_OR_EDIT;
		} else if (action.equalsIgnoreCase("searchstudentsfromprogram")) {
			// LIST ALL RECORDS or Students that are part of a particular program
			forward = LIST_STUDENTS_FROM_PROGRAM;
			String programRequest = request.getParameter("program");
			request.setAttribute("students", dao.getStudentByProgram(programRequest));
		} else if (action.equalsIgnoreCase("searchstudentswithgpa")) {
			// LIST ALL RECORDS or Students that are part of a particular program
			forward = LIST_STUDENTS_WITH_GPA;
			String gpaRequest = request.getParameter("gpa");
			double gpadblRequest = Double.parseDouble(gpaRequest);
			request.setAttribute("students", dao.getStudentByGPA(gpadblRequest));
		} else {
			// LIST ALL RECORDS or Students
			forward = LIST_STUDENT;
			request.setAttribute("students", dao.getAllStudents());
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
	
		Student student = new Student();
		//takes an Integer primitive
		//student.setStudentid(request.getParameter("studentId"));
		student.setFirstname(request.getParameter("firstName"));
		student.setLastname(request.getParameter("lastName"));
		student.setProgram(request.getParameter("program"));
		//valueOf or try-catch block
		gpastr = request.getParameter("gpa");
//		double gpadbl = Double.parseDouble(gpastr);
		try{
			gpadbl = Double.parseDouble(gpastr);
		} catch(NumberFormatException e){
			throw new RuntimeException(gpadbl + " is not a number");
		}
		//double gpadbl = Double.parseDouble(gpastr);
		student.setGpa(gpadbl);
		
//		String studentId = request.getParameter("ID");
		String studentId = request.getParameter("studentId");
		
		if(studentId == null || studentId.isEmpty())
			dao.addStudent(student);
		else {
			student.setStudentid(Integer.parseInt(studentId));
			dao.updateStudent(student);
		}
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_STUDENT);
		request.setAttribute("students", dao.getAllStudents());
		view.forward(request, response);
		
	}

}
