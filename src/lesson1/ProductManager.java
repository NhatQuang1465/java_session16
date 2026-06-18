package lesson1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductManager {

    private static HashMap<Integer, Product> products = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Product Price: ");
        double price = sc.nextDouble();

        products.put(id, new Product(id, name, price));

        System.out.println("Product added successfully.");
    }

    public static void updateProduct() {
        System.out.print("Enter Product ID to edit: ");
        int id = sc.nextInt();
        sc.nextLine();

        Product p = products.get(id);

        if (p != null) {
            System.out.print("Enter new Product Name: ");
            String name = sc.nextLine();

            System.out.print("Enter new Product Price: ");
            double price = sc.nextDouble();

            p.setName(name);
            p.setPrice(price);

            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();

        if (products.remove(id) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void showProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void filterProducts() {
        products.values()
                .stream()
                .filter(p -> p.getPrice() > 100)
                .forEach(System.out::println);
    }

    public static void totalValue() {
        double total = products.values()
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println("Total value of products: " + total);
    }
}