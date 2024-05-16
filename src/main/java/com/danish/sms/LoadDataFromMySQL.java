package com.danish.sms;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LoadDataFromMySQL {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/academicDBHandler";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    public static ObservableList<Staff> loadStaffData() {
        ObservableList<Staff> staffList = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM Staff";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Staff staff = new Staff();
                    staff.setEmployerId(String.valueOf(resultSet.getInt("employerId")));
                    staff.setFullName(resultSet.getString("fullName"));
                    staff.setDateOfBirth(String.valueOf(resultSet.getDate("dateOfBirth")));
                    staff.setGender(resultSet.getString("gender"));
                    staff.setCnicNumber(resultSet.getString("cnicNumber"));
                    staff.setContact(resultSet.getString("contact"));
                    staff.setQualification(resultSet.getString("qualification"));
                    staff.setJobTitle(resultSet.getString("jobTitle"));
                    staff.setJobType(resultSet.getString("jobType"));
                    staff.setMonthlySalary(resultSet.getDouble("monthlySalary"));
                    staff.setJoiningDate(String.valueOf(resultSet.getTimestamp("joiningDate")));
                    staff.setWorkSchedule(resultSet.getString("workSchedule"));
                    staffList.add(staff);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staffList;
    }
}
