package App.Models.Enums;

public enum Continent {
    NA("North America"),
    SA("South America"),
    ASIA("Asia"),
    AFR("Africa"),
    ANT("Antartica"),
    EU("Europe"),
    AUS("Australia");

    private final String text;

    Continent(final String text){
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
