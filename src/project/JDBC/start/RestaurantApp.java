package project.JDBC.start;

import project.JDBC.entity.Customer;
import project.JDBC.entity.MenuItem;
import project.JDBC.entity.Order;
import project.JDBC.service.CustomerService;
import project.JDBC.service.MenuService;
import project.JDBC.service.OrderService;

import java.util.*;

public class RestaurantApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MenuService menu = new MenuService();
        CustomerService cs = new CustomerService();
        OrderService os = new OrderService();

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Menu Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Order Management");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.println("1 Add Item\n2 View\n3 Update\n4 Delete");
                    int c1 = sc.nextInt();
                    if (c1 == 1) {
                        System.out.println("Enter ID, name, price, category:");
                        int id = sc.nextInt();
                        String name = sc.next();
                        double price = sc.nextDouble();
                        String cat = sc.next();
                        menu.addMenuItem(new MenuItem(id, name, price, cat));
                    } else if (c1 == 2) {
                        menu.viewAllItems();
                    }
                    else if (c1 == 3) {
                        System.out.println(" enter id  name  price");
                        int id = sc.nextInt();
                        String name = sc.next();
                        double price = sc.nextDouble();
                        menu.updateMenuItem( id,name,price);
                    }
                    else if (c1 == 4) {
                        System.out.println(" enter id ");
                        int id = sc.nextInt();
                        menu. deleteMenuItem(id);
                    }


                    break;

                case 2:
                    System.out.println("1 Add Customer\n2 View\n3 Update\n4 Delete");
                    int c2 = sc.nextInt();
                    if (c2 == 1) {
                        System.out.println("Enter ID, name, phone:");
                        int id = sc.nextInt();
                        String name = sc.next();
                        String phone = sc.next();
                        cs.addCustomer(new Customer(id, name, phone));
                    } else if (c2 == 2) {
                        cs.viewCustomers();
                    }
                    else if (c2 == 3) {
                        System.out.println(" enter, id ,name , phone ");
                        int id = sc.nextInt();
                        String name = sc.next();
                        String phone = sc.next();
                        cs.updateCustomer(id,  name, phone);
                    }else if (c2 == 4) {
                        System.out.println(" enter id");
                        int id = sc.nextInt();
                        cs.deleteCustomer( id);
                    }


                    break;

                case 3:
                    System.out.println("Enter Order ID:");
                    int oid = sc.nextInt();
                    System.out.println("Enter Customer ID:");
                    int cid = sc.nextInt();

                    Order order = new Order(oid, cid);

                    System.out.println("How many items?");
                    int count = sc.nextInt();

                    for (int i = 0; i < count; i++) {
                        System.out.println("Enter Item ID:");
                        order.getItemIds().add(sc.nextInt());
                    }

                    os.createOrder(order);
                    break;


                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid!");
            }
        }
    }
}
