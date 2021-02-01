package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;


public class Listeners extends CommonOpps implements ITestListener
{
    /*
    #####################################################################################
    Method name: onStart
    Method description: This method is called when a execution of a suite of tests starts
    Method parameter: execution - context in ITestContext interface
    Method return: none
    #####################################################################################
    */
    public void onStart(ITestContext execution)
    {
        System.out.println("\n---------- Starting execution ----------");
    }

    /*
    ###################################################################################
    Method name: onFinish
    Method description: This method is called when a execution of a suite of tests ends
    Method parameter: execution - context in ITestContext interface
    Method return: none
    ###################################################################################
    */
    public void onFinish(ITestContext execution)
    {
        System.out.println("\n---------- Execution ended ----------");
    }

    /*
    ################################################################################
    Method name: onTestStart
    Method description: This method is called when any Test starts.
    Method parameter: test - context in ITestResult interface
    Method return: none
    ################################################################################
    */
    public void onTestStart(ITestResult test)
    {
        System.out.println("\n---------- Starting test: " + test.getName() + " ----------");
    }

    /*
    ################################################################################
    Method name: onTestSkipped
    Method description: This method is called on skipped of any Test.
    Method parameter: test - context in ITestResult interface
    Method return: none
    ################################################################################
    */
    public void onTestSkipped(ITestResult test)
    {
        System.out.println("\n---------- Skipping test: " + test.getName() + " ----------");
    }

    /*
    ################################################################################
    Method name: onTestSuccess
    Method description: This method is called on the success of any Test.
    Method parameter: test - context in ITestResult interface
    Method return: none
    ################################################################################
    */
    public void onTestSuccess(ITestResult test)
    {
        System.out.println("---------- Test: " + test.getName() + " Passed ----------");
        if (!platform.equalsIgnoreCase("api"))
        {
            // Stop Recording
            try
            {
                MonteScreenRecorder.stopRecord();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            // Delete Recorded File
            File file = new  File("./test-recordings/" + test.getName() + ".avi");
            if (file.delete())
                System.out.println("File deleted successfully");
            else
                System.out.println("Failed to delete the file");
            }
        }

    /*
    ################################################################################
    Method name: onTestFailure
    Method description: This method is called on the failure of any Test.
    Method parameter: test - context in ITestResult interface
    Method return: none
    ################################################################################
    */
    public void onTestFailure(ITestResult test)
    {
        System.out.println("---------- Test: " + test.getName() + " Failed ------------");
        if (!platform.equalsIgnoreCase("api"))
        {
            // Stop Recording
            try
            {
                MonteScreenRecorder.stopRecord();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            saveScreenshot();
        }
    }

    /*
    ################################################################################################
    Method name: onTestFailedButWithinSuccessPercentage
    Method description: This method is called each time Test fails but is within success percentage.
    Method parameter: test - context in ITestResult interface
    Method return: none
    ################################################################################################
    */
    public void onTestFailedButWithinSuccessPercentage(ITestResult test)
    {
        System.out.println("---------- Test: " + test.getName() + " Failed with Success % ----------");
    }

    /*
    ############################################################################################
    Method name: saveScreenshot
    Method description: This method takes/saves screenshot of web/mobile page and adds on report
    Method parameter: none
    Method return: byte Array
    ############################################################################################
    */
    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] saveScreenshot()
    {
        if (!platform.equalsIgnoreCase("mobile"))
            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        else
            return ((TakesScreenshot)mobileDriver).getScreenshotAs(OutputType.BYTES);
    }
}
