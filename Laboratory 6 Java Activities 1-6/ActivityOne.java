/* 
Write a program that uses the Scanner class and the newer IO class to read a users name and age, then print a personalized greeting.
*/
import java.util.Scanner;

void main() {
    Scanner scan = new Scanner(System.in);

    IO.print("Enter your name: ");
    String name = scan.nextLine();

    IO.print("Enter your age: ");
    int age = scan.nextInt();

    IO.println("Hello, " + name + "! You are " + age + " years old.");
}