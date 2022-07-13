package pages;

import org.openqa.selenium.By;

public class ApplicationLoginPage extends BasePage {

    //This Page contains page objects for login page

    public By logo = By.className("logo-header");

    public By userName = By.cssSelector("[placeholder='User Name']");

    public By password = By.cssSelector("[formcontrolname='password']");

    public By loginButton = By.cssSelector("button.login-button");

    public By userLogo = By.className("username");

    public By productLogo = By.className("select-product");

    public By invalidMessage = By.className("message");

    public By userNameErrorMessage = By.xpath("//mat-error[contains(text(),' Please enter your user name ')]");
    public By passwordErrorMessage = By.xpath("//mat-error[contains(text(),' Please enter your password ')]");
    public By forgotPasswordButton = By.className("forgot-password");
    public By backToLoginArrow = By.className("back-text");
    public By emailIdText = By.cssSelector("[placeholder='Email ID']");
    public By sigtupleLogo = By.cssSelector("[alt='SigTuple']");
    public By resetPassword = By.xpath("//span[text()='Reset Password']");
    public By forgotPasswordErrorMessage = By.cssSelector(".message");


    public void verifyLoginSuccessfully() {
        waitForElementToDisplay(userLogo);
        waitForElementToDisplay(productLogo);
    }


}
