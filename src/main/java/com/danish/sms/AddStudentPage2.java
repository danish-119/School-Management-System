package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class AddStudentPage2 {

    public void showAddStudentPage(Stage studentManagementStage, Stage addStudentStage1, Student student) {
        Stage addStudentStage2 = new Stage();
        addStudentStage2.setFullScreen(true);
        addStudentStage2.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Label heading1 = Utility.createTextLabel("Academic Information:", 30, "bold" ,100, 50);
        TextField admissionNumberField = Utility.createTextField("Admission Number", 100, 100);
        List<String> classGradeOptions = List.of("Class/Grade", "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th");
        HBox classGradeField = Utility.createSelect(classGradeOptions, 230, 45, 430, 100);
        List<String> sectionOptions = List.of("Select Section", "Section A", "Section B", "Section C", "Section D");
        TextField usernameField = Utility.createTextField("Username", 100, 170);
        usernameField.setText(student.getUsername());
        PasswordField passwordField = Utility.createPasswordField("Password", 430, 170);
        passwordField.setPrefWidth(230);
        passwordField.setText(Utility.generateRandomPassword());
        HBox sectionField = Utility.createSelect(sectionOptions, 230, 45, 100, 240);


        Label heading2 = Utility.createTextLabel("Other Information:", 30, "bold" ,100, 310);
        TextField monthlyFeeField = Utility.createTextField("Monthly Fee", 100, 350);
        List<String> scholarshipStatusOptions = List.of("Scholarship Status","Not Applied", "Pending", "Approved", "Rejected");
        HBox scholarshipStatusField = Utility.createSelect(scholarshipStatusOptions, 230, 45, 430, 350);
        TextField documentField = Utility.createTextField("Document Required", 100, 410);
        documentField.setText("1. B-Form (Issued by NADRA) 2. Previous Class Certificate 3. Application Form 4. Passport-sized Photographs");
        List<String> documentStatusOptions = List.of("Document Status", "Pending", "Approved", "Under Review", "Processing","Archived", "On Hold");
        HBox documentStatusField = Utility.createSelect(documentStatusOptions, 230, 45, 430, 410);

        Label errorLabel = Utility.createTextLabel("", 18,"normal",200,500);



        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            addStudentStage2.close();
            addStudentStage1.show();
        });

        Button saveBtn = Utility.createButton("Save", 100, 50, 360, 730);
        saveBtn.setOnAction(event -> {
            System.out.println("Save Button Clicked!");

            // Collect data entered on this page
            String admissionNumber = admissionNumberField.getText();
            String classGrade = (String) UIControlUtils.HBoxToComboBox(classGradeField).getValue();
            String section = (String) UIControlUtils.HBoxToComboBox(sectionField).getValue();
            String password = passwordField.getText();
            double monthlyFee = Double.parseDouble(monthlyFeeField.getText());
            String scholarshipStatus =(String) UIControlUtils.HBoxToComboBox(scholarshipStatusField).getValue();
            String documentStatus = (String) UIControlUtils.HBoxToComboBox(documentStatusField).getValue();
            String documents = documentField.getText();

            student.setStudentDetails2(admissionNumber, classGrade, section, password, monthlyFee, scholarshipStatus, documentStatus, documents);
            boolean isSave = SaveDataToMySQL.saveStudentInfo(student);

            if(isSave)
            {
                addStudentStage2.close();
                studentManagementStage.show();

            }
            else{
                errorLabel.setText("Please fill all the fields");
            }
        });

        rightPane.getChildren().addAll(heading1,admissionNumberField,classGradeField,sectionField,usernameField,passwordField, heading2,monthlyFeeField,scholarshipStatusField,documentStatusField, documentField, errorLabel);
        leftPane.getChildren().addAll(Utility.createTextLabel("Add New Student", 30, "bold" ,115, 530), backBtn,saveBtn,Utility.displayImage("/media/danish/8E20E81220E7FF59/Programming/Code/Java Code/IntelliJ IDEA/Projects/School Management System/src/main/resources/add.png", 120,220));
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        addStudentStage2.setScene(scene);
        addStudentStage2.show();
    }
}
