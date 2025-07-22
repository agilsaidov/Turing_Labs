package projects.country_subclasses;

import projects.superclasses.City;
import projects.superclasses.Country;

public class EuropeanCountry extends Country {
    private boolean isInEuropeanUnion;
    private String mainExport;
    private int foundingYear;

    public EuropeanCountry(int id, String name, String continent, long population, String code, int cityCount, boolean isInEuropeanUnion, String mainExport, int foundingYear) {
        super(id, name, continent, population, code, cityCount);
        this.isInEuropeanUnion = isInEuropeanUnion;
        this.mainExport = mainExport;
        this.foundingYear = foundingYear;
    }

    public boolean isInEuropeanUnion() {
        return isInEuropeanUnion;
    }

    public void setInEuropeanUnion(boolean inEuropeanUnion) {
        isInEuropeanUnion = inEuropeanUnion;
    }

    public String getMainExport() {
        return mainExport;
    }

    public void setMainExport(String mainExport) {
        this.mainExport = mainExport;
    }

    public int getFoundingYear() {
        return foundingYear;
    }

    public void setFoundingYear(int foundingYear) {
        this.foundingYear = foundingYear;
    }



    @Override
    public String toString() {
        return super.toString() +
                ", isInEuropeanUnion=" + isInEuropeanUnion +
                ", mainExport='" + mainExport + '\'' +
                ", foundingYear=" + foundingYear +'}';
    }
}
