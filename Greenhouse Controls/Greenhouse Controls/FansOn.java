/** public class FansOn which extends Event */
public class FansOn extends Event {

    /** Constructor for FansOn which represents FansOn events
     * @param delayTime takes delayTime as parameter */
    public FansOn(long delayTime) {
        super(delayTime);
    }

    /** Method which sets fans variable to true */
    public void action() {
        GreenhouseControls g = GreenhouseControls.getEventObject();
        g.setVariable("fans", true);
    }

    /** Method that returns String representation of the FansOn object
     * @return string representation of FansOn */
    public String toString() {
        return "Fan is on";
    }

} // end of public class FansOn