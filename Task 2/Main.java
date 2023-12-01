package secondTask;

import javax.swing.SwingUtilities;

// The Main class extends the DisplayGrade class
public class Main extends DisplayGrade {

    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure that the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Call the screen method to create and display the GUI
                screen();
            }
        });
    }
}