package projects.arrays;

import projects.superclasses.City;
import projects.superclasses.Country;

public class GlobalArrays {
    private static int indexCity;
    private static int indexCountry;

    private static City[] globalCities = new City[100];

    private static Country[] globalCountries = new Country[100];

    public int saveGlobalCity(City city){

        if(indexCity ==globalCities.length) return 0;
        globalCities[indexCity] = city;
        indexCity++;
        return 1;

    }

    public int saveGlobalCountry(Country country){

        if(indexCountry == globalCountries.length) return 0;
        globalCountries[indexCountry] = country;
        indexCountry++;
        return 1;

    }

    public City deleteGlobalCity(int id){
        int tempIndex = findIndexCityById(id);
        if(tempIndex == -1) return null;

        City result = globalCities[tempIndex];
        globalCities[tempIndex] = null;
        shiftCities(tempIndex);
        return result;
    }

    public City deleteGlobalCity(String name){
        int tempIndex = findIndexCityByName(name);
        if (tempIndex== -1) return null;

        City result = globalCities[tempIndex];
        globalCities[tempIndex] = null;
        shiftCities(tempIndex);
        return result;

    }


    public int deleteGlobalCountry(int id){
        int tempIndex = findIndexCountryById(id);
        if (tempIndex == -1) return 0;

        Country countryToDelete = globalCountries[tempIndex];

        for(int i = indexCity-1; i>=0; i--){
            City city = globalCities[i];
            if(city != null && city.getCountry().equals(countryToDelete)) {
                deleteGlobalCity(city.getId());
            }
        }

        shiftCountries(tempIndex);
        return 1;

    }

    public int deleteGlobalCountry(String name){
        int tempIndex = findIndexCountryByName(name);
        if(tempIndex == -1) return 0;

        Country countryToDelete = globalCountries[tempIndex];
        for(int i = indexCity-1 ; i >= 0; i--){
            City city = globalCities[i];
            if(city != null && city.getCountry().equals(countryToDelete)){
                deleteGlobalCity(city.getId());
            }
        }
        shiftCountries(tempIndex);
        return 1;

    }


    public Country getCountry(int id ,String name){
        if (name == null || id<0) return null;

        for(int i = 0 ; i < indexCountry; i++){

            Country country = globalCountries[i];
            if( country != null && (country.getName().equals(name) || country.getId() == id)){
                return country;
            }
        }
        return null;
    }


    public Country getCountry(int id) {
        int tempIndex = findIndexCountryById(id);
        if (tempIndex == -1) return null;
        else return globalCountries[tempIndex];
    }

    public Country getCountry(String name) {
        int tempIndex = findIndexCountryByName(name);
        if (tempIndex == -1) return null;
        else return globalCountries[tempIndex];
    }

    public City getCity(int id){
        int tempIndex = findIndexCityById(id);
        if (tempIndex == -1) return null;
        else return globalCities[tempIndex];
    }

    public City getCity(String name) {
        int tempIndex = findIndexCityByName(name);
        if (tempIndex == -1) return null;
        else return globalCities[tempIndex];
    }



    //Helper Methods
    private int findIndexCityById(int id){
        if( id <0) return -1;

        for (int i = 0; i < indexCity; i++) {
            if (globalCities[i] != null && globalCities[i].getId() == id) return i;
        }
        return -1;
    }

    private int findIndexCityByName(String name){
        for (int i = 0; i < indexCity; i++) {
            if (globalCities[i].getName().equals(name)) return i;
        }
        return -1;
    }

    private int findIndexCountryById(int id){
        if (id <0) return -1;

        for (int i = 0; i < indexCountry; i++) {
            if (globalCountries[i].getId() == id) return i;
        }
        return -1;
    }

    private int findIndexCountryByName(String name){
        for (int i = 0; i < indexCountry; i++) {
            if (globalCountries[i].getName().equals(name)) return i;
        }
        return -1;
    }

    private void shiftCities(int index){
        for(int i = index; i<indexCity-1; i++){
            globalCities[i] = globalCities[i+1];
        }
        globalCities[indexCity-1] = null;
        indexCity--;
    }

    private void shiftCountries(int index){
        for(int i = index; i<indexCountry-1; i++){
            globalCountries[i] = globalCountries[i+1];
        }
        globalCountries[indexCountry-1] = null;
        indexCountry--;
    }

    public void showCities(){
       for(int i =0 ; i<indexCity; i++){
           if(globalCities[i] != null) {
               System.out.println(globalCities[i].toString());
           }
       }
    }
    public void showCountries(){
        for(int i =0 ; i<indexCountry; i++){
            if(globalCountries[i] != null) {
                System.out.println(globalCountries[i].toString());
            }
        }
    }

}
