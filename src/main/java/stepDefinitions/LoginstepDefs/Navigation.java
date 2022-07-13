package stepDefinitions.LoginstepDefs;


import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.BasePage;
import pages.ApplicationLoginPage;

public class Navigation extends BasePage {

    private final ApplicationLoginPage applicationLoginPage = new ApplicationLoginPage();


    @Given("user Navigate to 'Application Login Page'")
    public void navigateTOAURL() {
        Assert.assertTrue(waitForElementToDisplay(applicationLoginPage.logo).isDisplayed());
    }

    @Given("user navigate to 'Application Forgot Password Page'")
    public void navigateTOForgotLinkURL() {
        Assert.assertTrue(waitForElementToDisplay(applicationLoginPage.logo).isDisplayed());
    }

}
