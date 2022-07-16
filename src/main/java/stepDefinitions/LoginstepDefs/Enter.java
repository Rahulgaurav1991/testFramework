package stepDefinitions.LoginstepDefs;

import Util.Config_Reader;
import Util.UISteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class Enter extends UISteps {
    private final LoginPage loginPage = new LoginPage();
    private final Config_Reader config_reader = new Config_Reader();


    @When("user enters 'Application Login Page:UserName'")
    public void entersUserName() {
        enterValues(loginPage.userName, config_reader.getUserName());
    }

    @When("^user enters '(.*)' in Application Login Page:UserName'$")
    public void entersUserName(String value) {
        doClick(loginPage.password);
        enterValues(loginPage.userName, value);
    }

    @When("user enters 'Application Login Page:Password'")
    public void entersPassword() {
        enterValues(loginPage.password, config_reader.getPassword());
    }

    @When("^user enters '(.*)'in Application Login Page:Password'$")
    public void entersPassword(String value) {
        enterValues(loginPage.password, value);

    }

    @And("^user enters '(.*)'in Application:Forgot Password Page email id'$")
    public void entersAnyEmailIdForForgotPassword(String value) {
        doClick(loginPage.emailIdText);
        enterValues(loginPage.emailIdText, value);


    }


}
