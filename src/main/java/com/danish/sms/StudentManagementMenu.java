package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentManagementMenu {
    // Method to display the student management menu scene
    public void showStudentManagementMenu(Stage adminMenuStage) {
        // Create a new stage for the student management menu
        Stage studentManagementStage = new Stage();
        studentManagementStage.setFullScreen(true);
        studentManagementStage.setFullScreenExitHint("");

        // Create main layout and content layout
        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();

        // Create buttons
        Button addStudentBtn = Utility.createButton("Add Student", 300, 20, 200, 240);
        addStudentBtn.setOnAction(event -> {
            System.out.println("Add Student Button Clicked!");
            studentManagementStage.close();
            AddStudentPage1 addStudentPage1 = new AddStudentPage1();
            addStudentPage1.showAddStudentPage(studentManagementStage);
        });
        Button updateStudentBtn = Utility.createButton("Update Student", 300, 20, 200, 310);
        updateStudentBtn.setOnAction(event ->{
            System.out.println("Update Student Button Clicked!");
            studentManagementStage.close();
            UpdateStudentPage1 updateStudentPage = new UpdateStudentPage1();
            updateStudentPage.showUpdateStudentPage1(studentManagementStage);
        });
        Button removeStudentBtn = Utility.createButton("Remove Student", 300, 50, 200, 380);
        removeStudentBtn.setOnAction(event -> {
            System.out.println("Remove Student Button Clicked!");
            studentManagementStage.close();
            RemoveStudentPage removeStudentPage = new RemoveStudentPage();
            removeStudentPage.showRemoveStudentPage(studentManagementStage);
        });
        Button displayAllStudentBtn = Utility.createButton("Display All Students", 300, 50, 200, 450);
        displayAllStudentBtn.setOnAction(event -> {
            System.out.println("Display All Student Button Clicked!");
            studentManagementStage.close();
           DisplayAllStudentsPage displayAllStudentsPage = new DisplayAllStudentsPage();
           displayAllStudentsPage.showDisplayAllStudentsPage(studentManagementStage);
        });
        Button backBtn = Utility.createBackButton();
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            studentManagementStage.close();
            adminMenuStage.show();
        });


        // Create left and right panes
        Pane leftPane = Utility.createLeftPane();
        leftPane.getChildren().addAll(Utility.createTextLabel("Manage Students",30, "bold" ,115, 530), backBtn,Utility.displayImage("/media/danish/8E20E81220E7FF59/Programming/Code/Java Code/IntelliJ IDEA/Projects/School Management System/src/main/resources/student.png", 125,220));
        Pane rightPane = Utility.createRightPane();
        rightPane.getChildren().addAll(addStudentBtn, updateStudentBtn, removeStudentBtn, displayAllStudentBtn);

        // Add panes to content layout
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        // Set up and show the scene
        Scene scene = new Scene(mainLayout, 1200, 800);
        studentManagementStage.setScene(scene);
        studentManagementStage.show();
    }
}