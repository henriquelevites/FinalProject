package pageObjects.electronApiDemos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    @FindBy(how = How.ID, using = "button-windows")
    private WebElement btn_Windows;

    @FindBy(how = How.ID, using = "button-crash-hang")
    private WebElement btn_CrashesAndHangs;

    @FindBy(how = How.ID, using = "button-menus")
    private WebElement btn_Menus;

    @FindBy(how = How.XPATH, using = "//section[@id='windows-section']/div[@class='demo']")
    private List<WebElement> lst_WindowsDemoItems;

    @FindBy(how = How.XPATH, using = "//section[@id='crash-hang-section']/div[@class='demo']")
    private List<WebElement> lst_CrashesAndHangsDemoItems;

    @FindBy(how = How.XPATH, using = "//section[@id='menus-section']/div[@class='demo']")
    private List<WebElement> lst_MenusDemoItems;

    /*
      ################################################################################################
      The following "getter" methods are used to make sure that above WebElements are hidden from users.
      Method description: These methods provide access to private WebElements/Lists<WebElement>
      Methods parameter: none
      Methods return: public WebElements/Lists<WebElement>
      ################################################################################################
    */
    public WebElement getBtn_Windows() {
        return btn_Windows;
    }

    public WebElement getBtn_CrashesAndHangs() {
        return btn_CrashesAndHangs;
    }

    public WebElement getBtn_Menus() {
        return btn_Menus;
    }

    public List<WebElement> getLst_WindowsDemoItems() {
        return lst_WindowsDemoItems;
    }

    public List<WebElement> getLst_CrashesAndHangsDemoItems() {
        return lst_CrashesAndHangsDemoItems;
    }

    public List<WebElement> getLst_MenusDemoItems() {
        return lst_MenusDemoItems;
    }



}
