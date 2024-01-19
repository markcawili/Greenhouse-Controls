/** public class for WindowMalfunction which extends Event */
public class WindowMalfunction extends Event {

    /** Constructor for WindowMalfunction to set up objects
     * @param delayTime takes parameter delayTime */
    public WindowMalfunction(long delayTime) {
        super(delayTime);
    }

    /** Method that sets window variable to false for error and sets errorcode, calls shutdown() method */
    public void action() {

        GreenhouseControls g = GreenhouseControls.getEventObject();

        try {
            g.setVariable("windowok",false);
            throw new ControllerException("The window will not budge at all!");
        } catch (ControllerException e) {
            System.out.println(e.getMessage());
            g.setVariable("errorcode",1);
            g.shutdown();
        }
    }

    /** Method that returns String message of the object
     * @return message */
    public String toString() {
        return "The window will not open!";
    }

} // end of public class WindowMalfunction