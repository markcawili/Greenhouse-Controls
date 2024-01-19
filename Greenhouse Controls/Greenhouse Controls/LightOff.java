/**
 * primary public class for LightOff
 */
public class LightOff extends Event {

    /**
     * Constructor initiates LightOff objects with a delayTime
     * @param delayTime delayTime of event read from file
     */
    public LightOff(long delayTime) { super(delayTime); }

    /**
     * Sets Light variable to false for off
     */
    public void action() {
        // Put hardware control code here to
        // physically turn off the light.
        GreenhouseControls g = GreenhouseControls.getEventObject();
        g.setVariable("light", false);
    }

    /**
     * Method to return String representation of LightOff objects
     * @return statement representing LightOff class
     */
    public String toString() { return "Light is off"; }

} // end of public class LightOff