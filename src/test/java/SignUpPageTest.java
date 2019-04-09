import Pages.LoginPage;
import Pages.SignUpPage;
import Utils.ErrorMessages;

import org.testng.Assert;
import org.testng.annotations.*;

public class SignUpPageTest extends BaseTest {
    private SignUpPage signUpPage;
    private LoginPage loginPage;

    private final String headerText = "Sign Up";
    private final String subHeaderText = "Create your NQA Social Media account";


    @BeforeClass
    public void launchPage(){
        this.signUpPage = new SignUpPage(this.driver);
        driver.get(baseURL + signUpPage.getPageUrl());
    }

    // Returns to or refreshes the signup page, because some tests navigate away
    @BeforeMethod
    public void returnToSignup(){
        driver.get(baseURL + signUpPage.getPageUrl());
    }

    @Test
    public void assertHeader(){
        Assert.assertEquals(signUpPage.getHeaderText(), this.headerText);
    }

    @Test
    public void assertSubHeader(){
        Assert.assertEquals(signUpPage.getSubHeaderText(), this.subHeaderText);
    }

    @Test
    public void assertSubmitButtonText(){
        Assert.assertEquals(signUpPage.getSubmitButtonText(), "Submit");
    }

    @Test (description = "Click submit and verify all error messages display")
    public void assertEmptySubmit(){
        signUpPage.clickSubmit();
        Assert.assertEquals(signUpPage.getNameErrorText(), ErrorMessages.nameIsRequired);
        Assert.assertEquals(signUpPage.getEmailErrorText(), ErrorMessages.emailIsRequired);
        Assert.assertEquals(signUpPage.getPasswordErrorText(), ErrorMessages.passwordIsRequired);
        Assert.assertEquals(signUpPage.getPassword2ErrorText(), ErrorMessages.password2IsRequired);
    }

    @Test
    public void assertNameTooShortSubmit(){
        signUpPage.enterName("a");
        signUpPage.clickSubmit();
        Assert.assertEquals(signUpPage.getNameErrorText(), ErrorMessages.nameInvalidLength);
    }

    @Test
    public void assertNameTooLongSubmit(){
        signUpPage.enterName("abcdefghijklmnopqrstuvwxyzqwert");
        signUpPage.clickSubmit();
        Assert.assertEquals(signUpPage.getNameErrorText(), ErrorMessages.nameInvalidLength);
    }

    @Test
    public void assertInvalidEmailSubmit(){
        signUpPage.enterEmail("invalid@email");
        signUpPage.clickSubmit();
        Assert.assertEquals(signUpPage.getEmailErrorText(), ErrorMessages.emailInvalid);
    }

    @Test
    public void assertEmailExistsSubmit(){
        signUpPage.enterName("Automation User");
        signUpPage.enterEmail("test@test.com");
        signUpPage.enterPassword("password");
        signUpPage.enterPassword2("password");
        signUpPage.clickSubmit();
        Assert.assertEquals(signUpPage.getEmailErrorText(), ErrorMessages.emailAlreadyExists);
    }

    @Test
    public void assertPasswordTooShortSubmit(){
        signUpPage.enterPassword("ab");
        signUpPage.clickSubmit();
        Assert.assertEquals(signUpPage.getPasswordErrorText(), ErrorMessages.passwordInvalidLength);
    }

    @Test
    public void assertPasswordTooLongSubmit(){
        signUpPage.enterPassword("abcdefghijklmnopqrstuvwxyzqwert");
        signUpPage.clickSubmit();
        Assert.assertEquals(signUpPage.getPasswordErrorText(), ErrorMessages.passwordInvalidLength);
    }

    @Test
    public void assertConfirmPasswordNotMatchingSubmit(){
        signUpPage.enterPassword("validpassword");
        signUpPage.enterPassword2("nomatch");
        signUpPage.clickSubmit();
        Assert.assertEquals(signUpPage.getPassword2ErrorText(), ErrorMessages.password2NoMatch);
    }

    @Test
    public void assertSuccessfulRegister(){
        signUpPage.enterName("Automation User");
        signUpPage.enterEmail(signUpPage.generateRandomEmail());
        signUpPage.enterPassword("password");
        signUpPage.enterPassword2("password");
        signUpPage.clickSubmit();
        this.loginPage = new LoginPage(this.driver);
        // TODO: No longer checking for page URL so it's asserting too early.
        Assert.assertEquals(loginPage.getHeaderText(), "Log In");
    }
}
