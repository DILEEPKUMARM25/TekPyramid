package project.collection;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Collection;

public class RestaurantApp {

    public static void main(String[] args) {

        MenuService menuService = new MenuService();
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService(menuService, customerService);
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        // Seed some initial menu items
        try {
            menuService.addMenuItem(new MenuItem(1, "Margherita Pizza", 199.0, "Pizza"));
            menuService.addMenuItem(new MenuItem(2, "Veg Burger", 119.0, "Burger"));
            menuService.addMenuItem(new MenuItem(3, "Cold Coffee", 79.0, "Beverage"));
        } catch (Exception ignored) {}

        while (running) {
            try {
                printMainMenu();
                int choice = readInt(sc, "Select main option: ");

                switch (choice) {
                    case 1: menuManagement(sc, menuService); break;
                    case 2: customerManagement(sc, customerService); break;
                    case 3: orderManagement(sc, menuService, customerService, orderService); break;
                    case 4:
                        System.out.println("Exiting... Goodbye!");
                        running = false;
                        break;
                    default:
                        throw new MenuSelectionException("Invalid main menu selection.");
                }

            } catch (MenuSelectionException e) {
                System.out.println("[ERROR] " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] Invalid input type.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        sc.close();
    }

    // ========================================
    // MAIN MENU
    // ========================================
    private static void printMainMenu() {
        System.out.println("\n===== RESTAURANT MANAGEMENT =====");
        System.out.println("1. Menu Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Order Management");
        System.out.println("4. Exit");
    }

    // ========================================
    // MENU MANAGEMENT
    // ========================================
    private static void menuManagement(Scanner sc, MenuService ms) throws Exception {
        boolean back = false;

        while (!back) {
            System.out.println("\n--- MENU MANAGEMENT ---");
            System.out.println("1. Add Menu Item");
            System.out.println("2. View All Menu Items");
            System.out.println("3. Update Menu Item");
            System.out.println("4. Delete Menu Item");
            System.out.println("5. View Categories");
            System.out.println("6. Back");

            int choice = readInt(sc, "Select option: ");

            switch (choice) {
                case 1:
                    try {
                        int id = readInt(sc, "Enter Menu Item ID: ");
                        String name = readNonEmptyString(sc, "Enter name: ");
                        double price = readDouble(sc, "Enter price: ");
                        String cat = readNonEmptyString(sc, "Enter category: ");

                        ms.addMenuItem(new MenuItem(id, name, price, cat));
                        System.out.println("Menu item added.");
                    } catch (Exception e) {
                        System.out.println("[ERROR] " + e.getMessage());
                    }
                    break;

                case 2:
                    List<MenuItem> items = ms.getAll();
                    System.out.println("\n-- Menu Items --");
                    if (items.isEmpty()) System.out.println("<no menu items>");
                    else items.forEach(System.out::println);
                    break;

                case 3:
                    try {
                        int id = readInt(sc, "Enter ID to update: ");
                        String name = readOptionalString(sc, "New name: ");
                        Double price = readOptionalDouble(sc, "New price: ");
                        String cat = readOptionalString(sc, "New category: ");

                        ms.updateMenuItem(id,
                                name.isEmpty() ? null : name,
                                price,
                                cat.isEmpty() ? null : cat);

                        System.out.println("Menu item updated.");
                    } catch (Exception e) {
                        System.out.println("[ERROR] " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        int id = readInt(sc, "Enter ID to delete: ");
                        ms.deleteMenuItem(id);
                        System.out.println("Menu item deleted.");
                    } catch (Exception e) {
                        System.out.println("[ERROR] " + e.getMessage());
                    }
                    break;

                case 5:
                    Set<String> cats = ms.getCategories();
                    System.out.println("Categories: " + (cats.isEmpty() ? "<none>" : cats));
                    break;

                case 6:
                    back = true;
                    break;

                default:
                    throw new MenuSelectionException("Invalid selection.");
            }
        }
    }

    // ========================================
    // CUSTOMER MANAGEMENT
    // ========================================
    private static void customerManagement(Scanner sc, CustomerService cs) throws Exception {
        boolean back = false;

        while (!back) {
            System.out.println("\n--- CUSTOMER MANAGEMENT ---");
            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Back");

            int choice = readInt(sc, "Select option: ");

            switch (choice) {
                case 1:
                    try {
                        int id = readInt(sc, "Enter Customer ID: ");
                        String name = readNonEmptyString(sc, "Enter name: ");
                        String phone = readNonEmptyString(sc, "Enter phone: ");
                        cs.addCustomer(new Customer(id, name, phone));
                        System.out.println("Customer added.");
                    } catch (Exception e) {
                        System.out.println("[ERROR] " + e.getMessage());
                    }
                    break;

                case 2:
                    Collection<Customer> list = cs.getAll();
                    System.out.println("\n-- Customers --");
                    if (list.isEmpty()) System.out.println("<no customers>");
                    else list.forEach(System.out::println);
                    break;

                case 3:
                    try {
                        int id = readInt(sc, "Enter Customer ID to update: ");
                        String name = readOptionalString(sc, "New name: ");
                        String phone = readOptionalString(sc, "New phone: ");
                        cs.updateCustomer(id,
                                name.isEmpty() ? null : name,
                                phone.isEmpty() ? null : phone);
                        System.out.println("Customer updated.");
                    } catch (Exception e) {
                        System.out.println("[ERROR] " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        int id = readInt(sc, "Enter Customer ID to delete: ");
                        cs.deleteCustomer(id);
                        System.out.println("Customer deleted.");
                    } catch (Exception e) {
                        System.out.println("[ERROR] " + e.getMessage());
                    }
                    break;

                case 5:
                    back = true;
                    break;

                default:
                    throw new MenuSelectionException("Invalid menu selection.");
            }
        }
    }

    // ========================================
    // ORDER MANAGEMENT
    // ========================================
    private static void orderManagement(Scanner sc, MenuService ms, CustomerService cs, OrderService os)
            throws Exception {

        boolean back = false;

        while (!back) {
            System.out.println("\n--- ORDER MANAGEMENT ---");
            System.out.println("1. Create Order");
            System.out.println("2. View All Orders");
            System.out.println("3. Update Order (add/remove item)");
            System.out.println("4. Cancel Order");
            System.out.println("5. Delete Order");
            System.out.println("6. Back");

            int choice = readInt(sc, "Select option: ");

            switch (choice) {

                case 1:
                    try {
                        int orderId = readInt(sc, "Enter Order ID: ");
                        int customerId = readInt(sc, "Enter Customer ID: ");

                        Order o = new Order(orderId, customerId);

                        boolean adding = true;
                        while (adding) {
                            System.out.println("1. Add item   2. Finish");
                            int a = readInt(sc, "Choice: ");

                            if (a == 1) {
                                int menuId = readInt(sc, "Enter MenuItem ID: ");
                                MenuItem mi = ms.findById(menuId);

                                if (mi == null) System.out.println("Item not found.");
                                else o.addItem(mi);
                            } else {
                                adding = false;
                            }
                        }

                        os.createOrder(o);
                        System.out.println("Order created.");
                    } catch (Exception e) {
                        System.out.println("[ERROR] " + e.getMessage());
                    }
                    break;

                case 2:
                    Collection<Order> orders = os.getAll();
                    System.out.println("\n-- Orders --");
                    if (orders.isEmpty()) System.out.println("<no orders>");
                    else orders.forEach(System.out::println);
                    break;

                case 3:
                    try {
                        int orderId = readInt(sc, "Enter Order ID: ");
                        System.out.println("1. Add Item\n2. Remove Item");
                        int sub = readInt(sc, "Choice: ");

                        if (sub == 1) {
                            int menuId = readInt(sc, "Enter MenuItem ID: ");
                            os.addItemToOrder(orderId, menuId);
                            System.out.println("Item added.");
                        } else if (sub == 2) {
                            int menuId = readInt(sc, "Enter MenuItem ID: ");
                            os.removeItemFromOrder(orderId, menuId);
                            System.out.println("Item removed.");
                        } else {
                            throw new MenuSelectionException("Invalid selection.");
                        }

                    } catch (Exception e) {
                        System.out.println("[ERROR] " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        int id = readInt(sc, "Enter Order ID to cancel: ");
                        os.cancelOrder(id);
                        System.out.println("Order cancelled.");
                    } catch (Exception e) {
                        System.out.println("[ERROR] " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        int id = readInt(sc, "Enter Order ID to delete: ");
                        os.deleteOrder(id);
                        System.out.println("Order deleted.");
                    } catch (Exception e) {
                        System.out.println("[ERROR] " + e.getMessage());
                    }
                    break;

                case 6:
                    back = true;
                    break;

                default:
                    throw new MenuSelectionException("Invalid order selection.");
            }
        }
    }

    // ========================================
    // INPUT HELPERS
    // ========================================
    private static int readInt(Scanner sc, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Enter a valid integer!");
            }
        }
    }

    private static double readDouble(Scanner sc, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Enter a valid number!");
            }
        }
    }

    private static String readNonEmptyString(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Value cannot be empty!");
        }
    }

    private static String readOptionalString(Scanner sc, String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    private static Double readOptionalDouble(Scanner sc, String msg) {
        System.out.print(msg);
        String s = sc.nextLine().trim();
        if (s.isEmpty()) return null;
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            System.out.println("Invalid number, skipping.");
            return null;
        }
    }
}
