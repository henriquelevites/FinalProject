package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOpps;

public class ElectronFlows extends CommonOpps {

    @Step("Business Flow: Count and Return Number of 'Create and manage windows' Demo Items")
    public static int getNumberOfWindowsDemoItems() {
        UIActions.click(electronApiDemosMainPage.getBtn_Windows());
        return electronApiDemosMainPage.getLst_WindowsDemoItems().size();
    }

    @Step("Business Flow: Count and Return Number of 'Handling window crashes and hangs' Demo Items")
    public static int getNumberOfCrashesAndHangsDemoItems() {
        UIActions.click(electronApiDemosMainPage.getBtn_CrashesAndHangs());
        return electronApiDemosMainPage.getLst_CrashesAndHangsDemoItems().size();
    }

    @Step("Business Flow: Count and Return Number of 'Customize menus' Demo Items")
    public static int getNumberOfMenusDemoItems() {
        UIActions.click(electronApiDemosMainPage.getBtn_Menus());
        return electronApiDemosMainPage.getLst_MenusDemoItems().size();
    }
}
