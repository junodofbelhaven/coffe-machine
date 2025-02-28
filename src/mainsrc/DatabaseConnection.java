package mainsrc;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/new_schema";
    private static final String USER = "root";
    private static final String PASSWORD = "asdbnm1122";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void initializeDatabase() {
        String createDB = "CREATE DATABASE IF NOT EXISTS coffeMachineHistory_db";
        String useDB = "USE coffeMachineHistory_db";
        String createTable = """
                CREATE TABLE IF NOT EXISTS history(
                		order_num INT Primary key AUTO_INCREMENT,
                                num_of_cups INT,
                                date TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
        """;
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(createDB);
            stmt.execute(useDB);
            stmt.execute(createTable);
            System.out.println("Database initialized successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Database initialization failed: " + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void record(int numOfCups) {
        String insertQuery = "INSERT INTO history (num_of_cups) VALUES (?)";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeMachineHistory_db", USER, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
            pstmt.setInt(1, numOfCups);
            pstmt.executeUpdate();
            System.out.println("Record added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static int getCurrentMonthOrders() {
        String query = """
            SELECT COUNT(*) AS num_of_orders
            FROM history
            WHERE MONTH(date) = MONTH(CURRENT_DATE)
            AND YEAR(date) = YEAR(CURRENT_DATE);
            """;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeMachineHistory_db", USER, PASSWORD); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                int numOfOrders = rs.getInt("num_of_orders");
                return numOfOrders;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
