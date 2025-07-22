package projects.operations;

import projects.arrays.GlobalArrays;
import projects.city_subclasses.IndustrialCity;
import projects.city_subclasses.TouristCity;
import projects.superclasses.City;
import projects.validate.ValidateInput;

import java.util.Scanner;

public class Calculations {
    ValidateInput validate = new ValidateInput();
    Scanner scanner = new Scanner(System.in);
    Scanner stringScanner = new Scanner(System.in);
    GlobalArrays globalArrays = new GlobalArrays();



    public void populationGrowthRate() {
        City city = cityFinderSwitch();
        if (city != null) {
            growthRateSwitch(city);
        } else System.out.println("City not found");

    }

    public void calculateTourismGrowth(){

        City city = cityFinderSwitch();
        if (city != null) {

            if(city instanceof TouristCity){
                System.out.println("Enter Previous Revenue: ");
                double preRevenue = scanner.nextDouble();

                System.out.println("Enter Years: ");
                int years = scanner.nextInt();

                double growth = ((TouristCity) city).calculateTourismGrowthRate(preRevenue, years);

                System.out.printf("Tourism growth rate is %2.2f within %d years %n" , growth ,years);


            }else{ System.out.println("City must be a tourist city to calculate growth"); }

        }else System.out.println("City not found");

    }


    public void calculateProductionGrowth(){
        City city = cityFinderSwitch();
        if (city != null) {
            if(city instanceof IndustrialCity){
                System.out.println("Enter Previous Volume: ");
                double preRevenue = scanner.nextDouble();

                System.out.println("Enter Years: ");
                int years = scanner.nextInt();

                double growth = ((IndustrialCity) city).productionGrowth(preRevenue, years);

                System.out.printf("Industrial production growth rate is %2.2f within %d years %n" ,growth, years);
            }else{
                System.out.println("City must be an industrial city to calculate growth");
            }
        }
        else System.out.println("City not found");
    }

    //Helpers

    private City cityFinderSwitch(){
        System.out.println("Choose a way to find city:" +
                "\n1. Id" +
                "\n2. Name");
        int choice = validate.validateInput(1,2);
        switch (choice) {
            case 1:
                System.out.println("Enter ID: ");
                int id = scanner.nextInt();
                return globalArrays.getCity(id);

            case 2:
                System.out.println("Enter Name: ");
                String name = stringScanner.nextLine();
                return globalArrays.getCity(name);

        }
        return null;
    }


    private void growthRateSwitch(City city){
        System.out.println("Choose Calculation Type: " +
                "\n1. Growth Rate" +
                "\n2. Growth Rate with Migration");

        int calType = validate.validateInput(1,2);

        System.out.println("Enter previous population: ");
        long previousPopulation = scanner.nextLong();

        System.out.println("Enter years: ");
        int years = scanner.nextInt();

        switch (calType) {

            case 1:
                System.out.printf("Growth Rate is %2.2f within %d years %n" , city.calculateGrowthRate(previousPopulation, years), years);
                break;
            case 2:
                System.out.println("Enter migrations: ");
                long migrations = scanner.nextLong();
                System.out.printf("Growth Rate is %2.2f within %d years with %d migration %n" , city.calculateGrowthRate(previousPopulation, years, migrations), years, migrations);
                break;
        }
    }
}
