/**
 * title: Gui.java
 * description: Demonstrates GUI building and logic implementation through the GUI
 * date: August 17, 2023
 * ID# 3605866
 * @author This program contains code implemented by Mark Cawili for the TME4 assignment.
 * The original author of the GreenhouseControls class can be found in documentation of GreenhouseControls
 * @version 1.0
 * @copyright 2023 Mark Cawili
 */

/**
 * DOCUMENTATION...
 */

/**
 * GUI for Greenhouse Controls program
 *
 * Purpose and Description
 *
 * Part 2: GUI (45%)
 *
 * This part aims to develop a Graphical User Interface used to control a GreenhouseControls object. You are free to
 * design the layout of the interface. In case you are not sure you may develop the interface that looks like this,
 * this or this. The minimum number of components and their functionalities of the GUI are:
 *
 * 1. Each window of the GUI must have a scrollable text area, a set of 5 buttons, a pulldown menu and a popup menu.
 *
 * 2. The pulldown menu consists of the following sub menus:
 *
 * New window - creates a new GUI window. The new GUI window should associate with another GreenhouseControls object.
 *
 * Close window - closes the current window. If the GreenhouseControls object is running, a warning message should be
 * displayed to ask the user to confirm closing of the window. If the current window is the only window opened, exit
 * the application.
 *
 * Open Events - opens an events file. It should bring up a file dialog and let the user chooses an event file. If the
 * chosen file is not a valid event file, display an appropriate error message.
 *
 * Restore - opens a dump.out file and restore the GreenhouseControls object. It should bring up a file dialog and let
 * the user choose a dump.out file. If the chosen file is not a valid dump.out file, display an appropriate error
 * message. This option should be disabled if the GreenhouseControls is running.
 *
 * Exit - exit the application. If any of the opened GUIs is running a GreenhouseControls object, display a warning
 * message to ask the user to confirm the exit.
 *
 * Associate a keyboard shortcut with each of the above menu items.
 *
 * 3. The buttons:
 *
 * Start - start to run a GreenhouseControls object. This button should be disabled if the GreenhouseControls object
 * is running.
 *
 * Restart - add a Restart object to rerun the current event file. This button should be disabled if no events file is
 * read, or if the GreenhouseControls object is running.
 *
 * Terminate - add a Terminate event to the running GreenhouseControls object. It should bring up a dialog to prompt
 * for the delay time in milliseconds. This button should be disabled if the GreenhouseControls object is not running.
 *
 * Suspend - suspends all running event threads. This button should be disabled if the GreenhouseControls object is not
 * running.
 *
 * Resume - resume all suspended event threads. This button should be disabled if the GreenhouseControls object is
 * running.
 *
 * 4. The popup menu should contain the following 5 submenus: Start, Restart, Terminate, Suspend, and Resume, with the
 * same functionalities as the buttons.
 *
 * 5. In addition to the above components, you are free to add as many components as necessary to make the GUI look
 * nice.
 *
 * Compiling and running instructions
 * Change to the directory continuing the source code.
 * Compile:         javac Gui.java
 * Run:             java Gui
 *
 */

/**
 * This program utilizes class GreenhouseControls.java, Controller.java, and Event.java written by another author.
 * Extended documentation on these classes and their subclasses will be provided
 *
 * Classes
 *
 * public class Gui implements ActionListener
 * public (primary) class for this program, implements ActionListener
 *
 * public class CustomOutputStream extends OutputStream
 * primary public class for CustomOutputStream
 *
 * public class GreenhouseControls extends Controller implements Serializable
 * public (primary) class for this program, extends Controller and implements Serializable
 *
 * public static class Restore extends GreenhouseControls
 * primary class for Restore which extends GreenhouseControls
 *
 * public class FixWindow implements Fixable
 * public class for FixWindow which implements Fixable
 *
 * public class PowerOn implements Fixable
 * public class for PowerOn which implements Fixable
 *
 * public class WindowMalfunction extends Event
 * public class for WindowMalfunction which extends Event
 *
 * public class PowerOut extends Event
 * public class for PowerOut which extends Event
 *
 * public class MyFormatter extends Formatter
 * public MyFormatter class which extends formatter which formats log record
 *
 * public class MyFilter implements Filter
 * public MyFilter class which implements Filter
 *
 * public class ControllerException extends Exception
 * public ControllerException class which extends Exception, represents custom exception
 *
 * public class FansOn extends Event
 * public class FansOn which extends Event
 *
 * public class FansOff extends Event
 * public class FansOff which extends Event
 *
 * public class Bell extends Event
 * public class for Bell which extends public class Event
 *
 * public class Restart extends Event
 * public class for Restart which extends Event
 *
 * public class Controller
 * public class for Controller
 *
 * public class Event
 * public class for Event implements Serializable and Runnable
 *
 * public interface Fixable
 * Interface for fixable objects, implemented by fixable events
 *
 * public class LightOff extends Event
 * primary public class for LightOff
 *
 * public class LightOn extends Event
 * primary public class for LightOn
 *
 * public class Terminate extends Event
 * primary public class for Terminate
 *
 * public class ThermostatDay extends Event
 * primary public class for ThermostatDay
 *
 * public class ThermostatNight extends Event
 * primary public class for ThermostatNight
 *
 * public class WaterOff extends Event
 * primary public class for WaterOff
 *
 * public class WaterOn extends Event
 * primary public class for WaterOn
 *
 * public class TwoTuple<K, V> implements Seri
 * primary public class for TwoTuple
 *
 * Gui methods
 *
 * public Gui(GreenhouseControls gc)
 * Constructor for Gui, sets up Gui
 *
 * private void executeInBackground(Runnable task)
 * SwingWorker to execute logic threads in the background
 *
 * void rightClickEvent(MouseEvent e)
 * Shows the menu where user right clicks
 *
 * void txtFileDialog()
 * Runs event when a text file is chosen post browse button press
 *
 * void outFileDialog()
 * Runs event when a .out file is chosen when restore window item button is pressed
 *
 * void terminateAction()
 * Runs event when terminate button is pressed
 *
 * void startAction()
 * Runs event when start button is pressed
 *
 * void restartAction()
 * Runs event when restart button is pressed
 *
 * void suspendAction()
 * Runs event when suspend button is pressed
 *
 * void resumeAction()
 * Runs event when resume button is pressed
 *
 * void initialButtons()
 * Sets functionality of buttons at initial program
 *
 * void postButtons()
 * Sets functionality of buttons post initial program run
 *
 * void postDump()
 * Runs event after restore event has been run
 *
 * public void actionPerformed(ActionEvent e)
 * ActionListener method, passes in ActionEvent objects, loops through different event scenarios
 *
 * public static void main(String[] args)
 * Main method for this program, starts the Gui
 *
 * CustomOutputStream methods
 *
 * public CustomOutputStream(JTextArea textArea)
 * Constructor initializes CustomOutputStream objects with a JTextArea
 *
 * public void write(int b) throws IOException
 * Writes console output onto GUI JTextArea
 *
 * GreenhouseControls methods
 *
 * public GreenhouseControls()
 * Constructor initializes events and state variables to TwoTuple stateVariables
 *
 * public static GreenhouseControls getEventObject()
 * Method that returns original event object
 *
 * public static GreenhouseControls getRestoredEventObject()
 * Method that returns restored event object
 *
 * public List<Event> getRestoredEventList()
 * Returns the restoredEventList
 *
 * public void setEventObject(GreenhouseControls gc)
 * Sets GreenhouseControls object to passed GreenhouseControls object
 *
 * public void setRestoredEventObject(GreenhouseControls object)
 * Sets the restoredEventObject to the passed in GreenhouseControls object
 *
 * Returns the value to the desired key from the TwoTuple list
 * public Object getVariable(String event)
 *
 * Sets the value to the desired key from the TwoTuple list
 * public synchronized void setVariable(String event, Object status)
 *
 * public int getErrorCode()
 * Method that returns errorcode variable for error identification
 *
 * public Fixable getFixable(int errorCode)
 * Method that takes parameter errorcode and returns appropriate Fixable class object
 *
 * public void shutdown()
 * Method that prints out log information for causing error and implements steps to serialize the GreenhouseControls
 * object
 *
 * private void serialize()
 * Method that serializes the GreenhouseControls object
 *
 * public static void printUsage()
 * Prints out correct use format for incorrect console arguments
 *
 * public Event createEvent(String eventName, long delayTime) throws Exception
 * Creates new events
 *
 * public static void main(String[] args)
 * Main method for this class
 *
 * Restore methods
 *
 * public Restore(String file)
 * Constructor for Restore which de serializes the object and calls appropriate fix() and log() methods of the
 * Fixable object derived from error code of the restoredEventObject
 *
 * FixWindow methods
 *
 * public void fix()
 * Method which fixes the running events by resetting the errorcode and setting error variable to true
 *
 * public void log()
 * Method which logs the appropriate fix
 *
 * PowerOn methods
 *
 * public void fix()
 * Method which fixes the running events by resetting the errorcode and setting error variable to true
 *
 * public void log()
 * Method which logs the appropriate fix
 *
 * WindowMalfunction methods
 *
 * public WindowMalfunction(long delayTime)
 * Constructor for WindowMalfunction to set up objects
 *
 * public void action()
 * Method that sets window variable to false for error and sets errocode, calls shutdown() method
 *
 * public String toString()
 * Method that returns String message of the object
 *
 * PowerOut methods
 *
 * public PowerOut(long delayTime)
 * Constructor for PowerOut to set up objects
 *
 * public void action()
 * Method that sets power variable to false for error and sets errocode, calls shutdown() method
 *
 * public String toString()
 * Method that returns String message of the object
 *
 * MyFormatter methods
 *
 * public String format(LogRecord record)
 * Method that formats log messages and returns it
 *
 * MyFilter methods
 *
 * public boolean isLoggable(LogRecord log)
 * Method that sets loggable variable
 *
 * ControllerException methods
 *
 * public ControllerException(String message)
 * Constructor for ControllerException,takes String message as parameter to pass through
 *
 * FansOn methods
 *
 * public FansOn(long delayTime)
 * Constructor for FansOn which represents FansOn events
 *
 * public void action()
 * Method which sets fans variable to true
 *
 * public String toString()
 * Method that returns String message of the object
 *
 * FansOff methods
 *
 * public FansOff(long delayTime)
 * Constructor for FansOff which represents FansOff events
 *
 * public void action()
 * Method which sets fans variable to false
 *
 * public String toString()
 * Method that returns String message of the object
 *
 * Bell methods
 *
 * public Bell(long delayTime,int rings)
 * Constructor for Bell, takes delayTime and rings as arguments to set up Bell objects
 *
 * public String toString()
 * Method that returns the String representation of the Bell class
 *
 * Restart methods
 *
 * public Restart(long delayTime, String filename, GreenhouseControls gc)
 * Constructor initializes Restart objects with delayTime, reads from filename, and passes in GreenhouseControls
 * object
 *
 * public void action()
 * Method that reads console argument file input and utilizes regular expression to splice file contents based on
 * the desired events
 *
 * public String toString()
 * Returns String representation of Restart objects
 *
 * Controller methods
 *
 * public void suspend()
 * Suspends the running thread; variable suspended set to true and isRunning to false, initializes suspendedTime
 * to current time at suspension and prints out statement
 *
 * public synchronized void resume()
 * Resumes the running thread; variable suspended set to false and isRunning to true, initializes resumeTime
 * to current time at resumption and calculates the suspendedDuration time. Loops through events in eventList and
 * updates eventTime with added suspendedDuration. Prints out statement and wakes all threads
 *
 * public boolean getRunning()
 * Returns isRunning boolean true/false
 *
 * public boolean getSuspended()
 * Returns suspended boolean true/false
 *
 * public void addEvent(Event event)
 * Adds event to eventList
 *
 * public void shutdown()
 * Prints out statement closing controls
 *
 * public List<Event> getEventList()
 * Method to return the eventList List variable
 *
 * public void setEventList(List<Event> eventList)
 * Method to set the eventList List variable from another List
 *
 * public void run()
 * Sets isRunning to true, utilizes ExecutorService to manage a thread pool of Event objects. If suspended, thread
 * pool execution is paused, otherwise, loops through eventList with the executor and runs the run() method of Event
 * for each event then removes the event from the list. Shuts down executor and sets isRunning to false.
 *
 * Event methods
 *
 * public Event(long delayTime)
 * Initializes Event objects with a delayTime and calculates eventTime for runtime
 *
 * public void run()
 * Prints out the String representation of the Event object and runs its action() method. Overrides from Runnable
 * class run() method
 *
 * public void start()
 * Calculates the eventTime of the event by adding delayTime to System time at runtime
 *
 * public boolean ready()
 * Returns boolean true/false if eventTime reaches or is over current System time
 *
 * public abstract void action()
 * Abstract method to implement Event actions
 *
 * public long getEventTime()
 * Returns the eventTime
 *
 * public void setEventTime(long eventTime)
 * Method to set eventTime variable
 *
 * public long getDelayTime()
 * Method to return delayTime variable
 *
 * Fixable methods
 *
 * void fix();
 * turns Power on, fix window and zeros out error codes
 *
 * void log()
 * logs to a text file in the current directory called fix.log; prints to the console, and identify time and nature of
 * the fix
 *
 * LightOff methods
 *
 * public LightOff(long delayTime)
 * Constructor initiates LightOff objects with a delayTime
 *
 * public String toString()
 * Method to return String representation of LightOff objects
 *
 * public void action()
 * Sets Light variable to false for off
 *
 * LightOn methods
 *
 * public LightOn(long delayTime)
 * Constructor initiates LightOn objects with a delayTime
 *
 * public void action()
 * Sets Light variable to true for on
 *
 * public String toString()
 * Returns String representation of LightOn objects
 *
 * Terminate methods
 *
 * public Terminate(long delayTime)
 * Constructor initializes Terminate objects with a delayTime
 *
 * public void action()
 * Clears the eventList and prints out a space
 *
 * public String toString()
 * Returns String representation of Terminate objects
 *
 * ThermostatDay methods
 *
 * public ThermostatDay(long delayTime)
 * Constructor initiates ThermostatDay objects with a delayTime
 *
 * public void action()
 * Sets variable thermostat to Day
 *
 * public String toString()
 * Returns String representation of ThermostatDay objects
 *
 * ThermostatNight methods
 *
 * public ThermostatNight(long delayTime)
 * Constructor initiates ThermostatNight objects with a delayTime
 *
 * public void action()
 * Sets thermostat variable to Night
 *
 * public String toString()
 * Return String representation of ThermostatNight objects
 *
 * WaterOn methods
 *
 * public WaterOn(long delayTime)
 * Constructor initializes WaterOn objects with a delayTime
 *
 * public void action()
 * Sets water variable to true for on
 *
 * public String toString()
 * Returns String representation of WaterOn objects
 *
 * WaterOff methods
 *
 * public WaterOff(long delayTime)
 * Constructor initializes WaterOff objects with a delayTime
 *
 * public void action()
 * Sets water variable to false for off
 *
 * public String toString()
 * Returns String representation of WaterOff objects
 *
 * TwoTuple methods
 *
 * public TwoTuple(K event, V status)
 * Constructor initializes events and status from passed parameters
 *
 * public String toString()
 * Returns String representation of event, status TwoTuple
 *
 * public K getEvent()
 * Returns the event stored
 *
 * public V getStatus()
 * Returns the status of the event paired
 *
 * public void setStatus(V value)
 * Sets the status of the event paired
 *
 * Gui Instance Variables
 *
 * private GreenhouseControls gc - Private GreenhouseControls to hold variable gc
 * private final JButton fileButton - Private final JButton to hold variable fileButton
 * private final JButton startButton - Private final JButton to hold variable startButton
 * private final JButton terminateButton - Private final JButton to hold variable terminateButton
 * private final JButton suspendButton - Private final JButton to hold variable suspendButton
 * private final JButton resumeButton - Private final JButton to hold variable resumeButton
 * private final JButton restartButton - Private final JButton to hold variable restartButton
 * private final JMenuItem startMenu - Private final JMenuItem to hold variable startMenu
 * private final JMenuItem terminateMenu - Private final JMenuItem to hold variable terminateMenu
 * private final JMenuItem restartMenu - Private final JMenuItem to hold variable restartMenu
 * private final JMenuItem suspendMenu - Private final JMenuItem to hold variable suspendMenu
 * private final JMenuItem resumeMenu - Private final JMenuItem to hold variable resumeMenu
 * private final JMenuItem openEventsWindowItem - Private final JMenuItem to hold variable openEventsWindowItem
 * private final JMenuItem restoreWindowItem - Private final JMenuItem to hold variable restoreWindowItem
 * private final JFrame frame - Private final JFrame to hold variable frame
 * private final JTextField fileNameText - Private final JTextField to hold variable fileNameText
 * private final JPopupMenu rightClick - Private final JPopupMenu to hold variable rightClick
 * private JTextArea textArea - Private final JTextArea to hold variable textArea
 *
 * CustomOutputStream Instance Variables
 *
 * private JTextArea textArea - private JTextArea to hold variable textArea
 *
 * GreenhouseControls Instance Variables
 *
 * private static final long serialVersionUID - Holds the serial ID of the class
 * private List<Event> restoredEventList - List<Event> variable restoredEventList to hold remaining events in original
 * list before serialization
 * private final List<TwoTuple<String, Object>> stateVariables - private List<TwoTuple<String,Object> to hold variable
 * stateVariables
 * private static GreenhouseControls restoredEventObject - GreenhouseControls variable restoredEventObject to hold
 * de-serialized event object
 * private static GreenhouseControls eventObject - GreenhouseControls variable eventObject to hold original event object
 * before serialization
 *
 * Restore Instance Variables
 *
 * protected GreenhouseControls restoredEvents;
 * protected GreenhouseControls variable restoredEvents which holds the deserialized object
 *
 * Bell Instance Variables
 *
 * protected final int rings;
 * variable to store int rings for Bell events
 *
 * Controller Instance Variables
 *
 * private boolean isRunning - private boolean to hold variable isRunning to determine if program is running
 * private boolean suspended - private boolean to hold variable suspended initialized to false
 * private long suspendedTime - private long to hold variable suspendedTime for time between program suspension and
 * resumption
 * private List<Event> eventList - private List<Event> to hold variable eventList which stores read events from a file
 *
 * Event Instance Variables
 *
 * private variable eventTime to store event time at runtime - private long eventTime
 * protected final long delayTime - protected variable delayTime for event delayTime read from file
 *
 * Restart Instance Variables
 *
 * GreenhouseControls gc - Variable gc for GreenhouseControls object initialized to null
 *
 * TwoTuple Instance Variables
 *
 * private final K event - variable K to hold events
 * private V status - variable V to hold the status of events
 *
 */

/**
 * CODE
 */

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.PrintStream;

/**
 * primary public class Gui implementing ActionListener
 */
public class Gui implements ActionListener {

    /**
     * Private GreenhouseControls to hold variable gc
     */
    private GreenhouseControls gc;

    /**
     * Private final JButton to hold variable fileButton
     */
    private final JButton fileButton;

    /**
     * Private final JButton to hold variable startButton
     */
    private final JButton startButton;

    /**
     * Private final JButton to hold variable terminateButton
     */
    private final JButton terminateButton;

    /**
     * Private final JButton to hold variable suspendButton
     */
    private final JButton suspendButton;

    /**
     * Private final JButton to hold variable resumeButton
     */
    private final JButton resumeButton;

    /**
     * Private final JButton to hold variable restartButton
     */
    private final JButton restartButton;

    /**
     * Private final JMenuItem to hold variable startMenu
     */
    private final JMenuItem startMenu;

    /**
     * Private final JMenuItem to hold variable terminateMenu
     */
    private final JMenuItem terminateMenu;

    /**
     * Private final JMenuItem to hold variable restartMenu
     */
    private final JMenuItem restartMenu;

    /**
     * Private final JMenuItem to hold variable suspendMenu
     */
    private final JMenuItem suspendMenu;

    /**
     * Private final JMenuItem to hold variable resumeMenu
     */
    private final JMenuItem resumeMenu;

    /**
     * Private final JMenuItem to hold variable openEventsWindowItem
     */
    private final JMenuItem openEventsWindowItem;

    /**
     * Private final JMenuItem to hold variable restoreWindowItem
     */
    private final JMenuItem restoreWindowItem;

    /**
     * Private final JFrame to hold variable frame
     */
    private final JFrame frame;

    /**
     * Private final JTextField to hold variable fileNameText
     */
    private final JTextField fileNameText;

    /**
     * Private final JPopupMenu to hold variable rightClick
     */
    private final JPopupMenu rightClick;

    /**
     * Private final JTextArea to hold variable textArea
     */
    private JTextArea textArea;

    /**
     * Constructor for Gui, sets up Gui
     * @param gc passes in a GreenhouseControls object
     */
    public Gui(GreenhouseControls gc) {

        this.gc = gc;
        //JPanel = a GUI component that functions as a container to hold other components
        JPanel panel = new JPanel();

        //LayoutManager = Defines natural layout for components within a container
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        //JFrame = a GUI window to add components to
        frame = new JFrame();
        frame.setTitle("Greenhouse Controls");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(650, 400);
        //Action on window close
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                boolean isRunning = gc.getRunning();

                if (isRunning) {
                    int warning = JOptionPane.showConfirmDialog(frame, "GreenhouseControls is running. Are " +
                                    "you sure you want to exit the program?", "Confirm close",
                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                    if (warning == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                } else {
                    System.exit(0);
                }
            }
        });

        //JLabel = a GUI display area for a string of text, image, or both
        JLabel fileNameLabel = new JLabel("Events File:");
        fileNameLabel.setBounds(10,20,300,20);
        panel.add(fileNameLabel);

        //Adds text field box
        fileNameText = new JTextField();
        fileNameText.setBounds(90,20,300,20);
        //Updates buttons based on fileNameText field
        fileNameText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateBrowseButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateBrowseButton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateBrowseButton();
            }

            /**
             * updates buttons on browse button file choose
             */
            private void updateBrowseButton() {
                String fileName = fileNameText.getText();
                boolean isTxtFile = fileName.endsWith(".txt");
                boolean isOutFile = fileName.endsWith(".out");
                boolean enabledBrowse = !fileName.isEmpty() && isTxtFile;
                boolean disableRestart = !fileName.isEmpty() && isOutFile;

                if (enabledBrowse) {
                    startButton.setEnabled(enabledBrowse);
                    startMenu.setEnabled(enabledBrowse);
                }

                if (disableRestart) {
                    restartButton.setEnabled(false);
                    startButton.setEnabled(false);
                    startMenu.setEnabled(false);
                    openEventsWindowItem.setEnabled(false);
                    restoreWindowItem.setEnabled(false);
                }

            }
        });
        panel.add(fileNameText);

//----------------------------------------------------------------------------------------------------------------------

        //JTextArea = GUI component to add text area screen
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(10,40,630,220);
        textArea.setMargin(new Insets(10,10,10,10));   //borders
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

//        //CAN COMMENT/UNCOMMENT TO SEE EXCEPTIONS IN CONSOLE//
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
        System.setOut(printStream);
        System.setErr(printStream);

        panel.add(textArea);

        //JScrollPane = GUI component for scroll pane. Handles own events and performs own scrolling
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(10,50,630,220);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scroll);

//----------------------------------------------------------------------------------------------------------------------

        //Buttons

        startButton = new JButton("Start");
        startButton.setBounds(25, 280, 100, 60);
        startButton.addActionListener(e -> startAction());
        startButton.setEnabled(false);
        panel.add(startButton);

        restartButton = new JButton("Restart");
        restartButton.setBounds(150, 280, 100, 60);
        restartButton.addActionListener(e -> restartAction());
        restartButton.setEnabled(false);
        panel.add(restartButton);

        terminateButton = new JButton("Terminate");
        terminateButton.setBounds(275,280,100,60);
        terminateButton.addActionListener(e -> terminateAction());
        terminateButton.setEnabled(false);
        panel.add(terminateButton);

        suspendButton = new JButton("Suspend");
        suspendButton.setBounds(400, 280, 100, 60);
        suspendButton.addActionListener(e -> suspendAction());
        suspendButton.setEnabled(false);
        panel.add(suspendButton);

        resumeButton = new JButton("Resume");
        resumeButton.setBounds(525, 280, 100, 60);
        resumeButton.addActionListener(e -> resumeAction());
        resumeButton.setEnabled(false);
        panel.add(resumeButton);

        //Button for file chooser
        fileButton = new JButton("Browse");
        fileButton.setBounds(390,15,100,30);
        fileButton.addActionListener(this);
        panel.add(fileButton);

//----------------------------------------------------------------------------------------------------------------------

        //JPopupMenu

        rightClick = new JPopupMenu();
        //identify the content pane so method can be applied to it (rclick)
        Container container = frame.getContentPane();

        container.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                rightClickEvent(e);
            }
        });

        startMenu = new JMenuItem("Start");
        startMenu.addActionListener(e -> startAction());
        startMenu.setEnabled(false);
        rightClick.add(startMenu);

        restartMenu = new JMenuItem("Restart");
        restartMenu.addActionListener(e -> restartAction());
        restartMenu.setEnabled(false);
        rightClick.add(restartMenu);

        rightClick.addSeparator();

        terminateMenu = new JMenuItem("Terminate");
        terminateMenu.addActionListener(e -> terminateAction());
        terminateMenu.setEnabled(false);
        rightClick.add(terminateMenu);

        rightClick.addSeparator();

        suspendMenu = new JMenuItem("Suspend");
        suspendMenu.addActionListener(e -> suspendAction());
        suspendMenu.setEnabled(false);
        rightClick.add(suspendMenu);

        resumeMenu = new JMenuItem("Resume");
        resumeMenu.addActionListener(e -> resumeAction());
        resumeMenu.setEnabled(false);
        rightClick.add(resumeMenu);

//----------------------------------------------------------------------------------------------------------------------

        //Menu Bar

        //JMenuBar = a menu bar ; JMenu = a menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        //JMenuItem = Adds items to menu on menu bar
        JMenuItem newWindowItem = new JMenuItem("New window");
        newWindowItem.setMnemonic(KeyEvent.VK_N);  //N for new
        //New Gui with new GreenhouseControls object
        newWindowItem.addActionListener(e -> {
            Gui newGui = new Gui(new GreenhouseControls());
            newGui.frame.setVisible(true);
        });
        menu.add(newWindowItem);

        JMenuItem closeWindowItem = new JMenuItem("Close window");
        closeWindowItem.setMnemonic(KeyEvent.VK_C);   //C for close
        //Close window item event on click
        closeWindowItem.addActionListener(e -> {
            boolean isRunning = gc.getRunning();

            if (isRunning) {
                int warning = JOptionPane.showConfirmDialog(frame, "GreenhouseControls is running. Are " +
                        "you sure you want to close the window?", "Confirm close", JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                if (warning == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    gc.getEventList().clear();
                }
            } else {
                frame.dispose();
            }
        });
        menu.add(closeWindowItem);

        menu.addSeparator();

        openEventsWindowItem = new JMenuItem("Open Events File");
        openEventsWindowItem.setMnemonic(KeyEvent.VK_O);   //O for open
        openEventsWindowItem.addActionListener(this);
        menu.add(openEventsWindowItem);

        restoreWindowItem = new JMenuItem("Load Dump File");
        restoreWindowItem.setMnemonic(KeyEvent.VK_R);   //R for restore
        restoreWindowItem.addActionListener(this);
        menu.add(restoreWindowItem);

        menu.addSeparator();

        JMenuItem exitWindowItem = new JMenuItem("Exit");
        exitWindowItem.setMnemonic(KeyEvent.VK_E);   //E for exit
        //Exit window item on click
        exitWindowItem.addActionListener(e -> {
            boolean isRunning = gc.getRunning();

            if (isRunning) {
                int warning = JOptionPane.showConfirmDialog(frame, "GreenhouseControls is running. Are " +
                                "you sure you want to exit the program?", "Confirm close",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (warning == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            } else {
                System.exit(0);
            }
        });
        menu.add(exitWindowItem);

//----------------------------------------------------------------------------------------------------------------------

        //Add the panel to the frame, menu to frame, and set frame to visible
        frame.setJMenuBar(menuBar);
        frame.add(panel);
        frame.setVisible(true);

    } // end of Gui constructor

//----------------------------------------------------------------------------------------------------------------------

    /**
     * SwingWorker to execute logic threads in the background
     * @param task Runnable object
     */
    private void executeInBackground(Runnable task) {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                task.run();
                return null;
            }
        };
        worker.execute();
    }

    /**
     * Shows the menu where user right clicks
     * @param e MouseEvent, popup menu
     */
    void rightClickEvent(MouseEvent e) {
        if (e.isPopupTrigger()) {
            rightClick.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    /**
     * Runs event when a text file is chosen post browse button press
     */
    void txtFileDialog() {

        //JFileChooser = A GUI mechanism that lets user choose a file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a .txt file");
        fileChooser.setAcceptAllFileFilterUsed(false);  //not all files

        int response = fileChooser.showOpenDialog(null);

        //If file selection successful then set field text as file
        if (response == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null) {
                fileNameText.setText(selectedFile.getAbsolutePath());

                if (!fileChooser.getSelectedFile().getName().endsWith(".txt")) {
                    String errorMessage = "Incorrect file type, select a .txt file";
                    JOptionPane.showMessageDialog(fileChooser, errorMessage, "ERROR",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    /**
     * Runs event when a .out file is chosen when restore window item button is pressed
     */
    void outFileDialog() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a .out file");
        fileChooser.setAcceptAllFileFilterUsed(false);  //not all files

        int response = fileChooser.showOpenDialog(null);

        //If file selection successful then set field text as file
        if (response == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null) {
                fileNameText.setText(selectedFile.getAbsolutePath());

                if (fileChooser.getSelectedFile().getName().endsWith(".out")) {
                    openEventsWindowItem.setEnabled(false);
                    restoreWindowItem.setEnabled(false);

                    System.out.println("dump.out file loaded");
                    System.out.println();

                    executeInBackground(() -> {
                        gc.setEventObject(gc);
                        Restore restored = new Restore(fileNameText.getText());
                        restored.run();

                        SwingUtilities.invokeLater(this::postDump);
                    });
                } else {
                    String errorMessage = "Incorrect file type, select a .out file";
                    JOptionPane.showMessageDialog(fileChooser, errorMessage, "ERROR",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    /**
     * Runs event when terminate button is pressed
     */
    void terminateAction() {
        try {
            String terminateDelayTime = JOptionPane.showInputDialog("Please enter a delay time in msec");

                gc.setEventObject(gc);
                try {
                    gc.addEvent(gc.createEvent("Terminate", Integer.parseInt(terminateDelayTime)
                            - 1000));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

        } catch (Exception e) {
            System.out.println("Terminate cancelled");
        }
    }

    /**
     * Runs event when start button is pressed
     */
    void startAction() {
        initialButtons();

        executeInBackground(() -> {
            gc.setEventObject(gc);
            Restart restart = new Restart(0,fileNameText.getText(),gc);
            restart.action();
            gc.run();

            SwingUtilities.invokeLater(this::postButtons);  //method ref
        });
    }

    /**
     * Runs event when restart button is pressed
     */
    void restartAction() {
        initialButtons();

        executeInBackground(() -> {
            gc.setEventObject(gc);
            gc.getEventList().clear();
            System.out.println();
            Restart restart = new Restart(0,fileNameText.getText(),gc);
            restart.action();
            System.out.println(restart);
            gc.run();

            SwingUtilities.invokeLater(this::postButtons);  //method ref
        });
    }

    /**
     * Runs event when suspend button is pressed
     */
    void suspendAction() {
        gc.suspend();
        resumeButton.setEnabled(true);
        resumeMenu.setEnabled(true);
        suspendButton.setEnabled(false);
        suspendMenu.setEnabled(false);
    }

    /**
     * Runs event when resume button is pressed
     */
    void resumeAction() {
        gc.resume();
        resumeButton.setEnabled(false);
        resumeMenu.setEnabled(false);
        suspendButton.setEnabled(true);
        suspendMenu.setEnabled(true);
    }

    /**
     * Sets functionality of buttons at initial program run
     */
    void initialButtons() {
        startButton.setEnabled(false);
        startMenu.setEnabled(false);
        restoreWindowItem.setEnabled(false);
        suspendButton.setEnabled(true);
        suspendMenu.setEnabled(true);
        terminateButton.setEnabled(true);
        terminateMenu.setEnabled(true);
        restartButton.setEnabled(false);
        restartMenu.setEnabled(false);
        openEventsWindowItem.setEnabled(false);
    }

    /**
     * Sets functionality of buttons post initial program run
     */
    void postButtons() {
        startButton.setEnabled(true);
        startMenu.setEnabled(true);
        restoreWindowItem.setEnabled(true);
        suspendButton.setEnabled(false);
        suspendMenu.setEnabled(false);
        terminateButton.setEnabled(false);
        terminateMenu.setEnabled(false);
        restartButton.setEnabled(true);
        restartMenu.setEnabled(true);
        openEventsWindowItem.setEnabled(true);
    }

    /**
     * Runs event after restore event has been run
     */
    void postDump() {
        openEventsWindowItem.setEnabled(true);
        restoreWindowItem.setEnabled(true);
    }

    /**
     * ActionListener method, passes in ActionEvent objects, loops through different event scenarios
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fileButton) {
            txtFileDialog();
        } else if (e.getSource() == openEventsWindowItem) {
            txtFileDialog();
        } else if (e.getSource() == restoreWindowItem) {
            outFileDialog();
        }
    }

    /**
     * Main method for this program, starts the Gui
     * @param args
     */
    public static void main(String[] args) {
        new Gui(new GreenhouseControls());
    }

} // end of public class Gui
