package secondTask;

public class AverageGrade extends Grades{
    // Method to calculate the sum of an array of integers
    public static int sum (int [] array) {
        int total = 0;
        // Loop through each number in the array
        for (int num : array) {
            // Add the number to the total
            total += num;
        }
        // Return the total sum
        return total;
    }

    // Method to calculate the average of an array of grades
    public static int returnAVG(int[] grades) {
        // Call the sum method to get the total sum of the grades, then divide by the number of grades (10 in this case)
        return sum(grades) / 10 ;
    }
}
