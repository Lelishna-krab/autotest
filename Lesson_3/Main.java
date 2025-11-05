import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", LocalDate.of(2025, 1, 2),
                "Samsung Corp.", "Korea", 5599.0, true);

        productsArray[1] = new Product("iPhone 16 Pro", LocalDate.of(2024, 9, 15),
                "Apple Inc.", "China", 6999.0, false);

        productsArray[2] = new Product("MacBook Air M3", LocalDate.of(2024, 3, 8),
                "Apple Inc.", "China", 12999.0, true);

        productsArray[3] = new Product("Sony WH-1000XM5", LocalDate.of(2024, 5, 20),
                "Sony Corporation", "Japan", 3499.0, false);

        productsArray[4] = new Product("Xiaomi Robot Vacuum", LocalDate.of(2024, 2, 10),
                "Xiaomi Inc.", "China", 1999.0, true);

        System.out.println("ВСЕ ТОВАРЫ");
        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("\nТовар #" + (i + 1) + ":");
            productsArray[i].printInfo();
        }
    }

}