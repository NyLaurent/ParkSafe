import java.sql.*;
import java.util.Scanner;

public class ParkingOperations {

    private DbConnection dbConnection;

    public ParkingOperations(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    // Park a car
    public void parkCar(String licensePlate, String color) {
        String insertCarQuery = "INSERT INTO cars (license_plate, color) VALUES (?, ?) RETURNING id";
        String updateSpotQuery = "UPDATE parking_spots SET is_occupied = true, car_id = ? WHERE spot_number = ?";

        try {
            // Check for available spots
            String checkAvailableSpotQuery = "SELECT spot_number FROM parking_spots WHERE is_occupied = false LIMIT 1";
            Statement stmt = dbConnection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(checkAvailableSpotQuery);

            if (rs.next()) {
                int availableSpot = rs.getInt("spot_number");

                // Add car to the 'cars' table and retrieve the car's ID
                PreparedStatement carStmt = dbConnection.getConnection().prepareStatement(insertCarQuery);
                carStmt.setString(1, licensePlate);
                carStmt.setString(2, color);
                ResultSet carRs = carStmt.executeQuery();

                if (carRs.next()) {
                    int carId = carRs.getInt("id");

                    // Assign the car to an available parking spot
                    PreparedStatement updateStmt = dbConnection.getConnection().prepareStatement(updateSpotQuery);
                    updateStmt.setInt(1, carId);
                    updateStmt.setInt(2, availableSpot);
                    updateStmt.executeUpdate();

                    System.out.println("Car " + licensePlate + " parked at spot " + availableSpot);
                }
            } else {
                System.out.println("No available parking spots.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Unpark a car
    public void unparkCar(String licensePlate) {
        String getCarQuery = "SELECT c.id, p.spot_number FROM cars c JOIN parking_spots p ON c.id = p.car_id WHERE c.license_plate = ?";
        String updateSpotQuery = "UPDATE parking_spots SET is_occupied = false, car_id = NULL WHERE spot_number = ?";
        String deleteCarQuery = "DELETE FROM cars WHERE license_plate = ?";

        try {
            // Find the car in the parking spots
            PreparedStatement getCarStmt = dbConnection.getConnection().prepareStatement(getCarQuery);
            getCarStmt.setString(1, licensePlate);
            ResultSet rs = getCarStmt.executeQuery();

            if (rs.next()) {
                int spotNumber = rs.getInt("spot_number");

                // Free the parking spot
                PreparedStatement updateSpotStmt = dbConnection.getConnection().prepareStatement(updateSpotQuery);
                updateSpotStmt.setInt(1, spotNumber);
                updateSpotStmt.executeUpdate();

                // Delete the car from the 'cars' table
                PreparedStatement deleteCarStmt = dbConnection.getConnection().prepareStatement(deleteCarQuery);
                deleteCarStmt.setString(1, licensePlate);
                deleteCarStmt.executeUpdate();

                System.out.println("Car " + licensePlate + " has been removed from spot " + spotNumber);
            } else {
                System.out.println("Car not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View parked cars
    public void viewParkedCars() {
        String query = "SELECT c.license_plate, c.color, p.spot_number FROM cars c JOIN parking_spots p ON c.id = p.car_id WHERE p.is_occupied = true";

        try {
            Statement stmt = dbConnection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Parked Cars:");
            while (rs.next()) {
                String licensePlate = rs.getString("license_plate");
                String color = rs.getString("color");
                int spotNumber = rs.getInt("spot_number");
                System.out.println("License Plate: " + licensePlate + ", Color: " + color + ", Spot: " + spotNumber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View available parking spots
    public void viewAvailableSpots() {
        String query = "SELECT spot_number FROM parking_spots WHERE is_occupied = false";

        try {
            Statement stmt = dbConnection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Available Parking Spots:");
            while (rs.next()) {
                int spotNumber = rs.getInt("spot_number");
                System.out.println("Spot: " + spotNumber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
