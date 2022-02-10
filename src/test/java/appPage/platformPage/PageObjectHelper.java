package appPage.platformPage;

import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Constant;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import java.time.Duration;

public class PageObjectHelper {



    /**
     * This method wait until an element is not displayed
     *
     * @param locator Locator that you want evaluate
     * @param timeout value in seconds
     * @return true if the element is not displayed or false if it is still displayed
     */
    public static boolean waitUntilElementNotDisplayed(MobileDriver driver, final By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (TimeoutException t) {
            return true;
        }
    }

    /**
     * This method check if an element is visible.
     * @param driver MobileDriver
     * @param element MobileElement used to find the element
     * @param timeOutInSeconds Duration
     * @return true if it is visible and has non-zero size, otherwise false.
     */
    public static boolean waitElementDisplayed(MobileDriver driver, MobileElement element, Duration...timeOutInSeconds) {
        final Duration timeout = timeOutInSeconds.length == 0 ? Constant.DURATION_TIMEOUT_DEFAULT : timeOutInSeconds[0];
        try {
            FluentWait<MobileDriver> fluentWait = new FluentWait<MobileDriver>(driver)
                    .pollingEvery(Constant.DURATION_POLLING_INTERVAL_MILLISECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class)
                    .withTimeout(timeout);
            return fluentWait.until(argDriver -> {
                try {
                    return element.isDisplayed();
                } catch (Exception e) {
                    return false;
                }
            });
        } catch (TimeoutException e) {
            return false;
        }
    }

    /***
     * Get an element text value
     * @param driver driver
     * @param element mobile element
     * @return the element text
     */
    public static String getElementText(MobileDriver<MobileElement> driver, MobileElement element) {
        return element.getText().trim();
    }

    /***
     * Perform a tap on a visible element
     * @param driver driver
     * @param element mobile element
     */
    public static void tapOnElement(MobileDriver<MobileElement> driver, MobileElement element) {
        new TouchAction(driver)
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)))
                .release()
                .perform();
    }


    /***
     * Verifies if an element is displayed on screen
     * @param element mobile element
     * @return true o false
     */
    public static boolean isElementVisible(MobileElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * An expectation for checking if the given text is present in the specified element.
     *
     * @param driver MobileDriver
     * @param element MobileElement used to find the element
     * @param textExpected String used to find text on element
     * @param timeOutInSeconds Duration
     * @return true once the element contains the given text
     */
    public static boolean waitTextIsVisible(MobileDriver driver, MobileElement element, String textExpected, Duration...timeOutInSeconds) {
        final Duration timeout = timeOutInSeconds.length == 0 ? Constant.DURATION_TIMEOUT_DEFAULT : timeOutInSeconds[0];
        try {
            FluentWait<MobileDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(timeout)
                    .pollingEvery(Constant.DURATION_POLLING_INTERVAL_MILLISECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class);
            return fluentWait.until(ExpectedConditions.textToBePresentInElement(element, textExpected));
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Performs swipe from the center of screen
     *
     * @param dir the direction of swipe
     * @version java-client: 7.3.0
     **/
    public static void swipeScreen(MobileDriver driver, Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

}
