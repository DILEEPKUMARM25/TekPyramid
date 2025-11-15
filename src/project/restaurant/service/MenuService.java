package project.restaurant.service;



import project.restaurant.exception.DuplicateEntryException;
import project.restaurant.exception.ResourceNotFoundException;
import project.restaurant.model.MenuItem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MenuService {

    private List<MenuItem> menuItems = new ArrayList<>();
    private HashSet<String> categories = new HashSet<>();

    public void addMenuItem(MenuItem item) throws DuplicateEntryException {
        for (MenuItem m : menuItems) {
            if (m.getId() == item.getId()) {
                throw new DuplicateEntryException("Menu item with ID already exists!");
            }
        }
        menuItems.add(item);
        categories.add(item.getCategory());
    }

    public List<MenuItem> getAllMenuItems() {
        return menuItems;
    }

    public void updateMenuItem(int id, String name, double price, String category)
            throws ResourceNotFoundException {

        for (MenuItem m : menuItems) {
            if (m.getId() == id) {
                m.setName(name);
                m.setPrice(price);
                m.setCategory(category);
                return;
            }
        }
        throw new ResourceNotFoundException("Menu item not found!");
    }

    public void deleteMenuItem(int id) throws ResourceNotFoundException {
        MenuItem toRemove = null;
        for (MenuItem m : menuItems) {
            if (m.getId() == id) {
                toRemove = m;
            }
        }
        if (toRemove == null)
            throw new ResourceNotFoundException("Menu item not found!");

        menuItems.remove(toRemove);
    }
}
