package stepDefinitions.LoginstepDefs;

import Util.UISteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class Clicks extends UISteps {

    private final LoginPage loginPage = new LoginPage();

    @And("user clicks 'Application Login Page:Submit Button'")
    public void clickSubmitButton() {
        doClick(loginPage.loginButton);

    }
    @When("user clicks 'Application Login Page:Forgot Link '")
    public void clickForgotButton() {
        doClick(loginPage.forgotPasswordButton);
    }

    @And("user clicks 'Application Forgot Password Page:Reset Password Button'")
    public void clickResetPasswordButton() {
        doClick(loginPage.resetPassword);

    }




}
