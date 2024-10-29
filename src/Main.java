public class Main {
    public static void main(String[] args) {
        // Create a parking lot with 3 spots
        ParkingLot parkingLot = new ParkingLot(3);
        ParkingManager manager = new ParkingManager(parkingLot);

        // Create some cars
        Car car1 = new Car("ABC123", "Red");
        Car car2 = new Car("VIP456", "Black");

        // Add a VIP spot
        manager.addVIPSpot(4);

        // Park the cars
        manager.parkCar(car1); // Regular spot
        manager.parkCar(car2); // VIP spot
    }
}
