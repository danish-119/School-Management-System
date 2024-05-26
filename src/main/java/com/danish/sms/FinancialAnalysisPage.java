package com.danish.sms;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinancialAnalysisPage {

    // Method to display the admin menu scene
    public void showFinancialAnalysisPage(Stage adminMenuStage) {
        // Create a new stage for the admin menu
        Stage financialAnalysisStage = new Stage();
        financialAnalysisStage.setFullScreen(true);
        financialAnalysisStage.setFullScreenExitHint("");

        // Create main layout and content layout
        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();

        // Load data from MySQL
        ObservableList<Student> students = LoadDataFromMySQL.loadStudentData();
        ObservableList<Teacher> teachers = LoadDataFromMySQL.loadTeacherData();
        ObservableList<Staff> staff = LoadDataFromMySQL.loadStaffData();

        // Calculate total fee revenue from students
        double totalFeeRevenue = 0;
        for (int i = 0; i < students.size(); i++) {
            totalFeeRevenue += students.get(i).getMonthlyFee();
        }

        // Calculate total expenses for teachers
        double totalTeacherExpense = 0;
        for (int i = 0; i < teachers.size(); i++) {
            totalTeacherExpense += teachers.get(i).getMonthlySalary();
        }

        // Calculate total expenses for staff
        double totalStaffExpense = 0;
        for (int i = 0; i < staff.size(); i++) {
            totalStaffExpense += staff.get(i).getMonthlySalary();
        }

        // Create labels to display the financial information
        Label studentInfoLabel = Utility.createTextLabel("Students Information", 30, "bold", 80, 50);
        Label totalStudentsLabel = Utility.createTextLabel("Total Students: " + students.size(), 22,"normal" ,80, 100);
        Label totalFeeRevenueLabel = Utility.createTextLabel("Fee Revenue: " + totalFeeRevenue + " PKR", 22,"normal" , 80, 150);
        Label teacherInfoLabel = Utility.createTextLabel("Teachers Information", 30, "bold", 80, 200);
        Label totalTeachersLabel = Utility.createTextLabel("Total Teachers: " + teachers.size(), 22, "normal" ,80, 250);
        Label totalTeacherExpenseLabel = Utility.createTextLabel("Teacher Expenses: " + totalTeacherExpense + " PKR", 22, "normal" ,80, 300);
        Label staffInfoLabel = Utility.createTextLabel("Staff Information", 30, "bold", 80, 350);
        Label totalStaffLabel = Utility.createTextLabel("Total Staff: " + staff.size(), 22, "normal" ,80, 400);
        Label totalStaffExpenseLabel = Utility.createTextLabel("Staff Expenses: " + totalStaffExpense + " PKR", 22, "normal" ,80, 450);
        Label OverallAnalysisLabel = Utility.createTextLabel("Overall Analysis", 30, "bold", 80, 500);
        Label totalExpenseLabel = Utility.createTextLabel("Total Expenses: " + (totalStaffExpense + totalTeacherExpense)  + " PKR", 22, "normal" ,80, 550);
        Label totalRevenueLabel = Utility.createTextLabel("Total Revenue: " + totalFeeRevenue + " PKR", 22, "normal" ,80, 600);
        Label differenceLabel = Utility.createTextLabel("", 22, "normal" ,80, 650);
        Label finalStatement = Utility.createTextLabel("", 18, "normal", 300,700);
        if((totalStaffExpense + totalTeacherExpense) < totalFeeRevenue) {
            differenceLabel.setText("Profit: " + (totalFeeRevenue - totalStaffExpense + totalTeacherExpense ) + " PKR");
            finalStatement.setText("You're in Profit");
            finalStatement.setStyle("-fx-text-fill: #29e429; -fx-font-size: 20;");
        }
        else{
            differenceLabel.setText("Loss: " + (totalStaffExpense + totalTeacherExpense  - totalFeeRevenue) + " PKR");
            finalStatement.setText("You're in Loss");
            finalStatement.setStyle("-fx-text-fill: #f42727; -fx-font-size: 20;");
        }




        // Create buttons
        Button backBtn = Utility.createButton("Back", 150, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            financialAnalysisStage.close();
            adminMenuStage.show();
        });

        // Create left and right panes
        Pane leftPane = Utility.createLeftPane();
        leftPane.getChildren().addAll(Utility.createTextLabel("Financial Analysis!", 30, "bold" ,110, 530), backBtn);

        Pane rightPane = Utility.createRightPane();
        rightPane.getChildren().addAll(studentInfoLabel,totalStudentsLabel,totalFeeRevenueLabel, teacherInfoLabel,totalTeachersLabel,totalTeacherExpenseLabel, staffInfoLabel, totalStaffLabel,totalStaffExpenseLabel, OverallAnalysisLabel,totalExpenseLabel,totalRevenueLabel,differenceLabel, finalStatement);

        // Add panes to content layout
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        // Set up and show the scene
        Scene scene = new Scene(mainLayout, 1200, 800);
        financialAnalysisStage.setScene(scene);
        financialAnalysisStage.show();
    }
}
