import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private Connection connection;

    public DbConnection() throws SQLException {
        // Initialize the connection
        String url = "jdbc:postgresql://localhost:5432/parksafe"; // Change to your DB URL
        String username = "postgres"; // Change to your DB username
        String password = "laulan"; // Change to your DB password

        connection = DriverManager.getConnection(url, username, password);
    }

    // Method to return the connection object
    public Connection getConnection() {
        return connection;
    }

    // Close the connection when done
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // Optional: Setup the parking spots (to be run once, when the system starts)
    public void setupParkingSpots() throws SQLException {
        String query = "SELECT COUNT(*) FROM parking_spots";
        try (var stmt = connection.createStatement(); var rs = stmt.executeQuery(query)) {
            if (rs.next() && rs.getInt(1) == 0) {
                // Insert 10 parking spots if none exist
                String insertQuery = "INSERT INTO parking_spots (spot_number) VALUES (1), (2), (3), (4), (5), (6), (7), (8), (9), (10)";
                try (var insertStmt = connection.prepareStatement(insertQuery)) {
                    insertStmt.executeUpdate();
                    System.out.println("Parking spots initialized.");
                }
            }
        }
    }
}
