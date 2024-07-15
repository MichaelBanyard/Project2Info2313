package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CityApplication extends Application {
    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setWidth(500);
        stage.setHeight(500);
        Button b = new Button("Button of DOOM!");
        b.setOnMouseClicked((action -> {
            if(action.getButton() == MouseButton.PRIMARY) {
                System.out.println("Hello!");
            }
        }));
        root.setOnMouseMoved(event -> {
            b.setTranslateX(event.getX() - root.getWidth() / 2);
            b.setTranslateY(event.getY() - root.getHeight() / 2);
        });
        stage.setScene(scene);
        root.getChildren().addAll(b);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}