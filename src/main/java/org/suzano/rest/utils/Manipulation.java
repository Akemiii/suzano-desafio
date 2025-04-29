package org.suzano.rest.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Manipulation {

    private Manipulation() {
    }

    public static Properties getProp() {
        Properties props = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/properties/application.properties");
            props.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    public static String getUserName() {
        return getProp().getProperty("User.username");
    }

    public static String getUserPassword() {
        return getProp().getProperty("User.password");
    }
}
