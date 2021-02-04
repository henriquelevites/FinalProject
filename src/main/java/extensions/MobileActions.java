package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOpps;
import java.util.concurrent.TimeUnit;


public class MobileActions extends CommonOpps {

   @Step("Update Text Element")
    public static void updateText(MobileElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Tap on Element")
    public static void tap(int fingers, MobileElement elem, int duration) {
       wait.until(ExpectedConditions.elementToBeClickable(elem));
//       mobileDriver.tap(fingers, elem, duration); (Put in comments due to conflict with winappdriver libraries)
    }

    @Step("Swipe")
    public static void swipe(int startX, int startY, int endX, int endY, int duration) {
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
//        mobileDriver.swipe(startX, startY, endX, endY, duration); (Put in comments due to conflict with winappdriver libraries)
    }

    @Step("Zoom Element")
    public static void zoom(MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
//        mobileDriver.zoom(elem);  (Put in comments due to conflict with winappdriver libraries)
    }

    @Step("Pinch Element")
    public static void pinch(MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
//        mobileDriver.pinch(elem); (Put in comments due to conflict with winappdriver libraries)
    }

    @Step("Execute Script")
    public static void executeScript(String script) {
        mobileDriver.executeScript(script);
    }

    @Step("Get Coordinate X of Element")
    public static int getCoordinateX(MobileElement elem) {
       return elem.getRect().getX();
    }

    @Step("Get Coordinate X of Element")
    public static int getCoordinateY(MobileElement elem) {
        return elem.getRect().getY();
    }
}
