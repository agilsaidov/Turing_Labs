package projects.operations;

import projects.validate.ValidateInput;

public class Menus {

    ValidateInput validate = new ValidateInput();
    Add add = new Add();
    Read read = new Read();
    Delete delete = new Delete();
    Update update = new Update();
    Calculations calculations = new Calculations();

    public void showMenu(){
        while (true) {
            System.out.println("=== Country-City Management ===:" +
                    "\n0. Exit" +
                    "\n1. Add City" +
                    "\n2. Add Country" +
                    "\n3. Delete City" +
                    "\n4. Delete Country" +
                    "\n5. Country Update" +
                    "\n6. City Update" +
                    "\n7. List All" +
                    "\n8. Calculations");

            int choice = validate.validateInput(0, 8);
            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                case 1:
                    add.addCity();
                    break;
                case 2:
                    add.addCountry();
                    break;
                case 3:
                    delete.deleteCity();
                    break;
                case 4:
                    delete.deleteCountry();
                    break;
                case 5:
                    update.updateCountry();
                    break;
                case 6:
                    update.updateCity();
                    break;
                case 7:
                    read.show();
                    break;
                case 8:
                    calculationsMenu();
                    break;
            }
        }
    }
    public void calculationsMenu() {
        while(true) {
            System.out.println("Enter Operation: " +
                    "\n0. Back to Main Menu" +
                    "\n1. Calculate Population Growth Rate" +
                    "\n2. Calculate Tourism Growth Rate" +
                    "\n3. Calculate Industrial Production Growth Rate");
            int choice = validate.validateInput(0,3);
            switch(choice) {
                case 0:
                    System.out.println("Went Back");
                    showMenu();
                    return;
                case 1:
                    calculations.populationGrowthRate();
                    break;
                case 2:
                    calculations.calculateTourismGrowth();
                    break;
                case 3:
                    calculations.calculateProductionGrowth();
                    break;
            }
        }
    }

}
