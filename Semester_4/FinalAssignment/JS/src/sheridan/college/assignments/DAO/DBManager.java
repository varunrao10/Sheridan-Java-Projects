/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheridan.college.assignments.DAO;

import java.sql.*;

public class DBManager {
	String conn = "jdbc:mysql://localhost:3306/bookingsys?autoReconnect=True&useSSL=False";
	String user = "root";
	String pass = "Canary_322";

	public Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {
			System.out.println("Could not find class : " + e.getMessage());
		}

		try {
			con = DriverManager.getConnection(conn, user, pass);
		}

		catch (SQLException e) {
			System.out.println("Error when getting connection : " + e.getMessage());
		}

		return con;
	}

	public ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			Connection con = getConnection();
			Statement st = con.createStatement();
			rs = st.executeQuery(sql);
		} catch (Exception e) {
			System.out.println("Error executing query " + e);
		}
		return rs;
	}

	public int executeUpdate(String sql) {
		int r = 0;
		try {
			Connection con = getConnection();
			Statement st = con.createStatement();
			r = st.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("Error executing query " + e);
		}
		return r;
	}

}
