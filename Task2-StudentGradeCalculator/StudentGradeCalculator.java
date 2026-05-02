import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of subjects
        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        int[] marks = new int[n];
        int total = 0;

        // Input marks
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();

            // Validation
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Enter between 0 and 100.");
                i--;
                continue;
            }

            total += marks[i];
        }

        // Calculate average
        double average = (double) total / n;

        // Find highest and lowest
        int max = marks[0];
        int min = marks[0];

        for (int i = 1; i < n; i++) {
            if (marks[i] > max) {
                max = marks[i];
            }
            if (marks[i] < min) {
                min = marks[i];
            }
        }

        // Grade calculation
        char grade;
        String performance;

        if (average >= 90) {
            grade = 'A';
            performance = "Excellent";
        } else if (average >= 80) {
            grade = 'B';
            performance = "Good";
        } else if (average >= 70) {
            grade = 'C';
            performance = "Average";
        } else if (average >= 60) {
            grade = 'D';
            performance = "Needs Improvement";
        } else {
            grade = 'F';
            performance = "Fail";
        }

        // Display result
        System.out.println("\n===== RESULT =====");
        System.out.println("Total Marks: " + total);
        System.out.println("Average Percentage: " + average + "%");
        System.out.println("Highest Marks: " + max);
        System.out.println("Lowest Marks: " + min);
        System.out.println("Grade: " + grade);
        System.out.println("Performance: " + performance);

        sc.close();
    }
}