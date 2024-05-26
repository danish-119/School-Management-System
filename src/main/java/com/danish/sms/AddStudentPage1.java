package com.danish.sms;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

public class AddStudentPage1 {

    public void showAddStudentPage(Stage studentManagementMenu) {
        Stage addStudentStage1 = new Stage();
        addStudentStage1.setFullScreen(true);
        addStudentStage1.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Label heading1 = Utility.createTextLabel("Student Information:", 30, "bold" ,100, 50);
        TextField sNameField = Utility.createTextField("Student Name", 100, 100);
        HBox dobField = Utility.createDateField("Date of Birth", 430, 100);
        TextField fNameField = Utility.createTextField("Father's Name", 100, 170);
        List<String> genderOptions = List.of("Gender", "Male", "Female", "Other");
        HBox genderField = Utility.createSelect(genderOptions, 230, 45, 430, 170);
        TextField sCnicField = Utility.createTextField("CNIC/B-Form Number", 100, 240);
        List<String> bloodGroupOptions = List.of("Blood Group", "A", "B", "AB", "O", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
        HBox bloodGroupField = Utility.createSelect(bloodGroupOptions, 230, 45, 430, 240);
        TextField emailField = Utility.createTextField("abc123@example.com", 100, 310);
        List<String> extracurricularOptions = List.of("Select Interest", "Sports", "Music", "Art", "Coding", "Writing", "Cooking", "Other");
        HBox extracurricularField = Utility.createSelect(extracurricularOptions, 230, 45, 430, 310);

        Label heading2 = Utility.createTextLabel("Parent/Guardian Information:", 30, "bold" ,100, 380);
        TextField gNameField = Utility.createTextField("Father's/Guardian Name", 100, 450);
        List<String> relationOptions = List.of("Relation", "Parent", "Guardian", "Sibling", "Relative", "Other");
        HBox relationField = Utility.createSelect(relationOptions, 230, 45, 430, 450);
        TextField gCnicField = Utility.createTextField("CNIC Number", 100, 520);
        List<String> occupationOptions = List.of("Occupation", "Doctor", "Engineer", "Teacher", "Nurse", "Artist", "Businessperson", "Homemaker", "Student", "Other");
        HBox occupationField = Utility.createSelect(occupationOptions, 230, 45, 430, 520);
        TextField gContactField = Utility.createTextField("Contact", 100, 580);

        Label jobType = Utility.createTextLabel("Job Type", 16, "bold" ,525, 580);
        List<String> jobTypeOptions = List.of("Governmental", "Private");
        HBox jobTypeField = Utility.createRadioButtonSelect(jobTypeOptions, 430, 610);

        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            addStudentStage1.close();
            studentManagementMenu.show();
        });

        Button nextBtn = Utility.createButton("Next", 100, 50, 360, 730);
        nextBtn.setOnAction(event -> {
            System.out.println("Next Button Clicked!");

            // Collect data entered by the user
            String studentName = sNameField.getText().toUpperCase();
            String dob = UIControlUtils.extractValueFromDatePicker(dobField);
            String fatherName = fNameField.getText().toUpperCase();
            String gender = (String) UIControlUtils.HBoxToComboBox(genderField).getValue();
            String cnic = sCnicField.getText();
            String bloodGroup = (String) UIControlUtils.HBoxToComboBox(bloodGroupField).getValue();
            String email = emailField.getText().toLowerCase();
            String extracurricular = (String) UIControlUtils.HBoxToComboBox(extracurricularField).getValue();
            String guardianName = gNameField.getText().toUpperCase();
            String relation = (String) UIControlUtils.HBoxToComboBox(relationField).getValue();
            String guardianCnic = gCnicField.getText();
            String occupation = (String) UIControlUtils.HBoxToComboBox(occupationField).getValue();
            String contact = gContactField.getText();
            String jobTypeSelected = UIControlUtils.extractSelectedRadioButtonText(jobTypeField);
            String username = studentName.toLowerCase().replace(" ", "") + "@school.edu.pk";

            Student student = new Student();
            student.setUsername(username);
            student.setStudentDetails1(studentName, dob, fatherName, gender, cnic, bloodGroup, email, extracurricular, guardianName, relation, guardianCnic, occupation, contact, jobTypeSelected);

            // Proceed to the next page or close the stage as needed
            AddStudentPage2 addStudentPage2 = new AddStudentPage2();
            addStudentPage2.showAddStudentPage(studentManagementMenu, addStudentStage1, student);
            addStudentStage1.close();
        });


        rightPane.getChildren().addAll(
                heading1, sNameField, fNameField, dobField, sCnicField, bloodGroupField,
                genderField, emailField, extracurricularField, heading2, gNameField,
                relationField, gCnicField, occupationField, gContactField, jobType, jobTypeField
        );
        leftPane.getChildren().addAll(
                Utility.createTextLabel("Add New Student", 30, "bold" ,140, 530), backBtn, nextBtn, Utility.displayImage("/media/danish/8E20E81220E7FF59/Programming/Code/Java Code/IntelliJ IDEA/Projects/School Management System/src/main/resources/addStudent.png", 120,220));
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        addStudentStage1.setScene(scene);
        addStudentStage1.show();
    }
}
