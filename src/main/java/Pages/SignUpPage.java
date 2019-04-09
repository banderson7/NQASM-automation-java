package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import java.util.Random;

public class SignUpPage extends BasePage {
    private final String url;

    private By header = By.className("display-4");
    private By subHeader = By.className("lead");
    private By nameField = By.id("name");
    private By nameError = By.id("nameError");
    private By emailField = By.id("email");
    private By emailError = By.id("emailError");
    private By passwordField = By.id("password");
    private By passwordError = By.id("passwordError");
    private By password2Field = By.id("password2");
    private By password2Error = By.id("password2Error");
    private By submitButton = By.xpath("//input[@type='submit']");

    public String getPageUrl(){ return url; }

    public SignUpPage(WebDriver webDriver){
        super(webDriver);
        this.url = "/register";
    }

    public String getHeaderText() {
        return element(header).getText();
    }

    public String getSubHeaderText() { return element(subHeader).getText(); }

    public String getNameErrorText() {
        return elementWhenVisible(nameError).getText();
    }

    public String getEmailErrorText() {
        return elementWhenVisible(emailError).getText();
    }

    public String getPasswordErrorText() {
        return elementWhenVisible(passwordError).getText();
    }

    public String getPassword2ErrorText() {
        return elementWhenVisible(password2Error).getText();
    }

    public void clickSubmit(){
        click(submitButton);
    }

    public void enterName(String text){
        enterText(nameField, text);
    }

    public void enterEmail(String text){
        enterText(emailField, text);
    }

    public void enterPassword(String text){
        enterText(passwordField, text);
    }

    public void enterPassword2(String text){
        enterText(password2Field, text);
    }

    public String getSubmitButtonText(){
        return element(submitButton).getAttribute("value");
    }

    public String generateRandomEmail(){
        Random rand = new Random();
        // Random number between 1 and 1000;
        int n = rand.nextInt(1000) + 1;
        return "test" + n + "@email.com";
    }
}