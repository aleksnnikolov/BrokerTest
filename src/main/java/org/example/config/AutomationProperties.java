package org.example.config;

import lombok.extern.log4j.Log4j2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Log4j2
public class AutomationProperties {

    public static String PROPERTIES_PATH = "src/main/resources/application.properties";

    public static String BROWSER_TYPE = "selenium.browser.type";
    public static String IMPLICIT_WAIT_TIMEOUT = "selenium.timeout.implicit";

    private static AutomationProperties instance;
    Properties properties = new Properties();

    public static AutomationProperties getInstance() {
        if (instance == null) {
            instance = new AutomationProperties();
        }

        return instance;
    }

    private AutomationProperties() {
        try {
            properties.load(new FileInputStream(PROPERTIES_PATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Application.properties file not found", e);
        } catch (IOException e) {
            throw new RuntimeException("errore during properties loading", e);
        }

        log.info("Loaded properties: ");
        properties.forEach((key, value) -> log.info("[" + key + " = " + value + "]"));
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

}
