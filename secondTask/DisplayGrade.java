package secondTask;

import java.awt.*;
import javax.swing.*;

// The DisplayGrade class extends the GradeAssign class
public class DisplayGrade extends GradeAssign {

    // The screen method creates and displays a GUI for student grades
    public static void screen() {
        // Create a new JFrame with the title "Student Grade!"
        JFrame screen = new JFrame("Student Grade!");

        // Create a JTextArea for the introduction message
        JTextArea textArea = new JTextArea("For this part, you will input your name at first and then you will input all of the grades "
                + "that you have taken in a specific subject, after completing the process, you will get "
                + "a table consisting your subject, your points and the average and the grade according to the criteria!");

        // Set the properties of the JTextArea
        textArea.setColumns(30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setSize(textArea.getPreferredSize().width, 1);
        textArea.setOpaque(false);
        textArea.setEditable(false);

        // Show the introduction message in a dialog box
        JOptionPane.showMessageDialog(null, textArea, "Title", JOptionPane.INFORMATION_MESSAGE);

        // Set the look and feel to Nimbus
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set the default close operation for the JFrame
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new JPanel with BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Get the student's name from the user
        String name = "";
        do {
            name = JOptionPane.showInputDialog("Input Your Name?");
            if (name == null) {
                System.exit(0);
            } else if (name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Kindly Input Your Name!");
            }
        } while (name == null || name.trim().isEmpty());

        // Create a new JLabel for the student's name
        JLabel StudentName = new JLabel(name);

        // Set the properties of the JLabel
        StudentName.setFont(new Font("Arial", Font.BOLD, 24));
        StudentName.setHorizontalAlignment(SwingConstants.CENTER);

        // Add the JLabel to the north region of the JPanel
        panel.add(StudentName, BorderLayout.NORTH);

        // Get the grades, average, and grade from the user
        int[] grades = numGrades();  
        int average = returnAVG(grades);  
        String grade = criteria(average); 

        // Create a two-dimensional array for the data of the JTable
        Object[][] data = new Object[10][4];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = subjects[i];
            data[i][1] = grades[i];  // Use the stored grades
            data[0][2] = average;
            data[0][3] = grade;
        }

        // Create a one-dimensional array for the column names of the JTable
        String[] columnNames = {"Subject", "Grade", "Average", "Mark"};

        // Create a new JTable with the data and column names
        JTable table = new JTable(data, columnNames);

        // Set the preferred size of the viewport for the JTable
        table.setPreferredScrollableViewportSize(table.getPreferredSize());

        // Create a JScrollPane and add the JTable to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the JScrollPane to the center region of the JPanel
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add the JPanel to the JFrame
        screen.add(panel);

        // Resize the JFrame to fit the preferred size of its components
        screen.pack();

        // Set the location of the JFrame to the center of the screen
        screen.setLocationRelativeTo(null);

        // Make the JFrame visible
        screen.setVisible(true);
    }
}
