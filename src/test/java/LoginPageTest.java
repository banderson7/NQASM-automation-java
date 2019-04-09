import Pages.LoginPage;
import Utils.ErrorMessages;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;

    private final String headerText = "Log In";
    private final String subHeaderText = "Sign in to your NQA Social Media account";

    @BeforeClass
    public void launchPage(){
        this.loginPage = new LoginPage(this.driver);
        driver.get(baseURL + loginPage.getPageUrl());
    }

    @BeforeMethod
    public void returnToLogin() { driver.get(baseURL + loginPage.getPageUrl()); }

    @Test
    public void assertHeader(){
        Assert.assertEquals(loginPage.getHeaderText(), headerText);
    }

    @Test
    public void assertSubHeader(){
        Assert.assertEquals(loginPage.getSubHeaderText(), subHeaderText);
    }

    @Test
    public void assertSubmitButtonText(){
        Assert.assertEquals(loginPage.getSubmitButtonText(), "Submit");
    }

    @Test
    public void assertEmptySubmit(){
        loginPage.clickSubmit();
        Assert.assertEquals(loginPage.getEmailErrorText(), ErrorMessages.emailIsRequired);
        Assert.assertEquals(loginPage.getPasswordErrorText(), ErrorMessages.passwordIsRequired);
    }
}
