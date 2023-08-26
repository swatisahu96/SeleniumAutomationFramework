package org.example.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class propReader {

    public propReader() {
    }

    static Properties properties = null;
    static FileInputStream fs;
    static Map<String, String> PROP_KEYS= new HashMap<>();

    static {
        try {
            fs = new FileInputStream(new File(System.getProperty("user.dir") + "/src/test/resources/config.properties"));
            properties= new Properties();
            properties.load(fs);

            for(Object key: properties.keySet()){
                PROP_KEYS.put(String.valueOf(key), properties.getProperty(String.valueOf(key)));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
          if(Objects.nonNull(fs)){
              try {
                  fs.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
        }
    }

    public static String readKey(String key) throws Exception {
        if (key == null && properties.getProperty(key) == null) {
            throw new Exception(properties.getProperty(key) + "not found!!");
        } else {
            return PROP_KEYS.get(key);
        }
    }

}
