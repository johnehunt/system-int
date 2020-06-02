package com.jjh.students;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TableQuery2 {
    public static void main(String [] args) {
        String user = "user";
        String pwd = "user123";
        String url = "jdbc:mysql://localhost/uni-database";
        try (Connection conn = DriverManager.getConnection(url,user,pwd)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.println("name: " + rs.getString("name") );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

