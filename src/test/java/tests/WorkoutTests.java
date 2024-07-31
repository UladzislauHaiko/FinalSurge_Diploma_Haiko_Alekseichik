package tests;

import com.github.javafaker.Faker;
import models.Runs;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkoutTests extends BaseTestWithLogin {
    Faker faker = new Faker();
    Runs run = Runs.builder()
            .date("07/23/2024")
            .time("08:15 AM")
            .name("nice run in the morning")
            .description("test description 123")
            .showPlannedDistance(true)
            .plannedDistance("10")
            .plannedDuration("01:10:00")
            .distance("7")
            .duration("00:44:20")
            .howIFelt("Good")
            .perceivedEffort("9 (Very Hard)")
            .minimumHeartRate("80")
            .averageHeartRate("135")
            .maximumHeartRate("190")
            .shoe("Dean Thomas")
            .build();

    @Test(groups = "positive")
    public void addNewRun() {
        dashboardPage.isPageOpened();
        dashboardPage.navigateToAddWorkout();
        addWorkoutPage.isPageOpened();
        addWorkoutPage.openActivityTypeByName("Run");
        addWorkoutPage.createNewRun(run);
        addWorkoutPage.clickAddWorkoutButton();
        Runs actualRun = addWorkoutPage.getRunInfo();
        Assert.assertEquals(actualRun, run);
    }
}