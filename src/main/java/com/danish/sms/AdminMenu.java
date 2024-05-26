package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminMenu {

    // Method to display the admin menu scene
    public void showAdminMenu(Stage landingPageStage) {
        // Create a new stage for the admin menu
        Stage adminMenuStage = new Stage();
        adminMenuStage.setFullScreen(true);
        adminMenuStage.setFullScreenExitHint("");

        // Create main layout and content layout
        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();

        // Create buttons
        Button manageStudentBtn = Utility.createButton("Manage Students", 270, 50, 200, 240);
        manageStudentBtn.setOnAction(event -> {
            adminMenuStage.close();
            StudentManagementMenu studentManagementMenu = new StudentManagementMenu();
            studentManagementMenu.showStudentManagementMenu(adminMenuStage);
        });
        Button manageTeacherBtn = Utility.createButton("Manage Teachers", 270, 50, 200, 310);
        manageTeacherBtn.setOnAction(event -> {
            System.out.println("Manage Teachers Button Clicked!");
            adminMenuStage.close();
            TeacherManagementMenu teacherManagementMenu = new TeacherManagementMenu();
            teacherManagementMenu.showTeacherManagementMenu(adminMenuStage);
        });
        Button manageStaffBtn = Utility.createButton("Manage Staff", 270, 50, 200, 380);
        manageStaffBtn.setOnAction(event -> {
            System.out.println("Manage Staff Button Clicked!");
            adminMenuStage.close();
            StaffManagementMenu staffManagementMenu = new StaffManagementMenu();
            staffManagementMenu.showStaffManagementMenu(adminMenuStage);
        });
        Button financialAnalysisBtn = Utility.createButton("Financial Analysis", 270, 50, 200, 450);
        financialAnalysisBtn.setOnAction(event -> {
            System.out.println("Financial Analysis Button Clicked!");
            adminMenuStage.close();
            FinancialAnalysisPage financialAnalysisPage = new FinancialAnalysisPage();
            financialAnalysisPage.showFinancialAnalysisPage(adminMenuStage);
        });
        Button logoutBtn = Utility.createButton("Logout", 150, 50, 20, 730);
        logoutBtn.setOnAction(event -> {
            System.out.println("Logout Button Clicked!");
            adminMenuStage.close();
            landingPageStage.show();
        });


        // Create left and right panes
        Pane leftPane = Utility.createLeftPane();
        leftPane.getChildren().addAll(Utility.createTextLabel("Welcome Admin!",30, "bold" ,120, 530), logoutBtn ,Utility.displayImage("/media/danish/8E20E81220E7FF59/Programming/Code/Java Code/IntelliJ IDEA/Projects/School Management System/src/main/resources/admin3.png", 120,220));
        Pane rightPane = Utility.createRightPane();
        rightPane.getChildren().addAll(manageStudentBtn, manageTeacherBtn, manageStaffBtn,financialAnalysisBtn);

        // Add panes to content layout
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        // Set up and show the scene
        Scene scene = new Scene(mainLayout, 1200, 800);
        adminMenuStage.setScene(scene);
        adminMenuStage.show();
    }
}