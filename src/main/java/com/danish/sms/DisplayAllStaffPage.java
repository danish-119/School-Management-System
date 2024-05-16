package com.danish.sms;


import com.mysql.cj.xdevapi.JsonArray;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.security.Timestamp;
import java.util.Date;

public class DisplayAllStaffPage {

    public void showDisplayAllStaffPage(Stage staffManagementStage) {
        Stage displayAllStaffStage = new Stage();
        displayAllStaffStage.setFullScreen(true);
        displayAllStaffStage.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            staffManagementStage.show();
            displayAllStaffStage.close();
        });

        // Load data from the database
        ObservableList<Staff> staffList = LoadDataFromMySQL.loadStaffData();

        // Create a TableView and define columns
        TableView<Staff> staffTable = new TableView<>();
        staffTable.setPrefHeight(800);
        staffTable.setPrefWidth(800);
//        staffTable.setStyle("-fx-control-inner-background: #e6e6f9;");


        TableColumn<Staff, String> employerIdColumn = new TableColumn<>("Employer ID");
        employerIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmployerId()));


        TableColumn<Staff, String> fullNameColumn = new TableColumn<>("Full Name");
        fullNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFullName()));

        TableColumn<Staff, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGender()));

        TableColumn<Staff, String> cnicColumn = new TableColumn<>("CNIC");
        cnicColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCnicNumber()));

        TableColumn<Staff, String> contactColumn = new TableColumn<>("Contact");
        contactColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContact()));

        TableColumn<Staff, String> qualificationColumn = new TableColumn<>("Qualification");
        qualificationColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getQualification()));

        TableColumn<Staff, String> jobTitleColumn = new TableColumn<>("Job Title");
        jobTitleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJobTitle()));

        TableColumn<Staff, String> jobTypeColumn = new TableColumn<>("Job Type");
        jobTypeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJobType()));

        TableColumn<Staff, String> workScheduleColumn = new TableColumn<>("Work Schedule");
        workScheduleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWorkSchedule()));

        TableColumn<Staff, Double> salaryColumn = new TableColumn<>("Monthly Salary");
        salaryColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getMonthlySalary()));

        // Add columns to the table
        staffTable.getColumns().addAll(employerIdColumn, fullNameColumn, genderColumn, cnicColumn, contactColumn, qualificationColumn, jobTitleColumn, jobTypeColumn, workScheduleColumn,salaryColumn);

        // Populate the table with data
        staffTable.setItems(staffList);

        // Add table to the layout
        rightPane.getChildren().add(staffTable);

        // Adjust layout structure
        leftPane.getChildren().addAll(Utility.createTextLabel("All Staff Info", 30, 140, 530), backBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        // Set up the scene and display the stage
        Scene scene = new Scene(mainLayout, 1200, 800);
        displayAllStaffStage.setScene(scene);
        displayAllStaffStage.show();
    }
}
