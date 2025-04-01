import java.sql.*;

public class BatchInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company_db";
        String user = "root";
        String password = "password";  // Change this to your MySQL password

        String insertQuery = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

            conn.setAutoCommit(false);  // Disable auto-commit for batch processing

            pstmt.setString(1, "Mike Ross");
            pstmt.setString(2, "Finance");
            pstmt.setDouble(3, 70000.00);
            pstmt.addBatch();

            pstmt.setString(1, "Rachel Zane");
            pstmt.setString(2, "Legal");
            pstmt.setDouble(3, 75000.00);
            pstmt.addBatch();

            pstmt.setString(1, "Harvey Specter");
            pstmt.setString(2, "Management");
            pstmt.setDouble(3, 100000.00);
            pstmt.addBatch();

            int[] result = pstmt.executeBatch();
            conn.commit();  // Commit batch changes

            System.out.println(result.length + " records inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
