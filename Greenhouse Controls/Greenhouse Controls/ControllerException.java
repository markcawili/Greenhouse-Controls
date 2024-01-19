/** public ControllerException class which extends Exception, represents custom exception */
public class ControllerException extends Exception {

    /** Constructor for ControllerException
     * @param message takes String message as parameter to pass through */
    public ControllerException(String message) {
        super(message);
    }

} // end of public class ControllerException