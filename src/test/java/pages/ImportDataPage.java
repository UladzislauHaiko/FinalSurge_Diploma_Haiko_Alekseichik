package pages;

import enums.ImportFrom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ImportDataPage extends BasePage {

    private final By dataImportStatus = By.xpath("//h3[@id='thestatus']");
    private final By uploadFileBtn = By.id("saveButton");
    private final By importingFromDropdown = By.id("LogType");
    private final By inputSelectFile = By.name("FileUpload1");

    public ImportDataPage(WebDriver driver) {
        super(driver);
    }

    public void clickToUploadFile() {
        driver.findElement(uploadFileBtn).click();
    }

    public String getDataImportStatusTxt() {
        return driver.findElement(dataImportStatus).getText();
    }

    public void selectImportingFromValue(ImportFrom name) {
        Select select = new Select(driver.findElement(importingFromDropdown));
        select.selectByVisibleText(name.getName());
    }
    public void selectFile(String fileName) {
        driver.findElement(inputSelectFile).sendKeys(fileName);
    }
    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(uploadFileBtn));
    }
}
