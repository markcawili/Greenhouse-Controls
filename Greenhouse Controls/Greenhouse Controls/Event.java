//: innerclasses/controller/Event.java
// The common methods for any control event.
// From 'Thinking in Java, 4th ed.' (c) Bruce Eckel 2005
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

/***********************************************************************
 * Adapted for COMP308 Java for Programmer,
 *		SCIS, Athabasca University
 *
 * Assignment: TME3
 * @author: Steve Leung
 * @date  : Oct. 21, 2006
 *
 * Description: Event abstract class
 *
 */

import java.io.Serializable;

/**
 * primary public class Event which implements Serializable and Runnable
 */
public abstract class Event implements Serializable, Runnable {

  /**
   * private variable eventTime to store event time at runtime
   */
  private long eventTime;

  /**
   * protected variable delayTime for event delayTime read from file
   */
  protected final long delayTime;

  /**
   * Initializes Event objects with a delayTime and calculates eventTime for runtime
   * @param delayTime delayTime read from a file
   */
  public Event(long delayTime) {
    this.delayTime = delayTime;
    start();
  }

  /**
   * Prints out the String representation of the Event object and runs its action() method. Overrides from Runnable
   * class run() method
   */
  @Override
  public void run() {
    try {
      System.out.println(this);
      action();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Calculates the eventTime of the event by adding delayTime to System time at runtime
   */
  public void start() { // Allows restarting
    eventTime = System.currentTimeMillis() + delayTime;
  }

  /**
   * Returns boolean true/false if eventTime reaches or is over current System time
   * @return boolean true/false for eventTime
   */
  public boolean ready() {
    return System.currentTimeMillis() >= eventTime;
  }

  /**
   * Abstract method to implement Event actions
   */
  public abstract void action();

  /** Method to set eventTime variable
   * @param eventTime passes in new eventTime variable to set */
  public void setEventTime(long eventTime) {
    this.eventTime = eventTime;
  }

  /**
   * Returns the eventTime
   * @return eventTime
   */
  public long getEventTime() {
    return eventTime;
  }

  /** Method to return delayTime variable
   * @return returns delayTime variable */
  public long getDelayTime() {
    return delayTime;
  }

} ///:~
