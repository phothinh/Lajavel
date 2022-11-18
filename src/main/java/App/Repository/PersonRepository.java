package App.Repository;

import App.Models.Person;

import java.util.List;

public class PersonRepository {

    private PersonRepository() {

    }

    public static List<Person> findAll() {
        Person henri = new Person("Henri", "Pth");
        Person benji = new Person("Benji", "Marques");
        return List.of(henri, benji);
    }
}
