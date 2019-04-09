package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final String url;

    private By header = By.className("display-4");
    private By subHeader = By.className("lead");
    private By emailField = By.id("email");
    private By emailErrorText = By.id("emailError");
    private By passwordField = By.id("password");
    private By passwordErrorText = By.id("passwordError");
    private By submitButton = By.xpath("//input[@type='submit']");

    public LoginPage(WebDriver webDriver){
        super(webDriver);
        this.url = "/login";
    }

    public String getPageUrl(){
        return this.url;
    }

    public String getHeaderText() {
        return element(header).getText();
    }

    public String getSubHeaderText() {
        return element(subHeader).getText();
    }

    public String getSubmitButtonText(){
        return element(submitButton).getAttribute("value");
    }

    public void clickSubmit() { element(submitButton).click();}

    public String getEmailErrorText(){
        return elementWhenVisible(emailErrorText).getText();
    }

    public String getPasswordErrorText(){
        return elementWhenVisible(passwordErrorText).getText();
    }
}