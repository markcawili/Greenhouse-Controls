/** public class FansOff which extends Event */
public class FansOff extends Event {

    /** Constructor for FansOff which represents FansOff events
     * @param delayTime takes delayTime as parameter */
    public FansOff(long delayTime) {
        super(delayTime);
    }

    /** Method which sets fans variable to false */
    public void action() {
        GreenhouseControls g = GreenhouseControls.getEventObject();
        g.setVariable("fans", false);
    }

    /** Method that returns the String representation of the FansOff class
     * @return statement representing FansOff class */
    public String toString() {
        return "Fan is off";
    }

} // end of public class FansOff
