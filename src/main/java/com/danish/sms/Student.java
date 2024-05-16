package com.danish.sms;

import java.io.Serializable;

public class Student implements Serializable {
    // Page 1
    private String studentName;
    private String dob;
    private String fatherName;
    private String gender;
    private String cnicOrBForm;
    private String bloodGroup;
    private String email;
    private String extracurricularInterest;
    private String guardianName;
    private String guardianRelation;
    private String guardianCnic;
    private String guardianOccupation;
    private String guardianContact;
    private String jobTypeSelected;
    // Page 2
    private String admissionNumber;
    private String classGrade;
    private String studentId;
    private String section;
    private String username;
    private String password;
    private String admissionDate;
    private double monthlyFee;
    private String scholarshipStatus;
    private String documentStatus;
    private String documents;

    // Method to set all details at once
    public void setStudentDetails1(String studentName, String dob, String fatherName, String gender, String cnic, String bloodGroup, String email, String extracurricularInterest, String guardianName, String guardianRelation, String guardianCnic, String guardianOccupation, String guardianContact, String jobTypeSelected) {
        this.studentName = studentName;
        this.dob = dob;
        this.fatherName = fatherName;
        this.gender = gender;
        this.cnicOrBForm = cnic;
        this.bloodGroup = bloodGroup;
        this.email = email;
        this.extracurricularInterest = extracurricularInterest;
        this.guardianName = guardianName;
        this.guardianRelation = guardianRelation;
        this.guardianCnic = guardianCnic;
        this.guardianOccupation = guardianOccupation;
        this.guardianContact = guardianContact;
        this.jobTypeSelected = jobTypeSelected;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDob() {
        return dob;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getGender() {
        return gender;
    }

    public String getCnicOrBForm() {
        return cnicOrBForm;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getEmail() {
        return email;
    }

    public String getExtracurricularInterest() {
        return extracurricularInterest;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public String getGuardianRelation() {
        return guardianRelation;
    }

    public String getGuardianCnic() {
        return guardianCnic;
    }

    public String getGuardianOccupation() {
        return guardianOccupation;
    }

    public String getGuardianContact() {
        return guardianContact;
    }

    public String getJobTypeSelected() {
        return jobTypeSelected;
    }

    public String getAdmissionNumber() {
        return admissionNumber;
    }

    public String getClassGrade() {
        return classGrade;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getSection() {
        return section;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public String getScholarshipStatus() {
        return scholarshipStatus;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public String getDocuments() {
        return documents;
    }
    


    // Method to set values for all attributes
    public void setStudentDetails2(String admissionNumber, String classGrade, String section, String password, double monthlyFee, String scholarshipStatus, String documentStatus, String documents) {
        this.admissionNumber = admissionNumber;
        this.classGrade = classGrade;
        this.section = section;
        this.password = password;
        this.monthlyFee = monthlyFee;
        this.scholarshipStatus = scholarshipStatus;
        this.documentStatus = documentStatus;
        this.documents = documents;
    }
}