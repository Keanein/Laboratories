/*
 * Write a program that inputs 5 numbers and stores them in an array, then calculates and prints their sum and average.
 */
import java.util.Scanner;

public class ActivityThree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = 0;

        System.out.println("Enter 5 numbers:");

        for (int i = 0; i < 5; i++) {
            sum += scan.nextInt();
        }

        double average = sum / 5.0;

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        scan.close();
    }
}

