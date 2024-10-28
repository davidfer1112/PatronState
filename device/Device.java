// src/Device.java
package device;

import state.SoundState;
import state.sound.NormalState;
import state.EnergyState;
import state.energy.NormalEnergyState;

public class Device {
    private SoundState soundState;
    private EnergyState energyState;
    private int batteryPercentage;
    private int brightness;

    public Device() {
        this.soundState = new NormalState();
        this.energyState = new NormalEnergyState();
        this.energyState.setDevice(this);
        this.batteryPercentage = 100; // Default battery percentage
        this.brightness = 100; // Default brightness
    }

    public void setSoundState(SoundState state) {
        this.soundState = state;
    }

    public void setEnergyState(EnergyState state) {
        this.energyState = state;
        this.energyState.setDevice(this);
    }

    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public int getBatteryPercentage() {
        return this.batteryPercentage;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public void alertSound() {
        this.soundState.alert();
    }

    public void alertEnergy() {
        this.energyState.lowBatteryAlert();
    }

    public void setMaxBrightness() {
        this.energyState.setMaxBrightness();
    }
}
