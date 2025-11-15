package project.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OrderService {

    private final Map<Integer, Order> orders = new HashMap<>();
    private final MenuService menuService;
    private final CustomerService customerService;

    public OrderService(MenuService menuService, CustomerService customerService) {
        this.menuService = menuService;
        this.customerService = customerService;
    }

    public synchronized void createOrder(Order order)
            throws DuplicateEntryException, ResourceNotFoundException {
        if (orders.containsKey(order.getOrderId())) {
            throw new DuplicateEntryException("Order with ID " + order.getOrderId() + " already exists.");
        }

        if (customerService.findById(order.getCustomerId()) == null) {
            throw new ResourceNotFoundException("Customer with ID " + order.getCustomerId() + " not found.");
        }

        orders.put(order.getOrderId(), order);
    }

    public synchronized Collection<Order> getAll() {
        return new ArrayList<>(orders.values());
    }

    public synchronized Order findById(int id) {
        return orders.get(id);
    }

    public synchronized void addItemToOrder(int orderId, int menuItemId)
            throws ResourceNotFoundException {
        Order o = orders.get(orderId);
        if (o == null) {
            throw new ResourceNotFoundException("Order with ID " + orderId + " not found.");
        }

        MenuItem mi = menuService.findById(menuItemId);
        if (mi == null) {
            throw new ResourceNotFoundException("Menu item with ID " + menuItemId + " not found.");
        }

        o.addItem(mi);
    }

    public synchronized void removeItemFromOrder(int orderId, int menuItemId)
            throws ResourceNotFoundException {
        Order o = orders.get(orderId);
        if (o == null) {
            throw new ResourceNotFoundException("Order with ID " + orderId + " not found.");
        }

        boolean removed = o.removeItemById(menuItemId);
        if (!removed) {
            throw new ResourceNotFoundException("Menu item with ID " + menuItemId + " not present in order.");
        }
    }

    public synchronized void cancelOrder(int orderId) throws ResourceNotFoundException {
        Order o = orders.get(orderId);
        if (o == null) {
            throw new ResourceNotFoundException("Order with ID " + orderId + " not found.");
        }
        o.cancel();
    }

    public synchronized void deleteOrder(int orderId) throws ResourceNotFoundException {
        if (!orders.containsKey(orderId)) {
            throw new ResourceNotFoundException("Order with ID " + orderId + " not found.");
        }
        orders.remove(orderId);
    }
}
