package project.JDBC.entity;

import java.util.LinkedList;

public class Order {
    private int id;
    private int customerId;
    private LinkedList<Integer> itemIds = new LinkedList<>();

    public Order(int id, int customerId) {
        this.id = id;
        this.customerId = customerId;
    }

    public LinkedList<Integer> getItemIds() {
        return itemIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setItemIds(LinkedList<Integer> itemIds) {
        this.itemIds = itemIds;
    }
}
