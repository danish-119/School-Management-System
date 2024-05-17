package com.danish.sms;

import java.io.Serializable;

public class Staff implements Serializable {
    private String fullName;
   private String dateOfBirth;
   private String cnicNumber;
   private String gender;
    private String contact;
   private String qualification;
    private String employerId;
    double monthlySalary;
   private String joiningDate;
   private String jobTitle;
    private String jobType;
  private   String workSchedule;

    public void setStaffDetails(String fullName, String dateOfBirth, String cnicNumber, String gender, String contact, String qualification, double monthlySalary, String jobTitle, String jobType, String workSchedule) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.cnicNumber = cnicNumber;
        this.gender = gender;
        this.contact = contact;
        this.qualification = qualification;
        this.monthlySalary = monthlySalary;
        this.jobTitle = jobTitle;
        this.jobType = jobType;
        this.workSchedule = workSchedule;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCnicNumber() {
        return cnicNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getContact() {
        return contact;
    }

    public String getQualification() {
        return qualification;
    }

    public String getEmployerId() {
        return employerId;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobType() {
        return jobType;
    }

    public String getWorkSchedule() {
        return workSchedule;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCnicNumber(String cnicNumber) {
        this.cnicNumber = cnicNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setEmployerId(String employerId) {
        this.employerId = employerId;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule;
    }
}