package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.mobileApiDemos.*;
import pageObjects.webSwaglabs.UpperMenu;

public class ManagePages extends Base{

    /*
    ##########################################################################################
    Method name: initWebSwagLabs
    Method description: This method initiates the elements of all pages tested in web platform
    Method parameter: none
    Method return: none
    ##########################################################################################
    */
    public static void initWebSwagLabs() {

        swaglabsLogin = PageFactory.initElements(driver, pageObjects.webSwaglabs.LoginPage.class);
        swaglabsProducts = PageFactory.initElements(driver, pageObjects.webSwaglabs.ProductsPage.class);
        swagLabsUpperMenu = PageFactory.initElements(driver, UpperMenu.class);
    }

    /*
    #############################################################################################
    Method name: initMobileMainApiDemos
    Method description: This method initiates the elements of all pages tested in mobile platform
    Method parameter: none
    Method return: none
    #############################################################################################
    */
    public static void initMobileMainApiDemos() {
        apiDemosFirstMenu = new FirstMenuPage(mobileDriver);
        apiDemosSecondMenu = new SecondMenuPage(mobileDriver);
        apiDemosThirdMenu = new ThirdMenuPage(mobileDriver);
        apiDemosClock = new ClockPage(mobileDriver);
    }

    /*
    ##############################################################################################
    Method name: initElectronApiDemos
    Method description: This method initiates the elements of the page tested in electron platform
    Method parameter: none
    Method return: none
    ##############################################################################################
    */
    public static void initElectronApiDemos() {
        electronApiDemosMainPage = PageFactory.initElements(driver, pageObjects.electronApiDemos.MainPage.class);
    }

    /*
    ##############################################################################################
    Method name: initDesktopCalculator
    Method description: This method initiates the elements of the page tested in desktop platform
    Method parameter: none
    Method return: none
    ##############################################################################################
    */
    public static void initDesktopCalculator() {
        calcMain = PageFactory.initElements(driver, pageObjects.desktopCalculator.MainPage.class);
    }
}
