package sheridandavis.dao;

import java.util.List;
import sheridandavis.model.Student;

public interface StudentDAO {

	// DAO --> Data Access Object
	// Design Pattern
	// CRUD operations
	// studentId is the PK (Primary Key)
	public void addStudent(Student student);
	public void deleteStudent(int studentId);
	public void updateStudent(Student student);
	public List<Student> getAllStudents();
	public Student getStudentById(int studentId);
	//Search or Filter (by Program)
	public List<Student> getStudentByProgram(String program);
	public List<Student> getStudentByGPA(double gpa);
	
}
