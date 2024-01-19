/**
 * primary public class for ThermostatNight
 */
public class ThermostatNight extends Event {

    /**
     * Constructor initiates ThermostatNight objects with a delayTime
     * @param delayTime delayTime read from file
     */
    public ThermostatNight(long delayTime) {
        super(delayTime);
    }

    /**
     * Sets thermostat variable to Night
     */
    public void action() {
        // Put hardware control code here.
        GreenhouseControls g = GreenhouseControls.getEventObject();
        g.setVariable("thermostat","Night");
    }

    /**
     * Return String representation of ThermostatNight objects
     * @return statement representing ThermostatNight class
     */
    public String toString() {
        return "Thermostat on night setting";
    }

} // end of public class ThermostatNight
