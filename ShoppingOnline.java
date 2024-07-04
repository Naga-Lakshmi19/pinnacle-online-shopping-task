import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingOnline {
    private static List<Product> products = new ArrayList<>();
    private static List<Category> categories = new ArrayList<>();
    private static ShoppingCart cart = new ShoppingCart();

    public static void main(String[] args) {
        // Sample data
        categories.add(new Category("Electronics"));
        categories.add(new Category("Clothing"));
        products.add(new Product("Laptop", 999.99, "Electronics"));
        products.add(new Product("T-Shirt", 19.99, "Clothing"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Browse Products");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    browseProducts(scanner);
                    break;
                case 2:
                    viewCart();
                    break;
                case 3:
                    checkout(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void browseProducts(Scanner scanner) {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + ". " + products.get(i));
        }
        System.out.println("Enter product index to add to cart:");
        int productIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (productIndex < 0 || productIndex >= products.size()) {
            System.out.println("Invalid product selected.");
            return;
        }

        System.out.println("Enter quantity:");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        cart.addItem(products.get(productIndex), quantity);
        System.out.println("Product added to cart.");
    }

    private static void viewCart() {
        System.out.println("Cart: " + cart);
    }

    private static void checkout(Scanner scanner) {
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        User user = new User(name, email);

        double totalPrice = cart.getTotalPrice();
        if (Payment.processPayment(user, totalPrice)) {
            Order order = new Order(user, cart.getItems(), totalPrice);
            System.out.println("Order placed: " + order);
        } else {
            System.out.println("Payment failed.");
        }
    }
}
