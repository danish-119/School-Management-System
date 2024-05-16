package com.danish.sms;

import java.io.Serializable;

public class Teacher implements Serializable {
    // Page 1
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
}