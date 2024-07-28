package smartcity;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.stage.Screen;
import smartcity.properties.util.Property;

public class SmartCityDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }
	
    // Method to set the stage
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("controllers/main.fxml"));
        
        // Get the screen size
        Screen screenBounds = Screen.getPrimary();
        
        // Calculate the desired width and height (75% of screen size)
        double width = screenBounds.getVisualBounds().getWidth() * 0.75;
        double height = screenBounds.getVisualBounds().getHeight() * 0.75;
        
        // Set the scene
        Parent root = loader.load();
        Scene scene = new Scene(root, width, height);
        stage.setScene(scene);
        stage.setTitle("Smart City Management");
        stage.show();
    }
    
    // Declare a property arraylist
    // public vs private issue
    // https://stackoverflow.com/questions/36231665/is-there-a-way-to-make-an-array-truly-private-in-java
    public static ArrayList<Property> buildingList = new ArrayList<>();
}
