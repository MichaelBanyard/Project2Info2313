package smartcity.properties;

import java.util.ArrayList;
import com.gluonhq.maps.MapPoint;
import smartcity.devices.util.SmartDevice;
import smartcity.properties.util.Building;

public class House extends Building {

    private int numFloors;
    private double area;
    private int garageSize;
    private double yardSize;


    public House(String address, int numberBedrooms, int numberBathrooms, int yearBuilt, double currentValue, ArrayList<SmartDevice> devices, MapPoint mapPoint) throws Exception {
        super(address, numberBedrooms, numberBathrooms, yearBuilt, currentValue, devices, mapPoint);
        this.type = Building.Type.House;
    }
    
    public String getBuildingType() {
		return Type.House.name();
    }

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloor) throws Exception {
        if (numFloor <= 0) {
            throw new Exception("Number of floors must be greater than zero.");
        }
        this.numFloors = numFloor;
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

    public int getGarageSize() {
        return garageSize;
    }

    public void setGarageSize(int garageSize) throws Exception {
        if (area <= 0) {
            throw new Exception("Size of garage must be greater than zero.");
        }
        this.garageSize = garageSize;
    }

    public double getYardSize() {
        return yardSize;
    }

    public void setYardSize(double yardSize) throws Exception {
        if (yardSize <= 0) {
            throw new Exception("Size of yard must be greater than zero.");
        }
        this.yardSize = yardSize;
    }

    @Override
    public String toString() {
        return  "Type: " + getBuildingType()  + ":\n" +
        		"Address: " + getAddress() + ":\n" +
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