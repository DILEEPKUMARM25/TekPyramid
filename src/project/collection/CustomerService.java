package project.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    private final Map<Integer, Customer> customers = new HashMap<>();

    public synchronized void addCustomer(Customer c) throws DuplicateEntryException {
        if (customers.containsKey(c.getId())) {
            throw new DuplicateEntryException("Customer with ID " + c.getId() + " already exists.");
        }
        customers.put(c.getId(), c);
    }

    public synchronized Collection<Customer> getAll() {
        return new ArrayList<>(customers.values());
    }

    public synchronized Customer findById(int id) {
        return customers.get(id);
    }

    public synchronized void updateCustomer(int id, String name, String phone)
            throws ResourceNotFoundException {
        Customer c = customers.get(id);
        if (c == null) {
            throw new ResourceNotFoundException("Customer with ID " + id + " not found.");
        }

        if (name != null) c.setName(name);
        if (phone != null) c.setPhone(phone);
    }

    public synchronized void deleteCustomer(int id) throws ResourceNotFoundException {
        if (!customers.containsKey(id)) {
            throw new ResourceNotFoundException("Customer with ID " + id + " not found.");
        }
        customers.remove(id);
    }
}