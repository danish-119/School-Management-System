package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RemoveStaffPage{

    public void showRemoveStaffPage(Stage staffManagementStage) {
        Stage removeStaffStage = new Stage();
        removeStaffStage.setFullScreen(true);
        removeStaffStage.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            staffManagementStage.show();
            removeStaffStage.close();
        });

        Button removeBtn = Utility.createButton("Remove", 120, 50, 360, 730);
        removeBtn.setOnAction(event -> {
            System.out.println("Remove Button Clicked!");
            removeStaffStage.close();
            staffManagementStage.show();
        });

        rightPane.getChildren().addAll();
        leftPane.getChildren().addAll(Utility.createTextLabel("Remove Staff", 30, 140, 530), backBtn,removeBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        removeStaffStage.setScene(scene);
        removeStaffStage.show();
    }
}
