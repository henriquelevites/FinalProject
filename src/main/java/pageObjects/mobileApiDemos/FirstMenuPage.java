package pageObjects.mobileApiDemos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static java.util.concurrent.TimeUnit.SECONDS;


public class FirstMenuPage {

    private AppiumDriver mobileDriver;

    public FirstMenuPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
     //   PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, SECONDS), this);   (Put in comments due to conflict with winappdriver libraries)
    }

    @AndroidFindBy(id="text1")
    private List<AndroidElement> btn_mainMenu;

    @AndroidFindBy(xpath = "//*[@text='Content']")
    private AndroidElement btn_Content;

    @AndroidFindBy(xpath="//*[@text='Views']")
    private AndroidElement btn_Views;

    /*
      ################################################################################################
      The following "getter" methods are used to make sure that above WebElements are hidden from users.
      Method description: These methods provide access to private AndroidElements/Lists<AndroidElement>.
      Methods parameter: none
      Methods return: public AndroidElements/Lists<AndroidElement>
      ################################################################################################
    */
    public List<AndroidElement> getBtn_mainMenu() {
        return btn_mainMenu;
    }

    public AndroidElement getBtn_Content() {
        return btn_Content;
    }

    public AndroidElement getBtn_Views() {
        return btn_Views;
    }

}
