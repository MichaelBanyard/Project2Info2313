package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.properties.util.Building;

public class SmartCityDemo extends Application {

    public Building[][] buildings = new Building[10][10];

    @Override
    public void start(Stage stage) {

        Building building = new Building("123 Test Street", 3 , 3, 2000, 1000000.0);

        System.out.println(building);

        StackPane root = new StackPane();
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}