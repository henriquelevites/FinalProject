package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOpps;

import java.util.concurrent.TimeUnit;

public class MobileFlows extends CommonOpps {

    @Step("Business Flow: Change Demo Clock Time")
    public static void changeDemoClockTimeTo9_45() {
        MobileActions.tap(1, apiDemosFirstMenu.getBtn_Views(), 500);
        MobileActions.tap(1, apiDemosSecondMenu.getBtn_DateWidgets(), 500);
        MobileActions.tap(1, apiDemosThirdMenu.getBtn_Inline(), 500);
        MobileActions.tap(1, apiDemosClock.getTxt_Hour9(), 500);
        MobileActions.tap(1, apiDemosClock.getTxt_Minute45(), 500);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

}
