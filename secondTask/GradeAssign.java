package secondTask;

// The GradeAssign class extends the AverageGrade class
public class GradeAssign extends AverageGrade {
    // A static variable to hold the grade
    static String grade = "";

    // The criteria method takes an average grade as input and returns a letter grade
    public static String criteria(int average) {
        // Check the average against each grade boundary
        if (average >= 98) {
            grade = "A+";
        } else if (average >= 93) {
            grade = "A";
        } else if (average >= 90) {
            grade = "A-";
        } else if (average >= 88) {
            grade = "B+";
        } else if (average >= 83) {
            grade = "B";
        } else if (average >= 80) {
            grade = "B-";
        } else if (average >= 78) {
            grade = "C+";
        } else if (average >= 73) {
            grade = "C";
        } else if (average >= 70) {
            grade = "C-";
        } else if (average >= 68) {
            grade = "D+";
        } else if (average >= 63) {
            grade = "D";
        } else if (average >= 60) {
            grade = "D-";
        } else {
            grade = "F";
        }

        // Return the letter grade
        return grade;
    }
}