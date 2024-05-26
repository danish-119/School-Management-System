package com.danish.sms;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class DisplayAllStudentsPage {
    public void showDisplayAllStudentsPage(Stage studentManagementStage) {
        Stage displayAllStudentsStage = new Stage();
        displayAllStudentsStage.setFullScreen(true);
        displayAllStudentsStage.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        ObservableList<Student> filteredList = FXCollections.observableArrayList();
        // Load data from the database
        ObservableList<Student> studentList = LoadDataFromMySQL.loadStudentData();
        // Create a TableView and define columns
        TableView<Student> studentTable = new TableView<>();
        studentTable.setStyle("-fx-background-color: #f0f0f0; -fx-font-size: 14px; -fx-border-color: #CCCCCC; -fx-border-width: 1px; -fx-border-radius: 5px;");
        studentTable.setPrefHeight(800);
        studentTable.setPrefWidth(800);


        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            studentManagementStage.show();
            displayAllStudentsStage.close();
        });

        TextField studentIdField = Utility.createTextField("Enter Student ID", 210, 730);
        studentIdField.setPrefWidth(155);
        studentIdField.setStyle("-fx-font-size: 14px;");

        Button searchBtn = Utility.createButton("Search", 100, 50, 380, 730);
        searchBtn.setOnAction(event -> {
            System.out.println("Search Button Clicked!");
            String studentId = studentIdField.getText();
            if (studentId.isEmpty()) {
                studentTable.setItems(studentList);
            } else {
                filteredList.clear();
                List<Student> filteredStudents = studentList.stream()
                        .filter(student -> Integer.toString(student.getStudentId()).equals(studentId))
                        .collect(Collectors.toList());
                filteredList.addAll(filteredStudents);
                studentTable.setItems(filteredList);
            }
        });



        TableColumn<Student, String> studentIdColumn = new TableColumn<>("Student ID");
        studentIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getStudentId())));

        TableColumn<Student, String> studentNameColumn = new TableColumn<>("Student Name");
        studentNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStudentName()));

        TableColumn<Student, String> dateOfBirthColumn = new TableColumn<>("Date of Birth");
        dateOfBirthColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDob()));

        TableColumn<Student, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGender()));

        TableColumn<Student, String> cnicColumn = new TableColumn<>("CNIC/B-Form");
        cnicColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCnicOrBForm()));

        TableColumn<Student, String> bloodGroupColumn = new TableColumn<>("Blood Group");
        bloodGroupColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBloodGroup()));

        TableColumn<Student, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));

        TableColumn<Student, String> extracurricularColumn = new TableColumn<>("Extracurricular Interest");
        extracurricularColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getExtracurricularInterest()));

        TableColumn<Student, String> guardianNameColumn = new TableColumn<>("Guardian Name");
        guardianNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGuardianName()));

        TableColumn<Student, String> guardianRelationColumn = new TableColumn<>("Guardian Relation");
        guardianRelationColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGuardianRelation()));

        TableColumn<Student, String> guardianCnicColumn = new TableColumn<>("Guardian CNIC");
        guardianCnicColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGuardianCnic()));

        TableColumn<Student, String> guardianOccupationColumn = new TableColumn<>("Guardian Occupation");
        guardianOccupationColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGuardianOccupation()));

        TableColumn<Student, String> guardianContactColumn = new TableColumn<>("Guardian Contact");
        guardianContactColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGuardianContact()));

        TableColumn<Student, String> jobTypeColumn = new TableColumn<>("Job Type");
        jobTypeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJobType()));

        TableColumn<Student, String> admissionNumberColumn = new TableColumn<>("Admission Number");
        admissionNumberColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdmissionNumber()));

        TableColumn<Student, String> classGradeColumn = new TableColumn<>("Class Grade");
        classGradeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClassGrade()));

        TableColumn<Student, String> sectionColumn = new TableColumn<>("Section");
        sectionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSection()));

        TableColumn<Student, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsername()));

        TableColumn<Student, String> passwordColumn = new TableColumn<>("Password");
        passwordColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPassword()));

        TableColumn<Student, String> admissionDateColumn = new TableColumn<>("Admission Date");
        admissionDateColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAdmissionDate()));

        TableColumn<Student, Double> monthlyFeeColumn = new TableColumn<>("Monthly Fee");
        monthlyFeeColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getMonthlyFee()));

        TableColumn<Student, String> scholarshipStatusColumn = new TableColumn<>("Scholarship Status");
        scholarshipStatusColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getScholarshipStatus()));

        TableColumn<Student, String> documentRequiredColumn = new TableColumn<>("Document Required");
        documentRequiredColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDocumentRequired()));

        TableColumn<Student, String> documentStatusColumn = new TableColumn<>("Document Status");
        documentStatusColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDocumentStatus()));


        // Add columns to the table
        TableColumn<Student, String> personalInfoColumn = new TableColumn<>("Personal Information");
        personalInfoColumn.getColumns().addAll(studentNameColumn, dateOfBirthColumn, genderColumn, cnicColumn, bloodGroupColumn, emailColumn, extracurricularColumn);

        TableColumn<Student, String> guardianInfoColumn = new TableColumn<>("Gardian's Information");
        guardianInfoColumn.getColumns().addAll(guardianNameColumn, guardianRelationColumn, guardianCnicColumn, guardianOccupationColumn, guardianContactColumn, jobTypeColumn);

        TableColumn<Student, String> academicInfoColumn = new TableColumn<>("Academic Information");
        academicInfoColumn.getColumns().addAll(admissionNumberColumn, classGradeColumn, sectionColumn, usernameColumn, passwordColumn, admissionDateColumn, monthlyFeeColumn, scholarshipStatusColumn, documentRequiredColumn, documentStatusColumn);

        List<String> infoOnScreen = List.of("All Information", "Personal Information", "Guardian's Information", "Academic Information");
        ComboBox<String> infoOnScreenField = new ComboBox<>();
        infoOnScreenField.getItems().addAll(infoOnScreen);
        infoOnScreenField.setStyle("-fx-font-family: 'Roboto'; -fx-font-size: 14px; -fx-background-color: #f9f9f9; -fx-border-color: #cccccc; -fx-border-radius: 5px; -fx-padding: 2px;");
        infoOnScreenField.setValue("All Information");
        infoOnScreenField.setPrefSize(230,50);

        infoOnScreenField.valueProperty().addListener((observable, oldValue, newValue) -> {
            studentTable.getColumns().clear(); // Clear existing columns
            if (newValue.equals("All Information")) {
                studentTable.getColumns().addAll(studentIdColumn, personalInfoColumn, guardianInfoColumn, academicInfoColumn);
            } else if (newValue.equals("Personal Information")) {
                studentTable.getColumns().addAll(studentIdColumn, personalInfoColumn);
            } else if (newValue.equals("Guardian's Information")) {
                studentTable.getColumns().addAll(studentIdColumn, guardianInfoColumn);
            } else if (newValue.equals("Academic Information")) {
                studentTable.getColumns().addAll(studentIdColumn, academicInfoColumn);
            }
        });

        // Set default columns
        studentTable.getColumns().addAll(studentIdColumn, personalInfoColumn, guardianInfoColumn, academicInfoColumn);



        // Populate the table with data
        studentTable.setItems(studentList);

        studentTable.setItems(studentList);
        // Add the TableView to the rightPane
        rightPane.getChildren().add(studentTable);

        // Adjust layout structure
        leftPane.getChildren().addAll(Utility.createTextLabel("All Students Info", 30, "bold" ,140, 530), backBtn, studentIdField, searchBtn, infoOnScreenField, Utility.displayImage("/media/danish/8E20E81220E7FF59/Programming/Code/Java Code/IntelliJ IDEA/Projects/School Management System/src/main/resources/allPerson.png", 65,220));
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        // Set up the scene and display the stage
        Scene scene = new Scene(mainLayout, 1200, 800);
        displayAllStudentsStage.setScene(scene);
        displayAllStudentsStage.show();
    }
}
