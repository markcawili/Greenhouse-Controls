import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/** public MyFormatter class which extends formatter which formats log record */
public class MyFormatter extends Formatter {

    /** Method that formats log messages and returns it
     * @param record the log record to be formatted.
     * @return returns log message */
    @Override
    public String format(LogRecord record) {
        return record.getMessage()+"::"+record.getMillis();
    }

} // end of public class MyFormatter
