package com.danish.sms;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class LandingPage extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = createLandingPageScene(stage);
        stage.setScene(scene);
        stage.setTitle("Attendance Tracker");
        stage.show();
    }

    // Method to create the main scene
    public static Scene createLandingPageScene(Stage stage) throws FileNotFoundException {
        VBox mainLayout = new VBox();
        mainLayout.setPrefSize(1200, 800);

        // Create content layout
        HBox contentLayout = new HBox();

        // Create left pane
        Pane leftPane = Utility.createLeftPane();
        leftPane.getChildren().addAll(Utility.createTextLabel("Welcome User!", 30, 140, 530));

        // Create right pane
        Pane rightPane = Utility.createRightPane();

        // Add buttons
        Button manageStudentsBtn = Utility.createButton("", 300, 50, 220, 680);
        Text buttonText = new Text("Tap to Continue!");
        manageStudentsBtn.setGraphic(buttonText);
        manageStudentsBtn.setOnAction(event -> {
            System.out.println("Manage Students Button Clicked...");
            LoginPage loginPage = new LoginPage();
            loginPage.showLoginPage(stage);
            stage.close();
        });

        // Adding animation to make text blink
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.3), e -> buttonText.setVisible(!buttonText.isVisible()))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        rightPane.getChildren().add(manageStudentsBtn);


        // Add panes to content layout
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        return new Scene(mainLayout);
    }
}
