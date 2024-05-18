package com.danish.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveDataFromMySQL {
    // JDBC URL, username, and password
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/academicDBHandler";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    public static boolean removeStudentFromDatabase(String studentId) {
        String sql = "DELETE FROM Student WHERE studentId = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, studentId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error removing student from database: " + e.getMessage());
            return false;
        }
    }

    // Method to remove staff from the database
    public static boolean removeStaffFromDatabase(String employerId) {

        String sql = "DELETE FROM Staff WHERE employerId = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set the staff ID parameter
            statement.setString(1, employerId);

            // Execute the delete operation
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error removing staff from database: " + e.getMessage());
            return false;
        }
    }
}
