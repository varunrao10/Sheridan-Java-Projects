package sheridan.college.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

@WebServlet("/HybridCars")
public class HybridCars extends HttpServlet {
    public static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    public static final String DB_URL="jdbc:mysql://localhost/hybridcars";
    public static final String USER = "root";
    public static final String PASS = "Ghost-101";  	
    private Connection conn;
    private  PreparedStatement stmt;
    private String sql;
    
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	
		 PrintWriter pOut = response.getWriter();
		
		//STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      try {
	    	  
	    	  Class.forName(JDBC_DRIVER); 
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Creating statement...");
		    String sql = "Select id,make,model from HybridCars where id = ?";
		    stmt = conn.prepareStatement(sql);
		    
		    stmt.setInt(1, 1);
		    ResultSet rs = stmt.executeQuery();
		  pOut.println("<html><body>");
		  pOut.println("<table><tr><th>id</th><th>make</th><th>model</th></tr>");
		    while(rs.next()){
		    	pOut.println("<tr>");
		         //Retrieve by column name
		    	  String id = rs.getString("id");
		    	  pOut.println("<td>" + id + "</td>");
		    	  String make = rs.getString("make");
		    	  pOut.println("<td>" + make + "</td>");
		    	  String model = rs.getString("model");
		    	  pOut.println("<td>" + model + "</td>");
		    	pOut.println("</tr>");
		    	
		    	  
		    }
		  pOut.println("</table");
		    rs.close();
		    stmt.close();
		    conn.close();
		    pOut.println("</body></html>");
	      } catch (Exception e) {
			e.printStackTrace();
		}
	      
	}

}
