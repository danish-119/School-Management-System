package com.danish.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataInMySQL {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/academicDBHandler";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    public static void updateStudentInfo(Student updatedStudent) {
        String sql = "UPDATE Student SET classGrade=?, section=?, password=?, monthlyFee=?, scholarshipStatus=?, documentStatus=?, documentRequired=? WHERE studentId=?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, updatedStudent.getClassGrade());
            statement.setString(2, updatedStudent.getSection());
            statement.setString(3, updatedStudent.getPassword());
            statement.setDouble(4, updatedStudent.getMonthlyFee());
            statement.setString(5, updatedStudent.getScholarshipStatus());
            statement.setString(6, updatedStudent.getDocumentStatus());
            statement.setString(7, updatedStudent.getDocumentRequired());
            statement.setInt(8, updatedStudent.getStudentId());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student information updated successfully.");
            } else {
                System.out.println("Failed to update student information.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating student information: " + e.getMessage());
        }
    }
}
