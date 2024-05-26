package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class UpdateStudentPage2 {

    public void showUpdateStudentPage2(Stage studentManagementStage, Stage updateStudentStage1 ,String studentId, Student updatedStudent) {
        Stage updateStudentStage2 = new Stage();
        updateStudentStage2.setFullScreen(true);
        updateStudentStage2.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Student student = GetDataByIdFromMySQL.getStudentById(studentId);

        Label heading1 = Utility.createTextLabel("Academic Information:", 30, "bold" ,80, 50);
        Label admissionNumberLabel = Utility.createTextLabel("Admission Number: " + student.getAdmissionNumber() , 20, "bold" ,80, 110);
        Label usernameLabel = Utility.createTextLabel("Username: " + student.getUsername() , 18, "bold" ,80, 180);
        PasswordField passwordField = Utility.createPasswordField("Password", 430, 170);
        passwordField.setPrefWidth(230);
        passwordField.setText(student.getPassword());
        List<String> classGradeOptions = List.of("Class/Grade", "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th");
        HBox classGradeField = Utility.createSelect(classGradeOptions, 230, 45, 430, 100);
        UIControlUtils.HBoxToComboBox(classGradeField).setValue(student.getClassGrade());
        List<String> sectionOptions = List.of("Select Section", "Section A", "Section B", "Section C", "Section D");
        HBox sectionField = Utility.createSelect(sectionOptions, 230, 45, 80, 240);
        UIControlUtils.HBoxToComboBox(sectionField).setValue(student.getSection());


        Label heading2 = Utility.createTextLabel("Other Information:", 30, "bold" ,80, 310);
        TextField monthlyFeeField = Utility.createTextField("Monthly Fee", 80, 370);
        monthlyFeeField.setText(String.valueOf(student.getMonthlyFee()));
        List<String> scholarshipStatusOptions = List.of("Scholarship Status","Not Applied", "Pending", "Approved", "Rejected");
        HBox scholarshipStatusField = Utility.createSelect(scholarshipStatusOptions, 230, 45, 430, 370);
        UIControlUtils.HBoxToComboBox(scholarshipStatusField).setValue(student.getScholarshipStatus());
        TextField documentField = Utility.createTextField("Document Required", 80, 430);
        documentField.setText("1. B-Form (Issued by NADRA) 2. Previous Class Certificate 3. Application Form 4. Passport-sized Photographs");
        documentField.setText(student.getDocumentRequired());
        List<String> documentStatusOptions = List.of("Document Status", "Pending", "Approved", "Under Review", "Processing","Archived", "On Hold");
        HBox documentStatusField = Utility.createSelect(documentStatusOptions, 230, 45, 430, 430);
        UIControlUtils.HBoxToComboBox(documentStatusField).setValue(student.getDocumentStatus());


        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            updateStudentStage1.show();
            updateStudentStage2.close();
        });

        Button updateBtn = Utility.createButton("Update", 120, 50, 360, 730);
        updateBtn.setOnAction(event -> {
            System.out.println("Update Button Clicked!");
            String classGrade = (String) UIControlUtils.HBoxToComboBox(classGradeField).getValue();
            String section = (String) UIControlUtils.HBoxToComboBox(sectionField).getValue();
            String password = passwordField.getText();
            double monthlyFee = Double.parseDouble(monthlyFeeField.getText());
            String scholarshipStatus =(String) UIControlUtils.HBoxToComboBox(scholarshipStatusField).getValue();
            String documentStatus = (String) UIControlUtils.HBoxToComboBox(documentStatusField).getValue();
            String documents = documentField.getText();

            updatedStudent.setStudentId(student.getStudentId());
            updatedStudent.setStudentDetails2(null,classGrade,section,password,monthlyFee,scholarshipStatus,documentStatus,documents);

            UpdateDataInMySQL.updateStudentInfo(updatedStudent);
            updateStudentStage2.close();
            studentManagementStage.show();
        });

        rightPane.getChildren().addAll(heading1,admissionNumberLabel,classGradeField,sectionField,usernameLabel,passwordField, heading2,monthlyFeeField,scholarshipStatusField,documentStatusField, documentField);
        leftPane.getChildren().addAll(Utility.createTextLabel("Update Student Info", 30, "bold" ,100, 530), backBtn,updateBtn, Utility.displayImage("/media/danish/8E20E81220E7FF59/Programming/Code/Java Code/IntelliJ IDEA/Projects/School Management System/src/main/resources/updatePerson.png", 120,220));
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        updateStudentStage2.setScene(scene);
        updateStudentStage2.show();
    }
}