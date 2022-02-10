package utilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.driver.DriverCapabilityFactory;
import utilities.driver.DriverManagerFactory;
import utilities.driver.DriverType;
import utilities.driver.type.DriverManagerAbstract;

import java.net.URL;

public class Hooks {

    private static Logger logger = LogManager.getLogger(Hooks.class.getName());
    protected static DriverManagerAbstract driverManager;
    protected static MobileDriver<MobileElement> driver;
    public Scenario scenario;

	public MobileDriver<MobileElement> getDriver() {
		return driver;
	}

	public Scenario getScenario() {
		return scenario;
	}

    /**
     * Si el driver es null, retorna la instancia de este segun plataforma
     *
     * @throws Exception se captura cualquier excepcion, no es recomendado.
     */
    public static void initializeDriver() throws Exception {
        if (driver == null) {
            try {
                driverInstance(Constant.PLATFORM);
            } catch (InterruptedException e) {
                logger.error("initializeDriver InterruptedException " + e.getMessage());
            }
        }
    }

    /**
     * Este metodo esta encargado de intanciar el driver, segun la plataforma seleccionada y las capabilities cargadas por defecto
     *
     * @param platform puede ser android o ios
     * @throws Exception se captura cualquier excepcion, no es recomendado.
     */
    private static void driverInstance(String platform) throws Exception {
        DesiredCapabilities capabilities;
        DriverCapabilityFactory driverCapabilityFactory = new DriverCapabilityFactory();
        switch (platform.toLowerCase()) {
            case "android":
                capabilities = driverCapabilityFactory.initDesiredCapabilities(Constant.PLATFORM, Constant.PLATFORM_VERSION);
                if(Constant.RUN_MODE.equalsIgnoreCase("local")){
                    driverManager = DriverManagerFactory.getManager(DriverType.SIMULATOR_ANDROID);
                    driver = driverManager.getNewRemoteDriver(new URL(Constant.LOCAL_URL), capabilities);
                }else if(Constant.RUN_MODE.equalsIgnoreCase("docker")){
                    driverManager = DriverManagerFactory.getManager(DriverType.SIMULATOR_ANDROID);
                    driver = driverManager.getNewRemoteDriver(new URL(Constant.DOCKER_ANDROID_URL), capabilities);
                }else{
                    driverManager = DriverManagerFactory.getManager(DriverType.BROWSERSTACK);
                    driver = driverManager.getNewRemoteDriver(new URL("https://"+Constant.userName+":"+Constant.accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);
                }
                logger.info("DriverInstance " + platform + " remote driver ok");
                break;
            case "ios":
                driverManager = DriverManagerFactory.getManager(DriverType.SIMULATOR_IOS);
                capabilities = driverCapabilityFactory.initDesiredCapabilities(Constant.PLATFORM, Constant.PLATFORM_VERSION);
                driver = driverManager.getNewRemoteDriver(new URL(Constant.LOCAL_URL), capabilities);
                logger.info("DriverInstance " + platform + " remote driver ok");
                break;
            default:
                logger.error("driverInstance default IllegalStateException" + platform);
                throw new IllegalStateException("Unexpected value PLATFORM: " + platform);
        }
    }

    /**
     * HOOKS Si necesitas agregar hooks para capturar eventos antes de un step o después de uno, debes usar:
     * @BeforeStep public void beforeStep() { }
     * @AfterStep public void afterStep() { }
     */

    @Before
    public void beforeScenario(Scenario scenario) {
        logger.info("BEFORE Scenario: " + scenario.getName());
        this.scenario = scenario;
        launchApp();
    }

    @After
    public void afterScenario(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
                logger.info("AFTER Scenario: isFailed - TakesScreenshot OK");
            }
        } catch (Throwable e) {
            logger.error("AFTER Scenario: Throwable " + e.getMessage());
        }
        closeApp();
    }

    /**
     * Este metodo verifica si la app esta instalada en el device, en caso de que no,
     * la instala y la abre, en caso contrario, simplemente la abre
     */
    public void launchApp() {
        driver = getDriver();
         try {
            if (!driver.isAppInstalled(Constant.APP_BUNDLE_ID)) {
                driver.installApp(Constant.USER_DIR+"/src/test/resources/apps/android/" + Constant.ANDROID_APP_NAME);
                logger.info("App is now installed on device");
            }
             driver.launchApp();
             logger.info("App is launched");
        }catch (Exception e){
            logger.error("Error on launchApp() method: "+e.getMessage());
        }
    }

    /**
     * Este metodo verifica si la app esta instalada en el device,
     * y en caso de que si, la desinstala
     */
    public void removeApp(){
        driver = getDriver();
        try{
            if (driver.isAppInstalled(Constant.APP_BUNDLE_ID)) {
                driver.removeApp(Constant.APP_BUNDLE_ID);
                logger.info("App is removed from device");
            }
        }catch (Exception e){
            logger.error("Error on removeApp() method: "+e.getMessage());
        }
    }

    /**
     * Este metodo verifica si la app esta instalada en el device,
     * y en caso de que si, la cierra
     */
    public void closeApp() {
        driver = getDriver();
        try{
            if (driver.isAppInstalled(Constant.APP_BUNDLE_ID)) {
                driver.closeApp();
                logger.info("The App is closed");
            }
        }catch (Exception e){
            logger.error("Error on removeApp() method: "+e.getMessage());
        }
    }

}
