/**
 * primary public class for WaterOn
 */
public class WaterOn extends Event {

    /**
     * Constructor initializes WaterOn objects with a delayTime
     * @param delayTime delayTime read from a file
     */
    public WaterOn(long delayTime) { super(delayTime); }

    /**
     * Sets water variable to true for on
     */
    public void action() {
        // Put hardware control code here.
        GreenhouseControls g = GreenhouseControls.getEventObject();
        g.setVariable("water",true);
    }

    /**
     * Returns String representation of WaterOn objects
     * @return statement representing WaterOn class
     */
    public String toString() {
        return "Greenhouse water is on";
    }

} // end of public class WaterOn
