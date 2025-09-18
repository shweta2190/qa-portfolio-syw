package utils;

import java.util.Properties;
import java.io.InputStream;

public class Config {
    private static Properties props = new Properties();

    static {
        try (InputStream in = Config.class.getResourceAsStream("/config.properties")) {
            if (in != null) props.load(in);
        } catch (Exception ignored) {}
    }

    public static String get(String key) {
        return System.getProperty(key, props.getProperty(key));
    }
}
