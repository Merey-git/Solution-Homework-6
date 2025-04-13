package CommandPattern;

public class Thermostat {
    public void setTemperature(int temperature) {
        System.out.println("[Thermostat] Setting temperature to " + temperature + "°C");
    }

    public void revertTemperature() {
        System.out.println("[Thermostat] Reverting to previous temperature");
    }
}
