package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOpps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class ApiDemosMobile extends CommonOpps {

    @Test(description = "Test01 - Verify Number of Menus in First Page of ApiDemos app")
    @Description("This test verifies the number of menus in first page of ApiDemos app")
    public void test01_verifyNumberOfFirstPageMenus() {
        Verifications.verifyNumberOfMobileElements(apiDemosFirstMenu.getBtn_mainMenu(), Integer.parseInt(getConfigData("FirstPageNumberOfMenuItems")));
    }

    @Test(description = "Test02 - Verify Demo Clock Time Change")
    @Description("This test verifies that demo clock time changed - This time to 9:45 PM")
    public void test02_verifyDemoClockTimeChangeTo9_45PM() {
        MobileFlows.changeDemoClockTimeTo9_45();
        Verifications.verifyTextInElement(apiDemosClock.getTxt_hour(), "9");
        Verifications.verifyTextInElement(apiDemosClock.getTxt_minutes(), "45");
    }
}
