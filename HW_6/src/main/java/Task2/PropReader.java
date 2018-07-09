package Task2;

import lombok.Cleanup;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropReader {
    public static Properties getProp(String path) {
        try {
            @Cleanup InputStreamReader reader = new FileReader(path);
            Properties prop = new Properties();
            prop.load(reader);
            return prop;
        } catch (FileNotFoundException e) {
            System.out.println(String.format("ERROR! File \"%s\" does not exist!", path));
            return null;
        } catch (IOException e) {
            System.out.println(String.format("ERROR! IOException while trying to reach \"%s\"!", path));
            return null;
        }
    }

    public static Map<String, String> getPropFromFile(String path) {
        Properties prop = getProp(path);
        if (prop != null) {
            Enumeration<?> e = prop.propertyNames();
            Map<String, String> propMap = new HashMap<>();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                propMap.put(key, prop.getProperty(key));
            }
            return propMap;
        }
        return null;
    }

    public static String getPropByName(String path, String key) {
        try {
            Map<String, String> propMap = getPropFromFile(path);
            if (propMap.containsKey(key))
                return propMap.get(key);
            else
                throw new NoSuchKeyException();
        } catch (NoSuchKeyException ex) {
            System.out.println(String.format("ERROR! There is no key \"%s\" in file \"%s\"!", key, path));
            return null;
        }
    }
}

class NoSuchKeyException extends Exception {}