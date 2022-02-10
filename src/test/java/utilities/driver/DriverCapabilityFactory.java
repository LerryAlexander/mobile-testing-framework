package utilities.driver;

import java.io.File;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.apache.tools.ant.Project;
import utilities.Constant;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverCapabilityFactory {

    private final DesiredCapabilities capabilities = new DesiredCapabilities();

    public DesiredCapabilities initDesiredCapabilities(final String platform, final String platformVersion) {
        File classPathRoot = new File(Constant.USER_DIR);
        File app;
        File appDir;
        switch (platform.toLowerCase()) {
            case "android":
                appDir = new File(classPathRoot, Constant.CLASS_PATH_ROOT + "android");
                app = new File(appDir, Constant.ANDROID_APP_NAME);
                capabilities.setCapability("platformName", Constant.PLATFORM);
                capabilities.setCapability("platformVersion", Constant.PLATFORM_VERSION);
                capabilities.setCapability("newCommandTimeout", Constant.CAPABILITY_TIMEOUT);
                capabilities.setCapability("autoGrantPermissions", "true");
                switch (Constant.RUN_MODE.toLowerCase()){
                    case "local":
                        capabilities.setCapability("app", app.getAbsolutePath());
                        break;
                    case "docker":
                        capabilities.setCapability("app", Constant.DOCKER_ANDROID_APK_PATH+Constant.ANDROID_APP_NAME);
                        break;
                    case "cloud":
                        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
                        capabilities.setCapability("app", "bs://3f77ba2bfcb42777aba0c310a4fd8eedb8fb2e53");
                        capabilities.setCapability("platformVersion", "10.0");
                        capabilities.setCapability("project", "JobGet Testing Framework");
                        capabilities.setCapability("build", "JobGet - Android Automated Tests");
                        capabilities.setCapability("name", "[Java] JobGet "+System.getProperty("cucumber.options").replace("--tags @","")+" Tests");
                        break;
                    default: throw new IllegalStateException("Unexpected runMode value, please type either local or docker value: " + Constant.RUN_MODE);
                }
                capabilities.setCapability("clearSystemFiles", true);
                //capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, Boolean.parseBoolean(System.getenv("DOCKER_ANDROID_SCREENSHOT")));
                platformVersionCapabilities(platformVersion);
                break;
            case "ios":
                appDir = new File(classPathRoot, Constant.CLASS_PATH_ROOT + "ios");
                app = new File(appDir, Constant.IOS_APP_NAME);
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("platformVersion", "12.4");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("clearSystemFiles", true);
                capabilities.setCapability("deviceName", "Iphone8v12.4");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("udid", "4D8D3219-02B2-437C-A944-A474DEACD74B");
                capabilities.setCapability("useNewWDA", true);
                capabilities.setCapability("autoAcceptAlerts",true);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + platform);
        }
        return capabilities;
    }

    private void platformVersionCapabilities(final String platformVersion) {
        String ANDROID_NAME;
        if(Constant.RUN_MODE.equalsIgnoreCase("local")){
            ANDROID_NAME = Constant.LOCAL_ANDROID_NAME;
        }else if(Constant.RUN_MODE.equalsIgnoreCase("docker")){
            ANDROID_NAME = Constant.DOCKER_ANDROID_NAME;
        }else {
            ANDROID_NAME = "Google Pixel 4 XL";
        }
        switch (platformVersion) {
            case "5.1":
                capabilities.setCapability("deviceName", ANDROID_NAME);
                capabilities.setCapability("automationName", "appium");
                break;
            case "6.0":
                capabilities.setCapability("deviceName", ANDROID_NAME);
                capabilities.setCapability("automationName", "appium");
                break;
            case "7.0":
                capabilities.setCapability("deviceName", ANDROID_NAME);
                capabilities.setCapability("automationName", "uiautomator2");
                break;
            case "8.0":
                capabilities.setCapability("deviceName", ANDROID_NAME);
                capabilities.setCapability("automationName", "uiautomator2");
                break;
            case "9": // según la versión de appium server se reconoce 9 y/o 9.0 siendo este ultimo la versión más actualizada
                capabilities.setCapability("deviceName", ANDROID_NAME);
                capabilities.setCapability("automationName", "uiautomator2");
                break;
            case "9.0":
                capabilities.setCapability("deviceName", ANDROID_NAME);
                capabilities.setCapability("automationName", "uiautomator2");
                break;
        }
    }
}
