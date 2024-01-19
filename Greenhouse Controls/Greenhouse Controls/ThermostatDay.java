/**
 * primary public class for ThermostatDay
 */
public class ThermostatDay extends Event {

    /**
     * Constructor initiates ThermostatDay objects with a delayTime
     * @param delayTime delayTime of event read from file
     */
    public ThermostatDay(long delayTime) {
        super(delayTime);
    }

    /**
     * Sets variable thermostat to Day
     */
    public void action() {
        // Put hardware control code here.
        GreenhouseControls g = GreenhouseControls.getEventObject();
        g.setVariable("thermostat", "Day");
    }

    /**
     * Returns String representation of ThermostatDay objects
     * @return statement representing ThermostatDay class
     */
    public String toString() {
        return "Thermostat on day setting";
    }

} // end of public class ThermostatDay