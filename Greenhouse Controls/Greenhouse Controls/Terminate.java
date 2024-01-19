/**
 * primary public class for Terminate
 */
public class Terminate extends Event {

    /**
     * Constructor initializes Terminate objects with a delayTime
     * @param delayTime delayTime read from file
     */
    public Terminate(long delayTime) { super(delayTime); }

    /**
     * Clears the eventList and prints out a space
     */
    public void action() {
        GreenhouseControls g = GreenhouseControls.getEventObject();
        g.getEventList().clear();
        System.out.println();
    }

    /**
     * Returns String representation of Terminate objects
     * @return statement representing Terminate class
     */
    public String toString() { return "Terminating";  }

} // end of public class Terminate