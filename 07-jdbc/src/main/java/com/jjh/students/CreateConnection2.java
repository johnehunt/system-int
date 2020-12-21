package com.jjh.students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection2 {

    public static void main(String[] args) {
        String user = "user";
        String pwd = "user123";
        String url = "jdbc:mysql://localhost/coursedb";
        // Uses the try with resources format
        // introduced in Java 7
        try (Connection conn = DriverManager.getConnection(url,user,pwd)) {
            System.out.println("Connection set up: " + conn);
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }
}
