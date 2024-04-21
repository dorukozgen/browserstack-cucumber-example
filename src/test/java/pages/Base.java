package pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Base {

    public Base() {
        PageFactory.initElements(Driver.getInstance().getDriver(), this);
    }

    public static HomePage homePage;
    public static Actions actions;

    public static void initialize() {
        homePage = new HomePage();
        actions = new Actions(Driver.getInstance().getDriver());
    }
}
