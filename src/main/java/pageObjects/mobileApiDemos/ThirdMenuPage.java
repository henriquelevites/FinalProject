package pageObjects.mobileApiDemos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ThirdMenuPage {

    private AppiumDriver mobileDriver;

    public ThirdMenuPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
//        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(xpath="//*[@text='2. Inline']")
    private AndroidElement btn_Inline;

    /*
      ################################################################################################
      Method name: getBtn_Inline
      Method description: This method provides access to private AndroidElement.
      Method parameter: none
      Method return: public AndroidElement
      ################################################################################################
    */
    public AndroidElement getBtn_Inline() {
        return btn_Inline;
    }
}
