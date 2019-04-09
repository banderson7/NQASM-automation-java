import Utils.Environment;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    protected Environment testEnvironment = ConfigFactory.create(Environment.class);
    protected String baseURL;

    @Parameters({"browser", "env", "headless"})
    @BeforeClass
    public void setUp(String browser, String env, boolean headless){
        String projectLocation = System.getProperty("user.dir");

        if (browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", projectLocation + "/drivers/chromedriver");
            ChromeOptions options = new ChromeOptions();
            if (headless){
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
        }
        else if (browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", projectLocation + "/drivers/geckodriver");
            driver = new FirefoxDriver();
        }

        if(env.equals("local")){
            baseURL = "http://localhost:3000";
        }
        else if (env.equals("prod")){
            baseURL = "https://nqa-social-media-prod.herokuapp.com";
        }
        else{

        }


    }

    @AfterClass
    public void tearDown(){ driver.close();}

}
