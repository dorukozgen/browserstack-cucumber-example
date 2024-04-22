package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;
import pages.Base;
import utilities.Driver;
import utilities.ReusableMethods;

public class HomeSteps extends Base {

    @Given("The user goes to {string}")
    public void theUserGoesTo(String url) {
        Driver.getInstance().getDriver().get(url);
    }

    @Given("The user sees the login form")
    public void shouldSeeTheWebPageOpened() {
        Assertions.assertTrue(homePage.testLoginTitleText.isDisplayed());
    }

    @Given("The user clicks on username input")
    public void theUserClicksOnUsernameInput() {
        homePage.usernameInput.click();
    }

    @Given("The user types {string} into username input")
    public void theUserTypesIntoUsernameInput(String username) {
        homePage.usernameInput.sendKeys(username);

        ReusableMethods.sleep(2);
    }

    @Given("The user clicks on password input")
    public void theUserClicksOnPasswordInput() {
        homePage.passwordInput.click();
    }

    @Given("The user types {string} into password input")
    public void theUserTypesIntoPasswordInput(String password) {
        homePage.passwordInput.sendKeys(password);

        ReusableMethods.sleep(2);
    }

    @Given("The user clicks on submit button")
    public void theUserClicksOnSubmitButton() {
        ReusableMethods.click(homePage.submitButton);
    }

    @Given("The user sees the login success message")
    public void theUserSeesTheLoginSuccessMessage() {
        Assertions.assertTrue(homePage.loggedInSuccessfullyText.isDisplayed());
    }
}
