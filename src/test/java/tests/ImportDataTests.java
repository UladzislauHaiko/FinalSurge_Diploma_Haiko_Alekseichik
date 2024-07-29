package tests;

import enums.ImportFrom;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImportDataTests extends BaseTestWithLogin {

    @Test(groups = "positive")
    public void verifyUploadFileOnImportData() {
        dashboardPage.isPageOpened();
        dashboardPage.navigateToImportData();
        importDataPage.selectImportingFromValue(ImportFrom.MY_SWIM_BIKE_RUN);
        String fileName = System.getProperty("user.dir") + "/src/test/resources/example.tcx";
        importDataPage.selectFile(fileName);
        importDataPage.clickToUploadFile();
        Assert.assertEquals(importDataPage.getDataImportStatusTxt(),
                "Your data import is complete! Your imported workouts will now be displayed on your calendar.");
        dashboardPage.clickCalendar();
        calendarPage.isPageOpened();
        Assert.assertTrue(calendarPage.isActivityCardDisplayedForDay("20"));
    }

    @Test(groups = "negative", enabled = false)
    public void verifyUploadWithoutFileOnImportData() {
        dashboardPage.isPageOpened();
        dashboardPage.navigateToImportData();
        importDataPage.clickToUploadFile();
        Assert.assertEquals(importDataPage.getDataImportStatusTxt(),
                "You did not upload a valid import file. Please choose a valid file and try again.");
    }
}