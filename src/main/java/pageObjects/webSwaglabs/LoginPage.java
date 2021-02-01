package pageObjects.webSwaglabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.ID, using = "user-name")
    private WebElement txt_username;

    @FindBy(how = How.ID, using = "password")
    private WebElement txt_password;

    @FindBy(how = How.ID, using = "login-button")
    private WebElement btn_login;

    @FindBy(how = How.CLASS_NAME, using = "error-button")
    private WebElement btn_error;

    /*
      ################################################################################################
      The following "getter" methods are used to make sure that above WebElements are hidden from users.
      Method description: These methods provide access to private WebElements.
      Methods parameter: none
      Methods return: public WebElements
      ################################################################################################
    */
    public WebElement getTxt_username() {
        return txt_username;
    }

    public WebElement getTxt_password() {
        return txt_password;
    }

    public WebElement getBtn_login() {
        return btn_login;
    }

    public WebElement getBtn_error() {
        return btn_error;
    }



}
