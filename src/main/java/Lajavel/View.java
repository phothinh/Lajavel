package Lajavel;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class View {

    public static String make(String viewName, Map.Entry<String, Object>... entries) throws Exception {

        String rawHtml = View.getViewContentFromName(viewName);

        Matcher matcher = Pattern.compile( "\\{\\{([^{{}}]*)\\}\\}").matcher(rawHtml);

        StringBuffer sb = new StringBuffer();

        while (matcher.find()){ // {{ person.firstname }}
            String rawStringOfAnObject = matcher.group(1).replaceAll("\\s+", "");
            String[] objectAndProperty = rawStringOfAnObject.split("\\.");

            if(objectAndProperty.length <= 1) {
                throw new Exception("You must specify an object and property in your html");
            }

            String objectName = objectAndProperty[0];
            String propertyName = objectAndProperty[1];

            // 1 = henri : Person, 2 = benji : Person
            for (Map.Entry<String, Object> entry : entries) {
                //String simpleClassName = object.getClass().getSimpleName().toLowerCase();
                if(entry.getKey().equals(objectName)) {
                    matcher.appendReplacement(sb, View.getValueOf(propertyName, entry.getValue()));
                    break;
                }
            }
        }

        matcher.appendTail(sb);

        return sb.toString();
    }


    public static String getValueOf(String propertyName, Object object)
    {
        boolean isMethod = false;
        if(propertyName.endsWith("()")) {
            isMethod = true;
            propertyName = propertyName.replace("()","");
        }

        if(!isMethod) {
            String propertyValue = getProperty(object, propertyName);
            return propertyValue.toString();
        }
        else {
            return getMethod(object, propertyName);
        }
    }
    public static String getProperty(Object obj, String property) {
        String returnValue = null;

        try {
            Field field = obj.getClass().getDeclaredField(property);
            field.setAccessible(true);
            returnValue = field.get(obj).toString();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return returnValue;
    }

    public static String getMethod(Object obj, String methodName) {
        String returnValue = null;

        try{
            Method method = obj.getClass().getMethod(methodName);
            method.setAccessible(true);
            returnValue = method.invoke(obj).toString();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return returnValue;
    }

    private static String getViewContentFromName(String viewName) {
        URL resource  = View.class.getClassLoader().getResource("views/" + viewName + ".javel");

        if (resource == null)
        {
            throw new RuntimeException("File : " + viewName + " not found:");
        }

        try {
            return Files.readString(Path.of(resource.toURI()), StandardCharsets.UTF_8);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
