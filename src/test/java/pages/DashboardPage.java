package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.PropertyReader;

public class DashboardPage extends BasePage {

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(dashboardButton));
    }

    public final By workoutHeader = By.xpath("//a[text()='Workouts']");
    public final By addWorkout = By.xpath("//a[text()='Add Workout']");
    public final By customizeActivityTypes = By.xpath("//a[text()='Customize Activity Types']");
    public final By paceZones = By.xpath("//a[text()='HR/Power/Pace Zones']");
    public final By gearRoutesHeader = By.xpath("//a[text()='Gear & Routes']");
    public final By shoes = By.xpath("//a[text()='Shoes']");
    public final By dailyVitalsHeader = By.xpath("//a[text()='Daily Vitals']");
    public final By viewAddVitals = By.xpath("//a[text()='View & Add Vitals']");
    public final By importData = By.xpath("//a[text()='Import Data']");
    public final By dashboardButton = By.xpath("//i[contains(@class, '-home')]");
    public final By calendar = By.xpath("//i[contains(@class, '-calendar')]");
    public final By workoutCalculators = By.xpath("//i[contains(@class, '-watch')]");
    public final By otherCalculators = By.xpath("//i[contains(@class, '-calculator')]");
    public final By logoutLink = By.xpath("//a[text()='Logout']");
    public static final By logoutMessage = By.cssSelector("[class^='alert']");
    public final By printWorkoutsLink = By.xpath("//nav//a[@data-reveal-id='PrintWorkouts']");
    public final By reportsStatisticsLink = By.xpath("//i[contains(@class, '-graph')]");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void navigateToShoesPage() {
        moveToElement(gearRoutesHeader);
        driver.findElement(shoes).click();
    }

    @Step
    public void navigateToImportData() {
        moveToElement(workoutHeader);
        driver.findElement(importData).click();
    }

    @Step
    public void openPage() {
        driver.get("https://log.finalsurge.com/default.cshtml");
    }

    @Step
    public void navigateToAddWorkout() {
        moveToElement(workoutHeader);
        driver.findElement(addWorkout).click();
    }

    @Step
    public void openCustomizeActivityTypes() {
        moveToElement(workoutHeader);
        driver.findElement(customizeActivityTypes).click();
    }

    @Step
    public void openAddPaceZones() {
        moveToElement(workoutHeader);
        driver.findElement(paceZones).click();
    }

    @Step
    public void navigateToViewAddVitals() {
        moveToElement(dailyVitalsHeader);
        driver.findElement(viewAddVitals).click();
    }

    @Step
    public boolean dashboardButtonIsDisplayed() {
        return driver.findElement(dashboardButton).isDisplayed();
    }

    @Step("Clicking 'Calendar'")
    public void clickCalendar() {
        driver.findElement(calendar).click();
    }

    @Step("Clicking 'Workout Calculators'")
    public void clickWorkoutCalculators() {
        driver.findElement(workoutCalculators).click();
    }

    @Step("Clicking 'Other Calculators'")
    public void clickOtherCalculators() {
        driver.findElement(otherCalculators).click();
    }

    @Step("Clicking 'Print Workouts' link")
    public void clickPrintWorkouts() {
        driver.findElement(printWorkoutsLink).click();
    }

    @Step("Clicking 'Reports & Statistics' link")
    public void clickReportsAndStatistics() {
        driver.findElement(reportsStatisticsLink).click();
    }

    @Step("Clicking 'Logout' link")
    public void clickLogoutButton() {
        driver.findElement(logoutLink).click();
    }

    @Step("Getting message about successfully logged out of the system")
    public String getLogoutMessage() {
        return driver.findElement(logoutMessage).getText();
    }

}


