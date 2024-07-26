package main.properties;

import main.devices.util.SmartDevice;
import main.properties.util.Building;

import java.util.ArrayList;

public class House extends Building {

    private int numFloors;
    private double area;
    private int garageSize;
    private double yardSize;


    public House(String address, int numberBedrooms, int numberBathrooms, int yearBuilt, double currentValue, ArrayList<SmartDevice> devices) {
        super(address, numberBedrooms, numberBathrooms, yearBuilt, currentValue, devices);
        this.type = Type.House;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloor) {
        this.numFloors = numFloor;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getGarageSize() {
        return garageSize;
    }

    public void setGarageSize(int garageSize) {
        this.garageSize = garageSize;
    }

    public double getYardSize() {
        return yardSize;
    }

    public void setYardSize(double yardSize) {
        this.yardSize = yardSize;
    }

    @Override
    public String toString() {
        return  "Address: " + getAddress() + ":\n" +
                "Bedrooms: " + getNumberBedrooms() + ",\n" +
                "Bathrooms: " + getNumberBathrooms() + ",\n" +
                "Built in: " + getYearBuilt() + ",\n" +
                "Current Value: " + getCurrentValue() + "\n" +
                "Floors: " + getNumFloors() + "\n" +
                "Area: " + getArea() + "\n" +
                "Garage Capacity: " + getGarageSize() + "\n" +
                "Yard Size: " + getYardSize() + "\n";
    }
}
