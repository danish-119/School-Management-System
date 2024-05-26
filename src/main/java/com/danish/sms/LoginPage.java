package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

public class LoginPage {

    // Method to display the login page scene
    public void showLoginPage(Stage landingPageStage) {
        // Create a new stage for the login page
        Stage loginStage = new Stage();
        loginStage.setFullScreen(true);

        // Create main layout and content layout
        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();

        // Create left and right panes
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        // Create username field, password field, and error label
        TextField usernameField = Utility.createTextField("Username", 220, 200);
        PasswordField passwordField = Utility.createPasswordField("Password", 220, 300);
        Label errorLabel = Utility.createTextLabel("", 22, "bold" ,220, 350);
        errorLabel.setStyle("-fx-text-fill: red;");


        // Create login button
        Button loginBtn = Utility.createButton("Login", 300, 50, 220, 400);
        loginBtn.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            System.out.println("Login Button Clicked!");

            if (Objects.equals(username, "admin") && Objects.equals(password, "admin123")) {
                errorLabel.setText("");
                System.out.println("Login Successful");
                AdminMenu adminMenu = new AdminMenu();
                adminMenu.showAdminMenu(landingPageStage);
                loginStage.close();
            } else {
                errorLabel.setText("Incorrect username or password");
            }
        });

        // Create back button
        Button backBtn = Utility.createBackButton();
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            loginStage.close();
            landingPageStage.show();
        });

        // Add nodes to panes and layout
        rightPane.getChildren().addAll(usernameField, passwordField, errorLabel, loginBtn);


        leftPane.getChildren().addAll(Utility.createTextLabel("Welcome User!",30, "bold" ,140, 530), backBtn, Utility.displayImage("/media/danish/8E20E81220E7FF59/Programming/Code/Java Code/IntelliJ IDEA/Projects/School Management System/src/main/resources/user.png", 120,220));
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        // Set up and show the scene
        Scene scene = new Scene(mainLayout, 1200, 800);
        loginStage.setScene(scene);
        loginStage.show();
    }
}