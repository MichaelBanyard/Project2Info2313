package smartcity.properties;

import java.util.ArrayList;
import com.gluonhq.maps.MapPoint;
import smartcity.devices.util.SmartDevice;
import smartcity.properties.util.Building;

public class Apartment extends Building {

    private int complexNumber = -1;
    private int floorNumber = -1;
    private int apartmentNumber = -1;

    public Apartment(String address, int numberBedrooms, int numberBathrooms, int yearBuilt, double currentValue, ArrayList<SmartDevice> devices, MapPoint mapPoint) throws Exception {
        super(address, numberBedrooms, numberBathrooms, yearBuilt, currentValue, devices, mapPoint);
        this.type = Building.Type.Apartment;
    }

    public Apartment(String address, int numberBedrooms, int numberBathrooms, int yearBuilt, double currentValue, ArrayList<SmartDevice> devices, MapPoint mapPoint, int complexNumber, int floorNumber, int apartmentNumber) throws Exception {
        super(address, numberBedrooms, numberBathrooms, yearBuilt, currentValue, devices, mapPoint);
        this.type = Type.Apartment;
        this.setComplexNumber(complexNumber);
        this.setFloorNumber(floorNumber);
        this.setApartmentNumber(apartmentNumber);
    }
    
    public String getBuildingType() {
		return Type.Apartment.name();
    }

    public int getComplexNumber() {
        return complexNumber;
    }

    public void setComplexNumber(int complexNumber) throws Exception {
        if (complexNumber <= 0) {
            throw new Exception("Number of complex number must be greater than zero.");
        }
        this.complexNumber = complexNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) throws Exception {
        if (floorNumber <= 0) {
            throw new Exception("Number of floor number must be greater than zero.");
        }
        this.floorNumber = floorNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) throws Exception {
        if (apartmentNumber <= 0) {
            throw new Exception("Number of apartment number must be greater than zero.");
        }
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return  "Type: " + getBuildingType()  + ":\n" +
        		"Address: " + getAddress() + ":\n" +
                "Bedrooms: " + getNumberBedrooms() + ",\n" +
                "Bathrooms: " + getNumberBathrooms() + ",\n" +
                "Built in: " + getYearBuilt() + ",\n" +
                "Current Value: " + getCurrentValue() + "\n" +
                "Complex Number: " + getComplexNumber() + "\n" +
                "Floor Number: " + getFloorNumber() + "\n" +
                "Apartment Number: " + getApartmentNumber() + "\n";
    }
}
