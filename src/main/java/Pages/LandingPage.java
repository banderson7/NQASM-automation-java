package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LandingPage {
    private final WebDriver driver;
    private final String url;

    private By header = By.className("display-3");
    private By subHeader = By.className("lead");
    private By signUpButton = By.className("btn-info");
    private By loginButton = By.className("btn-light");

    public LandingPage(WebDriver driver){
        this.driver = driver;
        this.url = "http://localhost:3000/";
    }

    public String getPageUrl(){ return url; }

    public void goToPageUrl(){ driver.get(url); }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public String getSubHeaderText(){
        return driver.findElement(subHeader).getText();
    }

    public String getSignUpButtonText(){
        return driver.findElement(signUpButton).getText();
    }

    public String getLoginButtonText(){
        return driver.findElement(loginButton).getText();
    }

    public void clickSignUpButton(){
        driver.findElement((signUpButton)).click();
    }

    public void clickLoginButton(){
        driver.findElement((loginButton)).click();
    }
}
