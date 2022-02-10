package utilities.driver;

import utilities.driver.type.*;

public class DriverManagerFactory {
    /**
     * Factory encargada de generar el Manager del driver según el tipo que se solicita
     * por ejemplo, si necesito generar la configuración +  el driver de un device de ios puedo generar la estructura básica desde aquí
     * @param driverType REAL_DEVICE, BROWSERSTACK, SIMULATOR_ANDROID, SIMULATOR_IOS
     * @return DriverManagerAbstract
     */
    public static DriverManagerAbstract getManager(final DriverType driverType) {
        DriverManagerAbstract driverManager;
        switch (driverType) {
            case REAL_DEVICE:
                return driverManager = new RealDeviceDriverManager();
            case BROWSERSTACK:
                return driverManager = new BrowserStackDriverManager();
            case SIMULATOR_ANDROID:
                return driverManager = new AndroidSimulatorDriverManager();
            case SIMULATOR_IOS:
                return driverManager = new IOSSimulatorDriverManager();
            default:
                throw new IllegalStateException("Unexpected value: " + driverType);
        }
    }
}
