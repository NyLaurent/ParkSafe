import java.util.List;
import java.util.ArrayList;

public class ParkingLot {
    protected List<ParkingSpot> spots;

    public ParkingLot(int totalSpots) {
        spots = new ArrayList<>();
        for (int i = 1; i <= totalSpots; i++) {
            spots.add(new ParkingSpot(i));
        }
    }

    public boolean parkCar(Car car) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                return spot.parkCar(car);
            }
        }
        System.out.println("No available spots to park the car.");
        return false;
    }

    public boolean removeCar(String licensePlate) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getParkedCar().getLicensePlate().equals(licensePlate)) {
                return spot.removeCar();
            }
        }
        System.out.println("Car with license plate " + licensePlate + " is not found.");
        return false;
    }

    public void addVIPSpot(int spotNumber) {
        spots.add(new VIPParkingSpot(spotNumber));
    }
}
