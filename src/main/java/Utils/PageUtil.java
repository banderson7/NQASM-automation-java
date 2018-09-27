package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtil {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public PageUtil(WebDriver driver){
        this.driver = driver;
         wait = new WebDriverWait(driver, 10);
    }

    public void waitForUrl(String url){
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public WebElement waitForElementToBeVisible(By elementLocation){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }
}
