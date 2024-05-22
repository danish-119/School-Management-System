package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinancialAnalysisPage{

    // Method to display the admin menu scene
    public void showFinancialAnalysisPage(Stage adminMenuStage) {
        // Create a new stage for the admin menu
        Stage financialAnalysisStage = new Stage();
        financialAnalysisStage.setFullScreen(true);
        financialAnalysisStage.setFullScreenExitHint("");

        // Create main layout and content layout
        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();

        // Create buttons
     
        Button backBtn = Utility.createButton("Back", 150, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            financialAnalysisStage.close();
            adminMenuStage.show();
        });


        // Create left and right panes
        Pane leftPane = Utility.createLeftPane();
        leftPane.getChildren().addAll(Utility.createTextLabel("Financial Analysis!",30, 140, 530), backBtn);
        Pane rightPane = Utility.createRightPane();
        rightPane.getChildren().addAll();

        // Add panes to content layout
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        // Set up and show the scene
        Scene scene = new Scene(mainLayout, 1200, 800);
        financialAnalysisStage.setScene(scene);
        financialAnalysisStage.show();
    }
}