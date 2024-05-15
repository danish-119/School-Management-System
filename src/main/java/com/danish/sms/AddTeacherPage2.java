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

public class AddTeacherPage2 {

    public void showAddTeacherPage(Stage addTeacherStage1, Teacher teacher) {
        Stage addTeacherStage2 = new Stage();
        addTeacherStage2.setFullScreen(true);
        addTeacherStage2.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Label heading1 = Utility.createTextLabel("Employment Information:", 30, 100, 50);
        List<String> jobTitleOptions = List.of("Job Title", "Professor", "Assistant Professor", "Associate Professor", "Lab Attendant","Lecturer", "Researcher", "Adjunct Professor" );
        HBox jobTitleField = Utility.createSelect(jobTitleOptions, 230, 50, 100, 100);
        List<String> jobTypeOptions = List.of("Job Type", "Full-Time", "Part-Time", "Contract", "Internship");
        HBox jobTypeField = Utility.createSelect(jobTypeOptions, 230, 50, 390, 100);
        List<String> departmentOptions = List.of("Department", "Computer Science", "Biology", "Physics", "Mathematics", "Chemistry", "English", "History", "Psychology", "Economics", "Engineering");
        HBox departmentField = Utility.createSelect(departmentOptions, 230, 50, 100, 170);
        HBox joiningDateField = Utility.createDateField("Date of Joining", 390, 170);

        Label heading2 = Utility.createTextLabel("Other Information:", 30, 100, 240);
        TextField monthlySalaryField = Utility.createTextField("Monthly Salary", 100, 290);
        List<String> bankOptions = List.of("Select Bank for Direct Deposit ", "Allied Bank Limited", "Askari Bank Limited", "Bank Alfalah Limited", "Bank Al-Habib Limited", "Faysal Bank Limited", "Habib Bank Limited (HBL)", "MCB Bank Limited", "Meezan Bank Limited", "National Bank of Pakistan (NBP)", "United Bank Limited (UBL)");
        HBox bankField = Utility.createSelect(bankOptions,230,50,430,290);
        TextField documentField = Utility.createTextField("Document Required", 100, 360);
        documentField.setText("1. B-Form (Issued by NADRA) 2. Previous Class Certificate 3. Application Form 4. Passport-sized Photographs");
        List<String> documentStatusOptions = List.of("Document Status", "Pending", "Approved", "Under Review", "Processing","Archived", "On Hold");
        HBox documentStatusField = Utility.createSelect(documentStatusOptions, 230, 50, 430, 360);


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
            String joiningDate = UIControlUtils.extractValueFromDatePicker(joiningDateField);
            String monthlySalary = monthlySalaryField.getText();
            String bank = UIControlUtils.extractValueFromComboBox(bankField);
            String documentStatus = UIControlUtils.extractValueFromComboBox(documentStatusField);
            String documents = documentField.getText();

            teacher.setTeacherDetails2(jobTitle, jobType, department, joiningDate, monthlySalary, bank, documentStatus, documents);

            TeacherFileHandler.writeTeacherToFile(teacher);
            TeacherFileHandler.readTeacherFromFile();

            addTeacherStage2.close();
        });


        rightPane.getChildren().addAll(heading1,jobTitleField, jobTypeField,joiningDateField,departmentField,heading2,monthlySalaryField, bankField,documentField, documentStatusField);
        leftPane.getChildren().addAll(Utility.createTextLabel("Add New Teacher", 30, 140, 530), backBtn,saveBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        addTeacherStage2.setScene(scene);
        addTeacherStage2.show();
    }
}
