package App.Repository;

import App.Models.Contributor;
import App.Models.Enums.Continent;

import java.util.List;

public class ContributorRepository {

    private ContributorRepository() {

    }

    public static List<Contributor> findAll() {
        Contributor krusty_burger = new Contributor("KRUSTY BURGER", Continent.NA, "Krusty Burger is a fast-food burger restaurant chain that was founded by Krusty the Clown in Springfield, but has locations in many cities.", "/images/contributors/krusty-burger.png" );
        Contributor moe_tavern = new Contributor("MOE'S TAVERN", Continent.NA, "Moe's Tavern, or simply called Moe's, is the local bar in Springfield. The bar is named after its owner: Moe Szyslak. It is the only known tavern in Springfield, though there is a Joe's Tavern in Shelbyville. Moe's is located right next to King Toot's Music Store", "/images/contributors/moe-tavern.png" );
        Contributor nuclear = new Contributor("NUCLEAR POWER PLANT", Continent.NA, "The Springfield Nuclear Power Plant (SNPP) is a two-unit pressurized water reactor nuclear power plant owned by Mr. Burns and is the main source of power in Springfield. Homer works here at sector 7G.","/images/contributors/nuclear-power-plant.png");
        Contributor school = new Contributor("ELEMENTARY SCHOOL", Continent.NA, "Springfield Elementary School is an elementary school that Bart Simpson, Lisa Simpson, and many other children of Springfield, such as Nelson Muntz, Janey Powell, Sherri and Terri. Jimbo Jones, Martin Prince, Ralph Wiggum, and Milhouse Van Houten attend.","/images/contributors/elementary-school.png");

        return List.of(krusty_burger, moe_tavern, nuclear ,school);
    }
}
