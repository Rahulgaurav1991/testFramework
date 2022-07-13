package stepDefinitions.LoginstepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.ApplicationLoginPage;

public class Clicks extends BasePage {

    ApplicationLoginPage applicationLoginPage = new ApplicationLoginPage();

    @And("user clicks 'Application Login Page:Submit Button'")
    public void clickSubmitButton() {
        doClick(applicationLoginPage.loginButton);

    }
    @When("user clicks 'Application Login Page:Forgot Link '")
    public void clickForgotButton() {
        doClick(applicationLoginPage.forgotPasswordButton);
    }

    @And("user clicks 'Application Forgot Password Page:Reset Password Button'")
    public void clickResetPasswordButton() {
        doClick(applicationLoginPage.resetPassword);

    }




}
