package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage extends Base {

    @FindBy(xpath = "//*[text()='Test login']")
    public WebElement testLoginTitleText;

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(xpath = "//*[text()='Logged In Successfully']")
    public WebElement loggedInSuccessfullyText;
}
