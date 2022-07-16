package stepDefinitions.LoginstepDefs;

import Assertions.Verification;
import Util.UISteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;

public class Verify extends UISteps {
   private final LoginPage loginPage = new LoginPage();
   private final Verification verification = new Verification();


    @And("user verify 'Application Login Page:Login Successfully'")
    public void displayUserLogoNameInHomePage() {
        loginPage.verifyLoginSuccessfully();
    }


    @And("^user verify 'Application Login Page:Error message' equals '(.*)'$")
    public void errorMessage(String value) {
        Assert.assertEquals(getTextFromElement(loginPage.invalidMessage), value);
    }

    @And("^user verify 'Application Login Page:Home Page' is not displayed'$")
    public void homePageNotDisplayed() {
        Assert.assertTrue(waitForElementNotDisplay(loginPage.userLogo));
    }


    @And("^user verify 'Application Login Page:Username' error message 'equals '(.*)'$")
    public void errorMessageUsername(String value) {
        Assert.assertEquals(getTextFromElement(loginPage.userNameErrorMessage), value);
    }

    @Then("^user verify 'Application Login Page:Password' error message 'equals '(.*)'$")
    public void errorMessagePassword(String value) {
       // do_click(LoginPage.userName);
        Assert.assertEquals(getTextFromElement(loginPage.passwordErrorMessage), value);

    }
    @And("user verify 'Application Login Page:Login Button' is disabled")
    public void loginButtonDisabled() {
        //Assert.assertTrue(wait_for_element_not_display(LoginPage.loginButton));
        loginPage.getTextFromAttribute(loginPage.loginButton,"class");

    }
    @Then("^user verify 'Application Login Page:Logo' is displayed$")
    public void sigTupleLogoDisplayInLoginPage() {
        //Assert.assertTrue(wait_for_element_to_display(LoginPage.sigtupleLogo).isDisplayed());
        verification.verifyElementNotDisplayed(waitForElementToDisplay(loginPage.sigtupleLogo).isDisplayed());

    }

    @Then("^user verify 'Application Forgot Password Page:Forgot Password' error message 'equals '(.*)'$")
    public void errorMessageForgotPassword(String value) {
        // do_click(LoginPage.userName);
        Assert.assertEquals(getTextFromElement(loginPage.forgotPasswordErrorMessage), value);

    }
}
