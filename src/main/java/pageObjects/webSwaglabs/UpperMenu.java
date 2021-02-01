package pageObjects.webSwaglabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class UpperMenu {

    @FindBy(how = How.CSS, using = "button[class='bm-burger-button']")
    private WebElement btn_menu;

    @FindBy(how = How.CSS, using = "span[class='fa-layers-counter shopping_cart_badge']")
    private List<WebElement> btn_shoppingCartBadge;

    /*
      ##################################################################################################################
      The following "getter" methods are used to make sure that above WebElement/List<WebElement> are hidden from users.
      Method description: These methods provide access to private WebElement/List<WebElement>
      Methods parameter: none
      Methods return: public WebElement/List<WebElement>
      ##################################################################################################################
    */
    public WebElement getBtn_menu() {
        return btn_menu;
    }

    public List<WebElement> getBtn_shoppingCartBadge() {
        return btn_shoppingCartBadge;
    }
}
