package stepDefinitions.LoginstepDefs;


import io.cucumber.java.en.Given;
import org.junit.Assert;
import Util.UISteps;
import pages.LoginPage;

public class Navigation extends UISteps {

    private final LoginPage loginPage = new LoginPage();


    @Given("user Navigate to 'Application Login Page'")
    public void navigateTOAURL() {
        Assert.assertTrue(waitForElementToDisplay(loginPage.logo).isDisplayed());
    }

    @Given("user navigate to 'Application Forgot Password Page'")
    public void navigateTOForgotLinkURL() {
        Assert.assertTrue(waitForElementToDisplay(loginPage.logo).isDisplayed());
    }

}
