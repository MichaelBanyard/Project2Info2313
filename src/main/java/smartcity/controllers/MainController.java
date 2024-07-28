package smartcity.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {

    @FXML
    private AnchorPane content;

    @FXML
    private void showProperties() throws IOException {
        loadContent("propertiesMapView");
    }

    @FXML
    private void showDevices() throws IOException {
        loadContent("property");
    }

    public void initialize() {
        try {
            showProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadContent(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml + ".fxml"));
        Parent loadedContent = loader.load();
        content.getChildren().setAll(loadedContent);
    }
}
