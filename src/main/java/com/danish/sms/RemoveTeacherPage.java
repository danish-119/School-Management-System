package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RemoveTeacherPage {

    public void showRemoveTeacherPage(Stage teacherManagementStage) {
        Stage removeTeacherStage = new Stage();
        removeTeacherStage.setFullScreen(true);
        removeTeacherStage.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        TextField teacherIdField = Utility.createTextField("Enter Teacher ID", 50, 50);

        Button searchBtn = Utility.createButton("Search", 100, 50, 370, 50);
        searchBtn.setOnAction(event -> {
            System.out.println("Search Button Clicked!");
            rightPane.getChildren().clear();
            rightPane.getChildren().addAll(teacherIdField, searchBtn);

            String teacherId = teacherIdField.getText();
            // Call a method to fetch teacher information by ID from the database
            Teacher teacher = GetDataByIdFromMySQL.getTeacherById(teacherId);
            if (teacher != null) {
                // Display teacher information for removal
                Label teacherInfoLabel = new Label("Teacher ID: " + teacher.getTeacherId() + "\nFull Name: " + teacher.getTeacherName() + "\nJob Title: " + teacher.getJobTitle());
                teacherInfoLabel.setLayoutX(50);
                teacherInfoLabel.setLayoutY(250);
                rightPane.getChildren().add(teacherInfoLabel);
            } else {
                // Show error message if teacher not found
                Label errorLabel = new Label("Teacher not found!");
                errorLabel.setLayoutX(50);
                errorLabel.setLayoutY(250);
                rightPane.getChildren().add(errorLabel);
            }
        });

        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            teacherManagementStage.show();
            removeTeacherStage.close();
        });

        Button removeBtn = Utility.createButton("Remove", 120, 50, 360, 730);
        removeBtn.setOnAction(event -> {
            System.out.println("Remove Button Clicked!");
            String teacherId = teacherIdField.getText();

            boolean removed = RemoveDataFromMySQL.removeTeacherFromDatabase(teacherId);
            if (removed) {
                System.out.println("Teacher removed successfully!");
                rightPane.getChildren().clear();
            } else {
                System.out.println("Failed to remove teacher!");
            }
            removeTeacherStage.close();
            teacherManagementStage.show();
        });

        rightPane.getChildren().addAll(teacherIdField, searchBtn);
        leftPane.getChildren().addAll(Utility.createTextLabel("Remove Teacher", 30, 140, 530), backBtn, removeBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        removeTeacherStage.setScene(scene);
        removeTeacherStage.show();
    }
}
