package thirdTask;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class ATMMachine extends Balance {
	
	
    public static void start() {
    	
    	
        // Create a new JFrame with the title "ATM Machine"
        JFrame layout = new JFrame("ATM Machine");
        // Set the operation that happens when the user closes the JFrame
        layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel with a background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                ImageIcon icon = new ImageIcon(Balance.class.getResource("StartPage1.jpeg"));
                Image image = icon.getImage();
                // Draw the background image
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        // Create an overlay panel with a GridBagLayout
        JPanel overlayPanel = new JPanel();
        overlayPanel.setLayout(new GridBagLayout());
        overlayPanel.setOpaque(false);
        overlayPanel.setBackground(new Color(255, 255, 255, 64)); // Semi-transparent white background
        
        // Create a JLabel for the instruction text
        JLabel inText = new JLabel("Input your PIN to start the Machine!");
        inText.setAlignmentX(Component.CENTER_ALIGNMENT);
        inText.setForeground(Color.WHITE);
        inText.setOpaque(true);
        inText.setBackground(Color.GRAY); // Gray background
        
        // Create a JTextField for the user to input their PIN
        JTextField textField = new JTextField(2);
        textField.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField tf = (JTextField) input;
                String text = tf.getText();
                // Check if the input is a 4-digit number
                return text.matches("\\d{4}");
            }
        });
        textField.setMaximumSize(new Dimension(200, 30));
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setOpaque(true);
        textField.setBackground(Color.WHITE); // White background

        // Create a JButton for the user to confirm their input
        JButton button = new JButton("Confirm");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if the input is valid
                if (textField.getInputVerifier().verify(textField)) {
                    JOptionPane.showMessageDialog(layout, "Confirmed");
                    // Call the screen method of the Balance class
                    Balance.screen();
                } else {
                    JOptionPane.showMessageDialog(layout, "Please input 4 digits!");
                }
            }
        });
        button.setOpaque(true);
        button.setBackground(Color.GRAY); // Gray background
       
        // Set the font of the components
        inText.setFont(new Font("Arial", Font.PLAIN, 30));
        textField.setFont(new Font("Arial", Font.PLAIN, 30));
        button.setFont(new Font("Arial", Font.PLAIN, 30));
        
        // Create a GridBagConstraints for the layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add the components to the overlay panel
        overlayPanel.add(inText, gbc);
        overlayPanel.add(textField, gbc);
        overlayPanel.add(Box.createRigidArea(new Dimension(0, 20)), gbc); // Add some space
        overlayPanel.add(button, gbc);
        
        // Set the layout of the background panel and add the overlay panel to it
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(overlayPanel, BorderLayout.CENTER);
        // Add the background panel to the JFrame
        layout.add(backgroundPanel);
        // Load the ImageIcon again to get the dimensions of the image
        ImageIcon icon = new ImageIcon(Balance.class.getResource("StartPage1.jpeg"));
        // Set the size of the JFrame to match the image dimensions
        layout.setSize(icon.getIconWidth(), (icon.getIconHeight() - 400)); 
        // Make the JFrame visible
        layout.setVisible(true);
    }
}