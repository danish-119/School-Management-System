package com.danish.sms;

import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

public class AddStaffPage {

    public void showAddStaffPage(Stage staffManagementMenu) {
        Stage addStaffStage = new Stage();
        addStaffStage.setFullScreen(true);
        addStaffStage.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Label heading1 = Utility.createTextLabel("Personal Information:", 30, 100, 50);
        TextField sNameField = Utility.createTextField("Full Name", 100, 100);
        HBox dobField = Utility.createDateField("Date of Birth", 430, 100);
        TextField cnicField = Utility.createTextField("CNIC Number", 100, 170);
        List<String> genderOptions = List.of("Gender", "Male", "Female", "Other");
        HBox genderField = Utility.createSelect(genderOptions, 230, 50, 430, 170);
        TextField gContactField = Utility.createTextField("Contact", 100, 240);
        List<String> qualificationOptions = List.of("Qualification", "Primary School Certificate", "Middle School Certificate", "Matriculation", "Intermediate", "Bachelor's Degree", "Diploma/Certificate");
        HBox qualificationField = Utility.createSelect(qualificationOptions, 230, 50, 430, 240);

        Label heading2 = Utility.createTextLabel("Employment Information:", 30, 100, 310);
        List<String> jobTitleOptions = List.of("Job Title", "Custodian", "Secretary", "Librarian", "Cafeteria Worker", "Security Officer", "Maintenance Worker", "IT Support Specialist", "Accountant");
        HBox jobTitleField = Utility.createSelect(jobTitleOptions, 300, 50, 100, 380);
        List<String> jobTypeOptions = List.of("Job Type", "Full-Time", "Part-Time", "Contract");
        HBox jobTypeField = Utility.createSelect(jobTypeOptions, 230, 50, 430, 380);
        TextField monthlySalaryField = Utility.createTextField("Monthly Salary", 100, 450);
        List<String> workScheduleOptions = List.of("Work Schedule", "Monday-Friday", "Weekends Only", "Rotating Shifts", "Flexible Hours");
        HBox workScheduleField = Utility.createSelect(workScheduleOptions, 230, 50, 430, 450);

        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            addStaffStage.close();
            staffManagementMenu.show();
        });

        Button nextBtn = Utility.createButton("Save", 100, 50, 360, 730);
        nextBtn.setOnAction(event -> {
            System.out.println("Next Button Clicked!");

            String fullName = sNameField.getText();
            String dateOfBirth = UIControlUtils.extractValueFromDatePicker(dobField);
            String cnicNumber = cnicField.getText();
            String gender = (String) UIControlUtils.HBoxToComboBox(genderField).getValue();
            String contact = gContactField.getText();
            String qualification = (String) UIControlUtils.HBoxToComboBox(qualificationField).getValue();
            double monthlySalary = Double.parseDouble(monthlySalaryField.getText());
            String jobTitle = (String) UIControlUtils.HBoxToComboBox(jobTitleField).getValue();
            String jobType = (String) UIControlUtils.HBoxToComboBox(jobTypeField).getValue();
            String workSchedule = (String) UIControlUtils.HBoxToComboBox(workScheduleField).getValue();

            Staff staff = new Staff();
            staff.setStaffDetails(fullName,dateOfBirth,cnicNumber,gender,contact,qualification,monthlySalary,jobTitle,jobType,workSchedule);

            SaveDataToMySQL.saveStaffInfo(staff);
            staffManagementMenu.show();
            addStaffStage.close();
        });


        rightPane.getChildren().addAll(heading1, sNameField, dobField, cnicField, genderField, gContactField, qualificationField, heading2, monthlySalaryField, jobTitleField, jobTypeField, workScheduleField);
        leftPane.getChildren().addAll(Utility.createTextLabel("Add New Staff", 30, 130, 530), backBtn, nextBtn, Utility.displayImage("/media/danish/8E20E81220E7FF59/Programming/Code/Java Code/IntelliJ IDEA/Projects/School Management System/src/main/resources/addStaff.png", 120,220));
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        addStaffStage.setScene(scene);
        addStaffStage.show();
    }
}
