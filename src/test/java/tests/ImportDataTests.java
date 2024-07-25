package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ImportDataTests extends BaseTest {
    @Test(groups = "negative")
    public void verifyUploadWithoutFileOnImportData() {
        dashboardPage.isPageOpened();
        dashboardPage.navigateToImportData();
        importDataPage.clickToUploadFile();
        Assert.assertEquals(importDataPage.getDataImportStatusTxt(),
                "You did not upload a valid import file. Please choose a valid file and try again.");
    }
}