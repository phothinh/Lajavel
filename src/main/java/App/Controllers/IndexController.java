package App.Controllers;

import Lajavel.Controller;
import App.Models.Person;
import Lajavel.Response;
import Lajavel.View;

import java.util.Map;

public class IndexController extends Controller {
    public void index(Response response) throws Exception {
        Person henri = new Person("Henri", "Pth");
        Person benji = new Person("Benji", "Marques");
        response.html(View.make("index",
                Map.entry("person", henri),
                Map.entry("person2", benji))
        );
    }
}
