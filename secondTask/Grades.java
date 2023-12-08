package secondTask;

import javax.swing.JOptionPane;

public class Grades extends Subject {
    // An array to hold the grade points for each subject
    static int[] gradePointsHolder = new int[subjects.length];

    // A method that returns the input number as it is
    public static int gradeNum(int num) {
        return num;
    }

    // A method to get the grades for each subject from the user
    public static int[] numGrades() {
        // Loop over each subject
        for (int i = 0; i < subjects.length; i++)  {
            // Initialize the grade for the current subject to -1
            int intGrade = -1;
            String grade;
            do {
                // Ask the user for the grade in the current subject
                grade = JOptionPane.showInputDialog("Input Your Grade in " + subjects[i] + "?");
                // If the user clicked cancel, exit the program
                if (grade == null) {
                    System.exit(0);
                } 
                // If the user didn't enter a grade, show a message and ask again
                else if (grade.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You have to input a grade!");
                    continue;
                }
                try {
                    // Try to parse the grade as an integer
                    intGrade = Integer.parseInt(grade);
                    // If the grade is not between 1 and 100, show a message and ask again
                    if (intGrade < 0 || intGrade > 100) {
                        JOptionPane.showMessageDialog(null, "You have to input between 1 to 100!");
                        intGrade = -1;  // Reset intGrade to -1
                    } else {
                        intGrade = gradeNum(intGrade);
                    }
                } catch (NumberFormatException e) {
                    // If the grade is not a valid number, show a message and ask again
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");
                    intGrade = -1;  // Reset intGrade to -1
                }
            // Repeat until a valid grade is entered
            } while (intGrade < 0 || intGrade > 100);
            // Store the grade in the gradePointsHolder array
            gradePointsHolder[i] = intGrade;
        }
        // Return the array of grades
        return gradePointsHolder;
    }
}
