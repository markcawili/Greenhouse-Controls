//: innerclasses/GreenhouseControls.java
// This produces a specific application of the
// control system, all in a single class. Inner
// classes allow you to encapsulate different
// functionality for each type of event.
// From 'Thinking in Java, 4th ed.' (c) Bruce Eckel 2005
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

/***********************************************************************
 * Adapated for COMP308 Java for Programmer, 
 *		SCIS, Athabasca University
 *
 * Assignment: TME3
 * @author: Steve Leung
 * @date  : Oct 21, 2005
 *
 */

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.*;

/** public (primary) class for this program, extends Controller and implements Serializable */
public class GreenhouseControls extends Controller implements Serializable {

    /**
     * Holds the serial ID of the class
     */
    @Serial
    private static final long serialVersionUID = -7773509718765573619L; // Ensures same code

    /**
     * private GreenhouseControls to hold variable eventObject
     */
    private static GreenhouseControls eventObject;

    /**
     * private GreenhouseControls to hold variable restoredEventObject
     */
    private static GreenhouseControls restoredEventObject;

    /**
     * private List<TwoTuple<String,Object> to hold variable stateVariables
     */
    private final List<TwoTuple<String, Object>> stateVariables;

    /**
     * private List<Event> to hold variable restoredEventList
     */
    private List<Event> restoredEventList = new ArrayList<Event>();

    /**
     * Constructor initializes events and state variables to TwoTuple stateVariables
     */
    public GreenhouseControls() {
        stateVariables = Arrays.asList(
                new TwoTuple<>("light", false),
                new TwoTuple<>("water", false),
                new TwoTuple<>("thermostat", "Day"),
                new TwoTuple<>("fans", false),
                new TwoTuple<>("windowok", true),
                new TwoTuple<>("poweron", true),
                new TwoTuple<>("errorcode", 0),
                new TwoTuple<>("eventsFile", "examples1.txt")
        );
    }

    /**
     * Returns the eventObject
     * @return eventObject
     */
    public static GreenhouseControls getEventObject() {
        return eventObject;
    }

    /**
     * Returns the restoredEventList
     * @return restoredEventList
     */
    public List<Event> getRestoredEventList() {
        return restoredEventList;
    }

    //GUI SETTER

    /**
     * Sets GreenhouseControls object to passed GreenhouseControls object
     * @param gc GreenhouseControls object
     */
    public void setEventObject(GreenhouseControls gc) {
        eventObject = gc;
    }

    /**
     * Returns the restoredEventObject
     * @return restoredEventObject
     */
    public static GreenhouseControls getRestoredEventObject() {
        return restoredEventObject;
    }

    /**
     * Sets the restoredEventObject to the passed in GreenhouseControls object
     * @param object GreenhouseControls object de serialized from read dump.out file
     */
    public void setRestoredEventObject(GreenhouseControls object) {
        GreenhouseControls.restoredEventObject = object;
    }

    /**
     * Returns the value to the desired key from the TwoTuple list
     * @param event String representation of event
     * @return value to the key pair in TwoTuple
     */
    public Object getVariable(String event) {
        for (TwoTuple<String, Object> twoTuple : stateVariables) {
            if (twoTuple.getEvent().equals(event)) {
                return twoTuple.getStatus();
            }
        }
        return null;
    }

    /**
     * Sets the value to the desired key from the TwoTuple list
     * @param event String representation of event
     * @param status Status of the variable
     */
    public synchronized void setVariable(String event, Object status) {
        for (TwoTuple<String, Object> twoTuple : stateVariables) {
            if (twoTuple.getEvent().equals(event)) {
                twoTuple.setStatus(status);
            }
        }
    }

    /**
     * Returns the appropriate fix method to the malfunction based on the errorCode
     * @param errorCode malfunction errorCode
     * @return FixWindow() method for code 1 or else PowerOn()
     */
    public Fixable getFixable(int errorCode) {
        if (errorCode == 1) {
            return new FixWindow();
        } else {
            return new PowerOn();
        }
    }

    /**
     * Logs the nature of the malfunction, saves the fixed list to a new restoredEventList and calls the serialize()
     * method. Clears the current eventList.
     */
    @Override
    public void shutdown() {

        //saves the fixed list to new list in GreenhouseControls
        restoredEventList = getEventObject().getEventList();

        serialize();

        //Clear so that nothing else runs
        getEventObject().getEventList().clear();

        //Initialize logger
        Logger logger = Logger.getLogger(this.getClass().getName());

        System.out.println("Error encountered, shutting down.");

        //Logs error, uses formatter and filter
        try {
            Handler fileHandler = new FileHandler("error.log", 2000, 5);
            fileHandler.setFormatter(new MyFormatter());
            fileHandler.setFilter(new MyFilter());
            logger.addHandler(fileHandler);

            //print out appropriate log based on error code
            if (getVariable("errorcode").equals(1)) {
                logger.log(Level.INFO, "Reason - WindowsMalfunction");
            } else {
                logger.log(Level.INFO, "Reason - PowerOut");
            }

            logger.log(Level.CONFIG, "Config data");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    /**
     * Serializes the GreenhouseControls object to a dump.out file
     */
    private void serialize() {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("dump.out"))) {
            out.writeObject(getEventObject());
            System.out.println("Object successfully serialized");

        } catch (IOException e) {
            System.out.println("Error encountered");
            e.printStackTrace();
        }

    }

    /**
     * Prints out correct use format for incorrect console arguments
     */
    public static void printUsage() {
        System.out.println("Correct format: ");
        System.out.println("  java GreenhouseControls -f <filename>, or");
        System.out.println("  java GreenhouseControls -d dump.out");
    }

    /**
     * Creates new events
     * @param eventName event type to be created
     * @param delayTime delayTime desired for event
     * @return new Event instance
     * @throws Exception for exceptions where invalid class / no constructor is recognied
     */
    public Event createEvent(String eventName, long delayTime) throws Exception {
        try {
            Class<?> eventClass = Class.forName(eventName);

            Constructor<?> constructor = eventClass.getConstructor(long.class);

            return (Event) constructor.newInstance(delayTime);
        } catch (ClassNotFoundException e) {
            throw new Exception("Class not found");
        } catch (NoSuchMethodException e) {
            throw new Exception("Constructor not found ");
        }
    }

//---------------------------------------------------------

    /**
     * Main method for this class
     * @param args console arguments
     */
    public static void main(String[] args) {
	    try {
	        String option = args[0];
	        String filename = args[1];

	        if ( !(option.equals("-f")) && !(option.equals("-d")) ) {
		    System.out.println("Invalid option");
		    printUsage();
	        }

	        GreenhouseControls gc = new GreenhouseControls();

            //puts event object into variable
            eventObject = gc;

	        if (option.equals("-f"))  {
                Restart restart = new Restart(0,filename,gc);
                restart.action();
	        }

            // added implementation: allows -d use in arguments for reading dump.out file
            if (option.equals("-d")) {
                Restore restored = new Restore(filename);
                restored.run();
                System.exit(0);
            }

            gc.run();

	    }
	    catch (ArrayIndexOutOfBoundsException e) {
	        System.out.println("Invalid number of parameters");
	        printUsage();
	    } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

} ///:~
