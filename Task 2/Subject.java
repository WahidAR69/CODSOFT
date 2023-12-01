package secondTask;

public class Subject {
    // An array of subjects
    static String[] subjects = {"Math", "English", "Science", "History", "Geography", "ART", "Music", "Physical Education", "Economics", "psychology"};

    // A method that takes a subject name as input and returns the corresponding subject from the array
    public static String subjectHolder(String sub) {
        // Check if the input matches each subject in the array
        if (sub == "Math") {
            return subjects[0];
        } else if (sub.equalsIgnoreCase("English")) {
            return subjects[1];
        } else if (sub.equalsIgnoreCase("Science")) {
            return subjects[2];
        } else if (sub.equalsIgnoreCase("History")) {
            return subjects[3];
        } else if (sub.equalsIgnoreCase("Geography")) {
            return subjects[4];
        } else if (sub.equalsIgnoreCase("ART")) {
            return subjects[5];
        } else if (sub.equalsIgnoreCase("Music")) {
            return subjects[6];
        } else if (sub.equalsIgnoreCase("Physical Education")) {
            return subjects[7];
        } else if (sub.equalsIgnoreCase("Economics")) {
            return subjects[8];
        } else if (sub.equalsIgnoreCase("Psychology")) {
            return subjects[9];
        }
        // If the input doesn't match any subject in the array, return the input string
        return sub;
    }
}