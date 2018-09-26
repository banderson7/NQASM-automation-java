import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class SignUpPage {
    private final WebDriver driver;
    private final String url;

    private By header = By.className("display-4");

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        this.url = "http://localhost:3000/register";
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }
}