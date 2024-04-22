package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;

public class ReusableMethods {

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void click(WebElement element) {
        if (Driver.getInstance().getDriver() instanceof AndroidDriver) {
            ((AndroidDriver) Driver.getInstance().getDriver()).hideKeyboard();

            ReusableMethods.sleep(1);
        }
        element.click();
    }
}
