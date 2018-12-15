import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {

	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 static final String DB_URL = "jdbc:mysql://localhost/student";
	 
	 
	public static void main(String[] args) {   
		Connection conn = null;
		String selectSQL = "Select USER_ID, USERNAME USER_ID = ?";
	  try {
		
			

			      
			    //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,"root","Ghost-10");
			      
			    //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();
			      
			      String sql = "SELECT firstname,lastname,program,gpa FROM student.student";
			      ResultSet rs = stmt.executeQuery(sql);
			      
			    //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve by column name
			    	  String firstname = rs.getString("firstname");
			    	  System.out.println(firstname);


			      }      
			      //STEP 6: Clean-up environment
			      rs.close();
			      stmt.close();
			      conn.close();
			}

		catch(Exception se) {
			System.out.println(se.getMessage());
		}

}
}
