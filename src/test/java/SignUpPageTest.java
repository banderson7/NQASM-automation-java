import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SignUpPageTest {
    private WebDriver driver;
    private SignUpPage signUpPage;

    private final String headerText = "Sign Up";
    private final String subHeaderText = "Create your NQA Social Media account";
    private final String nameIsRequiredError = "Name is required";
    private final String emailIsRequiredError = "Email is required";
    private final String passwordIsRequiredError = "Password is required";
    private final String password2IsRequiredError = "Confirm password is required";
    private final String nameInvalidLengthError = "Name must be between 2 and 30 characters";

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

    @Test
    public void assertHeader(){
        Assert.assertEquals(signUpPage.getHeaderText(), this.headerText);
    }

    @Test (enabled=false)
    public void assertSubHeader(){
        Assert.assertEquals(signUpPage.getSubHeaderText(), this.subHeaderText);
    }

    @Test (description = "Click submit and verify all error messages display")
    public void assertEmptySubmit(){
        signUpPage.clickSubmit();
        Assert.assertEquals(signUpPage.getNameErrorText(), this.nameIsRequiredError);
        Assert.assertEquals(signUpPage.getEmailErrorText(), this.emailIsRequiredError);
        Assert.assertEquals(signUpPage.getPasswordErrorText(), this.passwordIsRequiredError);
        Assert.assertEquals(signUpPage.getPassword2ErrorText(), this.password2IsRequiredError);
    }

    @Test
    public void assertNameTooShortSubmit(){
        signUpPage.enterName("a");
        signUpPage.clickSubmit();
        Assert.assertEquals(signUpPage.getNameErrorText(), this.nameInvalidLengthError);
    }

    @Test
    public void assertNameTooLongSubmit(){
        signUpPage.enterName("abcdefghijklmnopqrstuvwxyzqwert");
        signUpPage.clickSubmit();
        Assert.assertEquals(signUpPage.getNameErrorText(), this.nameInvalidLengthError);
    }

    @AfterClass
    public void tearDown(){ driver.close(); }
}
