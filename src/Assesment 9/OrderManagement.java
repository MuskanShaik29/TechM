import java.sql.*;

public class OrderManagement {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ecommerce_db";
        String user = "root";
        String password = "password";  // Change this to your MySQL password

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM orders")) {

            System.out.println("Order Details:");
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                String customer = rs.getString("customer_name");
                String product = rs.getString("product_name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");

                System.out.println(orderId + " | " + customer + " | " + product + " | " + quantity + " | " + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
