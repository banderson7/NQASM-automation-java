import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final String url;

    private By header = By.className("display-4");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.url = "http://localhost:3000/login";
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }
}