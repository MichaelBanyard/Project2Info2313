package main.properties;

import main.SmartDevice;
import main.properties.util.Building;

import java.util.ArrayList;

public class House extends Building {
    public House(String address, int numberBedrooms, int numberBathrooms, int yearBuilt, double currentValue, ArrayList<SmartDevice> devices) {
        super(address, numberBedrooms, numberBathrooms, yearBuilt, currentValue, devices);
        this.type = Type.House;
    }
}
