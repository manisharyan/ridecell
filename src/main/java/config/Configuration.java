package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    public static final String chromeKey = "webdriver.chrome.driver";
    public static final String fireFoxKey = "webdriver.gecko.driver";
    public static final String ieKey = "webdriver.ie.driver";
    static Properties properties;

//    private Configuration() {
//
//    }

    public static void loadConfig() {
        properties = new Properties();
        try {
            InputStream in = new FileInputStream(new File("src/main/java/config/input.properties").getAbsolutePath());
            properties.load(in);
        } catch (Exception e) {

        }
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }
}
