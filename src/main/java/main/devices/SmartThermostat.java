package main.devices;

import main.devices.util.SmartDevice;

public class SmartThermostat implements SmartDevice {


    private Mode mode;


    private int temperature;
    private final int MIN_TEMP = 6;
    private final int MAX_TEMP = 28;
    private final int HEAT_TEMP = 12;

    SmartThermostat(){
        this.setTemperature(22);
        this.setMode(Mode.OFF);
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = Math.min(temperature, this.MAX_TEMP);
        this.temperature = Math.max(this.temperature, MIN_TEMP);
        if(this.getTemperature() <= HEAT_TEMP){
            this.setMode(Mode.COOL);
        } else{
            this.setMode(Mode.HEAT);
        }
    }

    public void adjustTemperature(int amount){
        this.setTemperature(this.getTemperature() + amount);
    }

    @Override
    public void turnOn() {
        this.setMode(Mode.ON);
    }

    @Override
    public void turnOff() {
        this.setMode(Mode.OFF);
    }

    @Override
    public boolean isOn() {
        return mode != Mode.OFF;
    }

    @Override
    public String toString() {
        return  "Smart Thermostat:\n" +
                "Temperature: " + temperature + "\n" +
                "Mode: " + mode.name() + ".";
    }

    enum Mode{
        OFF,
        COOL,
        HEAT,
        ON
    }

}
