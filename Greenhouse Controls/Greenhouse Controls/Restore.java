import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/** primary class for Restore which extends GreenhouseControls */
public class Restore extends GreenhouseControls {

    /** protected GreenhouseControls variable restoredEvents which holds the deserialized object
     */
    protected GreenhouseControls restoredEvents;

    /** Constructor for Restore which de serializes the object and calls appropriate fix() and log() methods of the
     * Fixable object derived from error code of the restoredEventObject.
     * @param file parameter file console argument */
    public Restore(String file) {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {

            //reads from file to de serialize
            restoredEvents = (GreenhouseControls) in.readObject();

            setRestoredEventObject(restoredEvents);

            System.out.println("Object successfully restored");

            //sets eventList in event class from restored
            setEventList(getRestoredEventObject().getRestoredEventList());

            //adjusts start time to where error left off
            long restoredStart = System.currentTimeMillis();
            for (Event restoredEvents: getRestoredEventObject().getRestoredEventList()) {
                restoredEvents.setEventTime(restoredEvents.getDelayTime()+restoredStart);
            }

            //fixed object made from restoredEventObject errorcode passed into getFixable(), parses to Int first
            Fixable fixed = getRestoredEventObject().getFixable((Integer)
                    getRestoredEventObject().getVariable("errorcode"));

            fixed.fix();
            fixed.log();

        } catch (IOException e) {
            System.out.println("Error during restoration");
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }

    }

} // end of public class Restore