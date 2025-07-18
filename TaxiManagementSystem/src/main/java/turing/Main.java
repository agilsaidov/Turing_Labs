package turing;

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Taxi("Ford","Focus","10-BG-123",false,4,"Bolt");
        Vehicle v2 = new Bus("Mercedes","Tourismo","99-AA-999",true,40,false);

        //Polymorphism check
        v1.drive();
        v2.drive();

        //Instance of check
        if(v1 instanceof Taxi){
            Taxi taxi = (Taxi) v1;
            System.out.println("Fare: "+(taxi.calculateFare(10)));
            System.out.println("Night shift driving fee: "+(taxi.calculateFare(15,true)));
        }

        //Driver object
        Driver driver1 = new Driver();
        driver1.setName("Joshua");
        driver1.setLicenseNumber("CA-12345");
        driver1.setAge(36);

        //Object Details
        v1.vehicleInfo();
        v2.vehicleInfo();
        driver1.toString();
    }
}