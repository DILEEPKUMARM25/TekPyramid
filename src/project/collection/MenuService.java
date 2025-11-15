package project.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuService {

    private final List<MenuItem> menuItems = new ArrayList<>();
    private final Set<String> categories = new HashSet<>();

    public synchronized void addMenuItem(MenuItem m) throws DuplicateEntryException {
        if (exists(m.getId())) {
            throw new DuplicateEntryException("Menu item with ID " + m.getId() + " already exists.");
        }
        menuItems.add(m);
        categories.add(m.getCategory());
    }

    public synchronized List<MenuItem> getAll() {
        return new ArrayList<>(menuItems);
    }

    public synchronized MenuItem findById(int id) {
        for (MenuItem m : menuItems) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    public synchronized boolean exists(int id) {
        return findById(id) != null;
    }

    public synchronized void updateMenuItem(int id, String name, Double price, String category)
            throws ResourceNotFoundException {
        MenuItem m = findById(id);
        if (m == null) {
            throw new ResourceNotFoundException("Menu item with ID " + id + " not found.");
        }

        if (name != null) m.setName(name);
        if (price != null) m.setPrice(price);

        if (category != null) {
            categories.remove(m.getCategory());
            m.setCategory(category);
            categories.add(category);
        }
    }

    public synchronized void deleteMenuItem(int id) throws ResourceNotFoundException {
        MenuItem m = findById(id);
        if (m == null) {
            throw new ResourceNotFoundException("Menu item with ID " + id + " not found.");
        }
        menuItems.remove(m);

        // Rebuild category list
        categories.clear();
        for (MenuItem item : menuItems) {
            categories.add(item.getCategory());
        }
    }

    public synchronized Set<String> getCategories() {
        return new HashSet<>(categories);
    }
}
