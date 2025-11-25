package project.JDBC.service;

import project.JDBC.start.DBConnection;
import project.JDBC.entity.MenuItem;

import java.sql.*;

public class MenuService {

    public void addMenuItem(MenuItem item) {
        String sql = "INSERT INTO menu_items VALUES(?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, item.getId());
            ps.setString(2, item.getName());
            ps.setDouble(3, item.getPrice());
            ps.setString(4, item.getCategory());
            ps.executeUpdate();

            System.out.println("Menu Item Added!");

        } catch (SQLException e) {
            System.out.println("Error adding item: " + e.getMessage());
        }
    }

    public void viewAllItems() {
        String sql = "SELECT * FROM menu_items";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " | " +
                                rs.getString(2) + " | " +
                                rs.getDouble(3) + " | " +
                                rs.getString(4)
                );
            }

        } catch (SQLException e) {
            System.out.println("Error fetching items: " + e.getMessage());
        }
    }

    public void updateMenuItem(int id, String newName, double newPrice) {
        String sql = "UPDATE menu_items SET name=?, price=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newName);
            ps.setDouble(2, newPrice);
            ps.setInt(3, id);

            ps.executeUpdate();
            System.out.println("Menu item updated!");

        } catch (SQLException e) {
            System.out.println("Error updating: " + e.getMessage());
        }
    }

    public void deleteMenuItem(int id) {
        String sql = "DELETE FROM menu_items WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Menu item deleted!");

        } catch (SQLException e) {
            System.out.println("Error deleting: " + e.getMessage());
        }
    }
}

