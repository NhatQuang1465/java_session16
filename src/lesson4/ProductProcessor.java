package lesson4;

import java.util.List;

public interface ProductProcessor {
    double calculateTotalValue(List<Product> products);
    static void printProductList(List<Product> products) {

        System.out.println("\n===== PRODUCT LIST =====");

        products.forEach(System.out::println);
    }
    default boolean hasExpensiveProduct(List<Product> products) {

        return products.stream()
                .anyMatch(product -> product.getPrice() > 100);
    }
}
