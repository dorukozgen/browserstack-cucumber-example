package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.Base;
import utilities.Driver;

import java.net.MalformedURLException;

public class Hooks {

    @Before
    public static void setUp(Scenario scenario) throws MalformedURLException {
        Driver.DriverType driverType;

        if (scenario.getSourceTagNames().contains("@desktop")) {
            driverType = Driver.DriverType.DESKTOP;
        } else {
            driverType = Driver.DriverType.MOBILE;
        }

        Driver.getInstance().setDriver(driverType);
        Base.initialize();
    }

    @After
    public static void tearDown() {
        Driver.getInstance().getDriver().quit();
    }
}
