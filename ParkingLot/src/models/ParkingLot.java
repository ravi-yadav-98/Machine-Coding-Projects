package models;

import java.util.List;

public class ParkingLot extends BaseModel {
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;

    private int capacity;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
