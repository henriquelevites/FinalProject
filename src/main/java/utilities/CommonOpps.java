package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class CommonOpps extends Base {

    /*
    #########################################################################
    Method name: getConfigData
    Method description: This method gets the data from XML configuration file
    Method parameter: String nodeName - tag(node) name in XML file
    Method return: String - text content in tag(node) name in XML file
    #########################################################################
     */
    public static String getConfigData(String nodeName) {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try
        {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        }
        catch (Exception e)
        {
            System.out.println("Error Reading XML File: " + e);
        }
        finally
        {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

    /*
    ####################################################################################################
    Method name: startSession
    Method description: This method performs the following actions:
                        - starts new session according to platform name
                        - initiates objects: softAssert (for TestNG assertions) and screen (for sikuli)
                        - opens connection to DB using URL, username and password configured in XMl file
    Method parameter: String PlatformName - Name of platform to test
    Method return: none
    ####################################################################################################
     */
    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) {
        platform = PlatformName;
        if (platform.equalsIgnoreCase("web"))
            initBrowser(getConfigData("BrowserName"));
        else if (platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if (platform.equalsIgnoreCase("api"))
            initAPI();
        else if (platform.equalsIgnoreCase("electron"))
            initElectron();
        else if (platform.equalsIgnoreCase("desktop"))
            initDesktop();
        else throw new RuntimeException("Invalid platform name");
        softAssert = new SoftAssert();
        screen = new Screen();
        ManageDB.openConnection(getConfigData("DBURL"),getConfigData("DBUserName"), getConfigData("DBPassword"));
    }

    /*
    #################################################################################
    Method name: initBrowser
    Method description: This method performs the following actions:
                        - initiates driver according to browser type
                        - maximizes browser window
                        - sets implicitly wait time (timeout) configured in XML file
                        - navigates to web site configured in XML file
                        - creates object action from class Actions by constructor. Driver that was initiate with
                          ChromeDriver is sent to this constructor.
    Method parameter: String browserType - Name of browser to test
    Method return: none
    #################################################################################
     */
    public static void initBrowser(String browserType)  {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFireFoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else throw new RuntimeException("Invalid browser type");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getConfigData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getConfigData("Timeout")));
        driver.get(getConfigData("urlWeb"));
        action = new Actions(driver);

        ManagePages.initWebSwagLabs();
    }

    /*
    #######################################################
    Method name: initChromeDriver
    Method description: This method initiates Chrome driver
    Method parameter: none
    Method return: WebDriver driver
    #######################################################
     */
    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    /*
    #######################################################
    Method name: initFireFoxDriver
    Method description: This method initiates Firefox driver
    Method parameter: none
    Method return: WebDriver driver
    #######################################################
     */
    public static WebDriver initFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    /*
    #######################################################
    Method name: initIEDriver
    Method description: This method initiates IE driver
    Method parameter: none
    Method return: WebDriver driver
    #######################################################
    */
    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    /*
    ###########################################################################################################
    Method name: initMobile
    Method description: This method performs the following actions:
                        - defines and sets configurations of the device and the application to be tested
                          to mobileDriver
                        - initiates mobile driver given the local appium server URL and the object dc containing
                          all the configurations
                        - initiates all objects of the application pages to be tested
                        - sets implicitly wait time (timeout)
                        - creates object action from class Actions by constructor. Driver that was initiated with
                          ChromeDriver is sent to this constructor.
    Method parameter: none
    Method return: none
    ############################################################################################################
    */
    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, getConfigData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getConfigData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getConfigData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver(new URL(getConfigData("AppiumServer")), dc);
        } catch (MalformedURLException e) {
            System.out.println("Cannot connect to appium server; see details: " + e);
        }
        ManagePages.initMobileMainApiDemos();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getConfigData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver,Long.parseLong(getConfigData("Timeout")));
        action = new Actions(driver);
    }

   /*
   ###########################################################################################################
   Method name: initAPI
   Method description: This method performs the following actions:
                       - send the urlAPI (configured in XML file) to the property baseURI of class RestAssured
                       - initiates baseURI by method given() which returns object of type RequestSpecification
                         that is saved to httpRequest (now httpRequest is initiated with the same urlAPI).
   Method parameter: none
   Method return: none
   ###########################################################################################################
   */
    public static void initAPI() {
        RestAssured.baseURI = getConfigData("urlAPI");
        httpRequest = RestAssured.given();
    }

   /*
   ###############################################################################################################
   Method name: initElectron
   Method description: This method performs the following actions:
                       - defines electrondriver given the constant global operating system variable and
                         the path where electrondriver is saved
                       - initiates the object opt of type ChromeOptions.
                       - defines the path of the application to be tested via opt
                       - send to object dc the path of the application via opt
                       - set browser to Chrome (because Electron is build over the same engine as Chrome: Chromium)
                       - initiates driver by sending the capabilities in object dc
                       - initiates the objects of the application page to be tested
                       - sets implicitly wait time (timeout)
                       - creates object action from class Actions by constructor. Driver that was initiated with
                         ChromeDriver is sent to this constructor.
   Method parameter: none
   Method return: none
   ###############################################################################################################
   */
    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver",getConfigData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getConfigData("ElectronAppPath"));
        dc.setCapability("chromeOptions",opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initElectronApiDemos();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getConfigData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getConfigData("Timeout")));
        action = new Actions(driver);
    }

    /*
    ###############################################################################################################
    Method name: initDesktop
    Method description: This method performs the following actions:
                       - sends to variable "app" the application signature (if is Windows native app)
                         or the application location path (if not), and send the "app" to object dc (of
                         type Capability)
                       - initiates windows driver given the local appium server URL and the object dc containing
                         the configurations
                       - sets implicitly wait time (timeout)
                       - initiates the objects of the application pages to be tested
   Method parameter: none
   Method return: none
   ###############################################################################################################
   */
    public static void initDesktop() {
        dc.setCapability("app",getConfigData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL(getConfigData("AppiumServerDesktop")), dc);
        } catch (Exception e) {
            System.out.println("Cannot connect to Appium Server; see details: " + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getConfigData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getConfigData("Timeout")));
        ManagePages.initDesktopCalculator();
    }

    /*
      ###############################################################
      Method name: closeSession
      Method description: This method performs the following actions:
                          - Closes the connection to DB
                          - quit platform according to platform name
      Method parameter: none
      Method return: none
      ###############################################################
    */
    @AfterClass
    public void closeSession() {
        ManageDB.closeConnection();
        if (!platform.equalsIgnoreCase("api")) {
            if (!platform.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();
        }
    }

    /*
      ###############################################################
      Method name: beforeMethod
      Method description: This method starts video recording of tests
      Method parameter: Method method - name of test to be recorded
      Method return: none
      ###############################################################
    */
    @BeforeMethod
    public void beforeMethod(Method method) {
        if (!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*
      ####################################################################################
      Method name: afterMethod
      Method description: This method reloads the tested URL web site after each test case
      Method parameter: none
      Method return: none
      ####################################################################################
    */
    @AfterMethod
    public void afterMethod() {
        if (platform.equalsIgnoreCase("web"))
            driver.get(getConfigData("urlWeb"));
    }
}
