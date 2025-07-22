package turing;


import turing.SuperClasses.City;
import turing.SuperClasses.Country;

public class MainApp {
    public static String cityMostPopulation(City[] cities) {
        String cityWithMostPopulation=null;
        int population = cities[0].getPopulation();

        for(City city : cities){
            if(city.getPopulation() > population){
                population = city.getPopulation();
                cityWithMostPopulation = city.getName();
            }
        }
        return cityWithMostPopulation;
    }


    public static void main(String[] args) {

        City[] cities ;

        City Amsderdam = new City("Amsderdam","A-12345",936145,219.3);
        City Baku = new City("Baku","B-12345",2500000,2140);
        City Istanbul = new City("Istanbul","I-12345",15701602,5461);
        City Moscow = new City("Moscow","M-12345",13258262 ,2511);

        cities = new City[]{Amsderdam, Baku, Istanbul, Moscow};



        Country Azerbaijan = new Country("Azerbaijan",10000000,86600,"Baku","Asia");

        System.out.println("City with Most Population: " + (cities));





    }
}