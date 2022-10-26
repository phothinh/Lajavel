package App.Controllers;

import Lajavel.Controller;
import Lajavel.Response;
import Lajavel.View;
import io.javalin.http.Context;

public class StartController extends Controller {
    public void start(Response response) throws Exception {
        response.html(View.make("start"));
    }
}
