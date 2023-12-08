package firstWeek;

import javax.swing.JOptionPane;

public class NumberGame {
	static int scoreOfWins = 0; 
	static int numberOfAttempt = 0;
	static int count = 10;
	public static void main(String[] args) {
		game();
	}
	
	static void game() {
		try {
			int num = (int) (Math.random() * 100) + 1;
			while(count > 0) {
				System.out.println(num);
				String inputTitle = "Guess the number between 1 to 100";
				String input = JOptionPane.showInputDialog(inputTitle, "Enter your answer here...");
				if (input == null) {
					System.exit(0);
				}
				int intInput = Integer.parseInt(input);
				System.out.println(intInput);
				if (intInput == num) {
					numberOfAttempt = 11 - count;
					JOptionPane.showMessageDialog(null, "You win! Your guess was right after " + numberOfAttempt + " attempts");
					scoreOfWins++;
					count = 10;
					tryAgain();
					return;
				} else if (intInput > num) {
					String numberOfTimes = " You can try " + (count - 1) + " times";
					JOptionPane.showMessageDialog(null, "Your guess was not right! Please try Again with a lower value." + numberOfTimes);
					count--;
				} else if (intInput < num){
					String numberOfTimes = " You can try " + (count - 1) + " times";
					JOptionPane.showMessageDialog(null, "Your guess was not right! Please try Again with a higher value." + numberOfTimes);
					count--;
				}
			}
			JOptionPane.showMessageDialog(null, "You Lost the game!");
			count = 10;
			tryAgain();
		} catch (Exception E) {
			JOptionPane.showMessageDialog(null, "Number format exception detected, Please only input numbers!");
			game();
		}
	}
	
	static void tryAgain() {
		while (true) {
			String inputAns = JOptionPane.showInputDialog("Type yes if you want to containue!"
					+ " Type No if you want to give up!", "you won " + scoreOfWins + " times do you want to continue?");
			if (inputAns == null) {
				System.exit(0);
			}
			if (inputAns.equalsIgnoreCase("Y") | inputAns.equalsIgnoreCase("Yes")) {
				game();
			} else if (inputAns.equalsIgnoreCase("N") |inputAns.equalsIgnoreCase("NO")) {
				JOptionPane.showMessageDialog(null, "OKAY you won " + scoreOfWins + " times today, see you later!");
				return;
			} else {
				JOptionPane.showMessageDialog(null, "Please provide a good valid identifier like Yes or NO");
			}
		}
	}
}
