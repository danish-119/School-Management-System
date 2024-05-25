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
        String sql = "UPDATE Student SET email=?, extracurricularInterest=?, guardianName=?, guardianRelation=?, " +
                "guardianCnic=?, guardianOccupation=?, guardianContact=?, jobType=?, classGrade=?, section=?, " +
                "password=?, monthlyFee=?, scholarshipStatus=?, documentRequired=?, documentStatus=? WHERE studentId=?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, updatedStudent.getEmail());
            statement.setString(2, updatedStudent.getExtracurricularInterest());
            statement.setString(3, updatedStudent.getGuardianName());
            statement.setString(4, updatedStudent.getGuardianRelation());
            statement.setString(5, updatedStudent.getGuardianCnic());
            statement.setString(6, updatedStudent.getGuardianOccupation());
            statement.setString(7, updatedStudent.getGuardianContact());
            statement.setString(8, updatedStudent.getJobType());
            statement.setString(9, updatedStudent.getClassGrade());
            statement.setString(10, updatedStudent.getSection());
            statement.setString(11, updatedStudent.getPassword());
            statement.setDouble(12, updatedStudent.getMonthlyFee());
            statement.setString(13, updatedStudent.getScholarshipStatus());
            statement.setString(14, updatedStudent.getDocumentRequired());
            statement.setString(15, updatedStudent.getDocumentStatus());
            statement.setInt(16, updatedStudent.getStudentId());

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


    public static void updateTeacherInfo(Teacher updatedTeacher) {
        String updateQuery = "UPDATE Teacher SET email = ?, experience = ?, experienceYears = ?, universityGraduatedFrom = ?, qualification = ?, majorSubject = ? WHERE teacherId = ?";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, updatedTeacher.getEmail());
            preparedStatement.setString(2, updatedTeacher.getExperience());
            preparedStatement.setString(3, updatedTeacher.getExperienceYears());
            preparedStatement.setString(4, updatedTeacher.getUniversityGraduatedFrom());
            preparedStatement.setString(5, updatedTeacher.getQualification());
            preparedStatement.setString(6, updatedTeacher.getMajorSubject());
            preparedStatement.setInt(7, updatedTeacher.getTeacherId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Teacher information updated successfully.");
            } else {
                System.out.println("Failed to update teacher information.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
