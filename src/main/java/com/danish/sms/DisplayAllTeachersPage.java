package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DisplayAllTeachersPage {

    public void showDisplayAllTeachersPage(Stage teacherManagementStage) {
        Stage displayAllTeachersStage = new Stage();
        displayAllTeachersStage.setFullScreen(true);
        displayAllTeachersStage.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            teacherManagementStage.show();
            displayAllTeachersStage.close();
        });


        rightPane.getChildren().addAll();
        leftPane.getChildren().addAll(Utility.createTextLabel("All Teachers Info", 30, 140, 530), backBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        displayAllTeachersStage.setScene(scene);
        displayAllTeachersStage.show();
    }
}

