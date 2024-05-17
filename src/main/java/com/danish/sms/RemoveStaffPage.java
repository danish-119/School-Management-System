package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RemoveStaffPage {

    public void showRemoveStaffPage(Stage staffManagementStage) {
        Stage removeStaffStage = new Stage();
        removeStaffStage.setFullScreen(true);
        removeStaffStage.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        TextField staffIdField = new TextField();
        staffIdField.setPromptText("Enter Staff ID");
        staffIdField.setPrefWidth(200);
        staffIdField.setLayoutX(50);
        staffIdField.setLayoutY(200);

        Button searchBtn = Utility.createButton("Search", 100, 50, 270, 200);
        searchBtn.setOnAction(event -> {
            System.out.println("Search Button Clicked!");
            String staffId = staffIdField.getText();
            // Call a method to fetch staff information by ID from the database
            Staff staff = GetDataByIdFromMySQL.getStaffByIdFromDatabase(staffId);
            if (staff != null) {
                // Display staff information for removal
                Label staffInfoLabel = new Label("Staff ID: " + staff.getEmployerId() + "\nFull Name: " + staff.getFullName() + "\nJob Title: " + staff.getJobTitle());
                staffInfoLabel.setLayoutX(50);
                staffInfoLabel.setLayoutY(250);
                rightPane.getChildren().add(staffInfoLabel);
            } else {
                // Show error message if staff not found
                Label errorLabel = new Label("Staff not found!");
                errorLabel.setLayoutX(50);
                errorLabel.setLayoutY(250);
                rightPane.getChildren().add(errorLabel);
            }
        });

        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            staffManagementStage.show();
            removeStaffStage.close();
        });

        Button removeBtn = Utility.createButton("Remove", 120, 50, 360, 730);
        removeBtn.setOnAction(event -> {
            System.out.println("Remove Button Clicked!");
            String staffId = staffIdField.getText();

            boolean removed = RemoveDataFromMySQL.removeStaffFromDatabase(staffId);
            if (removed) {
                System.out.println("Staff removed successfully!");
                // Optionally, you can clear the right pane after successful removal
                rightPane.getChildren().clear();
            } else {
                System.out.println("Failed to remove staff!");
                // Optionally, display an error message if removal fails
            }
            removeStaffStage.close();
            staffManagementStage.show();
        });

        rightPane.getChildren().addAll(staffIdField, searchBtn);
        leftPane.getChildren().addAll(Utility.createTextLabel("Remove Staff", 30, 140, 530), backBtn, removeBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        removeStaffStage.setScene(scene);
        removeStaffStage.show();
    }
}