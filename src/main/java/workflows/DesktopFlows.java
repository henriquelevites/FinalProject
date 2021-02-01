package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOpps;

public class DesktopFlows extends CommonOpps {
    @Step("Calculate Addition: 1 + 7")
    public static void calculateAddition() {
        UIActions.click(calcMain.getBtn_clear());
        UIActions.click(calcMain.getBtn_one());
        UIActions.click(calcMain.getBtn_plus());
        UIActions.click(calcMain.getBtn_seven());
        UIActions.click(calcMain.getBtn_equals());
    }

    @Step("Calculate Combination of Operations")
    public static void calculateCombination() {
        UIActions.click(calcMain.getBtn_clear());
        UIActions.click(calcMain.getBtn_seven());
        UIActions.click(calcMain.getBtn_multiply());
        UIActions.click(calcMain.getBtn_nine());
        UIActions.click(calcMain.getBtn_plus());
        UIActions.click(calcMain.getBtn_one());
        UIActions.click(calcMain.getBtn_equals());
        UIActions.click(calcMain.getBtn_divide());
        UIActions.click(calcMain.getBtn_eight());
        UIActions.click(calcMain.getBtn_equals());
    }

    @Step("Calculate Division: 88 / 11")
    public static void calculateDivision() {
        UIActions.click(calcMain.getBtn_clear());
        UIActions.click(calcMain.getBtn_eight());
        UIActions.click(calcMain.getBtn_eight());
        UIActions.click(calcMain.getBtn_divide());
        UIActions.click(calcMain.getBtn_one());
        UIActions.click(calcMain.getBtn_one());
        UIActions.click(calcMain.getBtn_equals());
    }

    @Step("Calculate Multiplication: 9 * 9")
    public static void calculateMultiplication() {
        UIActions.click(calcMain.getBtn_equals());
        UIActions.click(calcMain.getBtn_nine());
        UIActions.click(calcMain.getBtn_multiply());
        UIActions.click(calcMain.getBtn_nine());
        UIActions.click(calcMain.getBtn_equals());
    }

    @Step("Calculate Subtraction: 9 - 1")
    public static void calculateSubtraction() {
        UIActions.click(calcMain.getBtn_clear());
        UIActions.click(calcMain.getBtn_nine());
        UIActions.click(calcMain.getBtn_minus());
        UIActions.click(calcMain.getBtn_one());
        UIActions.click(calcMain.getBtn_equals());
    }

    @Step("Get calculator Result Text")
    public static String getCalculatorResultText() {
        // trim extra text and whitespace off of the display value
        return calcMain.getField_result().getText().replace("Display is", "").trim();
    }
}
