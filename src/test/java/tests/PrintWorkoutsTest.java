package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintWorkoutsTest extends BaseTestWithLogin {

    @Test(groups = "negative")
    public void verifyPrintWithoutData() {
        dashboardPage.openPage();
        dashboardPage.isPageOpened();
        dashboardPage.clickPrintWorkouts();
        String expectedErrorMsg = """
                ×
                Please fix the following errors:
                *The date range you have selected does not contain any workouts. Please close this browser window and adjust your date range.""";
        printWorkoutsPage.print("06/07/2024", "06/09/2024");
        Assert.assertEquals(printWorkoutsPage.getErrorText(), expectedErrorMsg,
                "Error message does appear");
    }

    @Test(groups = "positive")
    public void verifyPrintWithData() {
        dashboardPage.isPageOpened();
        dashboardPage.clickPrintWorkouts();
        printWorkoutsPage.print("07/12/2024", "07/12/2024");
        Assert.assertTrue(printWorkoutsPage.isLogoDisplayed(), "Some data about fitness exists");
        printWorkoutsPage.closeTab();
    }

    @Test(groups = "negative")
    public void verifyPrintIncorrectDates() {
        dashboardPage.isPageOpened();
        dashboardPage.clickPrintWorkouts();
        printWorkoutsPage.print("07/24/2024", "07/23/2024");
        String expectedErrorMsg = """
                ×
                Please fix the following errors:
                *The Starting Date cannot be greater than the Ending Date. Please close this browser window and adjust your date range.""";
        Assert.assertEquals(printWorkoutsPage.getErrorText(), expectedErrorMsg);
        printWorkoutsPage.closeTab();
    }
}