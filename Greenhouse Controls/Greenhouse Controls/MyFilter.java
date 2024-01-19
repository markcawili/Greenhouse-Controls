import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/** public MyFilter class which implements Filter  */
public class MyFilter implements Filter {

    /** Method that sets loggable variable
     * @param log  a LogRecord */
    @Override
    public boolean isLoggable(LogRecord log) {
        if(log.getLevel() == Level.CONFIG) return false;
        return true;
    }

} // end of public class MyFilter