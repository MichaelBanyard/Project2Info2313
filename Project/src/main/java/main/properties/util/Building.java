package main.properties.util;

import main.Property;
import main.SmartDevice;

import java.util.ArrayList;

public class Building implements Property {

    String address;
    private int numberBedrooms;
    private int numberBathrooms;

    //Between 1970-2024
    private int yearBuilt;
    private double currentValue;

    public Type type;

    private ArrayList<SmartDevice> devices;

    public Building(String address, int numberBedrooms, int numberBathrooms, int yearBuilt, double currentValue, ArrayList<SmartDevice> devices){
        this.setAddress(address);
        this.setNumberBedrooms(numberBedrooms);
        this.setNumberBathrooms(numberBathrooms);
        this.setYearBuilt(yearBuilt);
        this.setCurrentValue(currentValue);
        this.devices = devices;
    }

    public Building(String address, int numberBedrooms, int numberBathrooms, int yearBuilt, double currentValue){
        this.setAddress(address);
        this.setNumberBedrooms(numberBedrooms);
        this.setNumberBathrooms(numberBathrooms);
        this.setYearBuilt(yearBuilt);
        this.setCurrentValue(currentValue);
        this.devices = new ArrayList<>();
    }

    public void addDevice(SmartDevice device){
        devices.add(device);
    }

    public void removeDevice(SmartDevice device){
        devices.remove(device);
    }

    public void removeDevice(int index){
        devices.remove(index);
    }

    @Override
    public double calculatePropertyValue() {
        return 0;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberBedrooms() {
        return numberBedrooms;
    }

    public void setNumberBedrooms(int numberBedrooms) {
        this.numberBedrooms = numberBedrooms;
    }

    public int getNumberBathrooms() {
        return numberBathrooms;
    }

    public void setNumberBathrooms(int numberBathrooms) {
        this.numberBathrooms = numberBathrooms;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        if(yearBuilt < 1970 || yearBuilt > 2024){
            this.yearBuilt = 1970;
            System.out.println("Invalid built date " + yearBuilt + "! Set to 1970.");
            return;
        }
        this.yearBuilt = yearBuilt;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public ArrayList<SmartDevice> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<SmartDevice> devices) {
        this.devices = devices;
    }


    public enum Type {
        Apartment,
        House,
        Townhouse
    }

    @Override
    public String toString() {
        return  "Address: " + getAddress() + ":\n" +
                "Bedrooms: " + getNumberBedrooms() + ",\n" +
                "Bathrooms: " + getNumberBathrooms() + ",\n" +
                "Built in: " + getYearBuilt() + ",\n" +
                "Current Value: " + getCurrentValue() + "\n";
    }


}
