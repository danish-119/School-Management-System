package com.danish.sms;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayAllTeachersPage {

    public void showDisplayAllTeachersPage(Stage teacherManagementStage) {
        Stage displayAllTeachersStage = new Stage();
        displayAllTeachersStage.setFullScreen(true);
        displayAllTeachersStage.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();


        ObservableList<Teacher> filteredList = FXCollections.observableArrayList();
        // Load data from the database
        ObservableList<Teacher> teacherList = LoadDataFromMySQL.loadTeacherData();
        // Create a TableView and define columns
        TableView<Teacher> teacherTable = new TableView<>();
        teacherTable.setPrefHeight(800);
        teacherTable.setPrefWidth(1200);


        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            teacherManagementStage.show();
            displayAllTeachersStage.close();
        });

        TextField teacherIdField = Utility.createTextField("Enter Teacher ID", 210, 730);
        teacherIdField.setPrefWidth(155);
        teacherIdField.setStyle("-fx-font-size: 14px;");

        Button searchBtn = Utility.createButton("Search", 100, 50, 380, 730);
        searchBtn.setOnAction(event -> {
            System.out.println("Search Button Clicked!");
            String teacherId = teacherIdField.getText();
            if (teacherId.isEmpty()) {
                teacherTable.setItems(teacherList);
            } else {
                filteredList.clear();
                List<Teacher> filteredTeachers = teacherList.stream()
                        .filter(teacher -> Integer.toString(teacher.getTeacherId()).equals(teacherId))
                        .collect(Collectors.toList());
                filteredList.addAll(filteredTeachers);
                teacherTable.setItems(filteredList);
            }
        });

        TableColumn<Teacher, String> teacherIdColumn = new TableColumn<>("Teacher ID");
        teacherIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getTeacherId())));

        TableColumn<Teacher, String> teacherNameColumn = new TableColumn<>("Teacher Name");
        teacherNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTeacherName()));

        TableColumn<Teacher, String> dateOfBirthColumn = new TableColumn<>("Date of Birth");
        dateOfBirthColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDob()));

        TableColumn<Teacher, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGender()));

        TableColumn<Teacher, String> cnicColumn = new TableColumn<>("CNIC");
        cnicColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCnic()));

        // Define more columns as needed for other teacher attributes...
        TableColumn<Teacher, String> bloodGroupColumn = new TableColumn<>("Blood Group");
        bloodGroupColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBloodGroup()));

        TableColumn<Teacher, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));

        TableColumn<Teacher, String> experienceColumn = new TableColumn<>("Experience");
        experienceColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getExperience()));

        TableColumn<Teacher, String> experienceYearsColumn = new TableColumn<>("Experience Years");
        experienceYearsColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty().asObject().asString());

        TableColumn<Teacher, String> universityColumn = new TableColumn<>("University Graduated From");
        universityColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUniversityGraduatedFrom()));

        TableColumn<Teacher, String> qualificationColumn = new TableColumn<>("Qualification");
        qualificationColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getQualification()));

        TableColumn<Teacher, String> majorSubjectColumn = new TableColumn<>("Major Subject");
        majorSubjectColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMajorSubject()));

        TableColumn<Teacher, String> jobTitleColumn = new TableColumn<>("Job Title");
        jobTitleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJobTitle()));

        TableColumn<Teacher, String> jobTypeColumn = new TableColumn<>("Job Type");
        jobTypeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJobType()));

        TableColumn<Teacher, String> departmentColumn = new TableColumn<>("Department");
        departmentColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDepartment()));

        TableColumn<Teacher, String> joiningDateColumn = new TableColumn<>("Joining Date");
        joiningDateColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getJoiningDate()));

        TableColumn<Teacher, Double> monthlySalaryColumn = new TableColumn<>("Monthly Salary");
        monthlySalaryColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getMonthlySalary()).asObject());

        TableColumn<Teacher, String> bankColumn = new TableColumn<>("Bank for Direct Deposit");
        bankColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBankForDirectDeposit()));

        TableColumn<Teacher, String> documentRequiredColumn = new TableColumn<>("Document Required");
        documentRequiredColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDocumentRequired()));

        TableColumn<Teacher, String> documentStatusColumn = new TableColumn<>("Document Status");
        documentStatusColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDocumentStatus()));

        TableColumn<Teacher, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsername()));

        TableColumn<Teacher, String> passwordColumn = new TableColumn<>("Password");
        passwordColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPassword()));

        // Add columns to the table
        TableColumn<Teacher, String> personalInfoColumn = new TableColumn<>("Personal Information");
        personalInfoColumn.getColumns().addAll(teacherNameColumn, dateOfBirthColumn, genderColumn, cnicColumn, bloodGroupColumn, emailColumn);

        TableColumn<Teacher, String> professionalInfoColumn = new TableColumn<>("Professional Information");
        professionalInfoColumn.getColumns().addAll( experienceColumn, experienceYearsColumn, universityColumn, qualificationColumn, majorSubjectColumn);

        TableColumn<Teacher, String> employmentInfoColumn = new TableColumn<>("Employment Information");
        employmentInfoColumn.getColumns().addAll(joiningDateColumn, jobTitleColumn, jobTypeColumn, departmentColumn, usernameColumn, passwordColumn);

        TableColumn<Teacher, String> otherInfoColumn = new TableColumn<>("Other Information");
        otherInfoColumn.getColumns().addAll( monthlySalaryColumn, bankColumn, documentRequiredColumn, documentStatusColumn);

        
        List<String> infoOnScreen = List.of("All Information", "Personal Information", "Employment Information", "Professional Information", "Other Information");
        ComboBox<String> infoOnScreenField = new ComboBox<>();
        infoOnScreenField.getItems().addAll(infoOnScreen);
        infoOnScreenField.setStyle("-fx-font-family: 'Roboto'; -fx-font-size: 14px; -fx-background-color: #f9f9f9; -fx-border-color: #cccccc; -fx-border-radius: 5px; -fx-padding: 2px;");
        infoOnScreenField.setValue("All Information");
        infoOnScreenField.setPrefSize(230,50);

        infoOnScreenField.valueProperty().addListener((observable, oldValue, newValue) -> {
            teacherTable.getColumns().clear(); // Clear existing columns
            if (newValue.equals("All Information")) {
                teacherTable.getColumns().addAll(teacherIdColumn, personalInfoColumn, professionalInfoColumn, employmentInfoColumn, otherInfoColumn);
            } else if (newValue.equals("Personal Information")) {
                teacherTable.getColumns().addAll(teacherIdColumn, personalInfoColumn);
            } else if (newValue.equals("Employment Information")) {
                teacherTable.getColumns().addAll(teacherIdColumn, employmentInfoColumn);
            } else if (newValue.equals("Professional Information")) {
                teacherTable.getColumns().addAll(teacherIdColumn, professionalInfoColumn);
            } else if (newValue.equals("Other Information")) {
                teacherTable.getColumns().addAll(teacherIdColumn, otherInfoColumn);
            }
        });

        // Add columns to the table
        teacherTable.getColumns().addAll(teacherIdColumn, personalInfoColumn,professionalInfoColumn, employmentInfoColumn, otherInfoColumn);

        // Populate the table with data
        teacherTable.setItems(teacherList);

        // Add the TableView to the rightPane
        rightPane.getChildren().add(teacherTable);

        // Adjust layout structure
        leftPane.getChildren().addAll(Utility.createTextLabel("All Teachers Info", 30, "bold" ,115, 530), backBtn, teacherIdField,searchBtn,infoOnScreenField,Utility.displayImage("/media/danish/8E20E81220E7FF59/Programming/Code/Java Code/IntelliJ IDEA/Projects/School Management System/src/main/resources/people.png", 110,220));
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        // Set up the scene and display the stage
        Scene scene = new Scene(mainLayout, 1200, 800);
        displayAllTeachersStage.setScene(scene);
        displayAllTeachersStage.show();
    }
}
