public class ParkingManager {
    private ParkingLot parkingLot;

    public ParkingManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public boolean parkCar(Car car) {
        return parkingLot.parkCar(car);
    }

    public boolean removeCar(String licensePlate) {
        return parkingLot.removeCar(licensePlate);
    }

    public void addVIPSpot(int spotNumber) {
        parkingLot.addVIPSpot(spotNumber);
        System.out.println("VIP spot " + spotNumber + " added to the parking lot.");
    }
}
