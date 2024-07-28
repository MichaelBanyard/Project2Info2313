package smartcity.properties;

import java.util.ArrayList;
import com.gluonhq.maps.MapPoint;
import smartcity.devices.util.SmartDevice;
import smartcity.properties.util.Building;

public class Townhouse extends Building {

    private int townHouseNumber;
    private int numFloors;
    private double area;

    public Townhouse(String address, int numberBedrooms, int numberBathrooms, int yearBuilt, double currentValue, ArrayList<SmartDevice> devices, MapPoint mapPoint) throws Exception {
        super(address, numberBedrooms, numberBathrooms, yearBuilt, currentValue, devices, mapPoint);
        this.type = Type.Townhouse;
    }

    public String getBuildingType() {
		return Type.Townhouse.name();
    }
    
    public int getTownHouseNumber() {
        return townHouseNumber;
    }

    public void setTownHouseNumber(int townHouseNumber) throws Exception {
        if (townHouseNumber <= 0) {
            throw new Exception("Number of townhouse number must be greater than zero.");
        }
        this.townHouseNumber = townHouseNumber;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloors) throws Exception {
        if (numFloors <= 0) {
            throw new Exception("Number of Floors must be greater than zero.");
        }
        this.numFloors = numFloors;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) throws Exception {
        if (area <= 0) {
            throw new Exception("Number of area must be greater than zero.");
        }
        this.area = area;
    }


    @Override
    public String toString() {
        return  "Type: " + getBuildingType()  + ":\n" +
        		"Address: " + getAddress() + ":\n" +
                "Bedrooms: " + getNumberBedrooms() + ",\n" +
                "Bathrooms: " + getNumberBathrooms() + ",\n" +
                "Built in: " + getYearBuilt() + ",\n" +
                "Current Value: " + getCurrentValue() + "\n" +
                "Town House Number: " + getTownHouseNumber() + "\n" +
                "Floors: " + getNumFloors() + "\n" +
                "Area: " + getArea() + "\n";
    }
}