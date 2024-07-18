package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(DASHBOARD_BUTTON));
    }

    public final By WORKOUTS_HEADER = By.xpath("//a[text()='Workouts']");
    public final By ADD_WORKOUT = By.xpath("//a[text()='Add Workout']");
    public final By CUSTOMIZE_ACTIVITY_TYPES = By.xpath("//a[text()='Customize Activity Types']");
    public final By PACE_ZONES = By.xpath("//a[text()='HR/Power/Pace Zones']");
    public final By GEAR_ROUTES_HEADER = By.xpath("//a[text()='Gear & Routes']");
    public final By SHOES = By.xpath("//a[text()='Shoes']");
    public final By DAILY_VITALS_HEADER = By.xpath("//a[text()='Daily Vitals']");
    public final By VIEW_ADD_VITALS = By.xpath("//a[text()='View & Add Vitals']");
    public final By DASHBOARD_BUTTON = By.xpath("//*[@class='icsw16-home']");
    public final By CALENDAR = By.className("icsw16-day-calendar");
    public final By WORKOUT_CALCULATORS = By.xpath("//i[@class='icsw16-stop-watch']");
    public final By OTHER_CALCULATORS = By.xpath("//i[@class='icsw16-calculator']");
    public final By LOGOUT_LINK = By.xpath("//a[text()='Logout']");
    public static final By LOGOUT_MESSAGE = By.cssSelector("[class^='alert']");
    public final By PRINT_WORKOUTS_LINK = By.xpath("//nav//li//i[@class='icsw16-printer']/..");
    public final By REPORTS_STATISTICS_LINK = By.xpath("//a/i[@class='icsw16-graph']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void navigateToShoesPage() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(GEAR_ROUTES_HEADER)).build().perform();
        driver.findElement(SHOES).click();
    }

    @Step
    public void navigateToAddWorkout() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(WORKOUTS_HEADER)).build().perform();
        driver.findElement(ADD_WORKOUT).click();
    }

    @Step
    public void openCustomizeActivityTypes() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(WORKOUTS_HEADER)).build().perform();
        driver.findElement(CUSTOMIZE_ACTIVITY_TYPES).click();
    }

    @Step
    public void openAddPaceZones() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(WORKOUTS_HEADER)).build().perform();
        driver.findElement(PACE_ZONES).click();
    }

    @Step
    public void navigateToViewAddVitals() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(DAILY_VITALS_HEADER)).build().perform();
        driver.findElement(VIEW_ADD_VITALS).click();
    }

    @Step
    public boolean dashboardButtonIsDisplayed() {
        return driver.findElement(DASHBOARD_BUTTON).isDisplayed();
    }

    @Step("Clicking 'Calendar'")
    public void clickCalendar() {
        driver.findElement(CALENDAR).click();
    }

    @Step("Clicking 'Workout Calculators'")
    public void clickWorkoutCalculators() {
        driver.findElement(WORKOUT_CALCULATORS).click();
    }

    @Step("Clicking 'Other Calculators'")
    public void clickOtherCalculators() {
        driver.findElement(OTHER_CALCULATORS).click();
    }

    @Step("Clicking 'Print Workouts' link")
    public void clickPrintWorkouts() {
        driver.findElement(PRINT_WORKOUTS_LINK).click();
    }

    @Step("Clicking 'Reports & Statistics' link")
    public void clickReportsAndStatistics() {
        driver.findElement(REPORTS_STATISTICS_LINK).click();
    }

    @Step("Clicking 'Logout' link")
    public void clickLogoutButton() {
        driver.findElement(LOGOUT_LINK).click();
    }

    @Step("Getting message about successfully logged out of the system")
    public static String getLogoutMessage() {
        return driver.findElement(LOGOUT_MESSAGE).getText();
    }

}


