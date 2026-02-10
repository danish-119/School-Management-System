package com.danish.sms;

import java.sql.*;


public class SaveDataToMySQL {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/academicDBHandler";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    public static boolean saveStudentInfo(Student student) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {

            String sql = "INSERT INTO Student (studentName, dateOfBirth, gender, cnicOrBForm, bloodGroup, email, extracurricularInterest, guardianName, guardianRelation, guardianCnic, guardianOccupation, guardianContact, jobType, admissionNumber, classGrade, section, username, password, admissionDate, monthlyFee, scholarshipStatus, documentRequired, documentStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, student.getStudentName());
                statement.setString(2, student.getDob());
                statement.setString(3, student.getGender());
                statement.setString(4, student.getCnicOrBForm());
                statement.setString(5, student.getBloodGroup());
                statement.setString(6, student.getEmail());
                statement.setString(7, student.getExtracurricularInterest());
                statement.setString(8, student.getGuardianName());
                statement.setString(9, student.getGuardianRelation());
                statement.setString(10, student.getGuardianCnic());
                statement.setString(11, student.getGuardianOccupation());
                statement.setString(12, student.getGuardianContact());
                statement.setString(13, student.getJobType());
                statement.setString(14, student.getAdmissionNumber());
                statement.setString(15, student.getClassGrade());
                statement.setString(16, student.getSection());
                statement.setString(17, student.getUsername());
                statement.setString(18, student.getPassword());
                statement.setString(19, student.getAdmissionDate());
                statement.setDouble(20, student.getMonthlyFee());
                statement.setString(21, student.getScholarshipStatus());
                statement.setString(22, student.getDocumentRequired());
                statement.setString(23, student.getDocumentStatus());

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new student was inserted successfully!");
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error inserting data into database: " + e.getMessage());
            return false;
        }
        return false;
    }

    public static boolean saveTeacherInfo(Teacher teacher) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO Teacher (teacherName, dateOfBirth, gender, cnicNumber, bloodGroup, email, experience, experienceYears, universityGraduatedFrom, qualification, majorSubject, jobTitle, jobType, department, monthlySalary, bankForDirectDeposit, documentRequired, documentStatus, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, teacher.getTeacherName());
                statement.setString(2, teacher.getDob());
                statement.setString(3, teacher.getGender());
                statement.setString(4, teacher.getCnic());
                statement.setString(5, teacher.getBloodGroup());
                statement.setString(6, teacher.getEmail());
                statement.setString(7, teacher.getExperience());
                statement.setString(8, teacher.getExperienceYears());
                statement.setString(9, teacher.getUniversityGraduatedFrom());
                statement.setString(10, teacher.getQualification());
                statement.setString(11, teacher.getMajorSubject());
                statement.setString(12, teacher.getJobTitle());
                statement.setString(13, teacher.getJobType());
                statement.setString(14, teacher.getDepartment());
                statement.setDouble(15, teacher.getMonthlySalary());
                statement.setString(16, teacher.getBankForDirectDeposit());
                statement.setString(17, teacher.getDocumentRequired());
                statement.setString(18, teacher.getDocumentStatus());
                statement.setString(19, teacher.getUsername());
                statement.setString(20, teacher.getPassword());

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new teacher was inserted successfully!");
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error inserting data into database: " + e.getMessage());
            return false;
        }
        return false;
    }

    public  static void saveStaffInfo(Staff staff) {

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO Staff (fullName, dateOfBirth, gender, cnicNumber, contact, qualification, jobTitle, jobType, monthlySalary, workSchedule) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, staff.getFullName());
                statement.setString(2, staff.getDateOfBirth());
                statement.setString(3, staff.getGender());
                statement.setString(4, staff.getCnicNumber());
                statement.setString(5, staff.getContact());
                statement.setString(6, staff.getQualification());
                statement.setString(7, staff.getJobTitle());
                statement.setString(8, staff.getJobType());
                statement.setDouble(9, staff.getMonthlySalary());
                statement.setString(10, staff.getWorkSchedule());

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
