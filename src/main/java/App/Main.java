package App;

import App.Controllers.ContributorsController;
import App.Controllers.StartController;
import Lajavel.*;
import App.Controllers.IndexController;

public class Main {
    public static void main(String[] args) throws Exception {

        Application app = Application.start(7071, Application.Mode.DEVELOPMENT);

        Route.register(HTTPVerb.GET,
                "/",
                IndexController.class,
                "index");

        Route.register(HTTPVerb.GET,
                "/getting-started",
                StartController.class,
                "start");

        Route.register(HTTPVerb.GET,
                "/contributors",
                ContributorsController.class,
                "contributors");


    }
}