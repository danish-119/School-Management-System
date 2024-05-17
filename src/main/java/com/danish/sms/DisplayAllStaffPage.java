package com.danish.sms;


import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DisplayAllStaffPage {

    public void showDisplayAllStaffPage(Stage staffManagementStage) {
        Stage displayAllStaffStage = new Stage();
        displayAllStaffStage.setFullScreen(true);
        displayAllStaffStage.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        // Load data from the database
        ObservableList<Staff> staffList = LoadDataFromMySQL.loadStaffData();

        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            staffManagementStage.show();
            displayAllStaffStage.close();
        });

        TextField employerIdField = Utility.createTextField("Enter Employer ID", 210, 730);
        employerIdField.setPrefWidth(155);
        employerIdField.setStyle("-fx-font-size: 14px;");

        Button searchBtn = Utility.createButton("Search", 100, 50, 380, 730);
        searchBtn.setOnAction(event -> {
            System.out.println("Search Button Clicked!");
            String employerId = employerIdField.getText();
        });

        // Create a TableView and define columns
        TableView<Staff> staffTable = new TableView<>();
        staffTable.setPrefHeight(800);
        staffTable.setPrefWidth(800);
//        staffTable.setStyle("-fx-control-inner-background: #e6e6f9;");


        TableColumn<Staff, String> employerIdColumn = new TableColumn<>("Employer ID");
        employerIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmployerId()));


        TableColumn<Staff, String> fullNameColumn = new TableColumn<>("Full Name");
        fullNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFullName()));

        TableColumn<Staff, String> dateOfBirthColumn = new TableColumn<>("Date of Birth");
        dateOfBirthColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDateOfBirth()));

        TableColumn<Staff, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGender()));

        TableColumn<Staff, String> cnicColumn = new TableColumn<>("CNIC");
        cnicColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCnicNumber()));

        TableColumn<Staff, String> contactColumn = new TableColumn<>("Contact");
        contactColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContact()));

        TableColumn<Staff, String> qualificationColumn = new TableColumn<>("Qualification");
        qualificationColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getQualification()));

        TableColumn<Staff, String> joiningDateColumn = new TableColumn<>("Joining Date");
        joiningDateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJoiningDate()));

        TableColumn<Staff, String> jobTitleColumn = new TableColumn<>("Job Title");
        jobTitleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJobTitle()));

        TableColumn<Staff, String> jobTypeColumn = new TableColumn<>("Job Type");
        jobTypeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJobType()));

        TableColumn<Staff, String> workScheduleColumn = new TableColumn<>("Work Schedule");
        workScheduleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWorkSchedule()));

        TableColumn<Staff, Double> salaryColumn = new TableColumn<>("Monthly Salary");
        salaryColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getMonthlySalary()));

        //
        TableColumn<Staff, String> personalInfoColumn = new TableColumn<>("Personal Information");
        personalInfoColumn.getColumns().addAll(fullNameColumn, dateOfBirthColumn, genderColumn, cnicColumn, contactColumn,qualificationColumn);

        TableColumn<Staff, String> professionalInfoColumn = new TableColumn<>("Professional Information");
        professionalInfoColumn.getColumns().addAll( joiningDateColumn, jobTitleColumn, jobTypeColumn, workScheduleColumn, salaryColumn);

        // Add columns to the table
        staffTable.getColumns().addAll(employerIdColumn, personalInfoColumn, professionalInfoColumn);

        staffTable.setItems(staffList);

        rightPane.getChildren().add(staffTable);

        // Adjust layout structure
        leftPane.getChildren().addAll(Utility.createTextLabel("All Staff Info", 30, 140, 530), backBtn, employerIdField, searchBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        // Set up the scene and display the stage
        Scene scene = new Scene(mainLayout, 1200, 800);
        displayAllStaffStage.setScene(scene);
        displayAllStaffStage.show();
    }
}
