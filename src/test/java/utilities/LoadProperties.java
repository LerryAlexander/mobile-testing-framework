package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
    private Logger logger = LogManager.getLogger(LoadProperties.class.getName());

    private static final String PLATFORM_VERSION = "PLATFORM_VERSION";
    public static final String PLATFORM = "PLATFORM";
    private static final String RUN_MODE = "RUN_MODE";
    private static Properties properties;
    private static InputStream inputStream;
    private static LoadProperties instance;

    private LoadProperties() {
        properties = new Properties();
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");

            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                logger.error("[LoadProperties] config.properties - FileNotFoundException: property file not found in the classpath");
                throw new FileNotFoundException("property file not found in the classpath");
            }
        } catch (IOException ioe) {
            logger.error("[LoadProperties] config.properties - IOException: " + ioe.getMessage());
        }
    }

    static LoadProperties getInstance() {
        if (null == instance) instance = new LoadProperties();
        return instance;
    }

    String getPlatformVersion() {
        return properties.getProperty(PLATFORM_VERSION);
    }

    public String getPlatform() {
        return properties.getProperty(PLATFORM);
    }

    public String getRunMode() {
        return properties.getProperty(RUN_MODE);
    }

}
