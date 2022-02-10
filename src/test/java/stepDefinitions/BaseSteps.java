package stepDefinitions;

import io.cucumber.core.api.Scenario;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import utilities.Hooks;

public abstract class BaseSteps {
    public MobileDriver<MobileElement> driver;
    public Scenario scenario;

    public BaseSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
        this.scenario = hooks.getScenario();
    }
}
