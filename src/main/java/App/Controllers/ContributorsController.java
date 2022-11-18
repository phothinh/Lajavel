package App.Controllers;

import App.Models.Contributor;
import App.Models.Partnair;
import App.Repository.ContributorRepository;
import App.Repository.PartnairRepository;
import Lajavel.Controller;
import Lajavel.Response;
import Lajavel.View;
import io.javalin.http.Context;

import java.util.List;
import java.util.Map;

public class ContributorsController extends Controller {
    public void contributors(Response response) throws Exception {
        List<Contributor> contributors = ContributorRepository.findAll();

        response.html(View.make("contributors",
                Map.entry("krusty", contributors.get(0)),
                Map.entry("moe", contributors.get(1)),
                Map.entry("nuclear", contributors.get(2)),
                Map.entry("school", contributors.get(3)))
        );
    }
}
