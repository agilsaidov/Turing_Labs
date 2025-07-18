package turing;

public class Taxi extends Vehicle {

    private int passengerCount;
    private String taxiCompany;


    public Taxi(String brand, String model, String plateNumber, boolean isAvailable, int passengerCount, String taxiCompany) {
        super(brand, model, plateNumber, isAvailable);
        this.passengerCount = passengerCount;
        this.taxiCompany = taxiCompany;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public String getTaxiCompany() {
        return taxiCompany;
    }

    public void setTaxiCompany(String taxiCompany) {
        this.taxiCompany = taxiCompany;
    }

    @Override
    public void drive(){
        if(isAvailable()) {
            System.out.printf("Taxi from %s is driving with %d passengers%n", taxiCompany, passengerCount);
        }else{
            System.out.println("Taxi isn't available");
        }
    }

    public double calculateFare(int km){
        return km * 0.6;
    }

    public double calculateFare(int km, boolean nightShift){
        return km * 0.9;
    }
}
