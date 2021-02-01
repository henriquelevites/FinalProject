package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOpps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SwagLabsWebDB extends CommonOpps {
    @Test(description = "Test01 - Login to SwagLabs with DB Credentials")
    @Description("This test login with DB credentials and verifies Products header text")
    public void test01_loginUsingDBAndVerifyHeader() {
        WebFlows.loginUsingDB();
        Verifications.verifyTextInElement(swaglabsProducts.getHead_Products(), "Products");
    }
}
