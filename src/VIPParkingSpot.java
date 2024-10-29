public class VIPParkingSpot extends ParkingSpot {
    private boolean isReserved;

    public VIPParkingSpot(int spotNumber) {
        super(spotNumber);
        this.isReserved = true;
    }

    @Override
    public boolean parkCar(Car car) {
        if (isReserved && !isOccupied()) {
            System.out.println("VIP Car " + car.getLicensePlate() + " parked at VIP spot " + getSpotNumber());
            return super.parkCar(car);
        }
        System.out.println("VIP spot " + getSpotNumber() + " is either not reserved or already occupied.");
        return false;
    }

    public boolean isReserved() {
        return isReserved;
    }
}
