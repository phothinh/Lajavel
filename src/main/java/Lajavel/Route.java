package Lajavel;

import io.javalin.http.Context;

import java.lang.reflect.Method;

public class Route {
    public final HTTPVerb httpverb;

    private Route(HTTPVerb httpverb)
    {
        this.httpverb = httpverb;
    }

    public static void register(HTTPVerb httpverb, String routeName, Class<?> controllerClass, String methodName)
    {

        Application app = Application.getInstance();

        switch (httpverb) {
            case GET -> app.server.get(routeName, context -> {
                InvokeController(context, controllerClass, methodName);
            });
            case HEAD -> app.server.head(routeName, context -> {
                InvokeController(context, controllerClass, methodName);
            });
            case POST -> app.server.post(routeName, context -> {
                InvokeController(context, controllerClass, methodName);
            });
            case PUT -> app.server.put(routeName, context -> {
                InvokeController(context, controllerClass, methodName);
            });
            case DELETE -> app.server.delete(routeName, context -> {
                InvokeController(context, controllerClass, methodName);
            });
            case OPTIONS -> app.server.options(routeName, context -> {
                InvokeController(context, controllerClass, methodName);
            });
            case PATCH -> app.server.patch(routeName, context -> {
                InvokeController(context, controllerClass, methodName);
            });
        }
    }

    public static void InvokeController(Context context, Class<?> controllerClass, String methodName) throws Exception
    {
        Response response = new Response(context);
        Controller controller = (Controller) controllerClass.getDeclaredConstructor().newInstance();
        Method controllerMethod = controllerClass.getDeclaredMethod(methodName, Response.class);

        controllerMethod.invoke(controller, response);
    }
}
