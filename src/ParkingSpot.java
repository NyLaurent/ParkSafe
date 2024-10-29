public class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private Car parkedCar;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isOccupied = false;
    }

    public boolean parkCar(Car car) {
        if (!isOccupied) {
            this.parkedCar = car;
            this.isOccupied = true;
            System.out.println("Car " + car.getLicensePlate() + " parked at spot " + spotNumber);
            return true;
        }
        System.out.println("Spot " + spotNumber + " is already occupied.");
        return false;
    }

    public boolean removeCar() {
        if (isOccupied) {
            System.out.println("Car " + parkedCar.getLicensePlate() + " removed from spot " + spotNumber);
            this.parkedCar = null;
            this.isOccupied = false;
            return true;
        }
        System.out.println("Spot " + spotNumber + " is already empty.");
        return false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    // Getter for spotNumber to resolve the error
    public int getSpotNumber() {
        return spotNumber;
    }
}
