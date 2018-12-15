package sheridandavis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sheridandavis.model.Student;
import sheridandavis.util.DBUtil;

public class StudentDAOImplementation implements StudentDAO {

	private Connection conn;
	
	public StudentDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	
	@Override
	public void addStudent(Student stu) {
		try {
			String query = "insert into student(FirstName, LastName, Program,GPA)values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,  stu.getFirstname());
			ps.setString(2,  stu.getLastname());
			ps.setString(3,  stu.getProgram());
			ps.setDouble(4,  stu.getGpa());
			ps.executeUpdate();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudent(int StudentID) {
		try {
			String query = "delete from student where ID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, StudentID);
			ps.executeUpdate();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student stu) {
		try {
//			String sql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";

			String query = "UPDATE student SET FirstName=?, LastName=?, Program=?, GPA=? WHERE ID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,  stu.getFirstname());
			ps.setString(2,  stu.getLastname());
			ps.setString(3,  stu.getProgram());
			ps.setDouble(4, stu.getGpa());
			//int myid = stu.getStudentid() - 1;
			//ps.setInt(5,  myid);
			ps.setInt(5,  stu.getStudentid());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//SELECT ALL or QUERY ALL
	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		try {
			Statement stmt = conn.createStatement();
			//select CAST(gpa as DECIMAL(3,2)) AS gpa from student;
			//ResultSet rs = stmt.executeQuery("select * from student");
			ResultSet rs = stmt.executeQuery("select ID, Firstname, Lastname, Program, CAST(gpa as DECIMAL(3,2)) AS gpa from student");
			
			while(rs.next()) {
				Student stu = new Student();
				stu.setStudentid(rs.getInt("ID"));
				stu.setFirstname(rs.getString("Firstname"));
				stu.setLastname(rs.getString("Lastname"));
				stu.setProgram(rs.getString("Program"));
				stu.setGpa(rs.getDouble("GPA"));

				students.add(stu);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return students;
	}

	@Override
	public Student getStudentById(int studentId) {
		Student stu = new Student();
		try {
			String query = "select * from student where ID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, studentId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				stu.setStudentid(rs.getInt("ID"));
				stu.setFirstname(rs.getString("FirstName"));
				stu.setLastname(rs.getString("LastName"));
				stu.setProgram(rs.getString("Program"));
				stu.setGpa(rs.getDouble("GPA"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stu;
	}

	@Override
	public List<Student> getStudentByProgram(String program) {
		List<Student> students = new ArrayList<Student>();

		try {
			String query = "select * from student where Program=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, program);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student stu = new Student();
				
				stu.setStudentid(rs.getInt("ID"));
				stu.setFirstname(rs.getString("FirstName"));
				stu.setLastname(rs.getString("LastName"));
				stu.setProgram(rs.getString("Program"));
				stu.setGpa(rs.getDouble("GPA"));

				students.add(stu);
			}
			
			rs.close();
			//stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return students;
	}

	@Override
	public List<Student> getStudentByGPA(double gpa) {
		List<Student> students = new ArrayList<Student>();

		try {
			//Convert JAVA double to MySQL decimal datatype
			//CAST(gpa as DECIMAL(3,2)) AS gpa

			String query = "select * from student where GPA=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setDouble(1, gpa);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student stu = new Student();
				
				stu.setStudentid(rs.getInt("ID"));
				stu.setFirstname(rs.getString("FirstName"));
				stu.setLastname(rs.getString("LastName"));
				stu.setProgram(rs.getString("Program"));
				stu.setGpa(rs.getDouble("GPA"));

				students.add(stu);
			}
			
			rs.close();
			//stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return students;
	}

}
