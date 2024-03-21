package config;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    @Getter
    private static final AppConfig instance = new AppConfig();
    private final Properties properties = new Properties();

    private AppConfig() {
        try {
            var file = new FileInputStream("src/main/resources/config.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file", e);
        }
    }

    public String getJsonPath() {
        return getValue("jsonPath");
    }

    public String getXmlPath() {
        return getValue("xmlPath");
    }

    private String getValue(String key) {
        return properties.getProperty(key);
    }
}
