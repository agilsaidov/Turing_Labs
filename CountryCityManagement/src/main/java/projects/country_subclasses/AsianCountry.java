package projects.country_subclasses;

import projects.superclasses.City;
import projects.superclasses.Country;

public class AsianCountry extends Country {
    private double gdpPerCapita;
    private boolean hasNuclearPower;
    private String mainReligion;

    public AsianCountry(int id, String name, String continent, long population, String code, int cityCount, double gdpPerCapita, boolean hasNuclearPower, String mainReligion) {
        super(id, name, continent, population, code, cityCount);
        this.gdpPerCapita = gdpPerCapita;
        this.hasNuclearPower = hasNuclearPower;
        this.mainReligion = mainReligion;
    }

    public double getGdpPerCapita() {
        return gdpPerCapita;
    }

    public void setGdpPerCapita(double gdpPerCapita) {
        this.gdpPerCapita = gdpPerCapita;
    }

    public boolean isHasNuclearPower() {
        return hasNuclearPower;
    }

    public void setHasNuclearPower(boolean hasNuclearPower) {
        this.hasNuclearPower = hasNuclearPower;
    }

    public String getMainReligion() {
        return mainReligion;
    }

    public void setMainReligion(String mainReligion) {
        this.mainReligion = mainReligion;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", gdpPerCapita=" + gdpPerCapita +
                ", hasNuclearPower=" + hasNuclearPower +
                ", mainReligion='" + mainReligion + '\''+'}';
    }
}
