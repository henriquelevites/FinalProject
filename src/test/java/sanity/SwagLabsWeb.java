package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOpps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SwagLabsWeb extends CommonOpps {

    @Test(description = "Test01 - Data Driven - Verify Successful Login", dataProvider = "data-provider-login", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test verifies successful user login using Data Driven")
    public void test01_verifySuccessfulLogin(String username, String password) {
        WebFlows.login(username,password);
        Verifications.verifyTextInElement(swaglabsProducts.getHead_Products(), "Products");
    }

    @Test(description = "Test02 - Verify Login Fail")
    @Description("This test verifies user login failure")
    public void test02_verifyLoginFail() {
        WebFlows.login("locked_out_user","secret_sauce");
        Verifications.verifyElementDisplayed(swaglabsLogin.getBtn_error());
    }

    @Test(description = "Test03 - Verify Item Added To Cart")
    @Description("This test verifies that item is added to cart")
    public void test03_verifyItemAddedToCart() {
        WebFlows.login(getConfigData("ValidUser"),getConfigData("ValidPassword"));
        WebFlows.addFirstItemToCart();
        Verifications.verifyElementExists(swagLabsUpperMenu.getBtn_shoppingCartBadge());
    }

    @Test(description = "Test04 - Verify Item Removed From Cart")
    @Description("This test verifies that item is removed from cart")
    public void test04_verifyItemRemovedFromCart() {
        WebFlows.login(getConfigData("ValidUser"),getConfigData("ValidPassword"));
        WebFlows.removeFirstItemFromCart();
        Verifications.verifyElementNotExists(swagLabsUpperMenu.getBtn_shoppingCartBadge());
    }

    @Test(description = "Test05 - Verify Sort Items By Price Low To High")
    @Description("This test verifies that items in products page are sorted by price from low to high")
    public void test05_verifySortItemsByPriceLowToHigh() {
        WebFlows.login(getConfigData("ValidUser"),getConfigData("ValidPassword"));
        WebFlows.sortItemsByPriceLowToHigh();
        Verifications.verifyElementsSortLowToHigh(swaglabsProducts.getItem_price());
    }

    @Test(description = "Test06 - Graphic Element- Verify Hamburger Icon")
    @Description("This test verifies the graphic element of Hamburger Icon Using Sikuli Tool")
    public void test06_verifyHamburgerIcon() {
        WebFlows.login(getConfigData("ValidUser"),getConfigData("ValidPassword"));
        Verifications.verifyVisualElement("Hamburger");
    }
}
