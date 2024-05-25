package com.danish.sms;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class UpdateStudentPage1 {

    public void showUpdateStudentPage1(Stage studentManagementStage) {
        Stage updateStudentStage1 = new Stage();
        updateStudentStage1.setFullScreen(true);
        updateStudentStage1.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        TextField emailField = Utility.createTextField("abc123@example.com", 80, 400);
        List<String> extracurricularOptions = List.of("Select Interest", "Sports", "Music", "Art", "Coding", "Writing", "Cooking", "Other");
        HBox extracurricularField = Utility.createSelect(extracurricularOptions, 230, 50, 430, 400);
        Label heading2 = Utility.createTextLabel("Parent/Guardian Information:", 30, 80, 480);
        TextField gNameField = Utility.createTextField("Father's/Guardian Name", 80, 550);
        List<String> relationOptions = List.of("Relation", "Parent", "Guardian", "Sibling", "Relative", "Other");
        HBox relationField = Utility.createSelect(relationOptions, 230, 45, 430, 550);
        TextField gCnicField = Utility.createTextField("CNIC Number", 80, 620);
        List<String> occupationOptions = List.of("Occupation", "Doctor", "Engineer", "Teacher", "Nurse", "Artist", "Businessperson", "Homemaker", "Student", "Other");
        HBox occupationField = Utility.createSelect(occupationOptions, 230, 45, 430, 620);
        TextField gContactField = Utility.createTextField("Contact", 80, 690);
        Label jobType = Utility.createTextLabel("Job Type", 16, 525, 690);
        List<String> jobTypeOptions = List.of("Governmental", "Private");
        HBox jobTypeField = Utility.createRadioButtonSelect(jobTypeOptions, 430, 720);


        TextField studentIdField = Utility.createTextField("Enter Student ID", 80, 30);

        Button searchBtn = Utility.createButton("Search", 100, 50, 400, 30);

        searchBtn.setOnAction(event -> {
            System.out.println("Search Button Clicked!");
            rightPane.getChildren().clear();
            rightPane.getChildren().addAll(studentIdField, searchBtn);

            String studentId = studentIdField.getText();
            // Call a method to fetch student information by ID from the database
            Student student = GetDataByIdFromMySQL.getStudentById(studentId);
            if (student != null) {
                Label heading1 = Utility.createTextLabel("Student Information:", 30, 80, 90);
                Label sNameLabel = Utility.createTextLabel("Student Name: " + student.getStudentName(),22,80,150);
                Label dobField = Utility.createTextLabel("Date of Birth: " + student.getDob(),22, 80, 200);

                Label sCnicLabel = Utility.createTextLabel("CNIC/B-Form Number:" + student.getCnicOrBForm(), 22, 80, 250);
                Label genderLabel = Utility.createTextLabel("Gender: " + student.getGender(), 22, 80,300);
                Label bloodGroupLabel = Utility.createTextLabel("Blood Group: " + student.getBloodGroup(), 22, 80, 350);
                emailField.setText(student.getEmail());

                UIControlUtils.HBoxToComboBox(extracurricularField).setValue(student.getExtracurricularInterest());
                gNameField.setText(student.getGuardianName());
                UIControlUtils.HBoxToComboBox(relationField).setValue(student.getGuardianRelation());
                gCnicField.setText(student.getGuardianCnic());
                UIControlUtils.HBoxToComboBox(occupationField).setValue(student.getGuardianOccupation());
                gContactField.setText(student.getGuardianContact());

                for (Node node : jobTypeField.getChildren()) {
                    if (node instanceof RadioButton) {
                        RadioButton radioButton = (RadioButton) node;
                        if (radioButton.getText().equalsIgnoreCase(student.getJobType())) {
                            radioButton.setSelected(true);
                            break;
                        }
                    }
                }

                rightPane.getChildren().addAll(
                        heading1, sNameLabel, dobField, sCnicLabel, bloodGroupLabel,genderLabel, emailField, extracurricularField, heading2, gNameField,
                        relationField, gCnicField, occupationField, gContactField, jobType, jobTypeField);
            } else {
                Label errorLabel = Utility.createTextLabel("Student not Found!",30,100,330);
                rightPane.getChildren().add(errorLabel);
            }
        });

        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            studentManagementStage.show();
            updateStudentStage1.close();
        });

        Button updateBtn = Utility.createButton("Next", 120, 50, 360, 730);
        updateBtn.setOnAction(event -> {
            System.out.println("Next Button Clicked!");
            // Collect data entered by the user
            String email = emailField.getText().toLowerCase();
            String extracurricular = (String) UIControlUtils.HBoxToComboBox(extracurricularField).getValue();
            String guardianName = gNameField.getText().toUpperCase();
            String relation = (String) UIControlUtils.HBoxToComboBox(relationField).getValue();
            String guardianCnic = gCnicField.getText();
            String occupation = (String) UIControlUtils.HBoxToComboBox(occupationField).getValue();
            String contact = gContactField.getText();
            String jobTypeSelected = UIControlUtils.extractSelectedRadioButtonText(jobTypeField);

            Student updatedStudent = new Student();
            updatedStudent.setStudentDetails1(null,null,null,null,null,null,email,extracurricular,guardianName,relation,guardianCnic,occupation,contact, jobTypeSelected);

            updateStudentStage1.close();
            UpdateStudentPage2 updateStudentPage2 = new UpdateStudentPage2();
            updateStudentPage2.showUpdateStudentPage2(studentManagementStage, updateStudentStage1, studentIdField.getText() , updatedStudent);
        });

        rightPane.getChildren().addAll(studentIdField,searchBtn);
        leftPane.getChildren().addAll(Utility.createTextLabel("Update Student Info", 30, 80, 530), backBtn,updateBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        updateStudentStage1.setScene(scene);
        updateStudentStage1.show();
    }
}