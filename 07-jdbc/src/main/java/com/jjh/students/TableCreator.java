package com.jjh.students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {
	public static void main(String[] args) {
		String user = "user";
		String pwd = "user123";
		String url = "jdbc:mysql://localhost/coursedb";
		try (Connection conn = DriverManager.getConnection(url,user,pwd)) {
			Statement st = conn.createStatement();
			st.executeUpdate("CREATE TABLE addresses (name char(15), address char(3))");
			st.executeUpdate("INSERT INTO addresses (name, address) VALUES('John', 'C46')");
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
