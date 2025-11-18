package project.restaurant.service;

import project.restaurant.exception.DuplicateEntryException;
import project.restaurant.exception.ResourceNotFoundException;
import project.restaurant.model.Customer;

import java.util.HashMap;

public class CustomerService {

    private HashMap<Integer, Customer> customers = new HashMap<>();

    public void addCustomer(Customer customer) throws DuplicateEntryException {

        // Validate phone number
        String phone = customer.getPhone();  // example getter

        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new DuplicateEntryException("Phone number must be exactly 10 digits!");
        }

        // Check duplicate customer ID
        if (customers.containsKey(customer.getId())) {
            throw new DuplicateEntryException("Customer with ID already exists!");
        }

        customers.put(customer.getId(), customer);
    }


    public HashMap<Integer, Customer> getAllCustomers() {
        return customers;
    }

    public void updateCustomer(int id, String name, String phone)
            throws ResourceNotFoundException {
        if (!customers.containsKey(id)) {
            throw new ResourceNotFoundException("Customer not found!");
        }
        Customer c = customers.get(id);
        c.setName(name);
        c.setPhone(phone);
    }

    public void deleteCustomer(int id) throws ResourceNotFoundException {
        if (!customers.containsKey(id))
            throw new ResourceNotFoundException("Customer not found!");

        customers.remove(id);
    }
}
