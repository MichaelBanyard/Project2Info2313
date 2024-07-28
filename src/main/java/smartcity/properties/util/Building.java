package smartcity.properties.util;

import java.util.ArrayList;
import com.gluonhq.maps.MapPoint;
import smartcity.devices.util.SmartDevice;

public class Building implements Property {

    String address;
    private int numberBedrooms;
    private int numberBathrooms;
    private int yearBuilt;
    private double currentValue;
    public Type type;
    private ArrayList<SmartDevice> devices;
    private MapPoint mapPoint;
    
    public Building(String address, int numberBedrooms, int numberBathrooms, int yearBuilt, double currentValue, ArrayList<SmartDevice> devices, MapPoint mapPoint) throws Exception {
        this.setAddress(address);
        this.setNumberBedrooms(numberBedrooms);
        this.setNumberBathrooms(numberBathrooms);
        this.setYearBuilt(yearBuilt);
        this.setCurrentValue(currentValue);
        this.devices = devices;
        this.mapPoint = mapPoint;
    }

    public Building(String address, int numberBedrooms, int numberBathrooms, int yearBuilt, double currentValue) throws Exception{
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
    
    @Override
    public MapPoint getMapPoint() {
        return mapPoint;
    }

    @Override
    public void setMapPoint(MapPoint mapPoint) {
        this.mapPoint = mapPoint;
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

    public void setNumberBedrooms(int numberBedrooms) throws Exception {
    	if (numberBedrooms <= 0) {
    		throw new Exception("Number of Bedrooms must be greater than zero.");
    	}
    	this.numberBedrooms = numberBedrooms;
    		
    }

    public int getNumberBathrooms() {
        return numberBathrooms;
    }

    public void setNumberBathrooms(int numberBathrooms) throws Exception {
    	if (numberBathrooms <= 0) {
    		throw new Exception("Number of Bathrooms must be greater than zero.");
    	}
        this.numberBathrooms = numberBathrooms;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) throws Exception {
        if (yearBuilt < 1970 || yearBuilt > 2024) {
            throw new Exception("Year built must be between 1970 and 2024.");
        }
        this.yearBuilt = yearBuilt;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) throws Exception {
    	if (currentValue <= 0) {
    		throw new Exception("Number of currentValue must be greater than zero.");
    	}
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