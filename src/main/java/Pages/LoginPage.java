package Pages;

import Utils.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final PageUtil pageUtil;
    private final String url;

    private By header = By.className("display-4");
    private By fullDisplay = By.className("login");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.url = "http://localhost:3000/login";
        this.pageUtil = new PageUtil(driver);

        pageUtil.waitForUrl(url);
    }

    public String getPageUrl(){ return url;}

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }
}