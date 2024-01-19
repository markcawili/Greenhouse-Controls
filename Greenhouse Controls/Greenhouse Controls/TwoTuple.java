import java.io.Serializable;

/**
 * primary public class for TwoTuple
 * @param <K> represents events of GreenhouseControls
 * @param <V> represents the status of the events
 */
public class TwoTuple<K, V> implements Serializable {

    /**
     * variable K to hold events
     */
    private final K event;

    /**
     * variable V to hold the status of events
     */
    private V status;

    /**
     * Constructor initializes events and status from passed parameters
     * @param event passed event type
     * @param status passed status of event
     */
    public TwoTuple(K event, V status) {
        this.event = event;
        this.status = status;
    }

    /**
     * Returns String representation of event, status TwoTuple
     * @return statement representing the event and status stored in the TwoTuple
     */
    public String toString() {
        return event + "," + status;
    }

    /**
     * Returns the event stored
     * @return event type
     */
    public K getEvent() {
        return event;
    }

    /**
     * Returns the status of the event paired
     * @return event status
     */
    public V getStatus() {
        return status;
    }

    /**
     * Sets the status of the event paired
     * @param value event status
     */
    public void setStatus(V value) {
        this.status = value;
    }

} // end of public class TwoTuple

