package main.properties;

import main.SmartDevice;
import main.properties.util.Building;

import java.util.ArrayList;

public class Townhouse extends Building {
    public Townhouse(String address, int numberBedrooms, int numberBathrooms, int yearBuilt, double currentValue, ArrayList<SmartDevice> devices) {
        super(address, numberBedrooms, numberBathrooms, yearBuilt, currentValue, devices);
        this.type = Type.Townhouse;
    }
}
