module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;


    opens main to javafx.fxml;
    exports main;
    exports main.properties;
    opens main.properties to javafx.fxml;
    exports main.properties.util;
    opens main.properties.util to javafx.fxml;
}