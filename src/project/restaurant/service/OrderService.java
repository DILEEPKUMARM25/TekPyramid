package project.restaurant.service;



import project.restaurant.exception.DuplicateEntryException;
import project.restaurant.exception.ResourceNotFoundException;
import project.restaurant.model.MenuItem;
import project.restaurant.model.Order;

import java.util.HashMap;

public class OrderService {

    private HashMap<Integer, Order> orders = new HashMap<>();

    public void createOrder(int orderId, int customerId) throws DuplicateEntryException {
        if (orders.containsKey(orderId))
            throw new DuplicateEntryException("Order with ID already exists!");

        orders.put(orderId, new Order(orderId, customerId));
    }

    public HashMap<Integer, Order> getAllOrders() {
        return orders;
    }

    public void addItemToOrder(int orderId, MenuItem item) throws ResourceNotFoundException {
        if (!orders.containsKey(orderId))
            throw new ResourceNotFoundException("Order not found!");

        orders.get(orderId).addItem(item);
    }

    public void removeItemFromOrder(int orderId, MenuItem item) throws ResourceNotFoundException {
        if (!orders.containsKey(orderId))
            throw new ResourceNotFoundException("Order not found!");

        orders.get(orderId).removeItem(item);
    }

    public void cancelOrder(int orderId) throws ResourceNotFoundException {
        if (!orders.containsKey(orderId))
            throw new ResourceNotFoundException("Order not found!");

        orders.remove(orderId);
    }
}
