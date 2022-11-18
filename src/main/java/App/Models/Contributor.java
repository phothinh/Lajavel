package App.Models;

import App.Models.Enums.Continent;

public class Contributor {

    public String name;
    public Continent continent;
    public String description;
    public String image;

    public Contributor(String name, Continent continent, String description, String image)
    {
        this.name = name;
        this.continent = continent;
        this.description = description;
        this.image = image;
    }
}
