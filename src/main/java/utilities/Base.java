package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.webSwaglabs.*;
import pageObjects.mobileApiDemos.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {

    //General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static String platform;

    //Web, Electron & Desktop
    protected static WebDriver driver;

    //Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    //Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject requestParams = new JSONObject();
    protected static JsonPath jp;

    // Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;

    // Page objects - Web
    protected static LoginPage swaglabsLogin;
    protected static ProductsPage swaglabsProducts;
    protected static UpperMenu swagLabsUpperMenu;

    // Page objects - Mobile
    protected static FirstMenuPage apiDemosFirstMenu;
    protected static SecondMenuPage apiDemosSecondMenu;
    protected static ThirdMenuPage apiDemosThirdMenu;
    protected static ClockPage apiDemosClock;

    // Page Object - Electron
    protected static pageObjects.electronApiDemos.MainPage electronApiDemosMainPage;

    // Page Object - Desktop
    protected static pageObjects.desktopCalculator.MainPage calcMain;
}
