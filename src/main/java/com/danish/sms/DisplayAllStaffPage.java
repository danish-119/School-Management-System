package com.danish.sms;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

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

        TableView<Staff> staffTable = new TableView<>();
        TableColumn<Staff, String> fullNameColumn = new TableColumn<>("Full Name");
        TableColumn<Staff, Date> dobColumn = new TableColumn<>("Date of Birth");
        // Define more columns as needed...

        staffTable.getColumns().addAll(fullNameColumn, dobColumn);

        final String JDBC_URL = "jdbc:mysql://localhost:3306/academicDBHandler";
        final String USERNAME = "root";
       final String PASSWORD = "admin";

        // Retrieve data from the database and populate the table
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT fullName, dateOfBirth FROM Staff";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                ObservableList<Staff> staffList = FXCollections.observableArrayList();
                while (resultSet.next()) {
                    Staff staff = new Staff();
                    staff.setFullName(resultSet.getString("fullName"));
                    staff.setDateOfBirth(String.valueOf(resultSet.getDate("dateOfBirth")));
                    // Set other staff attributes similarly...
                    staffList.add(staff);
                }
                staffTable.setItems(staffList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        rightPane.getChildren().addAll(staffTable);
        leftPane.getChildren().addAll(Utility.createTextLabel("All Staff Info", 30, 140, 530), backBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        displayAllStaffStage.setScene(scene);
        displayAllStaffStage.show();
    }
}
