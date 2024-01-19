import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/** public class for FixWindow which implements Fixable */
public class FixWindow implements Fixable {

    /** Method which fixes the running events by resetting the errorcode and setting error variable to true */
    public void fix() {
        GreenhouseControls g = GreenhouseControls.getEventObject();
        g.setVariable("windowok",true);
        g.setVariable("errorcode", 0);
    }

    /** Method which logs the appropriate fix */
    public void log() {
        Logger logger = Logger.getLogger(GreenhouseControls.class.getName());

        try {
            Handler fileHandler = new FileHandler("fix.log", 2000, 5);
            fileHandler.setFormatter(new MyFormatter());
            fileHandler.setFilter(new MyFilter());
            logger.addHandler(fileHandler);

            logger.log(Level.INFO, "Window fixed");

            logger.log(Level.CONFIG, "Config data");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

} // end of public class FixWindow