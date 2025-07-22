package projects.operations;

import projects.arrays.GlobalArrays;
import projects.city_subclasses.CapitalCity;
import projects.city_subclasses.IndustrialCity;
import projects.city_subclasses.TouristCity;
import projects.country_subclasses.AfricanCountry;
import projects.country_subclasses.AsianCountry;
import projects.country_subclasses.EuropeanCountry;
import projects.superclasses.City;
import projects.superclasses.Country;
import projects.validate.ValidateInput;

import java.util.Scanner;

public class Add {
    Scanner scanner = new Scanner(System.in);
    Scanner stringScanner = new Scanner(System.in);
    ValidateInput validate = new ValidateInput();
    GlobalArrays globalArrays = new GlobalArrays();
    Country country;

    private int countrySaveResult;


    public void addCity(){
        System.out.println("Choose City Type: " +
                "\n0. Parent City" +
                "\n1. Capital City" +
                "\n2. Tourist City" +
                "\n3. Industrial City");

        int choice = validate.validateInput(0,3);

        System.out.println("Enter City ID: ");
        int cityID = scanner.nextInt();

        System.out.println("Enter City Name: ");
        String cityName = stringScanner.nextLine();

        System.out.println("Enter Population: ");
        long population = scanner.nextLong();

        System.out.println("Is Capital City? (true/false): ");
        boolean isCapital = scanner.nextBoolean();

        System.out.println("Enter Area: ");
        double area = scanner.nextDouble();


        switch (choice) {
            case 0:
                country = addCountry();
                if(country != null) {
                    City parentCity = new City(cityID, cityName, population, isCapital, area, country);
                    if(country.addCity(parentCity) == 1){
                        globalArrays.saveGlobalCity(parentCity);
                    }
                }else{
                    System.out.println("City Couldn't be added");
                }
                break;

            case 1:
                System.out.println("Enter Government Type: ");
                String governmentType = stringScanner.nextLine();

                System.out.println("Enter number of Parliament members: ");
                int parliamentMembers = scanner.nextInt();


                System.out.println("Enter Mayor's Name: ");
                String mayorName = stringScanner.nextLine();

                country = addCountry();

                if (country != null) {
                    City capitalCity = new CapitalCity(cityID,cityName,population,isCapital,area,country,governmentType,parliamentMembers,mayorName);

                    if(country.addCity(capitalCity) == 1) {
                        globalArrays.saveGlobalCity(capitalCity);
                    }

                }else System.out.println("City Couldn't be added");
                break;


            case 2:
                System.out.println("Enter Number of Annual Visitors: ");
                int annualVisitors = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter Main Attraction: ");
                String mainAttraction = stringScanner.nextLine();

                System.out.println("Enter Annual Tourism Revenue: ");
                double annualTourismRevenue = scanner.nextDouble();

                country = addCountry();

                if (country != null) {
                    City touristCity = new TouristCity(cityID, cityName, population, isCapital, area, country, annualVisitors, mainAttraction, annualTourismRevenue);

                    if(country.addCity(touristCity)==1) {
                        globalArrays.saveGlobalCity(touristCity);
                    }

                } else {
                    System.out.println("City Couldn't be added");
                }

                break;


            case 3:
                System.out.println("Enter Number of Factories: ");
                int factories = scanner.nextInt();


                System.out.println("Enter Main Industry: ");
                String mainIndustry = stringScanner.nextLine();

                System.out.println("Enter Annual Production Volume: ");
                double annualProductionVolume = scanner.nextDouble();

                country = addCountry();

                if (country != null) {
                    City industrialCity = new IndustrialCity(cityID, cityName, population, isCapital, area, country, factories, mainIndustry, annualProductionVolume);


                    if(country.addCity(industrialCity) == 1) {
                        globalArrays.saveGlobalCity(industrialCity);
                    }

                }else System.out.println("City Couldn't be added");
                break;
        }
    }


    public Country addCountry(){

        System.out.println("Enter Country ID: ");
        int countryID = scanner.nextInt();

        System.out.println("Enter Country Name: ");
        String countryName = stringScanner.nextLine();

        Country checkedCountry = globalArrays.getCountry(countryID,countryName);

        if(checkedCountry != null){
            System.out.println("Country Found In Database...");
            return checkedCountry;
        }
        System.out.println("Enter Country Type: " +
                "\n0. Parent Country" +
                "\n1. European Country" +
                "\n2. African Country" +
                "\n3. Asian Country");

        int choice = validate.validateInput(0,3);

        System.out.println("Enter Continent: ");
        String continent = stringScanner.nextLine();

        System.out.println("Enter Population: ");
        long population = scanner.nextLong();

        System.out.println("Enter Code: ");
        String code = stringScanner.nextLine();

        System.out.println("Enter City Count: ");
        int cityCount = scanner.nextInt();


        switch (choice) {
            case 0:
                Country parentCountry = new Country(countryID, countryName, continent, population, code, cityCount);
                countrySaveResult = globalArrays.saveGlobalCountry(parentCountry);
                if(countrySaveResult==1) {
                    System.out.println("Country Saved Successfully");
                    return parentCountry;
                }else{
                    System.out.println("Country Saving Failed. Array Is May Full");
                    return null;
                }

            case 1:

                System.out.println("Is country in European union? (true/false): ");
                boolean isInEuropeanUnion = scanner.nextBoolean();

                System.out.println("What is the main exported good: ");
                String mainExport = stringScanner.nextLine();

                System.out.println("In what year was the country founded: ");
                int foundingYear = scanner.nextInt();

                Country euCountry = new EuropeanCountry(countryID, countryName, continent, population, code, cityCount, isInEuropeanUnion, mainExport, foundingYear);

                countrySaveResult = globalArrays.saveGlobalCountry(euCountry);

                if (countrySaveResult == 1) {
                    System.out.println("Country Saved Successfully");
                    return euCountry;
                }else {
                    System.out.println("Country Saving Failed. Array Is May Full");
                    return null;
                }


            case 2:

                System.out.println("Enter Main Language: ");
                String mainLanguage = stringScanner.nextLine();

                System.out.println("Is country developing? (true/false): ");
                boolean isDeveloping = scanner.nextBoolean();

                System.out.println("What is currency of country: ");
                String currency = stringScanner.nextLine();

                Country afCountry = new AfricanCountry(countryID, countryName, continent, population, code, cityCount, mainLanguage, isDeveloping, currency);

                countrySaveResult = globalArrays.saveGlobalCountry(afCountry);

                if (countrySaveResult == 1) {
                    System.out.println("Country Saved Successfully");
                    return afCountry;
                }else {
                    System.out.println("Country Saving Failed. Array Is Full");
                    return null;
                }


            case 3:

                System.out.println("Enter GDP per capita: ");
                double gdpPerCapita = scanner.nextDouble();

                System.out.println("Does country have nuclear power? (true/false): ");
                boolean hasNuclearPower = scanner.nextBoolean();

                System.out.println("Enter Main Religion: ");
                String mainReligion = stringScanner.nextLine();

                Country asCountry = new AsianCountry(countryID, countryName, continent, population, code, cityCount, gdpPerCapita, hasNuclearPower, mainReligion);

                countrySaveResult = globalArrays.saveGlobalCountry(asCountry);
                if (countrySaveResult == 1) {
                    System.out.println("Country Saved Successfully");
                    return asCountry;
                }else {
                    System.out.println("Country Saving Failed. Array Is Full");
                    return null;
                }
        }

        return null;
    }
}
