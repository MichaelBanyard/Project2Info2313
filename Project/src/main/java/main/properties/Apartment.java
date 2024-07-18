package main.properties;

import main.devices.util.SmartDevice;
import main.properties.util.Building;

import java.util.ArrayList;

public class Apartment extends Building {

    private int complexNumber = -1;
    private int floorNumber = -1;
    private int apartmentNumber = -1;

    public Apartment(String address, int numberBedrooms, int numberBathrooms, int yearBuilt, double currentValue, ArrayList<SmartDevice> devices) {
        super(address, numberBedrooms, numberBathrooms, yearBuilt, currentValue, devices);
        this.type = Type.Apartment;
    }

    public Apartment(String address, int numberBedrooms, int numberBathrooms, int yearBuilt, double currentValue, ArrayList<SmartDevice> devices, int complexNumber, int floorNumber, int apartmentNumber) {
        super(address, numberBedrooms, numberBathrooms, yearBuilt, currentValue, devices);
        this.type = Type.Apartment;
        this.setComplexNumber(complexNumber);
        this.setFloorNumber(floorNumber);
        this.setApartmentNumber(apartmentNumber);
    }

    public int getComplexNumber() {
        return complexNumber;
    }

    public void setComplexNumber(int complexNumber) {
        this.complexNumber = complexNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return  "Address: " + getAddress() + ":\n" +
                "Bedrooms: " + getNumberBedrooms() + ",\n" +
                "Bathrooms: " + getNumberBathrooms() + ",\n" +
                "Built in: " + getYearBuilt() + ",\n" +
                "Current Value: " + getCurrentValue() + "\n" +
                "Complex Number: " + getComplexNumber() + "\n" +
                "Floor Number: " + getFloorNumber() + "\n" +
                "Apartment Number: " + getApartmentNumber() + "\n";
    }
}
