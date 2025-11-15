package project.restaurant.start;


import project.restaurant.exception.*;
import project.restaurant.model.*;
import project.restaurant.service.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApplication {

    static Scanner sc = new Scanner(System.in);

    static MenuService menuService = new MenuService();
    static CustomerService customerService = new CustomerService();
    static OrderService orderService = new OrderService();

    public static void main(String[] args) {

        while (true) {
            try {
                System.out.println("\n====== Restaurant Management System ======");
                System.out.println("1. Menu Management");
                System.out.println("2. Customer Management");
                System.out.println("3. Order Management");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> menuManagement();
                    case 2 -> customerManagement();
                    case 3 -> orderManagement();
                    case 4 -> {
                        System.out.println("Exiting...");
                        System.exit(0);
                    }
                    default -> throw new MenuSelectionException("Invalid main menu choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter numbers only.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // ---------------- MENU MANAGEMENT ----------------
    public static void menuManagement() throws Exception {
        System.out.println("\n--- Menu Management ---");
        System.out.println("1. Add Menu Item");
        System.out.println("2. View Menu Items");
        System.out.println("3. Update Menu Item");
        System.out.println("4. Delete Menu Item");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter ID: "); int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: "); String name = sc.nextLine();
                System.out.print("Enter Price: "); double price = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter Category: "); String cat = sc.nextLine();
                menuService.addMenuItem(new MenuItem(id, name, price, cat));
            }
            case 2 -> menuService.getAllMenuItems().forEach(System.out::println);
            case 3 -> {
                System.out.print("Enter ID to update: "); int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter New Name: "); String name = sc.nextLine();
                System.out.print("Enter New Price: "); double price = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter New Category: "); String cat = sc.nextLine();
                menuService.updateMenuItem(id, name, price, cat);
            }
            case 4 -> {
                System.out.print("Enter ID: ");
                menuService.deleteMenuItem(sc.nextInt());
            }
            default -> throw new MenuSelectionException("Invalid menu selection!");
        }
    }

    // ---------------- CUSTOMER MANAGEMENT ----------------
    public static void customerManagement() throws Exception {
        System.out.println("\n--- Customer Management ---");
        System.out.println("1. Add Customer");
        System.out.println("2. View Customers");
        System.out.println("3. Update Customer");
        System.out.println("4. Delete Customer");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("ID: "); int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Name: "); String name = sc.nextLine();
                System.out.print("Phone: "); String phone = sc.nextLine();
                customerService.addCustomer(new Customer(id, name, phone));
            }
            case 2 -> customerService.getAllCustomers().values().forEach(System.out::println);
            case 3 -> {
                System.out.print("ID: "); int id = sc.nextInt();
                sc.nextLine();
                System.out.print("New Name: "); String name = sc.nextLine();
                System.out.print("New Phone: "); String phone = sc.nextLine();
                customerService.updateCustomer(id, name, phone);
            }
            case 4 -> {
                System.out.print("Enter ID: ");
                customerService.deleteCustomer(sc.nextInt());
            }
            default -> throw new MenuSelectionException("Invalid selection!");
        }
    }

    // ---------------- ORDER MANAGEMENT ----------------
    public static void orderManagement() throws Exception {
        System.out.println("\n--- Order Management ---");
        System.out.println("1. Create Order");
        System.out.println("2. View Orders");
        System.out.println("3. Add Item to Order");
        System.out.println("4. Remove Item from Order");
        System.out.println("5. Cancel Order");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Order ID: ");
                int orderId = sc.nextInt();
                System.out.print("Customer ID: ");
                int custId = sc.nextInt();
                orderService.createOrder(orderId, custId);
            }
            case 2 -> orderService.getAllOrders().values().forEach(System.out::println);
            case 3 -> {
                System.out.print("Order ID: "); int oid = sc.nextInt();
                System.out.print("Menu Item ID: "); int mid = sc.nextInt();
                MenuItem item = menuService.getAllMenuItems().stream()
                        .filter(i -> i.getId() == mid).findFirst()
                        .orElseThrow(() -> new ResourceNotFoundException("Menu item not found!"));
                orderService.addItemToOrder(oid, item);
            }
            case 4 -> {
                System.out.print("Order ID: "); int oid = sc.nextInt();
                System.out.print("Menu Item ID: "); int mid = sc.nextInt();
                MenuItem item = menuService.getAllMenuItems().stream()
                        .filter(i -> i.getId() == mid).findFirst()
                        .orElseThrow(() -> new ResourceNotFoundException("Menu item not found!"));
                orderService.removeItemFromOrder(oid, item);
            }
            case 5 -> {
                System.out.print("Order ID: ");
                orderService.cancelOrder(sc.nextInt());
            }
            default -> throw new MenuSelectionException("Invalid selection!");
        }
    }
}
