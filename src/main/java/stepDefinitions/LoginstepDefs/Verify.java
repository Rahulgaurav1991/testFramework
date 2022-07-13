package stepDefinitions.LoginstepDefs;

import Assertions.Verification;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.BasePage;
import pages.ApplicationLoginPage;

public class Verify extends BasePage {
   private final ApplicationLoginPage applicationLoginPage = new ApplicationLoginPage();
   private final Verification verification = new Verification();


    @And("user verify 'Application Login Page:Login Successfully'")
    public void displayUserLogoNameInHomePage() {
        applicationLoginPage.verifyLoginSuccessfully();
    }


    @And("^user verify 'Application Login Page:Error message' equals '(.*)'$")
    public void errorMessage(String value) {
        Assert.assertEquals(getTextFromElement(applicationLoginPage.invalidMessage), value);
    }

    @And("^user verify 'Application Login Page:Home Page' is not displayed'$")
    public void homePageNotDisplayed() {
        Assert.assertTrue(waitForElementNotDisplay(applicationLoginPage.userLogo));
    }


    @And("^user verify 'Application Login Page:Username' error message 'equals '(.*)'$")
    public void errorMessageUsername(String value) {
        Assert.assertEquals(getTextFromElement(applicationLoginPage.userNameErrorMessage), value);
    }

    @Then("^user verify 'Application Login Page:Password' error message 'equals '(.*)'$")
    public void errorMessagePassword(String value) {
       // do_click(ApplicationLoginPage.userName);
        Assert.assertEquals(getTextFromElement(applicationLoginPage.passwordErrorMessage), value);

    }
    @And("user verify 'Application Login Page:Login Button' is disabled")
    public void loginButtonDisabled() {
        //Assert.assertTrue(wait_for_element_not_display(ApplicationLoginPage.loginButton));
        applicationLoginPage.getTextFromAttribute(applicationLoginPage.loginButton,"class");

    }
    @Then("^user verify 'Application Login Page:Logo' is displayed$")
    public void sigTupleLogoDisplayInLoginPage() {
        //Assert.assertTrue(wait_for_element_to_display(ApplicationLoginPage.sigtupleLogo).isDisplayed());
        verification.verifyElementNotDisplayed(waitForElementToDisplay(applicationLoginPage.sigtupleLogo).isDisplayed());

    }

    @Then("^user verify 'Application Forgot Password Page:Forgot Password' error message 'equals '(.*)'$")
    public void errorMessageForgotPassword(String value) {
        // do_click(ApplicationLoginPage.userName);
        Assert.assertEquals(getTextFromElement(applicationLoginPage.forgotPasswordErrorMessage), value);

    }
}
