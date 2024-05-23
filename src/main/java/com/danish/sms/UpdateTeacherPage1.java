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

public class UpdateTeacherPage1 {

    public void showUpdateTeacherPage1(Stage teacherManagementStage) {
        Stage updateTeacherStage = new Stage();
        updateTeacherStage.setFullScreen(true);
        updateTeacherStage.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        TextField teacherIdField = Utility.createTextField("Enter Teacher ID", 80, 30);

        Button searchBtn = Utility.createButton("Search", 100, 50, 400, 30);

        searchBtn.setOnAction(event -> {
            System.out.println("Search Button Clicked!");
            rightPane.getChildren().clear();
            rightPane.getChildren().addAll(teacherIdField, searchBtn);

            String teacherId = teacherIdField.getText();
            Teacher teacher = GetDataByIdFromMySQL.getTeacherById(teacherId);

            if (teacher != null) {
                Label heading1 = Utility.createTextLabel("Personal Information:", 30, 80, 90);
                Label nameLabel = Utility.createTextLabel("Teacher Name: "+ teacher.getTeacherName(), 22, 80, 150);
                Label dobLabel = Utility.createTextLabel("Date of Birth: "+ teacher.getDob(), 22, 80, 200);
                Label genderLabel = Utility.createTextLabel("Gender: " + teacher.getGender(), 22, 80, 250);
                Label cnicLabel = Utility.createTextLabel("CNIC Number: " + teacher.getCnic(), 22, 80, 300);
                Label bloodGroupLabel = Utility.createTextLabel("Blood Group: " + teacher.getBloodGroup(), 22, 80, 350);

                TextField emailField = Utility.createTextField("abc123@example.com", 80, 400);

                Label heading2 = Utility.createTextLabel("Professional Information:", 30, 80, 480);
                TextField experienceField = Utility.createTextField("Experience", 80, 550);
                TextField experienceYearField = Utility.createTextField("Experience Years", 430, 550);
                experienceYearField.setPrefWidth(230);
                List<String> universityOptions = List.of("Select University", "Quaid-e-Azam University", "University of the Punjab", "Lahore University of Management Sciences (LUMS)", "National University of Sciences and Technology (NUST)", "University of Engineering and Technology (UET)", "Ag​a Khan University", "COMSATS University Islamabad", "International Islamic University Islamabad (IIUI)", "Pakistan Institute of Engineering and Applied Sciences (PIEAS)", "Lahore College for Women University (LCWU)");
                HBox graduatedFromField = Utility.createSelect(universityOptions, 300, 50, 80, 630);
                List<String> qualificationOptions = List.of("Qualification", "PhD", "Master's Degree", "Bachelor's Degree", "Other");
                HBox qualificationField = Utility.createSelect(qualificationOptions, 230, 50, 430, 630);
                List<String> subjectOptions = List.of("Major Subject", "Mathematics", "Science", "English","Urdu", "History", "Art", "Physical Education", "Computer Science", "Other");
                HBox subjectField = Utility.createSelect(subjectOptions, 230, 45, 430, 700);

                rightPane.getChildren().addAll(heading1,nameLabel,dobLabel,genderLabel,cnicLabel,bloodGroupLabel,emailField, heading2,experienceField, experienceYearField, graduatedFromField, qualificationField, subjectField);
            }
        });


        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            teacherManagementStage.show();
            updateTeacherStage.close();
        });

        Button updateBtn = Utility.createButton("Update", 120, 50, 360, 730);
        updateBtn.setOnAction(event -> {
            System.out.println("Update Button Clicked!");

            updateTeacherStage.close();
            teacherManagementStage.show();
        });

        rightPane.getChildren().addAll(teacherIdField,searchBtn);
        leftPane.getChildren().addAll(Utility.createTextLabel("Update Teacher Info", 30, 90, 530), backBtn,updateBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        updateTeacherStage.setScene(scene);
        updateTeacherStage.show();
    }
}
