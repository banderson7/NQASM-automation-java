package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LandingPage extends BasePage {
    private final String url;

    private By header = By.className("display-3");
    private By subHeader = By.className("lead");
    private By signUpButton = By.className("btn-info");
    private By loginButton = By.className("btn-light");

    public LandingPage(WebDriver webDriver){
        super(webDriver);
        this.url = "http://localhost:3000/";
    }

    public String getPageUrl(){ return url; }

    public void goToPageUrl(){ driver.get(url); }

    public String getHeaderText() {
        return element(header).getText();
    }

    public String getSubHeaderText(){
        return element(subHeader).getText();
    }

    public String getSignUpButtonText(){
        return element(signUpButton).getText();
    }

    public String getLoginButtonText(){
        return element(loginButton).getText();
    }

    public void clickSignUpButton(){
        element((signUpButton)).click();
    }

    public void clickLoginButton(){
        element((loginButton)).click();
    }
}
