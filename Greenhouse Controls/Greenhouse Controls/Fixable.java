/** primary (public) class for Fixable */
public interface Fixable {

    /**
     * Turns Power on or Fixes window, zeroes out error codes
     */
    void fix();

    /**
     * Logs to a text file in the current directory called fix.log, prints to console and identifies time and nature
     * of the fix
     */
    void log();

} //end of public class Fixable
