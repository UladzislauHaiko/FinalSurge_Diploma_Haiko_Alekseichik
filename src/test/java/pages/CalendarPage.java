package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalendarPage extends BasePage {

    protected final By calendarMonth = By.id("dpMonth");
    protected final String plusIcon = "//div[text()='%s']/../following-sibling::td//i";
    protected final String dayBox = "//div[text()='%s']";
    protected final String uploadData = "//a[@data-day='%s'][@data-reveal-id='WorkoutUpload']";
    protected final By iframe = By.cssSelector("iframe[id='WorkoutUploadiFrame']");
    protected final By inputSelectFile = By.name("FileUpload1");
    protected final By uploadFileBtn = By.id("saveButton");
    protected final By workoutDetailsSection = By.cssSelector("div[id=PublicBox]");

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void clickPlusIconForDay(String day) {
        driver.findElement(By.xpath(String.format(plusIcon, day))).click();
    }

    @Step
    public void selectUploadDataOptionForDay(String day) {
        Actions action = new Actions(driver);
        WebElement box = driver.findElement(By.xpath(String.format(dayBox, day)));
        action.moveToElement(box).build().perform();
        clickPlusIconForDay(day);
        driver.findElement(By.xpath(String.format(uploadData, day))).click();
    }

    private void switchToFrame() {
        driver.switchTo().frame(driver.findElement(iframe));
    }

    public void uploadFile(String fileName) {
        switchToFrame();
        selectFile(fileName);
        clickToUploadFile();
    }

    public boolean workoutDetailsSectionIsDisplayed() {
        return driver.findElement(workoutDetailsSection).isDisplayed();
    }

    private void selectFile(String fileName) {
        driver.findElement(inputSelectFile).sendKeys(fileName);
    }

    public void clickToUploadFile() {
        driver.findElement(uploadFileBtn).click();
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(calendarMonth));
    }
}
