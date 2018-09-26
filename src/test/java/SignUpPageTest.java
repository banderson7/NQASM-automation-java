import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SignUpPageTest {
    private WebDriver driver;
    private SignUpPage signUpPage;


    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/bianders/Documents/dev/NQATestAutomation/drivers/chromedriver");
        this.driver = new ChromeDriver();
        this.signUpPage = new SignUpPage(this.driver);
        driver.get(signUpPage.getPageUrl());
    }

    // Returns to or refreshes the signup page, because some tests navigate away
    @BeforeMethod
    public void returnToSignup(){
        driver.get(signUpPage.getPageUrl());
    }

    public void assertHeader(){

    }

    public void assertSubHeader(){

    }

    @AfterClass
    public void tearDown(){ driver.close(); }
}
