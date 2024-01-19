import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

/**
 * primary public class for CustomOutputStream
 */
public class CustomOutputStream extends OutputStream {

    /**
     * private JTextArea to hold variable textArea
     */
    private JTextArea textArea;

    /**
     * Constructor initializes CustomOutputStream objects with a JTextArea
     * @param textArea textArea for GUI
     */
    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    /**
     * Writes console output onto GUI JTextArea
     * @param b   the {@code byte}.
     * @throws IOException
     */
    @Override
    public void write(int b) throws IOException {
        textArea.setText(textArea.getText() + (char) b);
        textArea.setCaretPosition(textArea.getDocument().getLength());
        textArea.update(textArea.getGraphics());
    }

} // end of public class CustomOutputStream
