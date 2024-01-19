//: innerclasses/controller/Controller.java
// The reusable framework for control systems.
// From 'Thinking in Java, 4th ed.' (c) Bruce Eckel 2005
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

/***********************************************************************
 * Adapated for COMP308 Java for Programmer,
 *		SCIS, Athabasca University
 *
 * Assignment: TME3
 * @author: Steve Leung
 * @date  : Oct 21, 2006
 *
 */

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * primary public class for Controller
 */
public class Controller {
    // A class from java.util to hold Event objects:

    /**
     * private boolean to hold variable isRunning to determine if program is running
     */
    private boolean isRunning;

    /**
     * private boolean to hold variable suspended initialized to false
     */
    private boolean suspended = false;

    /**
     * private long to hold variable suspendedTime for time between program suspension and resumption
     */
    private long suspendedTime;

    /**
     * private List<Event> to hold variable eventList which stores read events from a file
     */
    private List<Event> eventList = new ArrayList<Event>();

    /**
     * Suspends the running thread; variable suspended set to true and isRunning to false, initializes suspendedTime
     * to current time at suspension and prints out statement
     */
    public void suspend() {
        suspended = true;
        isRunning = false;
        suspendedTime = System.currentTimeMillis();
        System.out.println("Suspending");
    }

    /**
     * Resumes the running thread; variable suspended set to false and isRunning to true, initializes resumeTime
     * to current time at resumption and calculates the suspendedDuration time. Loops through events in eventList and
     * updates eventTime with added suspendedDuration. Prints out statement and wakes all threads
     */
    public synchronized void resume() {
        suspended = false;
        isRunning = true;
        long resumeTime = System.currentTimeMillis();
        long suspendedDuration = resumeTime - suspendedTime;

        for (Event e : new ArrayList<>(eventList)) {
            e.setEventTime(e.getEventTime() + suspendedDuration);
        }

        System.out.println("Resuming");
        notifyAll();
    }

    /**
     * Returns isRunning boolean true/false
     * @return boolean true or false
     */
    public boolean getRunning() {
        return isRunning;
    }

    /**
     * Returns suspended boolean true/false
     * @return boolean true or false
     */
    public boolean getSuspended() {
        return suspended;
    }

    /**
     * Adds event to eventList
     * @param event event to be added, read from file
     */
    public void addEvent(Event event) {
        eventList.add(event);
    }

    /**
     * Prints out statement closing controls
     */
    public void shutdown() {
        System.out.println("Closing the controls");
    }

    /**
     * Returns eventList
     * @return eventList
     */
    public List<Event> getEventList() {
        return eventList;
    }

    /**
     * Sets an eventList
     * @param eventList passed eventList to set
     */
    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    /**
     * Sets isRunning to true, utilizes ExecutorService to manage a thread pool of Event objects. If suspended, thread
     * pool execution is paused, otherwise, loops through eventList with the executor and runs the run() method of Event
     * for each event then removes the event from the list. Shuts down executor and sets isRunning to false.
     */
    public void run() {
        isRunning = true;

        ExecutorService executor = Executors.newCachedThreadPool();

        while (eventList.size() > 0) {
            if(GreenhouseControls.getEventObject().getSuspended()) {
                synchronized (this) {
                    while (GreenhouseControls.getEventObject().getSuspended()) {
                        try {
                            System.out.println("Waiting");
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            for (Event e : new ArrayList<>(eventList)) {
                if (e.ready()) {

                    executor.execute(e);
                    eventList.remove(e);
                }
            }
        }
        executor.shutdown();
        isRunning = false;
    }

} // end of public class Controller

