package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AddWorkoutPage extends BasePage {
    public final By customizeLink = By.xpath("//a[text()='Customize this page']");
    public final String activityType = "//a[contains(text(), '%s')]/i";
    public final By date = By.id("WorkoutDate");
    public final By time = By.id("WorkoutTime");
    public final By workoutName = By.id("Name");
    public final By description = By.id("Desc");
    public final By showPlannedCheckbox = By.id("PlannedWorkout");
    public final By plannedDistance = By.id("PDistance");
    public final By plannedDuration = By.id("PDuration");
    public final By distance = By.id("Distance");
    public final By duration = By.id("Duration");
    public final String howIFeltRadio = "//*[text()='%s']/preceding-sibling::input";
    public final By perceivedEffort = By.id("PerEffort");
    public final By minimumHeartRate = By.id("MinHR");
    public final By averageHeartRate = By.id("AvgHR");
    public final By maximumHeartRate = By.id("MaxHR");
    public final By equipmentOption = By.id("EquipmentListBox");
    public final By selectShoeDropdown = By.id("EquipmentList");
    public final By addWorkoutButton = By.id("saveButton");
    public final By createdWorkoutName = By.cssSelector("div[style='clear: both; padding-top: 10px;']");

    public AddWorkoutPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void openActivityTypeByName(String name) {
        driver.findElement(By.xpath(String.format(activityType, name))).click();
    }

    @Step
    public void setDate(String activityDate) {
        Actions action = new Actions(driver);
        WebElement dateInput = driver.findElement(date);
        wait.until(ExpectedConditions.elementToBeClickable(date));
        action.click(dateInput)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL)
                .sendKeys("x")
                .keyUp(Keys.CONTROL)
                .build().perform();
        dateInput.sendKeys(activityDate);
    }

    @Step
    public void setTime(String activityTime) {
        driver.findElement(time).sendKeys(activityTime);
    }

    @Step
    public void setWorkoutName(String name) {
        driver.findElement(workoutName).sendKeys(name);
    }

    @Step
    public void setWorkoutDescription(String desc) {
        driver.findElement(description).sendKeys(desc);
    }

    @Step
    public void clickShowPlannedDistance() {
        driver.findElement(showPlannedCheckbox).click();
    }

    @Step
    public void setPlannedDistance(String planDistance) {
        driver.findElement(plannedDistance).sendKeys(planDistance);
    }

    @Step
    public void setPlannedDuration(String planDuration) {
        driver.findElement(plannedDuration).sendKeys(planDuration);
    }

    @Step
    public void setDistance(String actualDistance) {
        driver.findElement(distance).sendKeys(actualDistance);
    }

    @Step
    public void setDuration(String actualDuration) {
        driver.findElement(duration).sendKeys(actualDuration);
    }

    @Step
    public void selectHowIFeltRadioButton(String radio) {
        driver.findElement(By.xpath(String.format(howIFeltRadio, radio))).click();
    }

    @Step
    public void setPerceivedEffort(String effort) {
        Select perceivedEffortDropdown = new Select(driver.findElement(perceivedEffort));
        perceivedEffortDropdown.selectByVisibleText(effort);
    }

    @Step
    public void setMinimumHeartRate(String minHR) {
        driver.findElement(minimumHeartRate).sendKeys(minHR);
    }

    @Step
    public void setAverageHeartRate(String avgHR) {
        driver.findElement(averageHeartRate).sendKeys(avgHR);
    }

    @Step
    public void setMaximumHeartRate(String maxHR) {
        driver.findElement(maximumHeartRate).sendKeys(maxHR);
    }

    @Step
    public void expandEquipmentOption() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
        driver.findElement(equipmentOption).click();
    }

    @Step
    public void selectShoe(String shoe) {
        Select shoeDropdown = new Select(driver.findElement(selectShoeDropdown));
        shoeDropdown.selectByVisibleText(shoe);
    }

    @Step
    public void clickAddWorkoutButton() {
        driver.findElement(addWorkoutButton).click();
    }

    @Step
    public String getWorkoutName() {
        return driver.findElement(createdWorkoutName).getText();
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(customizeLink));
    }
}
