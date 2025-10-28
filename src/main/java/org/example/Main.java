package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class containing everything
public class Main {
    // Inner Product class
    static class Product {
        private int id;
        private String name;
        private int quantity;
        private double price;

        public Product(int id, String name, int quantity, double price) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public int getQuantity() { return quantity; }
        public double getPrice() { return price; }
        public void setQuantity(int quantity) { this.quantity = quantity; }

        @Override
        public String toString() {
            return String.format("ID: %d | Name: %s | Qty: %d | Price: %.2f",
                    id, name, quantity, price);
        }
    }

    // Inner InventoryService class
    static class InventoryService {
        private List<Product> products = new ArrayList<>();

        // Add a new product
        public void addProduct(Product product) {
            products.add(product);
            System.out.println("✅ Product added successfully!");
        }

        // View all products
        public void viewProducts() {
            if (products.isEmpty()) {
                System.out.println("❌ No products found.");
                return;
            }
            System.out.println("\n🧾 Inventory List:");
            for (Product p : products) {
                System.out.println(p);
            }
        }

        // Update product quantity
        public void updateProductQuantity(int id, int newQuantity) {
            for (Product p : products) {
                if (p.getId() == id) {
                    p.setQuantity(newQuantity);
                    System.out.println("✅ Quantity updated successfully!");
                    return;
                }
            }
            System.out.println("❌ Product not found.");
        }

        // Delete product
        public void deleteProduct(int id) {
            boolean removed = products.removeIf(p -> p.getId() == id);
            if (removed) {
                System.out.println("🗑️ Product deleted successfully!");
            } else {
                System.out.println("❌ Product not found.");
            }
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryService inventory = new InventoryService();

        while (true) {
            System.out.println("\n===== INVENTORY MANAGEMENT MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    Product product = new Product(id, name, qty, price);
                    inventory.addProduct(product);
                }
                case 2 -> inventory.viewProducts();
                case 3 -> {
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter New Quantity: ");
                    int qty = sc.nextInt();
                    inventory.updateProductQuantity(id, qty);
                }
                case 4 -> {
                    System.out.print("Enter Product ID to delete: ");
                    int id = sc.nextInt();
                    inventory.deleteProduct(id);
                }
                case 5 -> {
                    System.out.println("👋 Exiting... Thank you!");
                    System.exit(0);
                }
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }
}
