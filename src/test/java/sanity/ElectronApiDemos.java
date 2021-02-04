package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOpps;
import workflows.ElectronFlows;
import java.util.concurrent.TimeUnit;

@Listeners(utilities.Listeners.class)
public class ElectronApiDemos extends CommonOpps {

    @Test(description = "Test01 - Verify Number of 'Create and manage windows' Demo Items")
    @Description("This test verifies correct number of 'Create and manage windows' demo items")
    public void test01_verifyNumberOfWindowsDemoItems() {
        Verifications.verifyNumbers(ElectronFlows.getNumberOfWindowsDemoItems(), 4);
    }

    @Test(description = "Test02 - Verify Number of 'Handling window crashes and hangs' Demo Items")
    @Description("This test verifies correct number of 'Handling window crashes and hangs' demo items")
    public void test02_verifyNumberOfCrashesAndHangsDemoItems() {
        Verifications.verifyNumbers(ElectronFlows.getNumberOfCrashesAndHangsDemoItems(), 2);
    }

    @Test(description = "Test03 - Verify Number of 'Customize menus' Demo Items")
    @Description("This test verifies correct number of 'Customize menus' demo items")
    public void test02_verifyNumberOfMenusDemoItems() {
        Verifications.verifyNumbers(ElectronFlows.getNumberOfMenusDemoItems(), 2);
    }
}
