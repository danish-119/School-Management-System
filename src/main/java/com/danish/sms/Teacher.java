package com.danish.sms;

import java.io.Serializable;

public class Teacher implements Serializable {
    // Page 1
    private  int teacherId;
    private String teacherName;
    private String dob;
    private String fatherName;
    private String gender;
    private String cnic;
    private String bloodGroup;
    private String email;
    private String experience;
    private String experienceYears;
    private String universityGraduatedFrom;
    private String qualification;
    private String majorSubject;
    // Page 2
    private String jobTitle;
    private String jobType;
    private String department;
    private String joiningDate;
    private String username;
    private String password;
    private double monthlySalary;
    private String bankForDirectDeposit;
    private String documentStatus;
    private String documentRequired;

    public void setTeacherDetails1(String teacherName, String dob, String fatherName, String gender, String cnic, String bloodGroup, String email, String experience, String experienceYears, String universityGraduatedFrom, String qualification, String majorSubject) {
        this.teacherName = teacherName;
        this.dob = dob;
        this.fatherName = fatherName;
        this.gender = gender;
        this.cnic = cnic;
        this.bloodGroup = bloodGroup;
        this.email = email;
        this.experience = experience;
        this.experienceYears = experienceYears;
        this.universityGraduatedFrom = universityGraduatedFrom;
        this.qualification = qualification;
        this.majorSubject = majorSubject;
    }

    public void setTeacherDetails2(String jobTitle, String jobType, String department,String password, double monthlySalary, String bankForDirectDeposit, String documentStatus, String documentRequired) {
        this.jobTitle = jobTitle;
        this.jobType = jobType;
        this.department = department;
        this.password = password;
        this.monthlySalary = monthlySalary;
        this.bankForDirectDeposit = bankForDirectDeposit;
        this.documentStatus = documentStatus;
        this.documentRequired = documentRequired;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
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

    public String getCnic() {
        return cnic;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getEmail() {
        return email;
    }

    public String getExperience() {
        return experience;
    }

    public String getExperienceYears() {
        return experienceYears;
    }

    public String getUniversityGraduatedFrom() {
        return universityGraduatedFrom;
    }

    public String getQualification() {
        return qualification;
    }

    public String getMajorSubject() {
        return majorSubject;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobType() {
        return jobType;
    }

    public String getDepartment() {
        return department;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public String getBankForDirectDeposit() {
        return bankForDirectDeposit;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public String getDocumentRequired() {
        return documentRequired;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setExperienceYears(String experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void setUniversityGraduatedFrom(String universityGraduatedFrom) {
        this.universityGraduatedFrom = universityGraduatedFrom;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setMajorSubject(String majorSubject) {
        this.majorSubject = majorSubject;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public void setBankForDirectDeposit(String bankForDirectDeposit) {
        this.bankForDirectDeposit = bankForDirectDeposit;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }

    public void setDocumentRequired(String documentRequired) {
        this.documentRequired = documentRequired;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}