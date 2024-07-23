package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarTests extends BaseTest {
    @Test(groups = "positive")
    public void verifyUploadFileOnCalendarPageTest() {
        dashboardPage.isPageOpened();
        dashboardPage.clickCalendar();
        calendarPage.selectUploadDataOptionForDay("10");
        String fileName = System.getProperty("user.dir") + "/src/test/resources/example.tcx";
        calendarPage.uploadFile(fileName);
        Assert.assertTrue(calendarPage.workoutDetailsSectionIsDisplayed());
    }
}
