package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintWorkoutsTest extends BaseTest {

    @Test(groups = "negative")
    public void verifyPrintWithoutData() {
        dashboardPage.openPage();
        dashboardPage.isPageOpened();
        dashboardPage.clickPrintWorkouts();
        String expectedErrorMsg = """
                ×
                Please fix the following errors:
                *The date range you have selected does not contain any workouts. Please close this browser window and adjust your date range.""";
        printWorkoutsPage.print("07/07/2024", "07/09/2024");
        Assert.assertEquals(printWorkoutsPage.getErrorText(), expectedErrorMsg,
                "Error message does NOT appear");
    }

    @Test(groups = "positive")
    public void verifyPrintWithData() {
        dashboardPage.isPageOpened();
        dashboardPage.clickPrintWorkouts();
        printWorkoutsPage.print("07/12/2024", "07/12/2024");
        Assert.assertTrue(printWorkoutsPage.isLogoDisplayed(), "Some data about fitness exists");
        printWorkoutsPage.closeTab();
    }
}
