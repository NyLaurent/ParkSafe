import java.util.Scanner;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DbConnection dbConnection = null;
        ParkingOperations operations = null;

        try {
            dbConnection = new DbConnection();
            operations = new ParkingOperations(dbConnection);

            // Initial setup: Ensure parking spots exist
            dbConnection.setupParkingSpots();

            // Menu for the user
            while (true) {
                System.out.println("-- Parking System Menu --");
                System.out.println("1. Park a Car");
                System.out.println("2. Unpark a Car");
                System.out.println("3. View Parked Cars");
                System.out.println("4. View Available Parking Spots");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter car license plate: ");
                        String licensePlate = scanner.nextLine();
                        System.out.print("Enter car color: ");
                        String color = scanner.nextLine();
                        operations.parkCar(licensePlate, color);
                        break;

                    case 2:
                        System.out.print("Enter car license plate to unpark: ");
                        String licensePlateToUnpark = scanner.nextLine();
                        operations.unparkCar(licensePlateToUnpark);
                        break;

                    case 3:
                        operations.viewParkedCars();
                        break;

                    case 4:
                        operations.viewAvailableSpots();
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection when done
            if (dbConnection != null) {
                try {
                    dbConnection.closeConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
