package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TeacherManagementMenu {
    // Method to display the teacher management menu scene
    public void showTeacherManagementMenu(Stage adminMenuStage) {
        // Create a new stage for the teacher management menu
        Stage teacherManagementStage = new Stage();
        teacherManagementStage.setFullScreen(true);
        teacherManagementStage.setFullScreenExitHint("");

        // Create main layout and content layout
        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();

        // Create buttons
        Button addTeacherBtn  = Utility.createMenuButton("Add Teacher","/addBtn.png",240);
        addTeacherBtn.setOnAction(event -> {
            System.out.println("Add Teacher Button Clicked!");
            teacherManagementStage.close();
            AddTeacherPage1 addTeacherPage1 = new AddTeacherPage1();
            addTeacherPage1.showAddTeacherPage(teacherManagementStage);
        });
        Button updateTeacherBtn  = Utility.createMenuButton("Update Teacher","/updateBtn.png",310);
        updateTeacherBtn.setOnAction(event ->{
            System.out.println("Update Teacher Button Clicked!");
            teacherManagementStage.close();
          UpdateTeacherPage1 updateTeacherPage1 = new UpdateTeacherPage1();
          updateTeacherPage1.showUpdateTeacherPage1(teacherManagementStage);
        });
        Button removeTeacherBtn  = Utility.createMenuButton("Remove Teacher","/removeBtn.png",380);
        removeTeacherBtn.setOnAction(event ->{
            System.out.println("Remove Teacher Button Clicked!");
            teacherManagementStage.close();
            RemoveTeacherPage removeTeacherPage1 = new RemoveTeacherPage();
            removeTeacherPage1.showRemoveTeacherPage(teacherManagementStage);
        });
        Button displayAllTeacherBtn  = Utility.createMenuButton("Display All Teachers","/allPeople.png",450);
        displayAllTeacherBtn.setOnAction(event ->{
            System.out.println("Display All Teachers Button Clicked!");
            teacherManagementStage.close();
            DisplayAllTeachersPage displayAllTeacherPage = new DisplayAllTeachersPage();
            displayAllTeacherPage.showDisplayAllTeachersPage(teacherManagementStage);
        });
        Button backBtn = Utility.createBackButton();
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            teacherManagementStage.close();
            adminMenuStage.show();
        });


        // Create left and right panes
        Pane leftPane = Utility.createLeftPane();
        leftPane.getChildren().addAll(Utility.createTextLabel("Manage Teachers",30, "bold" ,120, 530), backBtn,Utility.displayImage("/media/danish/8E20E81220E7FF59/Programming/Code/Java Code/IntelliJ IDEA/Projects/School Management System/src/main/resources/teacher.png", 115,220));
        Pane rightPane = Utility.createRightPane();
        rightPane.getChildren().addAll(addTeacherBtn, updateTeacherBtn, removeTeacherBtn, displayAllTeacherBtn);

        // Add panes to content layout
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        // Set up and show the scene
        Scene scene = new Scene(mainLayout, 1200, 800);
        teacherManagementStage.setScene(scene);
        teacherManagementStage.show();
    }
}