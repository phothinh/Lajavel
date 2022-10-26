package App.Controllers;

import Lajavel.Controller;
import Lajavel.View;
import io.javalin.http.Context;

public class PartnerController extends Controller {
    public void show(Context context) throws Exception {
        context.html(View.make("show"));
    }
}
