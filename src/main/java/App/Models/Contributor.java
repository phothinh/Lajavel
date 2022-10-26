package App.Models;

import App.Models.Enums.Continent;

public class Contributor {

    public String name;
    public Continent continent;

    public Contributor(String name, Continent continent)
    {
        this.name = name;
        this.continent = continent;
    }
}
