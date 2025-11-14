/* 
Write a program to display the fibonacci series up to N terms
*/
import java.util.Scanner;

public class ActivityTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        int n = scan.nextInt();

        long first = 0, second = 1;
        System.out.print("Fibonacci sequence up to " + n + " terms: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");

            long next = first + second;
            first = second;
            second = next;
        }

        scan.close();
    }
}