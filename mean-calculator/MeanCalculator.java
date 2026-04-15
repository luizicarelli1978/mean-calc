import java.util.Scanner;
import java.util.Arrays;

public class MeanCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Declare array and variables
        int[] numbers = new int[10];
        int sum = 0;
        double mean;
        
        // Request input from user
        System.out.println("Enter 10 numbers to calculate their mean:");
        System.out.println();
        
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
            sum += numbers[i];
        }
        
        // Calculate mean
        mean = (double) sum / 10;
        
        // Sort numbers in ascending order
        Arrays.sort(numbers);
        
        // Display results
        System.out.println();
        System.out.println("=== RESULTS ===");
        System.out.println();
        
        System.out.println("Numbers in order (lower to greater):");
        for (int i = 0; i < 10; i++) {
            System.out.println(numbers[i]);
        }
        
        System.out.println();
        System.out.println("Sum of all numbers: " + sum);
        System.out.println("Mean (Average): " + mean);
        
        scanner.close();
    }
}