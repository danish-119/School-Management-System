package com.danish.sms;

import java.io.Serializable;

public class Staff implements Serializable {
    String fullName;
    String dateOfBirth;
    String cnicNumber;
    String gender;
    String contact;
    String qualification;
    String employerId;
    String monthlySalary;
    String joiningDate;
    String jobTitle;
    String jobType;
    String workSchedule;

    public void setStaffDetails(String fullName, String dateOfBirth, String cnicNumber, String gender, String contact, String qualification,String employerId, String monthlySalary, String joiningDate, String jobTitle, String jobType, String workSchedule) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.cnicNumber = cnicNumber;
        this.gender = gender;
        this.contact = contact;
        this.qualification = qualification;
        this.employerId = employerId;
        this.monthlySalary = monthlySalary;
        this.joiningDate = joiningDate;
        this.jobTitle = jobTitle;
        this.jobType = jobType;
        this.workSchedule = workSchedule;
    }

    @Override
    public String toString() {
        return "Staff Information:" +
                "\nFull Name: " + fullName +
                "\nDate of Birth: " + dateOfBirth +
                "\nCNIC Number: " + cnicNumber +
                "\nGender: " + gender +
                "\nContact: " + contact +
                "\nQualification: " + qualification +
                "\nEmployer ID: " + employerId +
                "\nMonthly Salary: " + monthlySalary +
                "\nJoining Date: " + joiningDate +
                "\nJob Title: " + jobTitle +
                "\nJob Type: " + jobType +
                "\nWork Schedule: " + workSchedule;
    }
}