package tests;

import models.Shoe;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkoutTests extends BaseTest {
    @Test
    public void addNewActivity() {
        dashboardPage.isPageOpened();
        dashboardPage.navigateToAddWorkout();
        addWorkoutPage.isPageOpened();
        addWorkoutPage.openActivityTypeByName("Run");
        addWorkoutPage.setDate("07/23/2024");
        addWorkoutPage.setTime("08:15 AM");
        addWorkoutPage.setWorkoutName("ytrenya probejka");
        addWorkoutPage.setWorkoutDescription("test description");
        addWorkoutPage.clickShowPlannedDistance();
        addWorkoutPage.setPlannedDistance("10");
        addWorkoutPage.setPlannedDuration("01:10:00");
        addWorkoutPage.setDistance("7");
        addWorkoutPage.setDuration("00:44:20");
        addWorkoutPage.selectHowIFeltRadioButton("Good");
        addWorkoutPage.setPerceivedEffort("3 (Light)");
        addWorkoutPage.setMinimumHeartRate("80");
        addWorkoutPage.setAverageHeartRate("135");
        addWorkoutPage.setMaximumHeartRate("190");
        addWorkoutPage.expandEquipmentOption();
        addWorkoutPage.selectShoe("Dean Thomas (17.0 mi)");
        addWorkoutPage.clickAddWorkoutButton();
        Assert.assertEquals(addWorkoutPage.getWorkoutName(), "ytrenya probejka");
    }
}
