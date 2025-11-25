package project.JDBC.service;

import project.JDBC.start.DBConnection;
import project.JDBC.entity.Order;

import java.sql.*;
public class OrderService {

    // Check if customer exists
    private boolean customerExists(Connection con, int customerId) throws SQLException {
        String sql = "SELECT id FROM customers WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, customerId);
        ResultSet rs = ps.executeQuery();
        boolean exists = rs.next();
        rs.close();
        ps.close();
        return exists;
    }

    // Check if menu item exists
    private boolean menuItemExists(Connection con, int itemId) throws SQLException {
        String sql = "SELECT id FROM menu_items WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, itemId);
        ResultSet rs = ps.executeQuery();
        boolean exists = rs.next();
        rs.close();
        ps.close();
        return exists;
    }

    public void createOrder(Order order) {
        String sql = "INSERT INTO orders VALUES(?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Validate customer ID
            if (!customerExists(con, order.getCustomerId())) {
                System.out.println("❌ Customer ID " + order.getCustomerId() + " does not exist!");
                return;
            }

            // Insert order first
            ps.setInt(1, order.getId());
            ps.setInt(2, order.getCustomerId());
            ps.executeUpdate();

            // Insert order items
            for (int itemId : order.getItemIds()) {

                if (!menuItemExists(con, itemId)) {
                    System.out.println("❌ Item ID " + itemId + " does not exist! Skipping...");
                    continue;
                }

                String sql2 = "INSERT INTO order_items VALUES(?, ?)";
                PreparedStatement ps2 = con.prepareStatement(sql2);
                ps2.setInt(1, order.getId());
                ps2.setInt(2, itemId);
                ps2.executeUpdate();
                ps2.close();
            }

            System.out.println("✅ Order created successfully!");

        } catch (SQLException e) {
            System.out.println("Order Error: " + e.getMessage());
        }
    }
}
