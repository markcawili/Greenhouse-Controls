// An example of an action() that inserts a
// new one of itself into the event list:

/** public class for Bell which extends public class Event */
public class Bell extends Event {

    /** variable to store int rings for Bell events  */
    protected final int rings;

    /** Constructor for Bell, takes delayTime and rings as arguments to set up Bell objects
     * @param delayTime variable delayTime for Bell events
     * @param rings variable rings for number of rings for Bell events */
    public Bell(long delayTime, int rings) {
        super(delayTime);
        this.rings = rings;
    }

    public void action() {
        // nothing to do
    }

    /** Method that returns the String representation of the Bell class
     * @return statement representing Bell class */
    public String toString() { return "Bing!"; }

} // end of public class Bell