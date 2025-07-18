package turing;

public class Bus extends Vehicle{
    private int capacity;
    private boolean isDoubleDecker;

    public Bus(String brand, String model, String plateNumber, boolean isAvailable, int capacity, boolean isDoubleDecker) {
        super(brand, model, plateNumber, isAvailable);
        this.capacity = capacity;
        this.isDoubleDecker = isDoubleDecker;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isDoubleDecker() {
        return isDoubleDecker;
    }

    public void setDoubleDecker(boolean doubleDecker) {
        isDoubleDecker = doubleDecker;
    }

    public void drive() {
        if(isAvailable()) {
            System.out.println("Bus with capacity " + capacity + " is moving");
        }else {
            System.out.println("Bus is not available");
        }
    }
}
