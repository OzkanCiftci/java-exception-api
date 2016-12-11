package org.javaex.properties.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ExceptionConfigUtil {
  private static final String PROPERTY_FILENAME = "exception.config";

  private static Properties prop = new Properties();
  private static boolean isPropertyLoaded = false;


  public static String getProperty(String key) {
    if (!isPropertyLoaded) {
      loadProperties();
    }
    return prop.getProperty(key);
  }

  private static void loadProperties() {
    InputStream input = null;

    try {

      // input = new FileInputStream(propertyFileName);
      input = ExceptionConfigUtil.class.getClassLoader().getResourceAsStream(PROPERTY_FILENAME);

      // load a properties file
      prop.load(input);

      isPropertyLoaded = true;
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      if (input != null) {
        try {
          input.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

}
