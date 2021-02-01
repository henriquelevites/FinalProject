package pageObjects.webSwaglabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ProductsPage {

    @FindBy(how = How.CLASS_NAME, using = "product_label")
    private WebElement head_Products;

    @FindBy(how = How.CSS, using = "button[class='btn_primary btn_inventory']")
    private WebElement btn_AddToCart;

    @FindBy(how = How.CSS, using = "button[class='btn_secondary btn_inventory']")
    private WebElement btn_RemoveFromCart;

    @FindBy(how = How.CLASS_NAME, using = "product_sort_container")
    private WebElement combox_ProductsSort;

    @FindBy(how = How.CSS, using = "option[value='lohi']")
    private WebElement option_SortPriceLowHigh;

    @FindBy(how = How.CLASS_NAME, using = "inventory_item_price")
    private List<WebElement> item_price;

    /*
      ################################################################################################
      The following "getter" methods are used to make sure that above WebElements are hidden from users.
      Method description: These methods provide access to private WebElements/List<WebElement>
      Methods parameter: none
      Methods return: public WebElements/List<WebElement>
      ################################################################################################
    */
    public WebElement getHead_Products() {
        return head_Products;
    }

    public WebElement getBtn_AddToCart() {
        return btn_AddToCart;
    }

    public WebElement getBtn_RemoveFromCart() {
        return btn_RemoveFromCart;
    }

    public WebElement getCombox_ProductsSort() {
        return combox_ProductsSort;
    }

    public WebElement getOption_SortPriceLowHigh() {
        return option_SortPriceLowHigh;
    }

    public List<WebElement> getItem_price() {
        return item_price;
    }

}
