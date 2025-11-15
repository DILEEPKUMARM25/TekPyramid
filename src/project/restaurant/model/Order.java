package project.restaurant.model;


import java.util.LinkedList;

public class Order {
    private int orderId;
    private int customerId;
    private LinkedList<MenuItem> items;

    public Order(int orderId, int customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = new LinkedList<>();
    }

    public int getOrderId() { return orderId; }
    public int getCustomerId() { return customerId; }
    public LinkedList<MenuItem> getItems() { return items; }

    public void addItem(MenuItem item) { items.add(item); }
    public void removeItem(MenuItem item) { items.remove(item); }

    @Override
    public String toString() {
        return "OrderID: " + orderId + " | CustomerID: " + customerId + " | Items: " + items;
    }
}

