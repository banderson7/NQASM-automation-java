package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtil {
    private WebDriver driver;
    private WebDriverWait wait;

    public PageUtil(WebDriver driver){
         wait = new WebDriverWait(driver, 10);
    }

    public void waitForUrl(String url){
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public WebElement waitForElementToBeVisible(By elementLocation){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

}
