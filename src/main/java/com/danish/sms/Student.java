package com.danish.sms;

import java.io.Serializable;

public class Student implements Serializable {
    // Page 1
    private String studentName;
    private String dob;
    private String fatherName;
    private String gender;
    private String cnic;
    private String bloodGroup;
    private String email;
    private String extracurricular;
    private String guardianName;
    private String relation;
    private String guardianCnic;
    private String occupation;
    private String contact;
    private String jobTypeSelected;
    // Page 2
    private String admissionNumber;
    private String classGrade;
    private String rollNumber;
    private String section;
    private String username;
    private String password;
    private String admissionDate;
    private String monthlyFee;
    private String scholarshipStatus;
    private String documentStatus;
    private String documents;

    // Method to set all details at once
    public void setStudentDetails1(String studentName, String dob, String fatherName, String gender, String cnic, String bloodGroup, String email, String extracurricular, String guardianName, String relation, String guardianCnic, String occupation, String contact, String jobTypeSelected) {
        this.studentName = studentName;
        this.dob = dob;
        this.fatherName = fatherName;
        this.gender = gender;
        this.cnic = cnic;
        this.bloodGroup = bloodGroup;
        this.email = email;
        this.extracurricular = extracurricular;
        this.guardianName = guardianName;
        this.relation = relation;
        this.guardianCnic = guardianCnic;
        this.occupation = occupation;
        this.contact = contact;
        this.jobTypeSelected = jobTypeSelected;
    }

    // Method to set values for all attributes
    public void setStudentDetails2(String admissionNumber, String classGrade, String rollNumber, String section, String username, String password, String admissionDate, String monthlyFee, String scholarshipStatus, String documentStatus, String documents) {
        this.admissionNumber = admissionNumber;
        this.classGrade = classGrade;
        this.rollNumber = rollNumber;
        this.section = section;
        this.username = username;
        this.password = password;
        this.admissionDate = admissionDate;
        this.monthlyFee = monthlyFee;
        this.scholarshipStatus = scholarshipStatus;
        this.documentStatus = documentStatus;
        this.documents = documents;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Student Details:\n");
        sb.append("Name: ").append(studentName).append("\n");
        sb.append("Date of Birth: ").append(dob).append("\n");
        sb.append("Father's Name: ").append(fatherName).append("\n");
        sb.append("Gender: ").append(gender).append("\n");
        sb.append("CNIC: ").append(cnic).append("\n");
        sb.append("Blood Group: ").append(bloodGroup).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Extracurricular Activities: ").append(extracurricular).append("\n");
        sb.append("Guardian's Name: ").append(guardianName).append("\n");
        sb.append("Relation with Guardian: ").append(relation).append("\n");
        sb.append("Guardian's CNIC: ").append(guardianCnic).append("\n");
        sb.append("Occupation: ").append(occupation).append("\n");
        sb.append("Contact: ").append(contact).append("\n");
        sb.append("Job Type Selected: ").append(jobTypeSelected).append("\n");

        sb.append("\nAdmission Details:\n");
        sb.append("Admission Number: ").append(admissionNumber).append("\n");
        sb.append("Class/Grade: ").append(classGrade).append("\n");
        sb.append("Roll Number: ").append(rollNumber).append("\n");
        sb.append("Section: ").append(section).append("\n");
        sb.append("Username: ").append(username).append("\n");
        sb.append("Password: ").append(password).append("\n");
        sb.append("Admission Date: ").append(admissionDate).append("\n");
        sb.append("Monthly Fee: ").append(monthlyFee).append("\n");
        sb.append("Scholarship Status: ").append(scholarshipStatus).append("\n");
        sb.append("Document Status: ").append(documentStatus).append("\n");
        sb.append("Documents: ").append(documents).append("\n");

        return sb.toString();
    }

}
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class Student {
//    private String studentName;
//    private String dob;
//    private String fatherName;
//    private String gender;
//    private String cnic;
//    private String bloodGroup;
//    private String email;
//    private String extracurricular;
//    private String guardianName;
//    private String relation;
//    private String guardianCnic;
//    private String occupation;
//    private String contact;
//    private String jobType;
//    private String admissionNumber;
//    private String classGrade;
//    private String rollNumber;
//    private String section;
//    private String username;
//    private String password;
//    private String admissionDate;
//    private double monthlyFee;
//    private String scholarshipStatus;
//    private String documentStatus;
//    private String documents;
//
//    // Constructor, getters, and setters omitted for brevity
//    public String getStudentName() {
//        return studentName;
//    }
//
//    public String getDob() {
//        return dob;
//    }
//
//    public String getFatherName() {
//        return fatherName;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public String getCnic() {
//        return cnic;
//    }
//
//    public String getBloodGroup() {
//        return bloodGroup;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getExtracurricular() {
//        return extracurricular;
//    }
//
//    public String getGuardianName() {
//        return guardianName;
//    }
//
//    public String getRelation() {
//        return relation;
//    }
//
//    public String getGuardianCnic() {
//        return guardianCnic;
//    }
//
//    public String getOccupation() {
//        return occupation;
//    }
//
//    public String getContact() {
//        return contact;
//    }
//
//    public String getJobType() {
//        return jobType;
//    }
//
//    public String getAdmissionNumber() {
//        return admissionNumber;
//    }
//
//    public String getClassGrade() {
//        return classGrade;
//    }
//
//    public String getRollNumber() {
//        return rollNumber;
//    }
//
//    public String getSection() {
//        return section;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getAdmissionDate() {
//        return admissionDate;
//    }
//
//    public double getMonthlyFee() {
//        return monthlyFee;
//    }
//
//    public String getScholarshipStatus() {
//        return scholarshipStatus;
//    }
//
//    public String getDocumentStatus() {
//        return documentStatus;
//    }
//
//    public String getDocuments() {
//        return documents;
//    }
//
//    public static class StudentDatabaseHandler {
//        private static final String JDBC_URL = "jdbc:mysql://localhost:3306/academicDBHandler";
//        private static final String USERNAME = "root";
//        private static final String PASSWORD = "admin";
//
//        public static void insertStudent(Student student) {
//            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
//                String query = "INSERT INTO students (student_name, dob, father_name, gender, cnic, blood_group, email, extracurricular, guardian_name, relation, guardian_cnic, occupation, contact, job_type, admission_number, class_grade, roll_number, section, username, password, admission_date, monthly_fee, scholarship_status, document_status, documents) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//                PreparedStatement statement = connection.prepareStatement(query);
//                // Set parameters
//                statement.setString(1, student.getStudentName());
//                statement.setString(2, student.getDob());
//                statement.setString(3, student.getFatherName());
//                statement.setString(4, student.getGender());
//                statement.setString(5, student.getCnic());
//                statement.setString(6, student.getBloodGroup());
//                statement.setString(7, student.getEmail());
//                statement.setString(8, student.getExtracurricular());
//                statement.setString(9, student.getGuardianName());
//                statement.setString(10, student.getRelation());
//                statement.setString(11, student.getGuardianCnic());
//                statement.setString(12, student.getOccupation());
//                statement.setString(13, student.getContact());
//                statement.setString(14, student.getJobType());
//                statement.setString(15, student.getAdmissionNumber());
//                statement.setString(16, student.getClassGrade());
//                statement.setString(17, student.getRollNumber());
//                statement.setString(18, student.getSection());
//                statement.setString(19, student.getUsername());
//                statement.setString(20, student.getPassword());
//                statement.setString(21, student.getAdmissionDate());
//                statement.setDouble(22, student.getMonthlyFee());
//                statement.setString(23, student.getScholarshipStatus());
//                statement.setString(24, student.getDocumentStatus());
//                statement.setString(25, student.getDocuments());
//                // Execute the query
//                statement.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}

