package projects.superclasses;


public class Country {
    private int id;
    private String name;
    private String continent;
    private long population;
    private String code;
    private int cityCount;

    private City[] cities = new City[10];

    int index;


    public Country(int id, String name, String continent, long population, String code, int cityCount) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.code = code;
        this.cityCount = cityCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCityCount() {
        return cityCount;
    }

    public void setCityCount(int cityCount) {
        this.cityCount = cityCount;
    }



    public int addCity(City city) {
        if(index == 10) {
            System.out.println("City Couldn't be added. City Limit Exceeded");
            return 0;
        }
        cities[index] = city;
        index++;
        return 1;
    }

    public int deleteCityWithId(int id) {

        int tempIndex = findCityById(id);
        if(tempIndex == -1) return 0;

        cities[tempIndex] = null;
        shiftCities(index);
        return 1;
    }

    public int deleteCityWithName(String name) {
        int tempIndex = findCityByName(name);
        if(tempIndex == -1) return 0;

        cities[tempIndex] = null;
        shiftCities(index);
        return 1;
    }


    private int findCityById(int id) {
        for(int i=0; i<index; i++) {
            if(cities[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private int findCityByName(String name) {
        for(int i=0; i<index; i++) {
            if(cities[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }


    private void shiftCities(int index){
        for(int i = index; i<index-1; i++){
            cities[i] = cities[i+1];
        }
        cities[index-1] = null;
        index--;
    }



    @Override
    public String toString() {
        return  getName()+"{"+
                "id=" + id +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", population=" + population +
                ", code='" + code + '\'' +
                ", cityCount=" + cityCount;
    }
}
