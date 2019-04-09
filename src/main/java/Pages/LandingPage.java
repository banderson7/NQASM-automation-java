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
        // TODO: Pull these URLs out of the classes and allow for multiple environments
        this.url = "";
    }

    public String getPageUrl(){ return url; }

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
