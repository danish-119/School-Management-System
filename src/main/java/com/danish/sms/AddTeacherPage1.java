package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class AddTeacherPage1 {

    public void showAddTeacherPage(Stage teacherManagementMenu) {
        Stage addTeacherStage1 = new Stage();
        addTeacherStage1.setFullScreen(true);
        addTeacherStage1.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Label heading1 = Utility.createTextLabel("Personal Information:", 30, "bold" ,100, 50);
        TextField sNameField = Utility.createTextField("Teacher Name", 100, 100);
        HBox dobField = Utility.createDateField("Date of Birth", 430, 100);
        TextField fNameField = Utility.createTextField("Father's Name", 100, 170);
        List<String> genderOptions = List.of("Gender", "Male", "Female", "Other");
        HBox genderField = Utility.createSelect(genderOptions, 230, 45, 430, 170);
        TextField sCnicField = Utility.createTextField("CNIC Number", 100, 240);
        List<String> bloodGroupOptions = List.of("Blood Group", "A", "B", "AB", "O", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
        HBox bloodGroupField = Utility.createSelect(bloodGroupOptions, 230, 45, 430, 240);
        TextField emailField = Utility.createTextField("abc123@example.com", 100, 310);

        Label heading2 = Utility.createTextLabel("Professional Information:", 30, "bold" ,100, 380);
        TextField experienceField = Utility.createTextField("Experience", 100, 450);
        TextField experienceYearField = Utility.createTextField("Experience Years", 430, 450);
        experienceYearField.setPrefWidth(230);
        List<String> universityOptions = List.of("Select University", "Quaid-e-Azam University", "University of the Punjab", "Lahore University of Management Sciences (LUMS)", "National University of Sciences and Technology (NUST)", "University of Engineering and Technology (UET)", "Ag​a Khan University", "COMSATS University Islamabad", "International Islamic University Islamabad (IIUI)", "Pakistan Institute of Engineering and Applied Sciences (PIEAS)", "Lahore College for Women University (LCWU)");
        HBox graduatedFromField = Utility.createSelect(universityOptions, 300, 50, 100, 530);
        List<String> qualificationOptions = List.of("Qualification", "PhD", "Master's Degree", "Bachelor's Degree", "Other");
        HBox qualificationField = Utility.createSelect(qualificationOptions, 230, 45, 430, 530);
        List<String> subjectOptions = List.of("Major Subject", "Mathematics", "Science", "English","Urdu", "History", "Art", "Physical Education", "Computer Science", "Other");
        HBox subjectField = Utility.createSelect(subjectOptions, 230, 45, 430, 600);

        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            addTeacherStage1.close();
            teacherManagementMenu.show();
        });

        Button nextBtn = Utility.createButton("Next", 100, 50, 360, 730);
        nextBtn.setOnAction(event -> {
            System.out.println("Next Button Clicked!");

            // Collect data entered by the user
            String teacherName = sNameField.getText().toUpperCase();
            String dob = UIControlUtils.extractValueFromDatePicker(dobField);
            String fatherName = fNameField.getText().toUpperCase();
            String gender = (String) UIControlUtils.HBoxToComboBox(genderField).getValue();
            String cnic = sCnicField.getText();
            String bloodGroup = (String) UIControlUtils.HBoxToComboBox(bloodGroupField).getValue();
            String email = emailField.getText().toLowerCase();
            String experience = experienceField.getText();
            String experienceYears = experienceYearField.getText();
            String university = (String) UIControlUtils.HBoxToComboBox(graduatedFromField).getValue();
            String qualification = (String) UIControlUtils.HBoxToComboBox(qualificationField).getValue();
            String subject = (String) UIControlUtils.HBoxToComboBox(subjectField).getValue();
            String username = teacherName.toLowerCase().replace(" ", "") + "@school.edu.pk";

            Teacher teacher = new Teacher();
            teacher.setUsername(username);
            teacher.setTeacherDetails1(teacherName, dob, fatherName, gender, cnic, bloodGroup, email, experience, experienceYears, university, qualification, subject);

            //-------------------------------
            addTeacherStage1.close();
            AddTeacherPage2 addTeacherPage2 = new AddTeacherPage2();
            addTeacherPage2.showAddTeacherPage(teacherManagementMenu, addTeacherStage1, teacher );
        });


        rightPane.getChildren().addAll(heading1, sNameField, fNameField, dobField, sCnicField, bloodGroupField, genderField, emailField, heading2, qualificationField, subjectField, experienceField, experienceYearField, graduatedFromField);
        leftPane.getChildren().addAll(Utility.createTextLabel("Add New Teacher", 30, "bold" ,120, 530), backBtn,nextBtn, Utility.displayImage("/media/danish/8E20E81220E7FF59/Programming/Code/Java Code/IntelliJ IDEA/Projects/School Management System/src/main/resources/addStaff.png", 120,220));
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        addTeacherStage1.setScene(scene);
        addTeacherStage1.show();
    }
}
