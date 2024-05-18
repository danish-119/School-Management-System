package com.danish.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class GetDataByIdFromMySQL {
    // JDBC URL, username, and password
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/academicDBHandler";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    public static Student getStudentById(String studentId) {
        Student student = null;

        // SQL query to retrieve student information by ID
        String sql = "SELECT * FROM Student WHERE studentId = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set the student ID parameter
            statement.setString(1, studentId);

            // Execute the query
            try (ResultSet resultSet = statement.executeQuery()) {
                // Check if any rows were returned
                if (resultSet.next()) {
                    // Create a new Student object and populate its fields from the result set
                    student = new Student();
                    student.setStudentId(resultSet.getInt("studentId"));
                    student.setStudentName(resultSet.getString("studentName"));
                    student.setDob(resultSet.getString("dateOfBirth"));
                    student.setGender(resultSet.getString("gender"));
                    student.setCnicOrBForm(resultSet.getString("cnicOrBForm"));
                    student.setBloodGroup(resultSet.getString("bloodGroup"));
                    student.setEmail(resultSet.getString("email"));
                    student.setExtracurricularInterest(resultSet.getString("extracurricularInterest"));
                    student.setGuardianName(resultSet.getString("guardianName"));
                    student.setGuardianRelation(resultSet.getString("guardianRelation"));
                    student.setGuardianCnic(resultSet.getString("guardianCnic"));
                    student.setGuardianOccupation(resultSet.getString("guardianOccupation"));
                    student.setGuardianContact(resultSet.getString("guardianContact"));
                    student.setJobType(resultSet.getString("jobType"));
                    student.setAdmissionNumber(resultSet.getString("admissionNumber"));
                    student.setClassGrade(resultSet.getString("classGrade"));
                    student.setSection(resultSet.getString("section"));
                    student.setUsername(resultSet.getString("username"));
                    student.setPassword(resultSet.getString("password"));
                    student.setAdmissionDate(resultSet.getDate("admissionDate").toLocalDate().toString());
                    student.setMonthlyFee(resultSet.getDouble("monthlyFee"));
                    student.setScholarshipStatus(resultSet.getString("scholarshipStatus"));
                    student.setDocumentRequired(resultSet.getString("documentRequired"));
                    student.setDocumentStatus(resultSet.getString("documentStatus"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving data from database: " + e.getMessage());
        }

        return student;
    }

    public static Teacher getTeacherById(String teacherId) {
        Teacher teacher = null;

        // SQL query to retrieve teacher information by ID
        String sql = "SELECT * FROM Teacher WHERE teacherId = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set the teacher ID parameter
            statement.setString(1, teacherId);

            // Execute the query
            try (ResultSet resultSet = statement.executeQuery()) {
                // Check if any rows were returned
                if (resultSet.next()) {
                    // Create a new Teacher object and populate its fields from the result set
                    teacher = new Teacher();
                    teacher.setTeacherId(resultSet.getInt("teacherId"));
                    teacher.setTeacherName(resultSet.getString("teacherName"));
                    teacher.setDob(resultSet.getString("dateOfBirth"));
                    teacher.setGender(resultSet.getString("gender"));
                    teacher.setCnic(resultSet.getString("cnicNumber"));
                    teacher.setBloodGroup(resultSet.getString("bloodGroup"));
                    teacher.setEmail(resultSet.getString("email"));
                    teacher.setExperience(resultSet.getString("experience"));
                    teacher.setExperienceYears(String.valueOf(resultSet.getInt("experienceYears")));
                    teacher.setUniversityGraduatedFrom(resultSet.getString("universityGraduatedFrom"));
                    teacher.setQualification(resultSet.getString("qualification"));
                    teacher.setMajorSubject(resultSet.getString("majorSubject"));
                    teacher.setJobTitle(resultSet.getString("jobTitle"));
                    teacher.setJobType(resultSet.getString("jobType"));
                    teacher.setDepartment(resultSet.getString("department"));
//                    teacher.setJoiningDate(resultSet.getTimestamp("joiningDate").toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                    teacher.setMonthlySalary(resultSet.getDouble("monthlySalary"));
                    teacher.setBankForDirectDeposit(resultSet.getString("bankForDirectDeposit"));
                    teacher.setDocumentRequired(resultSet.getString("documentRequired"));
                    teacher.setDocumentStatus(resultSet.getString("documentStatus"));
                    teacher.setUsername(resultSet.getString("username"));
                    teacher.setPassword(resultSet.getString("password"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving data from database: " + e.getMessage());
        }

        return teacher;
    }

    public static Staff getStaffByIdFromDatabase(String employerId) {
        Staff staff = null;

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
                    staff.setJoiningDate(resultSet.getTimestamp("joiningDate").toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
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
