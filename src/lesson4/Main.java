package lesson4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 1200));
        products.add(new Product("Mouse", 50));
        products.add(new Product("Keyboard", 80));
        products.add(new Product("Monitor", 300));

        ProductProcessor processor =
                new ProductProcessorImpl();

        if (processor.hasExpensiveProduct(products)) {

            System.out.println("Các sản phẩm có giá > 100:");

            products.stream()
                    .filter(product -> product.getPrice() > 100)
                    .forEach(System.out::println);

        } else {

            System.out.println("Không có sản phẩm đắt tiền");
        }

        double total =
                processor.calculateTotalValue(products);

        System.out.println("\nTổng giá trị sản phẩm: "
                + total);

        ProductProcessor.printProductList(products);
    }
}