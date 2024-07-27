package pages;

import io.qameta.allure.Step;
import models.Runs;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public final By createdWorkoutName = By.xpath("//span[@class='activityTypeName']/../following-sibling::div");
    public final By createdDescription = By.xpath("//p[@class=' testme dont-break-out']");
    public final By createdHowIFelt = By.xpath("//small[text()='How I Felt:']/following-sibling::span");
    public final By createdPerceivedEffort = By.xpath("//small[text()='Perceived Effort']/..");
    public final By createdHR = By.cssSelector("p.formSep");

    public AddWorkoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Expanding activity fields")
    public void openActivityTypeByName(String name) {
        driver.findElement(By.xpath(String.format(activityType, name))).click();
    }

    @Step
    public void expandEquipmentOption() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
        driver.findElement(equipmentOption).click();
    }

    @Step
    public void clickAddWorkoutButton() {
        driver.findElement(addWorkoutButton).click();
    }

    public String getWorkoutName() {
        return driver.findElement(createdWorkoutName).getText();
    }

    public String getDescription() {
        String description = driver.findElement(createdDescription).getText();
        Pattern pattern = Pattern.compile("Workout Description:\\s*(.*?)\\s*Planned:");
        Matcher matcher = pattern.matcher(description);
        matcher.find();
        return matcher.group(1);
    }

    public String getHowIFelt() {
        return driver.findElement(createdHowIFelt).getText();
    }

    public String getPerceivedEffort() {
        String perceivedEffort = driver.findElement(createdPerceivedEffort).getText();
        Pattern pattern = Pattern.compile("Perceived Effort (\\d+ \\(.*?\\))");
        Matcher matcher = pattern.matcher(perceivedEffort);
        matcher.find();
        return matcher.group(1);
    }

    public String getMinimumHR() {
        String resultBPM = driver.findElement(createdHR).getText();
        Pattern pattern = Pattern.compile("Min HR: (\\d+) bpm");
        Matcher matcher = pattern.matcher(resultBPM);
        matcher.find();
        return matcher.group(1);
    }

    public String getAverageHR() {
        String resultBPM = driver.findElement(createdHR).getText();
        Pattern pattern = Pattern.compile("Avg HR: (\\d+) bpm");
        Matcher matcher = pattern.matcher(resultBPM);
        matcher.find();
        return matcher.group(1);
    }

    public String getMaximumHR() {
        String resultBPM = driver.findElement(createdHR).getText();
        Pattern pattern = Pattern.compile("Max HR: (\\d+) bpm");
        Matcher matcher = pattern.matcher(resultBPM);
        matcher.find();
        return matcher.group(1);
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(customizeLink));
    }

    @Step("Creating new Run '{run.name}' full scenario")
    public void createNewRun(Runs run) {
        logger.info("Adding new run on date {} and time {}", run.getDate(), run.getTime());
        if (run.getDate() != null) {
            WebElement dateInput = driver.findElement(date);
            wait.until(ExpectedConditions.elementToBeClickable(date));
            clearInput(dateInput);
            dateInput.sendKeys(run.getDate());
        }
        if (run.getTime() != null) {
            driver.findElement(time).sendKeys(run.getTime());
        }
        if (run.getName() != null) {
            driver.findElement(workoutName).sendKeys(run.getName());
        }
        if (run.getDescription() != null) {
            driver.findElement(description).sendKeys(run.getDescription());
        }
        if (run.isShowPlannedDistance()) {
            driver.findElement(showPlannedCheckbox).click();
        }
        if (run.getPlannedDistance() != null) {
            driver.findElement(plannedDistance).sendKeys(run.getPlannedDistance());
        }
        if (run.getPlannedDuration() != null) {
            driver.findElement(plannedDuration).sendKeys(run.getPlannedDuration());
        }
        if (run.getDistance() != null) {
            driver.findElement(distance).sendKeys(run.getDistance());
        }
        if (run.getDuration() != null) {
            driver.findElement(duration).sendKeys(run.getDuration());
        }
        if (run.getHowIFelt() != null) {
            driver.findElement(By.xpath(String.format(howIFeltRadio, run.getHowIFelt()))).click();
        }
        if (run.getPerceivedEffort() != null) {
            driver.findElement(perceivedEffort).sendKeys(run.getPerceivedEffort());
        }
        if (run.getMinimumHeartRate() != null) {
            driver.findElement(minimumHeartRate).sendKeys(run.getMinimumHeartRate());
        }
        if (run.getAverageHeartRate() != null) {
            driver.findElement(averageHeartRate).sendKeys(run.getAverageHeartRate());
        }
        if (run.getMaximumHeartRate() != null) {
            driver.findElement(maximumHeartRate).sendKeys(run.getMaximumHeartRate());
        }
        if (run.getShoe() != null) {
            expandEquipmentOption();
            Select shoeDropdown = new Select(driver.findElement(selectShoeDropdown));
            shoeDropdown.selectByVisibleText(run.getShoe());
        }
    }

    public Runs getRunInfo() {
        Runs resultRun = Runs.builder()
                .name(this.getWorkoutName())
                .description(this.getDescription())
                .howIFelt(this.getHowIFelt())
                .perceivedEffort(this.getPerceivedEffort())
                .minimumHeartRate(getMinimumHR())
                .averageHeartRate(getAverageHR())
                .maximumHeartRate(getMaximumHR())
                .build();
        return resultRun;
    }
}