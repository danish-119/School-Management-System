package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RemoveStudentPage {

    public void showRemoveStudentPage(Stage studentManagementStage) {
        Stage removeStudentStage = new Stage();
        removeStudentStage.setFullScreen(true);
        removeStudentStage.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        TextField studentIdField = new TextField();
        studentIdField.setPromptText("Enter Student ID");
        studentIdField.setPrefWidth(200);
        studentIdField.setLayoutX(50);
        studentIdField.setLayoutY(200);

        Button searchBtn = Utility.createButton("Search", 100, 50, 270, 200);
        searchBtn.setOnAction(event -> {
            System.out.println("Search Button Clicked!");
            String studentId = studentIdField.getText();
            // Call a method to fetch student information by ID from the database
            Student student = GetDataByIdFromMySQL.getStudentById(studentId);
            if (student != null) {
                // Display student information for removal
                Label studentInfoLabel = new Label("Student ID: " + student.getStudentId() + "\nFull Name: " + student.getStudentName() + "\nClass: " + student.getClassGrade());
                studentInfoLabel.setLayoutX(50);
                studentInfoLabel.setLayoutY(250);
                rightPane.getChildren().add(studentInfoLabel);
            } else {
                // Show error message if student not found
                Label errorLabel = new Label("Student not found!");
                errorLabel.setLayoutX(50);
                errorLabel.setLayoutY(250);
                rightPane.getChildren().add(errorLabel);
            }
        });

        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            studentManagementStage.show();
            removeStudentStage.close();
        });

        Button removeBtn = Utility.createButton("Remove", 120, 50, 360, 730);
        removeBtn.setOnAction(event -> {
            System.out.println("Remove Button Clicked!");
            String studentId = studentIdField.getText();

            boolean removed = RemoveDataFromMySQL.removeStudentFromDatabase(studentId);
            if (removed) {
                System.out.println("Student removed successfully!");
                rightPane.getChildren().clear();
            } else {
                System.out.println("Failed to remove student!");
            }
            removeStudentStage.close();
            studentManagementStage.show();
        });

        rightPane.getChildren().addAll(studentIdField, searchBtn);
        leftPane.getChildren().addAll(Utility.createTextLabel("Remove Student", 30, 140, 530), backBtn, removeBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        removeStudentStage.setScene(scene);
        removeStudentStage.show();
    }
}
