package smartcity.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import smartcity.properties.Apartment;
import smartcity.properties.House;
import smartcity.properties.Townhouse;
import smartcity.properties.util.Building;
import smartcity.properties.util.Property;

import java.util.Objects;

public class PropertyPageController {

    @FXML
    private Label buildingTypeLabel;
    
    @FXML
    private Label addressLabel;
    
    @FXML
    private ImageView image;

    @FXML
    private Label numberBedroomsLabel;

    @FXML
    private Label numberBathroomsLabel;

    @FXML
    private Label yearBuiltLabel;

    @FXML
    private Label currentValueLabel;

    @FXML
    private Label numberBedroomsValueLabel;

    @FXML
    private Label numberBathroomsValueLabel;

    @FXML
    private Label yearBuiltValueLabel;

    @FXML
    private Label currentValueValueLabel;

    @FXML
    private Label dynamicLabel1, dynamicLabel2, dynamicLabel3, dynamicLabel4, dynamicLabel5, dynamicLabel6;
    @FXML
    private Label dynamicValue1, dynamicValue2, dynamicValue3, dynamicValue4, dynamicValue5, dynamicValue6;

    @FXML
    private GridPane detailsGridPane;

    public void loadData(Property property) {
        if (property instanceof Building building) {
            buildingTypeLabel.setText(building.type.name().toUpperCase());
            addressLabel.setText(building.getAddress());
            yearBuiltValueLabel.setText(String.valueOf(building.getYearBuilt()));
            currentValueValueLabel.setText(String.valueOf(building.getCurrentValue()));

            // Clear previous dynamic labels
            clearDynamicLabels();

            if (property instanceof House house) {
                image.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/house.jpg"))));
                addDynamicLabels(
                    "Number of Floors",
                    String.valueOf(house.getNumFloors()),
                    "Area (sq ft)",
                    String.valueOf(house.getArea()),
                    "Garage Size (cars)",
                    String.valueOf(house.getGarageSize()),
                    "Yard Size (sq ft): " + house.getYardSize(),
                    String.valueOf(house.getYardSize()),
                    "Number of Bedrooms",
                    String.valueOf(house.getNumberBedrooms()),
                    "Number of Bathrooms",
                    String.valueOf(house.getNumberBathrooms())
                );
            } else if (property instanceof Apartment apartment) {
                image.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/apartment.jpg"))));
                addDynamicLabels(
                    "Complex Number",
                    String.valueOf(apartment.getComplexNumber()),
                    "Floor Number",
                    String.valueOf(apartment.getFloorNumber()),
                    "Apartment Number",
                    String.valueOf(apartment.getApartmentNumber()),
                    "Number of Bedrooms",
                    String.valueOf(apartment.getNumberBedrooms()),
                    "Number of Bathrooms",
                    String.valueOf(apartment.getNumberBathrooms()),
                    null,
                    null
                );
            } else if (property instanceof Townhouse townhouse) {
                image.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/townhouse.jpg"))));
                addDynamicLabels(
                    "Townhouse Number",
                    String.valueOf(townhouse.getTownHouseNumber()),
                    "Number of Floors",
                    String.valueOf(townhouse.getNumFloors()),
                    "Area (sq ft)",
                    String.valueOf(townhouse.getArea()),
                    "Number of Bedrooms",
                    String.valueOf(townhouse.getNumberBedrooms()),
                    "Number of Bathrooms",
                    String.valueOf(townhouse.getNumberBathrooms()),
                    null,
                    null
                );
            }

            // Adjust static fields position based on dynamic labels
            adjustStaticFieldsPosition();
        }
    }

    private void clearDynamicLabels() {
        dynamicLabel1.setText("");
        dynamicLabel2.setText("");
        dynamicLabel3.setText("");
        dynamicLabel4.setText("");
        dynamicLabel5.setText("");
        dynamicLabel6.setText("");
        dynamicValue1.setText("");
        dynamicValue2.setText("");
        dynamicValue3.setText("");
        dynamicValue4.setText("");
        dynamicValue5.setText("");
        dynamicValue6.setText("");
    }

    private void addDynamicLabels(String label1Text, String value1Text, String label2Text, String value2Text, String label3Text, String value3Text, String label4Text, String value4Text, String label5Text, String value5Text, String label6Text, String value6Text) {
        if (label1Text != null) {
            dynamicLabel1.setText(label1Text);
            dynamicValue1.setText(value1Text);
        }
        if (label2Text != null) {
            dynamicLabel2.setText(label2Text);
            dynamicValue2.setText(value2Text);
        }
        if (label3Text != null) {
            dynamicLabel3.setText(label3Text);
            dynamicValue3.setText(value3Text);
        }
        if (label4Text != null) {
            dynamicLabel4.setText(label4Text);
            dynamicValue4.setText(value4Text);
        }
        if (label5Text != null) {
            dynamicLabel5.setText(label5Text);
            dynamicValue5.setText(value5Text);
        }
        if (label6Text != null) {
            dynamicLabel6.setText(label6Text);
            dynamicValue6.setText(value6Text);
        }
    }

    private void adjustStaticFieldsPosition() {
        int rowCount = 2;
        if (!dynamicLabel4.getText().isEmpty() || !dynamicLabel5.getText().isEmpty() || !dynamicLabel6.getText().isEmpty()) {
            rowCount = 3;
        }

        GridPane.setRowIndex(currentValueLabel, rowCount + 1);
        GridPane.setRowIndex(currentValueValueLabel, rowCount + 2);
        GridPane.setRowIndex(yearBuiltLabel, rowCount + 1);
        GridPane.setColumnIndex(yearBuiltLabel, 1);
        GridPane.setRowIndex(yearBuiltValueLabel, rowCount + 2);
        GridPane.setColumnIndex(yearBuiltValueLabel, 1);
    }
}
