package thirdTask;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.*;

public class Balance {

	// Static variable to hold the balance
	static int balance = (int)(Math.random() * 1000) + 1;

	public static void screen() {
		// Create a new JFrame with the title "ATM Machine-Balance!"
		JFrame layout = new JFrame("ATM Machine-Balance!");
		// Set the operation that happens when the user closes the JFrame
		layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a panel with a background image
		JPanel backgroundPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Load the background image
				ImageIcon icon = new ImageIcon(getClass().getResource("StartPage1.jpeg"));
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

		// Create a JLabel for the welcome text
		JLabel welcomeText = new JLabel("Welcome Wahid!");
		welcomeText.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeText.setForeground(Color.WHITE);
		welcomeText.setOpaque(true);
		welcomeText.setBackground(Color.GRAY); // Gray background
		welcomeText.setFont(new Font("Arial", Font.PLAIN, 30)); // Set the font of the welcome text

		// Create a JLabel to display the balance
		JLabel balanceLabel = new JLabel("Your balance is $" + balance);
		balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		balanceLabel.setForeground(Color.WHITE);
		balanceLabel.setOpaque(true);
		balanceLabel.setBackground(Color.GRAY); // Gray background
		balanceLabel.setFont(new Font("Arial", Font.PLAIN, 30)); // Set the font of the balance label

		// Create a JButton for the "Withdraw" action
		JButton withdrawButton = new JButton("Withdraw");
		withdrawButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Call the withdraw method when the button is clicked
				withdraw();
			}
		});

		// Create a JButton for the "Deposit" action
		JButton depositButton = new JButton("Deposit");
		depositButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Call the deposit method when the button is clicked
				deposit();
			}
		});

		// Create a JButton for the "Check Balance" action
		JButton checkBalanceButton = new JButton("Check Balance");
		checkBalanceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Call the checkBalance method when the button is clicked
				checkBalance();
			}
		});

		// Create a GridBagConstraints for the layout
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Add the components to the overlay panel
		overlayPanel.add(welcomeText, gbc);
		overlayPanel.add(Box.createRigidArea(new Dimension(0, 20)), gbc); // Add some space
		overlayPanel.add(balanceLabel, gbc);
		overlayPanel.add(Box.createRigidArea(new Dimension(0, 20)), gbc); // Add some space
		overlayPanel.add(withdrawButton, gbc);
		overlayPanel.add(Box.createRigidArea(new Dimension(0, 20)), gbc); // Add some space
		overlayPanel.add(depositButton, gbc);
		overlayPanel.add(Box.createRigidArea(new Dimension(0, 20)), gbc); // Add some space
		overlayPanel.add(checkBalanceButton, gbc);

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

	public static void withdraw() {
		JFrame withdrawFrame = new JFrame("Withdraw");
		withdrawFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		withdrawFrame.setSize(400, 300); // Set the size of the frame
		withdrawFrame.setLocationRelativeTo(null); // Center the frame

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding to the panel

		JLabel label = new JLabel("How much you want to withdraw?");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setFont(new Font("Arial", Font.BOLD, 16)); // Change the font of the label

		// Create a ButtonGroup for the radio buttons
		ButtonGroup group = new ButtonGroup();

		// Create radio buttons for the amounts $10, $20, $50, and $100
		JRadioButton tenButton = createRadioButton("$10", group);
		JRadioButton twentyButton = createRadioButton("$20", group);
		JRadioButton fiftyButton = createRadioButton("$50", group);
		JRadioButton hundredButton = createRadioButton("$100", group);

		// Add the radio buttons to the panel
		panel.add(tenButton);
		panel.add(twentyButton);
		panel.add(fiftyButton);
		panel.add(hundredButton);

		JTextField textField = new JTextField(2);
		textField.setMaximumSize(new Dimension(200, 30));
		textField.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton button = new JButton("Confirm");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setFont(new Font("Arial", Font.BOLD, 14)); // Change the font of the button
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int amount;
				if (tenButton.isSelected()) {
					amount = 10;
				} else if (twentyButton.isSelected()) {
					amount = 20;
				} else if (fiftyButton.isSelected()) {
					amount = 50;
				} else if (hundredButton.isSelected()) {
					amount = 100;
				} else {
					amount = Integer.parseInt(textField.getText());
				}
				if (amount > 200) {
					JOptionPane.showMessageDialog(withdrawFrame, "You can only withdraw up to $200.");
				} else {
					balance -= amount; 
					if (balance < 0) {
						JOptionPane.showMessageDialog(withdrawFrame, "Insufficient balance. Please try again.");
						balance += amount; // Revert the balance
					} else {
						JOptionPane.showMessageDialog(withdrawFrame, "You have withdrawn $" + amount);
						withdrawFrame.dispose();
					}
				}
			}
		});

		panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space between the radio buttons and the text field
		panel.add(textField);
		panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space between the text field and the button
		panel.add(button);

		withdrawFrame.add(panel);
		withdrawFrame.setVisible(true);
	}

	private static JRadioButton createRadioButton(String text, ButtonGroup group) {
		JRadioButton radioButton = new JRadioButton(text);
		radioButton.setFont(new Font("Arial", Font.PLAIN, 14)); // Change the font of the radio button
		radioButton.setAlignmentX(Component.LEFT_ALIGNMENT); // Align the radio button to the left
		radioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// Change the background color when the mouse enters the radio button
				radioButton.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// Change the background color back when the mouse exits the radio button
				radioButton.setBackground(UIManager.getColor("RadioButton.background"));
			}
		});
		group.add(radioButton);
		return radioButton;
	}


	public static void deposit() {
		// Create a new JFrame with the title "Deposit"
		JFrame depositFrame = new JFrame("Deposit");
		// Set the operation that happens when the user closes the JFrame
		depositFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		depositFrame.setSize(400, 300); // Set the size of the frame
		depositFrame.setLocationRelativeTo(null); // Center the frame

		// Create a JPanel with a BoxLayout
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding to the panel

		// Create a JLabel for the instruction text
		JLabel label = new JLabel("How much you want to deposit?");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setFont(new Font("Arial", Font.BOLD, 16)); // Change the font of the label

		// Create a JTextField for the user to input the deposit amount
		JTextField textField = new JTextField(2);
		textField.setMaximumSize(new Dimension(200, 30));
		textField.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Create a JButton for the user to confirm their input
		JButton button = new JButton("Confirm");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setFont(new Font("Arial", Font.BOLD, 14)); // Change the font of the button
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Parse the input amount as an integer
				int amount = Integer.parseInt(textField.getText());
				// Add the amount to the balance
				balance += amount; 
				// Show a message dialog confirming the deposit
				JOptionPane.showMessageDialog(depositFrame, "You have deposited $" + amount);
				// Dispose the JFrame
				depositFrame.dispose();
			}
		});

		panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space between the label and the text field
		panel.add(label);
		panel.add(textField);
		panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space between the text field and the button
		panel.add(button);

		depositFrame.add(panel);
		depositFrame.setVisible(true);
	}

	public static void checkBalance() {
		// Create a new JFrame with the title "ATM Machine-Balance!"
		JFrame layout = new JFrame("ATM Machine-Balance!");
		// Set the operation that happens when the user closes the JFrame
		layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a panel with a background image
		JPanel backgroundPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Load the background image
				ImageIcon icon = new ImageIcon(getClass().getResource("StartPage1.jpeg")); 
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

		// Create a JLabel for the welcome text
		JLabel welcomeText = new JLabel("Welcome Wahid!");
		welcomeText.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeText.setForeground(Color.WHITE);
		welcomeText.setOpaque(true);
		welcomeText.setBackground(Color.GRAY); // Gray background
		welcomeText.setFont(new Font("Arial", Font.PLAIN, 30)); // Set the font of the welcome text

		// Create a JLabel to display the balance
		JLabel balanceLabel = new JLabel("Your balance is $" + balance);
		balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		balanceLabel.setForeground(Color.WHITE);
		balanceLabel.setOpaque(true);
		balanceLabel.setBackground(Color.GRAY); // Gray background
		balanceLabel.setFont(new Font("Arial", Font.PLAIN, 30)); // Set the font of the balance label

		// Create a JButton for the "Withdraw" action
		JButton withdrawButton = new JButton("Withdraw");
		withdrawButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Call the withdraw method when the button is clicked
				withdraw();
			}
		});

		// Create a JButton for the "Deposit" action
		JButton depositButton = new JButton("Deposit");
		depositButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Call the deposit method when the button is clicked
				deposit();
			}
		});

		// Create a JButton for the "Check Balance" action
		JButton checkBalanceButton = new JButton("Check Balance");
		checkBalanceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Call the checkBalance method when the button is clicked
				checkBalance();
			}
		});

		// Create a GridBagConstraints for the layout
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Add the components to the overlay panel
		overlayPanel.add(welcomeText, gbc);
		overlayPanel.add(Box.createRigidArea(new Dimension(0, 20)), gbc); // Add some space
		overlayPanel.add(balanceLabel, gbc);
		overlayPanel.add(Box.createRigidArea(new Dimension(0, 20)), gbc); // Add some space
		overlayPanel.add(withdrawButton, gbc);
		overlayPanel.add(Box.createRigidArea(new Dimension(0, 20)), gbc); // Add some space
		overlayPanel.add(depositButton, gbc);
		overlayPanel.add(Box.createRigidArea(new Dimension(0, 20)), gbc); // Add some space
		overlayPanel.add(checkBalanceButton, gbc);

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
