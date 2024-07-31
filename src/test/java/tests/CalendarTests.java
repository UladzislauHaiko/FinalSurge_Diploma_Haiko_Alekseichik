package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarTests extends BaseTestWithLogin {
    @Test(groups = "positive")
    public void verifyUploadFileOnCalendarPageTest() {
        dashboardPage.isPageOpened();
        dashboardPage.clickCalendar();
        String day = "10";
        calendarPage.selectUploadDataOptionForDay(day);
        String fileName = System.getProperty("user.dir") + "/src/test/resources/example.tcx";
        calendarPage.uploadFile(fileName);
        Assert.assertTrue(calendarPage.workoutDetailsSectionIsDisplayed());
        dashboardPage.clickCalendar();
        calendarPage.isPageOpened();
        Assert.assertTrue(calendarPage.isActivityCardDisplayedForDay(day));
    }
}