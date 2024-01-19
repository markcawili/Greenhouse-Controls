import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** public class for Restart which extends Event */
public class Restart extends Event {

    /**
     * Variable gc for GreenhouseControls object initialized to null
     */
    GreenhouseControls gc = null;

    /**
     * Constructor initializes Restart objects with delayTime, reads from filename, and passes in GreenhouseControls
     * object
     * @param delayTime delayTime read from file
     * @param filename name of .txt file
     * @param gc GreenhouseControls object
     */
    public Restart(long delayTime, String filename, GreenhouseControls gc) {
        super(delayTime);
        this.gc = gc;
        this.gc.setVariable("eventsFile", filename);
    }

    /** Method that reads console argument file input and utilizes regular expression to splice file contents based on
     * the desired events */
    public void action() {

        File text = new File((String) gc.getVariable("eventsFile"));
        Scanner scanner = null;

        try {
            scanner = new Scanner(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();   //continuously reads next line while Scanner detects lines

            Pattern pattern = Pattern.compile("(\\w+)=(\\w+)");     //regular expression splits by =
            Matcher matcher = pattern.matcher(line);

            //variables for event type, time of runtime, and rings for Bell events
            String event = null;
            int time = 0;
            int rings = 0;

            while (matcher.find()) {
                String key = matcher.group(1);
                String value = matcher.group(2);

                //converts keys to appropriate values
                if (key.equals("Event")) {
                    event = value;
                } else if (key.equals("time")) {
                    time = Integer.parseInt(value);
                } else if (key.equals("rings")) {
                    rings = Integer.parseInt(value);
                }
            }

            //adds appropriate event object based on event value
            if (event != null) {
                switch (event) {
                    case "ThermostatNight" -> gc.addEvent(new ThermostatNight(time));
                    case "LightOn" -> gc.addEvent(new LightOn(time));
                    case "WaterOff" -> gc.addEvent(new WaterOff(time));
                    case "ThermostatDay" -> gc.addEvent(new ThermostatDay(time));
                    case "WaterOn" -> gc.addEvent(new WaterOn(time));
                    case "LightOff" -> gc.addEvent(new LightOff(time));
                    case "Terminate" -> gc.addEvent(new Terminate(time));
                    case "FansOn" -> gc.addEvent(new FansOn(time));
                    case "FansOff" -> gc.addEvent(new FansOff(time));
                    case "Bell" -> {
                        gc.addEvent(new Bell(time, rings));
                        for (int i = 1; i < rings; i++) {
                            long eventTime = time + (i * 2000L);
                            gc.addEvent(new Bell(eventTime, rings));
                        }
                    }
                    case "WindowMalfunction" -> gc.addEvent(new WindowMalfunction(time));
                    case "PowerOut" -> gc.addEvent(new PowerOut(time));
                }
            }
        }
    }

    /**
     * Returns String representation of Restart objects
     * @return statement representing Restart class
     */
    public String toString() {
        return "Restarting system test";
    }

} // end of public class Restart
