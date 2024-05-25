package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class UpdateTeacherPage2 {

    public void showUpdateTeacherPage2(Stage teacherManagementStage, Stage updateTeacherStage1 ,String teacherId, Teacher updatedTeacher) {
        Stage updateTeacherStage2 = new Stage();
        updateTeacherStage2.setFullScreen(true);
        updateTeacherStage2.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Teacher teacher = GetDataByIdFromMySQL.getTeacherById(teacherId);

        Label heading1 = Utility.createTextLabel("Employment Information:", 30, 80, 50);
        List<String> jobTitleOptions = List.of("Job Title", "Professor", "Assistant Professor", "Associate Professor", "Lab Attendant","Lecturer", "Researcher", "Adjunct Professor" );
        HBox jobTitleField = Utility.createSelect(jobTitleOptions, 300, 50, 80, 100);
        UIControlUtils.HBoxToComboBox(jobTitleField).setValue(teacher.getJobTitle());
        List<String> jobTypeOptions = List.of("Job Type", "Full-Time", "Part-Time", "Contract", "Internship");
        HBox jobTypeField = Utility.createSelect(jobTypeOptions, 230, 50, 430, 100);
        UIControlUtils.HBoxToComboBox(jobTypeField).setValue(teacher.getJobType());
        Label usernameLabel = Utility.createTextLabel("Username: " + teacher.getUsername() , 14, 80, 180);
        PasswordField passwordField = Utility.createPasswordField("Password", 430, 170);
        passwordField.setPrefWidth(230);
        passwordField.setText(teacher.getPassword());
        List<String> departmentOptions = List.of("Department", "Computer Science", "Biology", "Physics", "Mathematics", "Chemistry", "English", "History", "Psychology", "Economics", "Engineering");
        HBox departmentField = Utility.createSelect(departmentOptions, 300, 50, 80, 240);
        UIControlUtils.HBoxToComboBox(departmentField).setValue(teacher.getDepartment());

        Label heading2 = Utility.createTextLabel("Other Information:", 30, 80, 310);
        TextField monthlySalaryField = Utility.createTextField("Monthly Salary", 80, 360);
        monthlySalaryField.setText(String.valueOf(teacher.getMonthlySalary()));
        List<String> bankOptions = List.of("Select Bank for Direct Deposit ", "Allied Bank Limited", "Askari Bank Limited", "Bank Alfalah Limited", "Bank Al-Habib Limited", "Faysal Bank Limited", "Habib Bank Limited (HBL)", "MCB Bank Limited", "Meezan Bank Limited", "National Bank of Pakistan (NBP)", "United Bank Limited (UBL)");
        HBox bankField = Utility.createSelect(bankOptions,230,50,430,360);
        UIControlUtils.HBoxToComboBox(bankField).setValue(teacher.getBankForDirectDeposit());
        TextField documentField = Utility.createTextField("Document Required", 80, 430);
        documentField.setText(teacher.getDocumentRequired());
        List<String> documentStatusOptions = List.of("Document Status", "Pending", "Approved", "Under Review", "Processing","Archived", "On Hold");
        HBox documentStatusField = Utility.createSelect(documentStatusOptions, 230, 50, 430, 430);
        UIControlUtils.HBoxToComboBox(documentStatusField).setValue(teacher.getDocumentStatus());


        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            updateTeacherStage1.show();
            updateTeacherStage2.close();
        });

        Button updateBtn = Utility.createButton("Update", 120, 50, 360, 730);
        updateBtn.setOnAction(event -> {
            System.out.println("Update Button Clicked!");
            String jobTitle = (String) UIControlUtils.HBoxToComboBox(jobTitleField).getValue();
            String jobType = (String) UIControlUtils.HBoxToComboBox(jobTypeField).getValue();
            String password = passwordField.getText();
            String department = (String) UIControlUtils.HBoxToComboBox(departmentField).getValue();
            double monthlySalary = Double.parseDouble(monthlySalaryField.getText());
            String bankForDirectDeposit = (String) UIControlUtils.HBoxToComboBox(bankField).getValue();
            String documentRequired = documentField.getText();
            String documentStatus = (String) UIControlUtils.HBoxToComboBox(documentStatusField).getValue();

            updatedTeacher.setTeacherId(teacher.getTeacherId());
            updatedTeacher.setTeacherDetails2(jobTitle, jobType, password, department, monthlySalary, bankForDirectDeposit, documentRequired, documentStatus);

            UpdateDataInMySQL.updateTeacherInfo(updatedTeacher);
            updateTeacherStage2.close();
            teacherManagementStage.show();
        });

        rightPane.getChildren().addAll(heading1, jobTitleField, jobTypeField,usernameLabel, passwordField, departmentField, heading2, monthlySalaryField, bankField, documentField, documentStatusField);
        leftPane.getChildren().addAll(Utility.createTextLabel("Update Teacher Info", 30, 100, 530), backBtn,updateBtn, Utility.displayImage("/media/danish/8E20E81220E7FF59/Programming/Code/Java Code/IntelliJ IDEA/Projects/School Management System/src/main/resources/updatePerson.png", 120,220));
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        updateTeacherStage2.setScene(scene);
        updateTeacherStage2.show();
    }
}