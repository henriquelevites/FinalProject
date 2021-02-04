package pageObjects.mobileApiDemos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SecondMenuPage {

    private AppiumDriver mobileDriver;

    public SecondMenuPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
     //   PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS), this);  (Put in comments due to conflict with winappdriver libraries)
    }

    @AndroidFindBy(xpath="//*[@contentDescription='Date Widgets']")
    private AndroidElement btn_DateWidgets;

    /*
      ################################################################################################
      Method name: getBtn_DateWidgets
      Method description: This method provides access to private AndroidElement.
      Method parameter: none
      Method return: public AndroidElement
      ################################################################################################
    */
    public AndroidElement getBtn_DateWidgets() {
        return btn_DateWidgets;
    }
}
