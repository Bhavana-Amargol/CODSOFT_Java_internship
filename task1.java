/*TASK 2

Input: Take marks obtained (out of 100) in each subject.
Calculate Total Marks: Sum up the marks obtained in all subjects.
Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
average percentage.
Grade Calculation: Assign grades based on the average percentage achieved.
Display Results: Show the total marks, average percentage, and the corresponding grade to the user

Code: */
import java.util.Scanner;

public class GradeCalculator {

    // Method to calculate total marks
    public static int computeTotal(int[] scores) {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }

    // Method to calculate average percentage
    public static double computeAverage(int total, int subjectCount) {
        return (double) total / subjectCount;
    }

    // Method to assign grades based on average percentage
    public static String assignGrade(double average) {
        if (average >= 90) {
            return "A+";
        } else if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    // Method to display results
    public static void displayResults(int totalMarks, double averagePercent, String grade) {
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercent);
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of subjects
        System.out.print("Enter the number of subjects: ");
        int subjectCount = scanner.nextInt();

        // Array to store marks of each subject
        int[] marks = new int[subjectCount];

        // Input marks for each subject
        for (int i = 0; i < subjectCount; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        // Calculate total marks, average percentage, and grade
        int totalMarks = computeTotal(marks);
        double averagePercent = computeAverage(totalMarks, subjectCount);
        String grade = assignGrade(averagePercent);

        // Display the results
        displayResults(totalMarks, averagePercent, grade);

        scanner.close();
    }
}

/*Output:
Enter the number of subjects: 6
Enter marks obtained in subject 1: 98
Enter marks obtained in subject 2: 87
Enter marks obtained in subject 3: 75
Enter marks obtained in subject 4: 91
Enter marks obtained in subject 5: 79
Enter marks obtained in subject 6: 77
Total Marks: 507
Average Percentage: 84.50%
Grade: A */