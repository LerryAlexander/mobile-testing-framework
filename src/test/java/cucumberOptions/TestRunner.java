package cucumberOptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

import utilities.Hooks;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumberOptions"},
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "utilities"},
        dryRun = false,
        monochrome = true,
        tags = {"@signInAsEmployer"}
        )

public class TestRunner extends Hooks{

    private static Logger logger = LogManager.getLogger(TestRunner.class.getName());

    @BeforeClass
    public static void beforeAllScenarios() throws Throwable {
        logger.info("################################################");
        logger.info("BEFORE ALL SCENARIOS: ");
        initializeDriver();
        logger.info("Init Driver OK ");
    }

    @AfterClass
    public static void afterAllScenarios() {
        logger.info("################################################");
        logger.info("AFTER ALL SCENARIOS: ");
        driverManager.destroyDriver();
        logger.info("Destroy driver OK");
    }


}
