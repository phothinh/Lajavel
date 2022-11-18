package App.Repository;

import App.Models.Partnair;

import java.util.List;

public class PartnairRepository {

    private PartnairRepository() {

    }

    public static List<Partnair> findAll() {
        Partnair burns = new Partnair("Charles", "Montgomery</br>Burns", "/images/index/sponsors/burns.png");
        Partnair otto = new Partnair("Otto", "Bus", "/images/index/sponsors/otto.png");
        Partnair homer = new Partnair("Homer", "Simpsons", "/images/index/sponsors/homer.png");
        Partnair skinner = new Partnair("Seymour", "Skinner", "/images/index/sponsors/skinner.png");
        Partnair krusty = new Partnair("Krusty", "le clown", "/images/index/sponsors/krusty.png");

        return List.of(burns, otto, homer,skinner, krusty);
    }
}
