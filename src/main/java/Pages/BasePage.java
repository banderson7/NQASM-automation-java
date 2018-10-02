package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;

    protected BasePage(WebDriver webDriver) {
        driver = webDriver;

        wait = new WebDriverWait(driver, 10);
    }

    protected WebElement element(By locator){
        return driver.findElement(locator);
    }

    protected WebElement elementWhenVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator){
        driver.findElement(locator).click();
    }

    protected void enterText(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }
}
