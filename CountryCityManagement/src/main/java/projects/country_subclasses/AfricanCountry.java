package projects.country_subclasses;

import projects.superclasses.City;
import projects.superclasses.Country;

public class AfricanCountry extends Country {
    private String mainLanguage;
    private boolean isDeveloping;
    private String currency;

    public AfricanCountry(int id, String name, String continent, long population, String code, int cityCount, String mainLanguage, boolean isDeveloping, String currency) {
        super(id, name, continent, population, code,cityCount);
        this.mainLanguage = mainLanguage;
        this.isDeveloping = isDeveloping;
        this.currency = currency;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    public void setMainLanguage(String mainLanguage) {
        this.mainLanguage = mainLanguage;
    }

    public boolean isDeveloping() {
        return isDeveloping;
    }

    public void setDeveloping(boolean developing) {
        isDeveloping = developing;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", mainLanguage='" + mainLanguage + '\'' +
                ", isDeveloping=" + isDeveloping +
                ", currency='" + currency + '\''+'}';
    }
}
