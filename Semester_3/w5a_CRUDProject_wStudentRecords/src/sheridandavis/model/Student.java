package sheridandavis.model;

public class Student {

	//JAVA POJO or Bean properties must be LOWER CASE
	// getter is obtained by Camel case of the Property.
	private int studentid;
	private String firstname;
	private String lastname;
	private String program;
	private double gpa;
	
	//getter - setter for StudentId
	public int getStudentid() {
		return studentid;
	}
	
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	//getter - setter for FirstName
	public String getFirstname() {
		return this.firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	//getter - setter for LastName
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	//getter - setter for Program
	public String getProgram() {
		return this.program;
	}
	
	public void setProgram(String program) {
		this.program = program;
	}
	//getter - setter for GPA
	public double getGpa() {
		return gpa;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	@Override
	public String toString() {
		return "Student [StudentId=" + this.studentid + 
				", FirstName= " + this.firstname + 
				", LastName= " + this.lastname + 
				", Program= " + this.program + 
				", GPA= " + this.gpa + "]";
	}
	
}
