module com.danish.sms.schoolmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.danish.sms to javafx.fxml;
    exports com.danish.sms;
}