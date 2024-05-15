package com.danish.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class saveDataToMySQL {
    private static final String JDBC_URL = "";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    public  static void saveStaffInfo(String fullName, String dateOfBirth, String gender, String cnicNumber, String contact, String qualification, String jobTitle, String jobType, double monthlySalary, String workSchedule) {
        if (!Validator.isValidGender(gender)) {
            System.out.println("Invalid gender value: " + gender);
            return; // Don't proceed with insertion
        }

        // Validate jobType
        if (!Validator.isValidJobType(jobType)) {
            System.out.println("Invalid job type value: " + jobType);
            return; // Don't proceed with insertion
        }

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO Staff (fullName, dateOfBirth, gender, cnicNumber, contact, qualification, jobTitle, jobType, monthlySalary, workSchedule) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, fullName);
                statement.setString(2, dateOfBirth);
                statement.setString(3, gender);
                statement.setString(4, cnicNumber);
                statement.setString(5, contact);
                statement.setString(6, qualification);
                statement.setString(7, jobTitle);
                statement.setString(8, jobType);
                statement.setDouble(9, monthlySalary);
                statement.setString(10, workSchedule);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new staff member was inserted successfully!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error inserting data into database: " + e.getMessage());
        }
    }

}
