package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    protected static Properties petClinicProperties;

    public static void initializeProperties(){
        File petClinicConfigFile = new File("src/main/resources/petClinic-QA.properties");

        petClinicProperties = new Properties();
        try {
            petClinicProperties.load(new FileInputStream(petClinicConfigFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getPetClinicProperty(String key){
        return petClinicProperties.getProperty(key);
    }
}
