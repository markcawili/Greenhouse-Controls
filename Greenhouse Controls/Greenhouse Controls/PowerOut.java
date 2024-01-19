/** public class for PowerOut which extends Event */
public class PowerOut extends Event {

    /** Constructor for PowerOut to set up objects
     * @param delayTime takes parameter delayTime */
    public PowerOut(long delayTime) { super(delayTime); }

    /** Method that sets power variable to false for error and sets errocode, calls shutdown() method */
    public void action() {

        GreenhouseControls g = GreenhouseControls.getEventObject();

        try {
            g.setVariable("poweron",false);
            throw new ControllerException("There is no power at all!");
        } catch (ControllerException e) {
            System.out.println(e.getMessage());
            g.setVariable("errorcode",2);
            g.shutdown();
        }
    }

    /** Method that returns String message of the object
     * @return message */
    public String toString() {
        return "The power is out!";
    }

} // end of public class PowerOut
