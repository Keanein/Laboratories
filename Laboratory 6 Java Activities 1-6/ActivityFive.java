/*
 * Create a Rectangle class with length and width fields and a method calculateArea(). Demonstrate creating and using objects of this class
 */

import java.util.Scanner;

class Rectangle {
    double length;
    double width;

    double calculateArea() {
        return length * width;
    }
}

public class ActivityFive {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Rectangle r1 = new Rectangle();
        
        System.out.print("Enter length of Rectangle 1: ");
        r1.length = scan.nextDouble();
        System.out.print("Enter width of Rectangle 1: ");
        r1.width = scan.nextDouble();
        System.out.println("Area of Rectangle 1: " + r1.calculateArea());

        Rectangle r2 = new Rectangle();
        
        System.out.print("Enter length of Rectangle 2: ");
        r2.length = scan.nextDouble();
        System.out.print("Enter width of Rectangle 2: ");
        r2.width = scan.nextDouble();
        System.out.println("Area of Rectangle 2: " + r2.calculateArea());

        scan.close();
    }
}