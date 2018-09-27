import Pages.LandingPage;
import Pages.LoginPage;
import Pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LandingPageTest {
    private WebDriver driver;
    private LandingPage landingPage;
    private SignUpPage signUpPage;
    private LoginPage loginPage;

    private final String headerText = "NQA Social Media";
    private final String subHeaderText = "Create a profile, share posts and test";
    private final String pageTitle = "NQA Social Media";

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/bianders/Documents/dev/NQATestAutomation/drivers/chromedriver");
        this.driver = new ChromeDriver();
        this.landingPage = new LandingPage(this.driver);
        driver.get(landingPage.getPageUrl());
    }

    // Returns to or refreshes the landing page, because some tests navigate away
    @BeforeMethod
    public void returnToLanding(){
        driver.get(landingPage.getPageUrl());
    }

    @Test
    public void assertTitle(){
        Assert.assertEquals(driver.getTitle(), this.pageTitle);
    }

    @Test
    public void assertHeader(){
        Assert.assertEquals(landingPage.getHeaderText(), this.headerText);
    }

    @Test
    public void assertSubHeader(){
        Assert.assertEquals(landingPage.getSubHeaderText(), this.subHeaderText);
    }

    @Test
    public void assertSignUpButtonText(){
        Assert.assertEquals(landingPage.getSignUpButtonText(), "Sign Up");
    }

    @Test
    public void assertLoginButtonText(){
        Assert.assertEquals(landingPage.getLoginButtonText(), "Login");
    }

    @Test
    public void clickSignUpButton(){
        landingPage.clickSignUpButton();
        this.signUpPage = new SignUpPage(this.driver);
        Assert.assertEquals(signUpPage.getHeaderText(), "Sign Up");
    }

    @Test
    public void clickLoginButton(){
        landingPage.clickLoginButton();
        this.loginPage = new LoginPage(this.driver);
        Assert.assertEquals(loginPage.getHeaderText(), "Log In");
    }

    @AfterClass
    public void tearDown(){ driver.close(); }

}
