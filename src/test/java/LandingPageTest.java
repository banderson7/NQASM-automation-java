import Pages.LandingPage;
import Pages.LoginPage;
import Pages.SignUpPage;

import org.testng.Assert;
import org.testng.annotations.*;

public class LandingPageTest extends BaseTest {
    private LandingPage landingPage;
    private SignUpPage signUpPage;
    private LoginPage loginPage;

    private final String headerText = "NQA Social Media";
    private final String subHeaderText = "Create a profile, share posts and test";

    @BeforeClass
    public void launchPage(){
        this.landingPage = new LandingPage(this.driver);
        String url = baseURL + landingPage.getPageUrl();
        driver.get(url);
    }

    // Returns to or refreshes the landing page, because some tests navigate away
    @BeforeMethod
    public void returnToLanding(){
        driver.get(baseURL + landingPage.getPageUrl());
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

}
