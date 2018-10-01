import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser){
        String projectLocation = System.getProperty("user.dir");

        if (browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", projectLocation + "/drivers/chromedriver");
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", projectLocation + "/drivers/geckodriver");
            driver = new FirefoxDriver();
        }
    }

    @AfterClass
    public void tearDown(){ driver.close(); }

}
