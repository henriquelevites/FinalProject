package pageObjects.desktopCalculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    @FindBy(how = How.NAME, using = "Clear")
    private WebElement btn_clear;

    @FindBy(how = How.NAME, using = "One")
    private WebElement btn_one;

    @FindBy(how = How.NAME, using = "Seven")
    private WebElement btn_seven;

    @FindBy(how = How.NAME, using = "Eight")
    private WebElement btn_eight;

    @FindBy(how = How.NAME, using = "Nine")
    private WebElement btn_nine;

    @FindBy(how = How.NAME, using = "Plus")
    private WebElement btn_plus;

    @FindBy(how = How.NAME, using = "Minus")
    private WebElement btn_minus;

    @FindBy(how = How.NAME, using = "Multiply by")
    private WebElement btn_multiply;

    @FindBy(how = How.NAME, using = "Divide by")
    private WebElement btn_divide;

    @FindBy(how = How.NAME, using = "Equals")
    private WebElement btn_equals;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='CalculatorResults']")
    private WebElement field_result;

    /*
      ################################################################################################
      The following "getter" methods are used to make sure that above WebElements are hidden from users.
      Method description: These methods provide access to private WebElements.
      Methods parameter: none
      Methods return: public WebElements
      ################################################################################################
    */
    public WebElement getBtn_clear() {
        return btn_clear;
    }

    public WebElement getBtn_one() {
        return btn_one;
    }

    public WebElement getBtn_seven() {
        return btn_seven;
    }

    public WebElement getBtn_eight() {
        return btn_eight;
    }

    public WebElement getBtn_nine() {
        return btn_nine;
    }

    public WebElement getBtn_plus() {
        return btn_plus;
    }

    public WebElement getBtn_minus() {
        return btn_minus;
    }

    public WebElement getBtn_multiply() {
        return btn_multiply;
    }

    public WebElement getBtn_divide() {
        return btn_divide;
    }

    public WebElement getBtn_equals() {
        return btn_equals;
    }

    public WebElement getField_result() {
        return field_result;
    }
}
