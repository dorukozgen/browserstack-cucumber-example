package utilities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Driver {

    private final ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    private static Driver instance;

    private Driver() {
    }

    public static Driver getInstance() {
        if (instance == null) {
            instance = new Driver();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public enum DriverType {
        DESKTOP,
        MOBILE
    }

    public void setDriver(DriverType driverType) throws MalformedURLException {
        final String url = "https://" + ConfigReader.getProperty("BROWSERSTACK_USERNAME") + ":" + ConfigReader.getProperty("BROWSERSTACK_ACCESS_KEY") + "@hub.browserstack.com/wd/hub";

        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "latest");
        bstackOptions.put("projectName", "Login Form Test");

        switch (driverType) {
            case DESKTOP:
                bstackOptions.put("os", "Windows");
                bstackOptions.put("osVersion", "11");
                bstackOptions.put("browserVersion", "115.0");
                bstackOptions.put("consoleLogs", "info");
                bstackOptions.put("seleniumVersion", "4.19.1");
                bstackOptions.put("projectName", "Login Form Test");
                bstackOptions.put("sessionName", "Desktop Login Test");
                driver.set(new RemoteWebDriver(new URL(url), capabilities));
                break;
            case MOBILE:
                bstackOptions.put("osVersion", "13.0");
                bstackOptions.put("deviceName", "Samsung Galaxy S23 Ultra");
                bstackOptions.put("consoleLogs", "info");
                bstackOptions.put("appiumVersion", "1.21.0");
                bstackOptions.put("projectName", "Login Form Test");
                bstackOptions.put("sessionName", "Mobile Login Test");
                driver.set(new AppiumDriver(new URL(url), capabilities));
                break;
        }

        capabilities.setCapability("bstack:options", bstackOptions);
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
