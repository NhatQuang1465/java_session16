package lesson1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- Product Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Filter Products (Price > 100)");
            System.out.println("6. Total Value of Products");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ProductManager.addProduct();
                    break;

                case 2:
                    ProductManager.updateProduct();
                    break;

                case 3:
                    ProductManager.deleteProduct();
                    break;

                case 4:
                    ProductManager.showProducts();
                    break;

                case 5:
                    ProductManager.filterProducts();
                    break;

                case 6:
                    ProductManager.totalValue();
                    break;

                case 0:
                    System.out.println("Program ended.");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}