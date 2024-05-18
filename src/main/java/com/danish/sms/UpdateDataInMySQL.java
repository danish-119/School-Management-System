package com.danish.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataInMySQL {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/academicDBHandler";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    public static void updateStudentInfo(Student student) {
        String sql = "UPDATE Student SET classGrade=?, section=?, password=?, monthlyFee=?, scholarshipStatus=?, documentStatus=?, documentRequired=? WHERE studentId=?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, student.getClassGrade());
            statement.setString(2, student.getSection());
            statement.setString(3, student.getPassword());
            statement.setDouble(4, student.getMonthlyFee());
            statement.setString(5, student.getScholarshipStatus());
            statement.setString(6, student.getDocumentStatus());
            statement.setString(7, student.getDocumentRequired());
            statement.setInt(8, student.getStudentId());

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
