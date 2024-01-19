/**
 * primary public class for WaterOff
 */
public class WaterOff extends Event {

    /**
     * Constructor initializes WaterOff objects with a delayTime
     * @param delayTime delayTime read from file 
     */
    public WaterOff(long delayTime) { super(delayTime); }

    /**
     * Sets water variable to false for off 
     */
    public void action() {
        // Put hardware control code here.
        GreenhouseControls g = GreenhouseControls.getEventObject();
        g.setVariable("water",false);
    }

    /**
     * Returns String representation of WaterOff objects
     * @return statement representing WaterOff class 
     */
    public String toString() {
        return "Greenhouse water is off";
    }

} // end of public class WaterOff 