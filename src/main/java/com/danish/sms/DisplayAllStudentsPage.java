package com.danish.sms;

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

import java.util.Date;

public class DisplayAllStudentsPage {

    public void showDisplayAllStudentsPage(Stage studentManagementStage) {
        Stage displayAllStudentsStage = new Stage();
        displayAllStudentsStage.setFullScreen(true);
        displayAllStudentsStage.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            studentManagementStage.show();
            displayAllStudentsStage.close();
        });

        // Load data from the database
        ObservableList<Student> studentList = LoadDataFromMySQL.loadStudentData();

        // Create a TableView and define columns
        TableView<Student> studentTable = new TableView<>();
        studentTable.setPrefHeight(800);
        studentTable.setPrefWidth(1200);

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
        studentTable.getColumns().addAll(studentIdColumn, studentNameColumn, dateOfBirthColumn, genderColumn, cnicColumn, bloodGroupColumn, emailColumn, extracurricularColumn, guardianNameColumn, guardianRelationColumn, guardianCnicColumn, guardianOccupationColumn, guardianContactColumn, jobTypeColumn, admissionNumberColumn, classGradeColumn, sectionColumn, usernameColumn, passwordColumn, admissionDateColumn, monthlyFeeColumn, scholarshipStatusColumn, documentRequiredColumn, documentStatusColumn);

        // Populate the table with data
        studentTable.setItems(studentList);

        // Add the TableView to the rightPane
        rightPane.getChildren().add(studentTable);

        // Adjust layout structure
        leftPane.getChildren().addAll(Utility.createTextLabel("All Students Info", 30, 140, 530), backBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        // Set up the scene and display the stage
        Scene scene = new Scene(mainLayout, 1200, 800);
        displayAllStudentsStage.setScene(scene);
        displayAllStudentsStage.show();
    }
}
