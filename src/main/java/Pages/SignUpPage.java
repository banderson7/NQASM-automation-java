package Pages;

import Utils.PageUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignUpPage {
    private final WebDriver driver;
    private final PageUtil pageUtil;
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

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        this.pageUtil = new PageUtil(driver);
        this.url = "http://localhost:3000/register";

        pageUtil.waitForUrl(url);
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public String getSubHeaderText() { return driver.findElement(subHeader).getText(); }

    public String getNameFieldText() { return driver.findElement(nameField).getAttribute("value");}

    public String getNameErrorText() {
        WebElement nameErrorText = pageUtil.waitForElementToBeVisible(nameError);
        return nameErrorText.getText();
    }

    public String getEmailErrorText() { return driver.findElement(emailError).getText(); }

    public String getPasswordErrorText() { return driver.findElement(passwordError).getText(); }

    public String getPassword2ErrorText() { return driver.findElement(password2Error).getText(); }

    public void clickSubmit(){
        driver.findElement(submitButton).click();
    }

    public void enterName(String text){
        driver.findElement(nameField).sendKeys(text);
    }

    public void enterEmail(String text){
        driver.findElement(emailField).sendKeys(text);
    }

    public void enterPassword(String text){
        driver.findElement(passwordField).sendKeys(text);
    }

    public void enterPassword2(String text){
        driver.findElement(password2Field).sendKeys(text);
    }
}