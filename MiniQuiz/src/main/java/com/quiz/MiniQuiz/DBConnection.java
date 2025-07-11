package com.quiz.MiniQuiz;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // For MySQL 5.x
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/quiz_app",
                "root",
                "root"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
