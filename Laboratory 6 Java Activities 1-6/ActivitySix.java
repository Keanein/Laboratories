/*
    Problem 6
    - Setup: Create an ArrayList of Product objects, where Product has fields like name (String) and price (double) 
    - Activity: 
    - Use the stream() method on the list.
    - Apply the filter() intermediate operation using a lambda expression to select all products whose price is greater than a specific value provided by the user (e.g., 50.00, 65.00, 30.10)
    - Use the count() terminal operation to print the total number of expensive products found. 
 */
import java.util.Scanner;
import java.util.ArrayList;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class ActivitySix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Sample product list
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Adobo", 120.00));
        products.add(new Product("Rice", 30.00));
        products.add(new Product("Sinigang", 100.00));
        products.add(new Product("Dinuguan", 70.00));
        products.add(new Product("Nilaga", 120.00));
        products.add(new Product("Pancit", 30.00));
        products.add(new Product("Spaghetti", 30.00));
        products.add(new Product("Munggo", 20.00));
        products.add(new Product("Bangus", 75.00));

        System.out.print("Enter price filter: ");
        double filterPrice = scan.nextDouble();

        long count = products.stream()
                             .filter(pr -> pr.price > filterPrice)
                             .count();

        System.out.println("Products with price greater than " + filterPrice + ": " + count);

        products.stream()
                .filter(pr -> pr.price > filterPrice)
                .forEach(pr -> System.out.println(pr.name + " - " + pr.price));

        scan.close();
    }
}
