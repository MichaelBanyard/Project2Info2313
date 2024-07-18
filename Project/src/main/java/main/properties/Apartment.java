package main.properties;

import main.SmartDevice;
import main.properties.util.Building;

import java.util.ArrayList;

public class Apartment extends Building {
    public Apartment(String address, int numberBedrooms, int numberBathrooms, int yearBuilt, double currentValue, ArrayList<SmartDevice> devices) {
        super(address, numberBedrooms, numberBathrooms, yearBuilt, currentValue, devices);
        this.type = Type.Apartment;
    }
}
