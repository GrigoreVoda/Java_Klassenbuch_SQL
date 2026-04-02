package com.grigore.config;

import java.io.InputStream;
import java.util.Properties;

public class DbConfig {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = DbConfig.class.getClassLoader().getResourceAsStream("db.properties")){
            if (input == null){
                throw new RuntimeException("Unable to find db.properties");
            }
            properties.load(input);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String get(String key){
        return properties.getProperty(key);
    }
}
