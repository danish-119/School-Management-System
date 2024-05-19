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
                // Display student information for removal

                Label heading1 = Utility.createTextLabel("Student Information:", 30, 80, 90);
//                Label sNameLabel = Utility.createTextLabel("Student Name:", 18, 80, 140);
//                Label sNameField = Utility.createTextLabel(student.getStudentName(), 18, 230, 140); // Field replaced by a label
//                HBox dobField = Utility.createDateField("Date of Birth", 430, 140);
//                Label fNameLabel = Utility.createTextLabel("Father's Name:", 16, 80, 210);
//                Label fNameField = Utility.createTextLabel("", 18, 230, 210); // Field replaced by a label
//                List<String> genderOptions = List.of("Gender", "Male", "Female", "Other");
//                HBox genderField = Utility.createSelect(genderOptions, 230, 45, 430, 210);
//                Label sCnicLabel = Utility.createTextLabel("CNIC/B-Form Number:", 18, 80, 280);
//                Label sCnicField = Utility.createTextLabel(student.getCnicOrBForm(), 18, 230, 280); // Field replaced by a label
//                List<String> bloodGroupOptions = List.of("Blood Group", "A", "B", "AB", "O", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
//                Label bloodGroupLabel = Utility.createTextLabel("Blood Group:", 16, 80, 350);
//                Label bloodGroupField = Utility.createTextLabel(student.getBloodGroup(), 18, 230, 350); // Field replaced by a label
                TextField emailField = Utility.createTextField("abc123@example.com", 80, 400);
                emailField.setText(student.getEmail());
                List<String> extracurricularOptions = List.of("Select Interest", "Sports", "Music", "Art", "Coding", "Writing", "Cooking", "Other");
                HBox extracurricularField = Utility.createSelect(extracurricularOptions, 230, 50, 430, 400);
                UIControlUtils.HBoxToComboBox(extracurricularField).setValue(student.getExtracurricularInterest());
                // ----------------------------------------------------
                Label heading2 = Utility.createTextLabel("Parent/Guardian Information:", 30, 80, 480);
                TextField gNameField = Utility.createTextField("Father's/Guardian Name", 80, 550);
                gNameField.setText(student.getGuardianName());
                List<String> relationOptions = List.of("Relation", "Parent", "Guardian", "Sibling", "Relative", "Other");
                HBox relationField = Utility.createSelect(relationOptions, 230, 45, 430, 550);
                UIControlUtils.HBoxToComboBox(relationField).setValue(student.getGuardianRelation());
                TextField gCnicField = Utility.createTextField("CNIC Number", 80, 620);
                gCnicField.setText(student.getGuardianCnic());
                List<String> occupationOptions = List.of("Occupation", "Doctor", "Engineer", "Teacher", "Nurse", "Artist", "Businessperson", "Homemaker", "Student", "Other");
                HBox occupationField = Utility.createSelect(occupationOptions, 230, 45, 430, 620);
                UIControlUtils.HBoxToComboBox(occupationField).setValue(student.getGuardianOccupation());
                TextField gContactField = Utility.createTextField("Contact", 80, 690);
                gContactField.setText(student.getGuardianContact());
                Label jobType = Utility.createTextLabel("Job Type", 16, 525, 690);
                List<String> jobTypeOptions = List.of("Governmental", "Private");
                HBox jobTypeField = Utility.createRadioButtonSelect(jobTypeOptions, 430, 720);
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
                        heading1, /*sNameLabel, sNameField, fNameLabel, fNameField, dobField, sCnicLabel, sCnicField, bloodGroupLabel, bloodGroupField,
                        genderField,*/ emailField, extracurricularField, heading2, gNameField,
                        relationField, gCnicField, occupationField, gContactField, jobType, jobTypeField
                );
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


            Student student = new Student();

            updateStudentStage1.close();
            UpdateStudentPage2 updateStudentPage2 = new UpdateStudentPage2();
            updateStudentPage2.showUpdateStudentPage2(studentManagementStage, updateStudentStage1, student);
        });

        rightPane.getChildren().addAll(studentIdField,searchBtn);
        leftPane.getChildren().addAll(Utility.createTextLabel("Update Student Info", 30, 100, 530), backBtn,updateBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        updateStudentStage1.setScene(scene);
        updateStudentStage1.show();
    }
}