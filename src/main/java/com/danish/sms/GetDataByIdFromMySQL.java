package com.danish.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetDataByIdFromMySQL {

    public static Staff getStaffByIdFromDatabase(String employerId) {
        // Initialize the Staff object to null
        Staff staff = null;

        // JDBC URL, username, and password
        String JDBC_URL = "jdbc:mysql://localhost:3306/academicDBHandler";
        String USERNAME = "root";
        String PASSWORD = "admin";

        // SQL query to retrieve staff information by ID
        String sql = "SELECT * FROM Staff WHERE employerId = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set the staff ID parameter
            statement.setString(1, employerId);

            // Execute the query
            try (ResultSet resultSet = statement.executeQuery()) {
                // Check if any rows were returned
                if (resultSet.next()) {
                    // Create a new Staff object and populate its fields from the result set
                    staff = new Staff();
                    staff.setEmployerId(resultSet.getInt("employerId"));
                    staff.setFullName(resultSet.getString("fullName"));
                    staff.setDateOfBirth(resultSet.getString("dateOfBirth"));
                    staff.setGender(resultSet.getString("gender"));
                    staff.setCnicNumber(resultSet.getString("cnicNumber"));
                    staff.setContact(resultSet.getString("contact"));
                    staff.setQualification(resultSet.getString("qualification"));
                    staff.setJobTitle(resultSet.getString("jobTitle"));
                    staff.setJobType(resultSet.getString("jobType"));
                    staff.setJoiningDate(String.valueOf(resultSet.getTimestamp("joiningDate")));
                    staff.setMonthlySalary(resultSet.getDouble("monthlySalary"));
                    staff.setWorkSchedule(resultSet.getString("workSchedule"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving data from database: " + e.getMessage());
        }

        return staff;
    }
}
