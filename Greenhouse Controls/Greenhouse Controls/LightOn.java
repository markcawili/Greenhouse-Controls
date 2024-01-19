/**
 * primary public class for LightOn
 */
public class LightOn extends Event {

    /**
     * Constructor initiates LightOn objects with a delayTime
     * @param delayTime delayTime of event read from file
     */
    public LightOn(long delayTime) { super(delayTime); }

    /**
     * Sets Light variable to true for on
     */
    public void action() {
        // Put hardware control code here to
        // physically turn on the light.
        GreenhouseControls g = GreenhouseControls.getEventObject();
        g.setVariable("light", true);
    }

    /**
     * Returns String representation of LightOn objects
     * @return statement representing LightOn class
     */
    public String toString() { return "Light is on"; }

} // end of public class LightOn
