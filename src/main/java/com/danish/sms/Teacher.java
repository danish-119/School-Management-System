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
    private String university;
    private String qualification;
    private String subject;
    // Page 2
    private String jobTitle;
    private String jobType;
    private String department;
    private String joiningDate;
    private String monthlySalary;
    private String bank;
    private String documentStatus;
    private String documents;

    public void setTeacherDetails1(String teacherName, String dob, String fatherName, String gender, String cnic, String bloodGroup, String email, String experience, String experienceYears, String university, String qualification, String subject) {
        this.teacherName = teacherName;
        this.dob = dob;
        this.fatherName = fatherName;
        this.gender = gender;
        this.cnic = cnic;
        this.bloodGroup = bloodGroup;
        this.email = email;
        this.experience = experience;
        this.experienceYears = experienceYears;
        this.university = university;
        this.qualification = qualification;
        this.subject = subject;
    }

    public void setTeacherDetails2(String jobTitle, String jobType, String department, String joiningDate, String monthlySalary, String bank, String documentStatus, String documents) {
        this.jobTitle = jobTitle;
        this.jobType = jobType;
        this.department = department;
        this.joiningDate = joiningDate;
        this.monthlySalary = monthlySalary;
        this.bank = bank;
        this.documentStatus = documentStatus;
        this.documents = documents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Teacher Information:\n")
                .append("Name: ").append(teacherName).append("\n")
                .append("Date of Birth: ").append(dob).append("\n")
                .append("Father's Name: ").append(fatherName).append("\n")
                .append("Gender: ").append(gender).append("\n")
                .append("CNIC: ").append(cnic).append("\n")
                .append("Blood Group: ").append(bloodGroup).append("\n")
                .append("Email: ").append(email).append("\n")
                .append("Experience: ").append(experience).append(" (").append(experienceYears).append(" years)\n")
                .append("University: ").append(university).append("\n")
                .append("Qualification: ").append(qualification).append("\n")
                .append("Subject: ").append(subject).append("\n\n")
                .append("Job Information:\n")
                .append("Job Title: ").append(jobTitle).append("\n")
                .append("Job Type: ").append(jobType).append("\n")
                .append("Department: ").append(department).append("\n")
                .append("Joining Date: ").append(joiningDate).append("\n")
                .append("Monthly Salary: ").append(monthlySalary).append("\n")
                .append("Bank: ").append(bank).append("\n")
                .append("Document Status: ").append(documentStatus).append("\n")
                .append("Documents: ").append(documents);
        return sb.toString();
    }

}