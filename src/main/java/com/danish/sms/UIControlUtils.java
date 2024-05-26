package com.danish.sms;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import java.util.Optional;

public class UIControlUtils {

    // Method to extract value from DatePicker
    public static String extractValueFromDatePicker(HBox datePickerContainer) {
        DatePicker datePicker = (DatePicker) datePickerContainer.getChildren().getFirst();
        return datePicker.getValue().toString();
    }

    // Method to change HBox to ComboBox
    public static ComboBox HBoxToComboBox(HBox comboBoxContainer) {
        return (ComboBox<String>) comboBoxContainer.getChildren().getFirst();
    }

    // Method to extract text of the selected radio button
    public static String extractSelectedRadioButtonText(HBox radioButtonContainer) {
        Optional<Node> selectedNode = radioButtonContainer.getChildren().stream()
                .filter(node -> ((RadioButton) node).isSelected())
                .findFirst();
        if (selectedNode.isPresent()) {
            return ((RadioButton) selectedNode.get()).getText();
        } else {
            throw new RuntimeException("No radio button selected");
        }
    }
}
