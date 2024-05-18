package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UpdateStudentPage {

    public void showUpdateStudentPage(Stage studentManagementStage) {
        Stage updateStudentStage = new Stage();
        updateStudentStage.setFullScreen(true);
        updateStudentStage.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            studentManagementStage.show();
            updateStudentStage.close();
        });

        Button updateBtn = Utility.createButton("Update", 120, 50, 360, 730);
        updateBtn.setOnAction(event -> {
            System.out.println("Update Button Clicked!");

            updateStudentStage.close();
            studentManagementStage.show();
        });

        rightPane.getChildren().addAll();
        leftPane.getChildren().addAll(Utility.createTextLabel("Update Student Info", 30, 140, 530), backBtn,updateBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        updateStudentStage.setScene(scene);
        updateStudentStage.show();
    }
}