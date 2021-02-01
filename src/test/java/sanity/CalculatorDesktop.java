package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOpps;
import workflows.DesktopFlows;

@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOpps {

    @Test(description = "Verify Addition Result")
    @Description("This test verifies addition result by calculator")
    public void verifyAddition() {
        DesktopFlows.calculateAddition();
        Verifications.verifyTexts(DesktopFlows.getCalculatorResultText(), "8");
    }

    @Test(description = "Verify Combination of Operations Result")
    @Description("This test verifies combination of operations result by calculator")
    public void verifyCombination() {
        DesktopFlows.calculateCombination();
        Verifications.verifyTexts(DesktopFlows.getCalculatorResultText(), "8");
    }

    @Test(description = "Verify Division Result")
    @Description("This test verifies division result by calculator")
    public void verifyDivision() {
        DesktopFlows.calculateDivision();
        Verifications.verifyTexts(DesktopFlows.getCalculatorResultText(), "8");
    }

    @Test(description = "Verify Multiplication Result")
    @Description("This test verifies multiplication result by calculator")
    public void verifyMultiplication() {
        DesktopFlows.calculateMultiplication();
        Verifications.verifyTexts(DesktopFlows.getCalculatorResultText(), "81");
    }

    @Test(description = "Verify Subtraction Result")
    @Description("This test verifies subtraction result by calculator")
    public void verifySubtraction() {
        DesktopFlows.calculateSubtraction();
        Verifications.verifyTexts(DesktopFlows.getCalculatorResultText(), "8");
    }
}
