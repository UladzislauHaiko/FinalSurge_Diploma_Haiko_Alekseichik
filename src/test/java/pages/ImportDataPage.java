package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImportDataPage extends BasePage {

    private final By dataImportStatus = By.xpath("//h3[@id='thestatus']");

    private final By uploadFileBtn = By.id("saveButton");

    public ImportDataPage(WebDriver driver) {
        super(driver);
    }

    public void clickToUploadFile() {
        driver.findElement(uploadFileBtn).click();
    }

    public String getDataImportStatusTxt() {
        return driver.findElement(dataImportStatus).getText();
    }

    @Override
    public void isPageOpened() {

    }
}
