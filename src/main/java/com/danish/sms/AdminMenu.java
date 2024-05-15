package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminMenu {

    // Method to display the admin menu scene
    public void showAdminMenu(Stage loginStage) {
        // Create a new stage for the admin menu
        Stage adminStage = new Stage();
        adminStage.setFullScreen(true);
        adminStage.setFullScreenExitHint("");

        // Create main layout and content layout
        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();

        // Create buttons
        Button manageStudentBtn = Utility.createButton("Manage Students", 270, 50, 200, 240);
        manageStudentBtn.setOnAction(event -> {
            adminStage.close();
            StudentManagementMenu studentManagementMenu = new StudentManagementMenu();
            studentManagementMenu.showStudentManagementMenu(adminStage);
        });
        Button manageTeacherBtn = Utility.createButton("Manage Teachers", 270, 50, 200, 310);
        manageTeacherBtn.setOnAction(event -> {
            System.out.println("Manage Teachers Button Clicked!");
            adminStage.close();
            TeacherManagementMenu teacherManagementMenu = new TeacherManagementMenu();
            teacherManagementMenu.showTeacherManagementMenu(adminStage);
        });
        Button manageStaffBtn = Utility.createButton("Manage Staff", 270, 50, 200, 380);
        manageStaffBtn.setOnAction(event -> {
            System.out.println("Manage Staff Button Clicked!");
            adminStage.close();
            StaffManagementMenu staffManagementMenu = new StaffManagementMenu();
            staffManagementMenu.showStaffManagementMenu(adminStage);
        });
        Button logoutBtn = Utility.createButton("Logout", 150, 50, 20, 730);
        logoutBtn.setOnAction(event -> {
            System.out.println("Logout Button Clicked!");
            adminStage.close();
            loginStage.show();
        });


        // Create left and right panes
        Pane leftPane = Utility.createLeftPane();
        leftPane.getChildren().addAll(Utility.createTextLabel("Welcome Admin!",30, 140, 530), logoutBtn);
        Pane rightPane = Utility.createRightPane();
        rightPane.getChildren().addAll(manageStudentBtn, manageTeacherBtn, manageStaffBtn);

        // Add panes to content layout
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        // Set up and show the scene
        Scene scene = new Scene(mainLayout, 1200, 800);
        adminStage.setScene(scene);
        adminStage.show();
    }
}