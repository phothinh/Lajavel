package App.Models;

import App.Models.Enums.Continent;

public class Partnair {

    public String name;
    public Continent continent;
    public String description;

    public Partnair(String name, Continent continent, String description)
    {
        this.name = name;
        this.continent = continent;
        this.description = description;
    }

}
