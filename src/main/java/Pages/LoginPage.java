package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final String url;

    private By header = By.className("display-4");

    public LoginPage(WebDriver webDriver){
        super(webDriver);
        this.url = "http://localhost:3000/login";

    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }
}