package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.DBActions;
import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOpps;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebFlows extends CommonOpps {

    @Step("Business Flow: Login")
    public static void login(String username, String password) {
        UIActions.updateText(swaglabsLogin.getTxt_username(), username);
        UIActions.updateText(swaglabsLogin.getTxt_password(), password);
        UIActions.click(swaglabsLogin.getBtn_login());
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Step("Business Flow: Login to SwagLabs with Database credentials")
    public static void loginUsingDB() {
        String query = "SELECT user_name, password FROM myUsers WHERE id = '3'";
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(swaglabsLogin.getTxt_username(), cred.get(0));
        UIActions.updateText(swaglabsLogin.getTxt_password(), cred.get(1));
        UIActions.click(swaglabsLogin.getBtn_login());
    }

    @Step("Business Flow: Add First Item To Cart")
    public static void addFirstItemToCart() {
        UIActions.click(swaglabsProducts.getBtn_AddToCart());
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Step("Business Flow: Remove First Item From Cart")
    public static void removeFirstItemFromCart() {
        UIActions.click(swaglabsProducts.getBtn_RemoveFromCart());
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Step("Business Flow: Sort Items By Price Low To High")
    public static void sortItemsByPriceLowToHigh() {
        UIActions.updateDropDown(swaglabsProducts.getCombox_ProductsSort(), swaglabsProducts.getOption_SortPriceLowHigh());
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

}
