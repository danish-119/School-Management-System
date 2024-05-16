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
    private String jobType;
    // Page 2
    private String admissionNumber;
    private String classGrade;
    private int studentId;
    private String section;
    private String username;
    private String password;
    private String admissionDate;
    private double monthlyFee;
    private String scholarshipStatus;
    private String documentStatus;
    private String documents;

    // Method to set all details at once
    public void setStudentDetails1(String studentName, String dob, String fatherName, String gender, String cnic, String bloodGroup, String email, String extracurricularInterest, String guardianName, String guardianRelation, String guardianCnic, String guardianOccupation, String guardianContact, String jobType) {
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
        this.jobType = jobType;
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

    public String getJobType() {
        return jobType;
    }

    public String getAdmissionNumber() {
        return admissionNumber;
    }

    public String getClassGrade() {
        return classGrade;
    }

    public int getStudentId() {
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

    public String getDocumentRequired() {
        return documents;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCnicOrBForm(String cnicOrBForm) {
        this.cnicOrBForm = cnicOrBForm;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setExtracurricularInterest(String extracurricularInterest) {
        this.extracurricularInterest = extracurricularInterest;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public void setGuardianRelation(String guardianRelation) {
        this.guardianRelation = guardianRelation;
    }

    public void setGuardianCnic(String guardianCnic) {
        this.guardianCnic = guardianCnic;
    }

    public void setGuardianOccupation(String guardianOccupation) {
        this.guardianOccupation = guardianOccupation;
    }

    public void setGuardianContact(String guardianContact) {
        this.guardianContact = guardianContact;
    }

    public void setJobType(String jobTypeSelected) {
        this.jobType = jobTypeSelected;
    }

    public void setAdmissionNumber(String admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public void setClassGrade(String classGrade) {
        this.classGrade = classGrade;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public void setScholarshipStatus(String scholarshipStatus) {
        this.scholarshipStatus = scholarshipStatus;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }

    public void setDocumentRequired(String documents) {
        this.documents = documents;
    }
}