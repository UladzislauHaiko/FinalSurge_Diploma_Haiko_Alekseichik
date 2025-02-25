package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalendarPage extends BasePage {

    protected final By calendarMonth = By.id("dpMonth");
    protected final String plusIcon = "//div[text()='%s']/../following-sibling::td//i";
    protected final String activityCard = "//td[@data-day='%s']//a[@class='dropdown-toggle detailslink']";
    protected final String dayBox = "//div[text()='%s']";
    protected final String uploadData = "//a[@data-day='%s'][@data-reveal-id='WorkoutUpload']";
    protected final By iframe = By.cssSelector("iframe[id='WorkoutUploadiFrame']");
    protected final By inputSelectFile = By.name("FileUpload1");
    protected final By uploadFileBtn = By.id("saveButton");
    protected final By workoutDetailsSection = By.cssSelector("div[id=PublicBox]");

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening dropdown with different options for a given day")
    public void clickPlusIconForDay(String day) {
        driver.findElement(By.xpath(String.format(plusIcon, day))).click();
    }

    @Step("Clicking Upload Data")
    public void selectUploadDataOptionForDay(String day) {
        Actions action = new Actions(driver);
        WebElement box = driver.findElement(By.xpath(String.format(dayBox, day)));
        action.moveToElement(box).build().perform();
        clickPlusIconForDay(day);
        driver.findElement(By.xpath(String.format(uploadData, day))).click();
    }

    public boolean isActivityCardDisplayedForDay(String day) {
        try {
            driver.findElement(By.xpath(String.format(activityCard, day))).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
        return true;
    }

    @Step
    public void uploadFile(String fileName) {
        switchToFrame(iframe);
        selectFile(fileName);
        clickToUploadFile();
        switchToDefaultContent();
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
