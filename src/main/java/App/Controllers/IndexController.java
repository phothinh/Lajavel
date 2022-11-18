package App.Controllers;

import App.Models.Partnair;
import App.Repository.PartnairRepository;
import App.Repository.PersonRepository;
import Lajavel.Controller;
import App.Models.Person;
import Lajavel.Response;
import Lajavel.View;

import java.util.List;
import java.util.Map;

public class IndexController extends Controller {
    public void index(Response response) throws Exception {
        List<Partnair> partnairs = PartnairRepository.findAll();

        response.html(View.make("index",
                Map.entry("burns", partnairs.get(0)),
                Map.entry("otto", partnairs.get(1)),
                Map.entry("homer", partnairs.get(2)),
                Map.entry("skinner", partnairs.get(3)),
                Map.entry("krusty", partnairs.get(4)))
        );
    }
}
