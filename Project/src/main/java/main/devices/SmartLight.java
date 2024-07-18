package main.devices;

import main.devices.util.SmartDevice;

public class SmartLight implements SmartDevice {
    private boolean enabled = false;

    public int maxBrightness = 100;

    private int brightness = 50;

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = Math.min(brightness, maxBrightness);
        this.brightness = Math.max(this.brightness, 0);
    }

    public void increaseBrightness(int brightnessIncrease){
        setBrightness(getBrightness() + brightnessIncrease);
    }

    public void decreaseBrightness(int brightnessDecrease){
        setBrightness(getBrightness() - brightnessDecrease);
    }

    @Override
    public void turnOn() {
        enabled = true;
    }

    @Override
    public void turnOff() {
        enabled = false;
    }

    @Override
    public boolean isOn() {
        return enabled;
    }

    @Override
    public String toString() {
        return  "Smart Light:\n" +
                "Brightness: " + brightness + "\n" +
                "Enabled: " + enabled + ".";
    }
}
