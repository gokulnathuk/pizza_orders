package pizza;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PizzaApp {

    private static Map<String, String> adminDatabase = new HashMap<>();

    public static void main(String[] args) {
        initializeAdmins();

        Scanner scanner = new Scanner(System.in);

        // Admin Login
        if (!adminLogin(scanner)) {
            System.out.println("Admin login failed. Exiting...");
            return;
        }

        // Customer Details
        System.out.print("Enter your name: ");
        String customerName = scanner.next();
        System.out.print("Enter your mobile number: ");
        String mobileNumber = scanner.next();

        System.out.println("Welcome to the Pizza Order System!");
        System.out.print("Choose pizza type (1 for Veg, 2 for Non-Veg): ");
        int choice = scanner.nextInt();
        
        boolean isVeg = choice == 1;
        Pizza pizza = new Pizza(isVeg);

        // Extra options
        if (selectExtraOptions(scanner, pizza)) {
            pizza.TakeAway();
        }

        pizza.getBill();
        scanner.close();
    }

    private static void initializeAdmins() {
        adminDatabase.put("Gokul", "@gokul");
        // Add more admins as needed
    }

    private static boolean adminLogin(Scanner scanner) {
        System.out.print("Enter admin username: ");
        String username = scanner.next();
        System.out.print("Enter admin password: ");
        String password = scanner.next();

        return adminDatabase.containsKey(username) && adminDatabase.get(username).equals(password);
    }

    private static boolean selectExtraOptions(Scanner scanner, Pizza pizza) {
        System.out.println("Would you like to add extra cheese? (yes/no): ");
        if (scanner.next().equalsIgnoreCase("yes")) {
            pizza.addExtracheesa();
        }

        System.out.println("Would you like to add extra toppings? (yes/no): ");
        if (scanner.next().equalsIgnoreCase("yes")) {
            pizza.addExtraTopping();
        }

        System.out.println("Choose additional items (comma-separated): ");
        System.out.println("1. Chicken (150)");
        System.out.println("2. Onion (50)");
        System.out.println("3. Tomato (30)");
        System.out.println("4. Cheese (100)");
        System.out.println("5. Pepsi (40)");
        System.out.println("6. Water (20)");

        String[] extras = scanner.next().split(",");
        for (String extra : extras) {
            switch (extra.trim()) {
                case "1":
                    pizza.addChicken();
                    break;
                case "2":
                    pizza.addOnion();
                    break;
                case "3":
                    pizza.addTomato();
                    break;
                case "4":
                    pizza.addCheese();
                    break;
                case "5":
                    pizza.addPepsi();
                    break;
                case "6":
                    pizza.addWater();
                    break;
                default:
                    System.out.println("Invalid option: " + extra);
            }
        }

        System.out.print("Would you like your pizza for takeaway? (yes/no): ");
        return scanner.next().equalsIgnoreCase("yes");
    }
}
