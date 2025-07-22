package projects.operations;

import projects.arrays.GlobalArrays;
import projects.superclasses.City;
import projects.validate.ValidateInput;

import java.util.Scanner;

public class Delete {
    Scanner scanner = new Scanner(System.in);
    Scanner stringScanner = new Scanner(System.in);
    ValidateInput validate = new ValidateInput();
    GlobalArrays globalArrays = new GlobalArrays();

    public void deleteCity() {
        City deletedCity;
        System.out.println("=== Delete City ===");
        System.out.println("Methods:" +
                "\n1. Id" +
                "\n2. Name");
        int choice = validate.validateInput(1,2);
        switch (choice) {
            case 1:
                System.out.println("Enter City ID: ");
                int cityID = scanner.nextInt();

                deletedCity = globalArrays.deleteGlobalCity(cityID);
                if(deletedCity == null){
                    System.out.println("City Not Found In Database...");
                }else{

                    if(deletedCity.getCountry().deleteCityWithId(cityID) == 1){
                        System.out.println("City Deleted Successfully");
                    }else{
                        System.out.println("City Couldn't be Deleted from Object Array...");
                    }

                }
                break;


            case 2:
                System.out.println("Enter City Name: ");
                String cityName = stringScanner.nextLine();
                deletedCity = globalArrays.deleteGlobalCity(cityName);
                if(deletedCity == null){
                    System.out.println("City Not Found In Database...");
                }else {
                    if(deletedCity.getCountry().deleteCityWithName(cityName) == 1){
                        System.out.println("City Deleted Successfully");
                    }
                    else{
                        System.out.println("City Couldn't be Deleted from Object Array...");
                    }
                }

        }
    }

    public void deleteCountry() {
        System.out.println("=== Delete Country ===");
        System.out.println("Methods:" +
                "\n1. ID" +
                "\n2. Name");
        int choice = validate.validateInput(1,2);
        switch (choice) {
            case 1:
                System.out.println("Enter Country ID: ");
                int countryID = scanner.nextInt();

                if(globalArrays.deleteGlobalCountry(countryID) == 0){

                    System.out.println("Country with " + countryID + " ID Not Found in Database...");
                }else{
                    System.out.println("Country with " + countryID + " ID Deleted from Database...");
                }
                break;
            case 2:
                System.out.println("Enter Country Name: ");
                String countryName = stringScanner.nextLine();

                if(globalArrays.deleteGlobalCountry(countryName) == 0){

                    System.out.println("Country with " + countryName + " Name Not Found in Database...");
                }else{
                    System.out.println("Country with " + countryName + " Name Deleted from Database...");
                }
        }
    }
}
