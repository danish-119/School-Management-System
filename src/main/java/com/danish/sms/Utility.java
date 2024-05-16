package com.danish.sms;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Utility {
    // Method to create the left pane
    public static Pane createLeftPane() {
        Pane leftPane = new Pane();
        leftPane.setStyle("-fx-background-color: #e6e6f9; -fx-border-color: #b3b3b3; -fx-border-width: 2px;");
        leftPane.setMinWidth(500);
        leftPane.setMinHeight(800);
        return leftPane;
    }

    // Method to create the right pane
    public static Pane createRightPane() {
        Pane rightPane = new Pane();
        rightPane.setStyle("-fx-background-color: #f9f9f9; -fx-border-color: #b3b3b3; -fx-border-width: 2px;");
        rightPane.setMinWidth(700);
        rightPane.setMinHeight(800);
        return rightPane;
    }


    // Method to create the main layout
    public static VBox createMainLayout() {
        VBox mainLayout = new VBox();
        mainLayout.setAlignment(Pos.CENTER);
        return mainLayout;
    }

    // Method to create the content layout
    public static HBox createContentLayout() {
        HBox contentLayout = new HBox();
        contentLayout.setAlignment(Pos.CENTER);
        return contentLayout;
    }

    // Method to create a text label
    public static Label createTextLabel(String text,int fontSize, int layoutX, int layoutY) {
        Label textLabel = new Label(text);
        textLabel.setStyle("-fx-font-family: 'Roboto'; -fx-font-size:" + fontSize + "px; -fx-text-fill: #555555; -fx-font-weight: bold;");
        textLabel.setLayoutX(layoutX);
        textLabel.setLayoutY(layoutY);
        return textLabel;
    }

    // Method to create a button
    public static Button createButton(String text, int width, int height, int layoutX, int layoutY) {
        Button continueBtn = new Button(text);
        continueBtn.setStyle("-fx-font-family: 'Roboto'; -fx-font-size: 20px; -fx-background-color: #4CAF50; -fx-text-fill: white; -fx-border-radius: 8px; -fx-background-radius: 10px; -fx-border-color: #388E3C;");
        continueBtn.setPrefSize(width, height);
        continueBtn.setLayoutX(layoutX);
        continueBtn.setLayoutY(layoutY);
        return continueBtn;
    }

    // Method to create a text field
    public static TextField createTextField(String promptText, int layoutX, int layoutY) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        textField.setStyle("-fx-font-family: 'Roboto'; -fx-font-size: 20px; -fx-background-color: #f9f9f9; -fx-border-color: #cccccc; -fx-border-radius: 5px; -fx-padding: 8px;");
        textField.setPrefSize(300, 50);
        textField.setLayoutX(layoutX);
        textField.setLayoutY(layoutY);
        return textField;
    }

    // Method to create a password field
    public static PasswordField createPasswordField(String promptText, int layoutX, int layoutY) {
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText(promptText);
        passwordField.setStyle("-fx-font-family: 'Roboto'; -fx-font-size: 20px; -fx-background-color: #f9f9f9; -fx-border-color: #cccccc; -fx-border-radius: 5px; -fx-padding: 8px;");
        passwordField.setPrefSize(300, 50);
        passwordField.setLayoutX(layoutX);
        passwordField.setLayoutY(layoutY);
        return passwordField;
    }

    public static HBox createDateField(String promptText, int layoutX, int layoutY) {
        DatePicker datePicker = new DatePicker();
        datePicker.setPrefSize(230, 45);

        datePicker.setPromptText(promptText);
        datePicker.setStyle("-fx-font-family: 'Roboto'; -fx-font-size: 18px; -fx-background-color: #f9f9f9; -fx-border-color: #cccccc; -fx-border-radius: 5px; -fx-padding: 2px;");

        HBox dobField = new HBox(datePicker);
        dobField.setLayoutX(layoutX);
        dobField.setLayoutY(layoutY);
        return dobField;
    }

    // Static method to create Gender selection field with a list of options
    public static HBox createSelect(List<String> options,int width,int height, int layoutX, int layoutY) {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(options);
        comboBox.setValue(options.getFirst());
        comboBox.setStyle("-fx-font-family: 'Roboto'; -fx-font-size: 18px; -fx-background-color: #f9f9f9; -fx-border-color: #cccccc; -fx-border-radius: 5px; -fx-padding: 2px;");
        comboBox.setPrefSize(width, height);

        HBox selectField = new HBox(comboBox);
        selectField.setLayoutX(layoutX);
        selectField.setLayoutY(layoutY);
        return selectField;
    }


    public static HBox createRadioButtonSelect(List<String> options, int layoutX, int layoutY) {
        ToggleGroup group = new ToggleGroup();
        HBox selectField = new HBox();
        selectField.setStyle("-fx-font-family: 'Roboto'; -fx-font-size: 16px;");

        for (String option : options) {
            RadioButton radioButton = new RadioButton(option);
            radioButton.setToggleGroup(group);
            selectField.getChildren().add(radioButton);
        }

        selectField.setSpacing(5);
        selectField.setLayoutX(layoutX);
        selectField.setLayoutY(layoutY);

        return selectField;
    }

    // Method to generate a random password
    public static String generateRandomPassword() {
        final String DIGITS = "0123456789";

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int randomIndex = random.nextInt(DIGITS.length());
            password.append(DIGITS.charAt(randomIndex));
        }

        return password.toString();
    }

    //  Method to create the user image
    public static ImageView createImage(String imgPath) throws FileNotFoundException {
        FileOutputStream imgFile= new FileOutputStream(imgPath);
        ImageView userImage = new ImageView(new Image(String.valueOf(imgFile)));
        userImage.setFitWidth(350);
        userImage.setFitHeight(350);
        userImage.setLayoutX(75);
        userImage.setLayoutY(180);
        return userImage;
    }
}