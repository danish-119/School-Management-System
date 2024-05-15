package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DisplayAllStaffPage {

    public void showDisplayAllStaffPage(Stage staffManagementStage) {
        Stage displayAllStaffStage = new Stage();
        displayAllStaffStage.setFullScreen(true);
        displayAllStaffStage.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            staffManagementStage.show();
            displayAllStaffStage.close();
        });


        rightPane.getChildren().addAll();
        leftPane.getChildren().addAll(Utility.createTextLabel("All Staff Info", 30, 140, 530), backBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        displayAllStaffStage.setScene(scene);
        displayAllStaffStage.show();
    }
}

