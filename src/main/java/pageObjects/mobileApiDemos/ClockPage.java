package pageObjects.mobileApiDemos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class ClockPage {

    private AppiumDriver mobileDriver;

    public ClockPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
//        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 5, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id="hours")
    private AndroidElement txt_hour;

    @AndroidFindBy(id="minutes")
    private AndroidElement txt_minutes;

    @AndroidFindBy(xpath="//*[@contentDescription='12']")
    private AndroidElement txt_Hour12;

    @AndroidFindBy(xpath="//*[@contentDescription='9']")
    private AndroidElement txt_Hour9;

    @AndroidFindBy(xpath="//*[@contentDescription='15']")
    private AndroidElement txt_Minute15;

    @AndroidFindBy(xpath="//*[@content-desc='45']")
    private AndroidElement txt_Minute45;

    /*
      ################################################################################################
      The following "getter" methods are used to make sure that above WebElements are hidden from users.
      Method description: These methods provide access to private AndroidElements.
      Methods parameter: none
      Methods return: public AndroidElements
      ################################################################################################
    */
    public AndroidElement getTxt_hour() {
        return txt_hour;
    }

    public AndroidElement getTxt_minutes() {
        return txt_minutes;
    }

    public AndroidElement getTxt_Hour12() {
        return txt_Hour12;
    }

    public AndroidElement getTxt_Hour9() {
        return txt_Hour9;
    }

    public  AndroidElement getTxt_Minute15() {
        return txt_Minute15;
    }

    public AndroidElement getTxt_Minute45() {
        return txt_Minute45;
    }
}
