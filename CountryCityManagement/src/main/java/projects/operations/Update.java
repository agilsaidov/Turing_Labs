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


public class Update {
    ValidateInput validate = new ValidateInput();
    Scanner scanner = new Scanner(System.in);
    Scanner stringScanner = new Scanner(System.in);
    GlobalArrays globalArrays = new GlobalArrays();


    public void updateCountry() {
        Country countryToUpdate = null;

        System.out.println("\n=== Update Country ===");
        System.out.println("Search by:\n1. ID\n2. Name");
        int searchChoice = validate.validateInput(1, 2);

        switch (searchChoice) {
            case 1:
                System.out.println("Enter Country ID: ");
                int countryID = scanner.nextInt();
                countryToUpdate =  globalArrays.getCountry(countryID);
                break;
            case 2:
                System.out.println("Enter Country Name: ");
                String countryName = stringScanner.nextLine();
                countryToUpdate = globalArrays.getCountry(countryName);
        }

        if (countryToUpdate == null) {
            System.out.println("Country not found!");
            return;
        }

        updateCountryFields(countryToUpdate);
    }


    private void updateCountryFields(Country country) {
        boolean updating = true;
        int choice = 0;
        System.out.println("\nCurrent Data:");
        System.out.println(country);

        while (updating) {

            System.out.println("Select a Field: " +
                    "\n0. Update and Exit" +
                    "\n1. ID" +
                    "\n2. Name" +
                    "\n3. Continent" +
                    "\n4. Population" +
                    "\n5. Code" +
                    "\n6. City Count" +
                    "\n7. See Current Data");

            if(country instanceof AfricanCountry) {
                System.out.println("8. Main Language" +
                        "\n9. Is Developing?(true/false)" +
                        "\n10. Currency");
                choice = validate.validateInput(0, 10);

            }else if(country instanceof AsianCountry){
                System.out.println("8. GDP Per Capita" +
                        "\n9. Has Nuclear Power" +
                        "\n10. Main Religion");
                choice = validate.validateInput(0,10);

            }else if (country instanceof EuropeanCountry) {
                System.out.println("8. Is In European Union?(true/false)" +
                        "\n9. Main Export" +
                        "\n10. Founding Year");
                choice = validate.validateInput(0,10);

            }else choice = validate.validateInput(0,7);


            switch (choice) {
                case 0:
                    System.out.println("Updates saved Successfully");
                    System.out.println("Exiting...");
                    updating = false;
                    break;

                case 1:
                    System.out.print("Enter new ID: ");
                    country.setId(scanner.nextInt());
                    break;

                case 2:
                    System.out.print("Enter new Name: ");
                    country.setName(stringScanner.nextLine());
                    break;

                case 3:
                    System.out.print("Enter new Continent: ");
                    country.setContinent(stringScanner.nextLine());
                    break;

                case 4:
                    System.out.print("Enter new Population: ");
                    country.setPopulation(scanner.nextLong());
                    break;

                case 5:
                    System.out.print("Enter new Code: ");
                    country.setCode(stringScanner.nextLine());
                    break;

                case 6:
                    System.out.println("Enter new City Count: ");
                    country.setCityCount(scanner.nextInt());
                    break;

                case 7:
                    System.out.println(country);

                case 8:
                    updateSubclassField(country, choice);
                    break;

                case 9:
                    updateSubclassField(country, choice);
                    break;

                case 10:
                    updateSubclassField(country, choice);
                    break;
            }
        }
    }


    private void updateSubclassField(Country country, int fieldNumber) {
        if (country instanceof AfricanCountry) {
            AfricanCountry african = (AfricanCountry) country;
            switch (fieldNumber) {
                case 8:
                    System.out.print("Enter Main Language: ");
                    african.setMainLanguage(scanner.nextLine());
                    break;
                case 9:
                    System.out.print("Is Developing (true/false): ");
                    african.setDeveloping(scanner.nextBoolean());
                    break;
                case 10:
                    System.out.print("Enter Currency: ");
                    african.setCurrency(stringScanner.nextLine());
                    break;

            }
        }

        else if (country instanceof AsianCountry) {
            AsianCountry asian = (AsianCountry) country;
            switch (fieldNumber) {
                case 8:
                    System.out.print("Enter GDP per capita: ");
                    asian.setGdpPerCapita(scanner.nextDouble());
                    break;
                case 9:
                    System.out.print("Has Nuclear Power (true/false): ");
                    asian.setHasNuclearPower(scanner.nextBoolean());
                    break;
                case 10:
                    System.out.print("Enter Main Religion: ");
                    asian.setMainReligion(stringScanner.nextLine());
                    break;
            }
        }
        else if (country instanceof EuropeanCountry) {
            EuropeanCountry european = (EuropeanCountry) country;
            switch (fieldNumber) {
                case 8:
                    System.out.print("Is in EU (true/false): ");
                    european.setInEuropeanUnion(scanner.nextBoolean());
                    break;
                case 9:
                    System.out.print("Enter Main Export: ");
                    european.setMainExport(stringScanner.nextLine());
                    break;
                case 10:
                    System.out.print("Enter Founding Year: ");
                    european.setFoundingYear(scanner.nextInt());
                    break;
            }
        }
    }


    public void updateCity() {
        System.out.println("\n=== Update City ===");
        System.out.println("Search by:\n1. ID\n2. Name");
        int searchChoice = validate.validateInput(1, 2);

        City cityToUpdate = null;

        switch (searchChoice) {
            case 1:
                System.out.print("Enter City ID: ");
                int cityId = scanner.nextInt();
                cityToUpdate = globalArrays.getCity(cityId);
                break;
            case 2:
                System.out.print("Enter City Name: ");
                String cityName = stringScanner.nextLine();
                cityToUpdate = globalArrays.getCity(cityName);
                break;
        }

        if (cityToUpdate == null) {
            System.out.println("City not found!");
            return;
        }

        updateCityFields(cityToUpdate);
    }

    private void updateCityFields(City city) {
        int choice = 0;
        boolean updating = true;
        System.out.println("\nCurrent City Data:");
        System.out.println(city);

        while (updating) {
            System.out.println("Select a Field: " +
                    "\n0. Save and Exit" +
                    "\n1. ID" +
                    "\n2. Name" +
                    "\n3. Population" +
                    "\n4. Is Capital" +
                    "\n5. Area" +
                    "\n6. Country" +
                    "\n7. See Current Data");

            if (city instanceof CapitalCity) {
                System.out.println("8. Government Type");
                System.out.println("9. Parliament Members");
                System.out.println("10. Mayor Name");

                choice = validate.validateInput(0, 10);
            }
            else if (city instanceof TouristCity) {
                System.out.println("8. Annual Visitors");
                System.out.println("9. Main Attraction");
                System.out.println("10. Tourism Revenue");

                choice = validate.validateInput(0, 10);
            }
            else if (city instanceof IndustrialCity) {
                System.out.println("8. Number of Factories");
                System.out.println("9. Main Industry");
                System.out.println("10. Production Volume");

                choice = validate.validateInput(0, 10);
            }
            else{

                choice = validate.validateInput(0, 7);
            }

            switch (choice) {
                case 0:
                    System.out.println("Updates saved successfully!");
                    updating = false;
                    break;

                case 1:
                    System.out.print("Enter new ID: ");
                    city.setId(scanner.nextInt());
                    break;

                case 2:
                    System.out.print("Enter new Name: ");
                    city.setName(stringScanner.nextLine());
                    break;

                case 3:
                    System.out.print("Enter new Population: ");
                    city.setPopulation(scanner.nextLong());
                    break;

                case 4:
                    System.out.print("Is Capital? (true/false): ");
                    city.setCapital(scanner.nextBoolean());
                    break;

                case 5:
                    System.out.print("Enter new Area: ");
                    city.setArea(scanner.nextDouble());
                    break;

                case 6:
                    System.out.println("Country association cannot be changed here!");
                    break;

                case 7:
                    System.out.println(city);
                    break;
                case 8:
                    updateCitySubclassFields(city, choice);
                    break;

                case 9:
                    updateCitySubclassFields(city, choice);
                    break;
                case 10:
                    updateCitySubclassFields(city, choice);
                    break;

            }
        }
    }


    private void updateCitySubclassFields(City city, int fieldNumber) {
        if (city instanceof CapitalCity capital) {
            switch (fieldNumber) {
                case 8:
                    System.out.print("Enter Government Type: ");
                    capital.setGovernmentType(stringScanner.nextLine());
                    break;
                case 9:
                    System.out.print("Enter Parliament Members: ");
                    capital.setParliamentMembers(scanner.nextInt());
                    break;
                case 10:
                    System.out.print("Enter Mayor Name: ");
                    capital.setMayorName(stringScanner.nextLine());
                    break;
            }
        }
        else if (city instanceof TouristCity tourist) {
            switch (fieldNumber) {
                case 8:
                    System.out.print("Enter Annual Visitors: ");
                    tourist.setAnnualVisitors(scanner.nextInt());
                    break;
                case 9:
                    System.out.print("Enter Main Attraction: ");
                    tourist.setMainAttraction(stringScanner.nextLine());
                    break;
                case 10:
                    System.out.print("Enter Tourism Revenue: ");
                    tourist.setAnnualTourismRevenue(scanner.nextDouble());
                    break;
            }
        }

        else if (city instanceof IndustrialCity industrial) {
            switch (fieldNumber) {
                case 8:
                    System.out.print("Enter Number of Factories: ");
                    industrial.setNumberOfFactories(scanner.nextInt());
                    break;
                case 9:
                    System.out.print("Enter Main Industry: ");
                    industrial.setMainIndustry(stringScanner.nextLine());
                    break;
                case 10:
                    System.out.print("Enter Production Volume: ");
                    industrial.setAnnualProductionVolume(scanner.nextDouble());
                    break;
            }
        }
    }


}
