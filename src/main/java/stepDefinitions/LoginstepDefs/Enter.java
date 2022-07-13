package stepDefinitions.LoginstepDefs;

import Util.Config_Reader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.ApplicationLoginPage;

public class Enter extends BasePage {
    private final ApplicationLoginPage applicationLoginPage = new ApplicationLoginPage();
    private final Config_Reader config_reader = new Config_Reader();


    @When("user enters 'Application Login Page:UserName'")
    public void entersUserName() {
        enterValues(applicationLoginPage.userName, config_reader.getUserName());
    }

    @When("^user enters '(.*)' in Application Login Page:UserName'$")
    public void entersUserName(String value) {
        doClick(applicationLoginPage.password);
        enterValues(applicationLoginPage.userName, value);
    }

    @When("user enters 'Application Login Page:Password'")
    public void entersPassword() {
        enterValues(applicationLoginPage.password, config_reader.getPassword());
    }

    @When("^user enters '(.*)'in Application Login Page:Password'$")
    public void entersPassword(String value) {
        enterValues(applicationLoginPage.password, value);

    }

    @And("^user enters '(.*)'in Application:Forgot Password Page email id'$")
    public void entersAnyEmailIdForForgotPassword(String value) {
        doClick(applicationLoginPage.emailIdText);
        enterValues(applicationLoginPage.emailIdText, value);


    }


}
