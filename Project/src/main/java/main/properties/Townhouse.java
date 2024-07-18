package main.properties;

import main.devices.util.SmartDevice;
import main.properties.util.Building;

import java.util.ArrayList;

public class Townhouse extends Building {

    private int townHouseNumber;
    private int numFloors;
    private double area;

    public Townhouse(String address, int numberBedrooms, int numberBathrooms, int yearBuilt, double currentValue, ArrayList<SmartDevice> devices) {
        super(address, numberBedrooms, numberBathrooms, yearBuilt, currentValue, devices);
        this.type = Type.Townhouse;
    }

    public int getTownHouseNumber() {
        return townHouseNumber;
    }

    public void setTownHouseNumber(int townHouseNumber) {
        this.townHouseNumber = townHouseNumber;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloors) {
        this.numFloors = numFloors;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }


    @Override
    public String toString() {
        return  "Address: " + getAddress() + ":\n" +
                "Bedrooms: " + getNumberBedrooms() + ",\n" +
                "Bathrooms: " + getNumberBathrooms() + ",\n" +
                "Built in: " + getYearBuilt() + ",\n" +
                "Current Value: " + getCurrentValue() + "\n" +
                "Town House Number: " + getTownHouseNumber() + "\n" +
                "Floors: " + getNumFloors() + "\n" +
                "Area: " + getArea() + "\n";
    }
}
