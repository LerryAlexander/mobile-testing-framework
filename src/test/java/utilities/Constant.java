package utilities;

import java.time.Duration;

/***
 * constant with settings project
 *  
 */
public class Constant {

	/***
	 * constantes para setear las capabilities del driver
	 */
	public static String PLATFORM = System.getProperty("platform");
	public static String PLATFORM_VERSION = System.getProperty("platformVersion");
	public static final String LOCAL_URL = "http://127.0.0.1:4723/wd/hub";
	public static String LOCAL_ANDROID_NAME = System.getProperty("localAndroidName");
	public static final String CLASS_PATH_ROOT = "src/test/resources/apps/";
	public static final String ANDROID_APP_NAME =  "app-preproduction-jobget-14-jan.apk";
	public static final String IOS_APP_NAME =  "TBD";
	public static final String USER_DIR = System.getProperty("user.dir");
	public static final int CAPABILITY_TIMEOUT = 180000;

	public static final String PASSWORD = "123456";
	public static final String INDIA_PHONE_NUMBER = "857-990-4918";
	public static final String DEFAULT_OTP = "1234";

	public static Duration WAIT_UNTIL_DECORATOR = Duration.ofSeconds(30);
	public static Duration DURATION_TIMEOUT_DEFAULT = Duration.ofSeconds(20);
	public static Duration DURATION_POLLING_INTERVAL_MILLISECONDS = Duration.ofMillis(500);

	public static String DOCKER_ANDROID_APK_PATH = "/root/tmp/";
	public static String DOCKER_ANDROID_URL = "http://127.0.0.1:4444/wd/hub";
	public static String DOCKER_ANDROID_NAME = System.getProperty("dockerAndroidName");

	public static String RUN_MODE = System.getProperty("runMode");

	//Browserstack credentials (for running tests on the cloud)
	public static final String userName = "demofalabella_xSqyOi";
	public static final String accessKey = "zhW6c7NAKCxtNMMA5sUy";

	/* APP ID */
	public static final String APP_ID = "com.jobget:id";
	public static final String APP_BUNDLE_ID = "com.jobget";

	// Wait until actions
	public enum WaitActionEnum {
		CLICKABLE,
		VISIBLE,
	}

}
