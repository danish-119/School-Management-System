package com.danish.sms;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class UpdateTeacherPage1 {

    public void showUpdateTeacherPage1(Stage teacherManagementStage) {
        Stage updateTeacherStage1 = new Stage();
        updateTeacherStage1.setFullScreen(true);
        updateTeacherStage1.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        TextField teacherIdField = Utility.createTextField("Enter Teacher ID", 80, 30);
        Button searchBtn = Utility.createButton("Search", 100, 50, 400, 30);

        TextField emailField = Utility.createTextField("abc123@example.com", 80, 400);
        Label heading2 = Utility.createTextLabel("Professional Information:", 30, 80, 480);
        TextField experienceField = Utility.createTextField("Experience", 80, 550);
        TextField experienceYearField = Utility.createTextField("Experience Years", 430, 550);
        experienceYearField.setPrefWidth(230);
        List<String> universityOptions = List.of("Select University", "Quaid-e-Azam University", "University of the Punjab", "Lahore University of Management Sciences (LUMS)", "National University of Sciences and Technology (NUST)", "University of Engineering and Technology (UET)", "Aga Khan University", "COMSATS University Islamabad", "International Islamic University Islamabad (IIUI)", "Pakistan Institute of Engineering and Applied Sciences (PIEAS)", "Lahore College for Women University (LCWU)");
        HBox graduatedFromField = Utility.createSelect(universityOptions, 300, 50, 80, 630);
        List<String> qualificationOptions = List.of("Qualification", "PhD", "Master's Degree", "Bachelor's Degree", "Other");
        HBox qualificationField = Utility.createSelect(qualificationOptions, 230, 50, 430, 630);
        List<String> subjectOptions = List.of("Major Subject", "Mathematics", "Science", "English", "Urdu", "History", "Art", "Physical Education", "Computer Science", "Other");
        HBox subjectField = Utility.createSelect(subjectOptions, 230, 45, 430, 700);

        searchBtn.setOnAction(event -> {
            System.out.println("Search Button Clicked!");
            rightPane.getChildren().clear();
            rightPane.getChildren().addAll(teacherIdField, searchBtn);

            String teacherId = teacherIdField.getText();
            Teacher teacher = GetDataByIdFromMySQL.getTeacherById(teacherId);

            if (teacher != null) {
                Label heading1 = Utility.createTextLabel("Personal Information:", 30, 80, 90);
                Label nameLabel = Utility.createTextLabel("Teacher Name: " + teacher.getTeacherName(), 22, 80, 150);
                Label dobLabel = Utility.createTextLabel("Date of Birth: " + teacher.getDob(), 22, 80, 200);
                Label genderLabel = Utility.createTextLabel("Gender: " + teacher.getGender(), 22, 80, 250);
                Label cnicLabel = Utility.createTextLabel("CNIC Number: " + teacher.getCnic(), 22, 80, 300);
                Label bloodGroupLabel = Utility.createTextLabel("Blood Group: " + teacher.getBloodGroup(), 22, 80, 350);

                emailField.setText(teacher.getEmail());
                experienceField.setText(teacher.getExperience());
                experienceYearField.setText(teacher.getExperienceYears());
                UIControlUtils.HBoxToComboBox(graduatedFromField).setValue(teacher.getUniversityGraduatedFrom());
                UIControlUtils.HBoxToComboBox(qualificationField).setValue(teacher.getQualification());
                UIControlUtils.HBoxToComboBox(subjectField).setValue(teacher.getMajorSubject());

                rightPane.getChildren().addAll(heading1, nameLabel, dobLabel, genderLabel, cnicLabel, bloodGroupLabel, emailField, heading2, experienceField, experienceYearField, graduatedFromField, qualificationField, subjectField);
            } else {
                Label errorLabel = Utility.createTextLabel("Teacher not Found!", 30, 100, 330);
                rightPane.getChildren().add(errorLabel);
            }
        });

        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            teacherManagementStage.show();
            updateTeacherStage1.close();
        });

        Button nextBtn = Utility.createButton("Next", 120, 50, 360, 730);
        nextBtn.setOnAction(event -> {
            System.out.println("Next Button Clicked!");
            // Collect data entered by the user
            String email = emailField.getText().toLowerCase();
            String experience = experienceField.getText();
            String experienceYears = experienceYearField.getText();
            String university = (String) UIControlUtils.HBoxToComboBox(graduatedFromField).getValue();
            String qualification = (String) UIControlUtils.HBoxToComboBox(qualificationField).getValue();
            String subject = (String) UIControlUtils.HBoxToComboBox(subjectField).getValue();

            Teacher updatedTeacher = new Teacher();
            updatedTeacher.setTeacherDetails1(null,null,null,null,null,null,email,experience,experienceYears,university,qualification,subject);

            updateTeacherStage1.close();
            UpdateTeacherPage2 updateTeacherPage2 = new UpdateTeacherPage2();
            updateTeacherPage2.showUpdateTeacherPage2(teacherManagementStage, updateTeacherStage1, teacherIdField.getText(), updatedTeacher);
        });

        rightPane.getChildren().addAll(teacherIdField, searchBtn);
        leftPane.getChildren().addAll(Utility.createTextLabel("Update Teacher Info", 30, 90, 530), backBtn, nextBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        updateTeacherStage1.setScene(scene);
        updateTeacherStage1.show();
    }
}
