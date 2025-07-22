package turing.SuperClasses;

public class City {
    private String name;
    private String postalCode;
    private int population;
    private double area;

    public City(String name, String postalCode, int population, double area) {
        this.name = name;
        this.postalCode = postalCode;
        this.population = population;
        this.area = area;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int percentage(Country country) {
        return this.population * 100 / country.getPopulation();
    }


    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", population=" + population +
                ", area=" + area +
                '}';
    }
}
