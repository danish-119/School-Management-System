package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class UpdateTeacherPage2 {

    public void showUpdateTeacherPage2(Stage teacherManagementStage, Stage updateTeacherStage1 ,String teacherId, Teacher updatedTeacher) {
        Stage updateTeacherStage2 = new Stage();
        updateTeacherStage2.setFullScreen(true);
        updateTeacherStage2.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Teacher teacher = GetDataByIdFromMySQL.getTeacherById(teacherId);


        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            updateTeacherStage1.show();
            updateTeacherStage2.close();
        });

        Button updateBtn = Utility.createButton("Update", 120, 50, 360, 730);
        updateBtn.setOnAction(event -> {

            updatedTeacher.setTeacherId(teacher.getTeacherId());
            updatedTeacher.setTeacherDetails2(null,null,null,null,10,null,null,null);
            UpdateDataInMySQL.updateTeacherInfo(updatedTeacher);
            updateTeacherStage2.close();
            teacherManagementStage.show();
        });

        rightPane.getChildren().addAll();
        leftPane.getChildren().addAll(Utility.createTextLabel("Update Teacher Info", 30, 100, 530), backBtn,updateBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        updateTeacherStage2.setScene(scene);
        updateTeacherStage2.show();
    }
}