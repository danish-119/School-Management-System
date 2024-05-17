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

public class AddTeacherPage2 {

    public void showAddTeacherPage(Stage teacherManagementMenu, Stage addTeacherStage1, Teacher teacher) {
        Stage addTeacherStage2 = new Stage();
        addTeacherStage2.setFullScreen(true);
        addTeacherStage2.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Label heading1 = Utility.createTextLabel("Employment Information:", 30, 100, 50);
        List<String> jobTitleOptions = List.of("Job Title", "Professor", "Assistant Professor", "Associate Professor", "Lab Attendant","Lecturer", "Researcher", "Adjunct Professor" );
        HBox jobTitleField = Utility.createSelect(jobTitleOptions, 300, 50, 100, 100);
        List<String> jobTypeOptions = List.of("Job Type", "Full-Time", "Part-Time", "Contract", "Internship");
        HBox jobTypeField = Utility.createSelect(jobTypeOptions, 230, 50, 430, 100);
        TextField usernameField = Utility.createTextField("Username? AutoGenerated", 100, 170);
        PasswordField passwordField = Utility.createPasswordField("Password", 430, 170);
        passwordField.setPrefWidth(230);
        passwordField.setText(Utility.generateRandomPassword());
        List<String> departmentOptions = List.of("Department", "Computer Science", "Biology", "Physics", "Mathematics", "Chemistry", "English", "History", "Psychology", "Economics", "Engineering");
        HBox departmentField = Utility.createSelect(departmentOptions, 300, 50, 100, 240);


        Label heading2 = Utility.createTextLabel("Other Information:", 30, 100, 310);
        TextField monthlySalaryField = Utility.createTextField("Monthly Salary", 100, 360);
        List<String> bankOptions = List.of("Select Bank for Direct Deposit ", "Allied Bank Limited", "Askari Bank Limited", "Bank Alfalah Limited", "Bank Al-Habib Limited", "Faysal Bank Limited", "Habib Bank Limited (HBL)", "MCB Bank Limited", "Meezan Bank Limited", "National Bank of Pakistan (NBP)", "United Bank Limited (UBL)");
        HBox bankField = Utility.createSelect(bankOptions,230,50,430,360);
        TextField documentField = Utility.createTextField("Document Required", 100, 430);
        documentField.setText("1. B-Form (Issued by NADRA) 2. Previous Class Certificate 3. Application Form 4. Passport-sized Photographs");
        List<String> documentStatusOptions = List.of("Document Status", "Pending", "Approved", "Under Review", "Processing","Archived", "On Hold");
        HBox documentStatusField = Utility.createSelect(documentStatusOptions, 230, 50, 430, 430);


        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            addTeacherStage2.close();
            addTeacherStage1.show();
        });

        Button saveBtn = Utility.createButton("Save", 100, 50, 360, 730);
        saveBtn.setOnAction(event -> {
            System.out.println("Save Button Clicked!");
            // Collect data entered on this page
            String jobTitle = UIControlUtils.extractValueFromComboBox(jobTitleField);
            String jobType = UIControlUtils.extractValueFromComboBox(jobTypeField);
            String department = UIControlUtils.extractValueFromComboBox(departmentField);
            String password = passwordField.getText();
            double monthlySalary = Double.parseDouble(monthlySalaryField.getText());
            String bank = UIControlUtils.extractValueFromComboBox(bankField);
            String documentStatus = UIControlUtils.extractValueFromComboBox(documentStatusField);
            String documents = documentField.getText();

            teacher.setTeacherDetails2(jobTitle, jobType, department, password, monthlySalary, bank, documentStatus, documents);

            SaveDataToMySQL.saveTeacherInfo(teacher);

            addTeacherStage2.close();
            teacherManagementMenu.show();
        });


        rightPane.getChildren().addAll(heading1,jobTitleField, jobTypeField,departmentField, usernameField,passwordField,heading2,monthlySalaryField, bankField,documentField, documentStatusField);
        leftPane.getChildren().addAll(Utility.createTextLabel("Add New Teacher", 30, 140, 530), backBtn,saveBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        addTeacherStage2.setScene(scene);
        addTeacherStage2.show();
    }
}
