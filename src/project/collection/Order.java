package project.collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Order {
    private final int orderId;
    private final int customerId;
    private final LinkedList<MenuItem> items = new LinkedList<>();
    private boolean cancelled = false;

    public Order(int orderId, int customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public List<MenuItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void cancel() {
        this.cancelled = true;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public boolean removeItemById(int menuItemId) {
        return items.removeIf(i -> i.getId() == menuItemId);
    }

    public double totalAmount() {
        double total = 0;
        for (MenuItem m : items) total += m.getPrice();
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Order[%d] for Customer[%d] - %s\n", orderId, customerId, cancelled ? "CANCELLED" : "ACTIVE"));

        if (items.isEmpty()) {
            sb.append("  <no items>\n");
        } else {
            for (MenuItem mi : items) {
                sb.append("  ").append(mi.toString()).append("\n");
            }
            sb.append(String.format("  Total: %.2f\n", totalAmount()));
        }
        return sb.toString();
    }
}