package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StaffManagementMenu {
    // Method to display the staff management menu scene
    public void showStaffManagementMenu(Stage adminMenuStage) {
        // Create a new stage for the staff management menu
        Stage staffManagementStage = new Stage();
        staffManagementStage.setFullScreen(true);
        staffManagementStage.setFullScreenExitHint("");

        // Create main layout and content layout
        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();

        // Create buttons
        Button addStaffBtn = Utility.createButton("Add Staff", 300, 50, 200, 240);
        addStaffBtn.setOnAction(event -> {
            System.out.println("Add Staff Button Clicked!");
            staffManagementStage.close();
            AddStaffPage addStaffPage = new AddStaffPage();
            addStaffPage.showAddStaffPage(staffManagementStage);
        });
        Button removeStaffBtn = Utility.createButton("Remove Staff", 300, 50, 200, 310);
        removeStaffBtn.setOnAction(event ->{
            System.out.println("Remove Staff Button Clicked!");
            staffManagementStage.close();
            RemoveStaffPage removeStaffPage = new RemoveStaffPage();
            removeStaffPage.showRemoveStaffPage(staffManagementStage);
        });
        Button displayAllStaffBtn = Utility.createButton("Display All Staff", 300, 50, 200, 380);
        displayAllStaffBtn.setOnAction(event ->{
            System.out.println("Display All Staff Button Clicked!");
            staffManagementStage.close();
            DisplayAllStaffPage displayAllStaffPage = new DisplayAllStaffPage();
            displayAllStaffPage.showDisplayAllStaffPage(staffManagementStage);
        });
        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            staffManagementStage.close();
            adminMenuStage.show();
        });


        // Create left and right panes
        Pane leftPane = Utility.createLeftPane();
        leftPane.getChildren().addAll(Utility.createTextLabel("Manage Staff",30, "bold" ,140, 530), backBtn);
        Pane rightPane = Utility.createRightPane();
        rightPane.getChildren().addAll(addStaffBtn, removeStaffBtn, displayAllStaffBtn);

        // Add panes to content layout
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        // Set up and show the scene
        Scene scene = new Scene(mainLayout, 1200, 800);
        staffManagementStage.setScene(scene);
        staffManagementStage.show();
    }
}