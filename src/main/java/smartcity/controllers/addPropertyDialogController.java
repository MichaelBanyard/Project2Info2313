package smartcity.controllers;

import com.gluonhq.maps.MapPoint;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import smartcity.SmartCityDemo;
import smartcity.devices.util.SmartDevice;
import smartcity.properties.Apartment;
import smartcity.properties.House;
import smartcity.properties.Townhouse;
import smartcity.properties.util.Building;
import smartcity.properties.util.Property;

import java.util.ArrayList;

public class addPropertyDialogController {

    @FXML
    private DialogPane dialogPane;

    @FXML
    private ComboBox<Building.Type> buildingTypeComboBox;

    @FXML
    private VBox comboBoxContainer;

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField numberBedroomsField;

    @FXML
    private TextField numberBathroomsField;

    @FXML
    private TextField yearBuiltField;

    @FXML
    private TextField currentValueField;

    @FXML
    private TextArea addressField;

    private ArrayList<SmartDevice> deviceList = new ArrayList<>();
    private TextField[] extraTextFields;
    private Label[] extraLabels;

    @FXML
    private void initialize() {
        // Initialize the building type ComboBox with options
        Building.Type[] buildingTypes = Building.Type.values();
        for (Building.Type type : buildingTypes) {
            buildingTypeComboBox.getItems().add(type);
        }
        buildingTypeComboBox.setOnAction(event -> onBuildingTypeChange());
    }

    private void onBuildingTypeChange() {
        // Clear previous dynamic TextFields
        if (gridPane.getChildren().size() > 5) {
        	gridPane.getChildren().remove(12, gridPane.getChildren().size());
        }

        // Get the selected building type
        Building.Type selectedBuildingType = buildingTypeComboBox.getValue();

        // Add the appropriate TextFields based on the selected building type
        switch (selectedBuildingType) {
            case House -> {
                extraTextFields = new TextField[4];
                extraLabels = new Label[4];
                addLabel("Number of Floors", 0, 6);
                addLabel("Area (sq ft)", 0, 7);
                addLabel("Garage Size (cars)", 0, 8);
                addLabel("Yard Size (sq ft)", 0, 9);
                addTextField(0, 1, 6);
                addTextField(1, 1, 7);
                addTextField(2, 1, 8);
                addTextField(3, 1, 9);
            }
            case Apartment -> {
                extraTextFields = new TextField[3];
                extraLabels = new Label[3];
                addLabel("Complex Number", 0, 6);
                addLabel("Floor Number", 0, 7);
                addLabel("Apartment Number", 0, 8);
                addTextField(0, 1, 6);
                addTextField(1, 1, 7);
                addTextField(2, 1, 8);
            }
            case Townhouse -> {
                extraTextFields = new TextField[3];
                extraLabels = new Label[3];
                addLabel("Townhouse Number", 0, 6);
                addLabel("Number of Floors", 0, 7);
                addLabel("Area (sq ft)", 0, 8);
                addTextField(0, 1, 6);
                addTextField(1, 1, 7);
                addTextField(2, 1, 8);
            }
        }
        // Resize the dialog (Add Property) after updating the UI
        dialogPane.getScene().getWindow().sizeToScene();
    }

    // Method to create and add a Label with name
    private void addLabel(String labelText, int columnIndex, int rowIndex) {
        Label label = new Label(labelText);
        gridPane.add(label, columnIndex, rowIndex);
    }

    // Method to create and add a TextField
    private void addTextField(int index, int columnIndex, int rowIndex) {
        TextField textField = new TextField();
        gridPane.add(textField, columnIndex, rowIndex);
        extraTextFields[index] = textField;
    }

    // Method to be called when user finishes selecting options
    public boolean storeUserSelections(MapPoint mapPoint) {
        String numberBedroomsText = numberBedroomsField.getText();
        String numberBathroomsText = numberBathroomsField.getText();
        String yearBuiltText = yearBuiltField.getText();
        String currentValueText = currentValueField.getText();
        String address = addressField.getText();

        if (numberBedroomsText.isEmpty() || numberBathroomsText.isEmpty() || yearBuiltText.isEmpty() || currentValueText.isEmpty() || address.isEmpty()) {
            showErrorAlert("Please fill in all required fields.");
            return false;
        }

        try {
            // Convert text to number
            int numberBedrooms = Integer.parseInt(numberBedroomsText);
            int numberBathrooms = Integer.parseInt(numberBathroomsText);
            int yearBuilt = Integer.parseInt(yearBuiltText);
            double currentValue = Double.parseDouble(currentValueText);

            Building.Type selectedBuildingType = buildingTypeComboBox.getValue();

            switch (selectedBuildingType) {
                case House -> {
                    if (extraTextFields[0].getText().isEmpty() || extraTextFields[1].getText().isEmpty() || extraTextFields[2].getText().isEmpty() || extraTextFields[3].getText().isEmpty()) {
                        showErrorAlert("Please fill in all required fields for House.");
                        return false;
                    }
                    int numFloors = Integer.parseInt(extraTextFields[0].getText());
                    double area = Double.parseDouble(extraTextFields[1].getText());
                    int garageSize = Integer.parseInt(extraTextFields[2].getText());
                    double yardSize = Double.parseDouble(extraTextFields[3].getText());
                    House house = new House(address, numberBedrooms, numberBathrooms, yearBuilt, currentValue, deviceList, mapPoint);
                    house.setAddress(address);
                    house.setNumberBedrooms(numberBedrooms);
                    house.setNumberBathrooms(numberBathrooms);
                    house.setYearBuilt(yearBuilt);
                    house.setCurrentValue(currentValue);
                    house.setNumFloors(numFloors);
                    house.setArea(area);
                    house.setGarageSize(garageSize);
                    house.setYardSize(yardSize);
                    SmartCityDemo.buildingList.add(house);
                }
                case Apartment -> {
                    if (extraTextFields[0].getText().isEmpty() || extraTextFields[1].getText().isEmpty() || extraTextFields[2].getText().isEmpty()) {
                        showErrorAlert("Please fill in all required fields for Apartment.");
                        return false;
                    }
                    int complexNumber = Integer.parseInt(extraTextFields[0].getText());
                    int floorNumber = Integer.parseInt(extraTextFields[1].getText());
                    int apartmentNumber = Integer.parseInt(extraTextFields[2].getText());
                    Apartment apartment = new Apartment(address, numberBedrooms, numberBathrooms, yearBuilt, currentValue, deviceList, mapPoint);
                    apartment.setAddress(address);
                    apartment.setNumberBedrooms(numberBedrooms);
                    apartment.setNumberBathrooms(numberBathrooms);
                    apartment.setYearBuilt(yearBuilt);
                    apartment.setCurrentValue(currentValue);
                    apartment.setComplexNumber(complexNumber);
                    apartment.setFloorNumber(floorNumber);
                    apartment.setApartmentNumber(apartmentNumber);
                    SmartCityDemo.buildingList.add(apartment);
                }
                case Townhouse -> {
                    if (extraTextFields[0].getText().isEmpty() || extraTextFields[1].getText().isEmpty() || extraTextFields[2].getText().isEmpty()) {
                        showErrorAlert("Please fill in all required fields for Townhouse.");
                        return false;
                    }
                    int townhouseNumber = Integer.parseInt(extraTextFields[0].getText());
                    int numFloorsTownhouse = Integer.parseInt(extraTextFields[1].getText());
                    double areaTownhouse = Double.parseDouble(extraTextFields[2].getText());
                    Townhouse townhouse = new Townhouse(address, numberBedrooms, numberBathrooms, yearBuilt, currentValue, deviceList, mapPoint);
                    townhouse.setAddress(address);
                    townhouse.setNumberBedrooms(numberBedrooms);
                    townhouse.setNumberBathrooms(numberBathrooms);
                    townhouse.setYearBuilt(yearBuilt);
                    townhouse.setCurrentValue(currentValue);
                    townhouse.setTownHouseNumber(townhouseNumber);
                    townhouse.setNumFloors(numFloorsTownhouse);
                    townhouse.setArea(areaTownhouse);
                    SmartCityDemo.buildingList.add(townhouse);
                }
            }

            // Print the buildingList for debug purpose
            for (Property building : SmartCityDemo.buildingList) {
                System.out.println(building);
            }
            return true;
        } catch (NumberFormatException e) {
            showErrorAlert("Please enter valid numbers for all fields.");
            return false;
        } catch (Exception e) {
            showErrorAlert(e.getMessage());
            return false;
        }
    }

    // Method to show error alert of input
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    // Method to get the property
    public Property getProperty() {
    	return SmartCityDemo.buildingList.getLast();
    }
}
