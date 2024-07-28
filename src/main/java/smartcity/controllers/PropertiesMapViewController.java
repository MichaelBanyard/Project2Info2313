package smartcity.controllers;

import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import smartcity.SmartCityDemo;
import smartcity.properties.util.Property;
import smartcity.util.CustomMapLayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PropertiesMapViewController {

    @FXML
    private AnchorPane map;
    private boolean dragging = false;

    @FXML
    private void initialize() {
        Screen screenBounds = Screen.getPrimary();

        map.setPrefHeight(screenBounds.getVisualBounds().getHeight());
        map.setPrefWidth(screenBounds.getVisualBounds().getWidth() * 0.75);

        MapView mapView = new MapView();
        MapPoint vancouver = new MapPoint(49.1577, -122.9533);

        mapView.setCenter(vancouver);
        mapView.setZoom(12);
        mapView.prefHeightProperty().bind(map.heightProperty());
        mapView.prefWidthProperty().bind(map.widthProperty());

        map.getChildren().add(mapView);
        MapOnClick(mapView);

        // Re-add markers when the view is re-initialize
        List<Property> propertiesCopy = new ArrayList<>(SmartCityDemo.buildingList);
        for (Property property : propertiesCopy) {
            addMarker(mapView, property);
        }
    }

    // Method to handle click on map
    private void MapOnClick(MapView mapView) {
    	
    	// Setup primary mouse click event on map
        mapView.addEventHandler(MouseEvent.ANY, event -> {
            if (!"PRIMARY".equals(event.getButton().toString())) {
                return;
            }
            
            // Differentiate mouse event (drag / click)
            if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                dragging = false;
            } else if (event.getEventType() == MouseEvent.DRAG_DETECTED) {
                dragging = true;
            } else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                dragging = true;
            } else if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
                if (!dragging) {
                    MapPoint mapPoint = mapView.getMapPosition(event.getX(), event.getY());
                    showDialog(mapView, mapPoint);   // First step
                }
            }
        });
    }
    
    // Method to show a custom dialog
    private void showDialog(MapView mapView, MapPoint mapPoint) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addPropertyDialog.fxml"));
            DialogPane dialogPane = loader.load();

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(dialogPane);
            dialog.setGraphic(dialogPane);
            dialog.setTitle("Add Property");

            addPropertyDialogController controller = loader.getController();

            // Setup the click event on 'OK' button
            Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);
            okButton.addEventFilter(ActionEvent.ACTION, event -> {
                if (controller.storeUserSelections(mapPoint)) {
                    Property property = controller.getProperty();
                    addMarker(mapView, property);   // Second step
                } else {
                    event.consume();
                }
            });

            dialog.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to add marker
    private void addMarker(MapView mapView, Property property) {
        ImageView marker = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/marker.png"))));
        marker.setFitWidth(25);
        marker.setFitHeight(25);
        marker.setPreserveRatio(true);
        marker.setCursor(Cursor.HAND);

        // Setup primary mouse click event on marker
        marker.setOnMouseClicked(event -> {
            if (!"PRIMARY".equals(event.getButton().toString())) {
                return;
            }
            event.consume();
            MarkerOnClick(property);   // Third step
        });

        CustomMapLayer markerLayer = new CustomMapLayer(property.getMapPoint(), marker);
        mapView.addLayer(markerLayer);
        markerLayer.refresh();
    }

    // Method to navigate to property page when marker is on click
    private void MarkerOnClick(Property property) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("property.fxml"));
            AnchorPane destinationPage = loader.load();
            PropertyPageController controller = loader.getController();
            controller.loadData(property);

            map.getChildren().setAll(destinationPage);   // Final step
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
