package tests.otherCalculators;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.base.BaseTest;
import pages.otherCalculators.OtherCalculatorsPage;
import utils.PropertyReader;

public class OtherCalculatorsTests extends BaseTest {

    public OtherCalculatorsPage otherCalculatorsPage;

    @BeforeMethod(alwaysRun = true)
    public void loginAndMoveToOtherCalc(){
        DashboardPage dashboardPage = loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
        otherCalculatorsPage = dashboardPage.clickOtherCalculators();
    }

    @Test(groups = "negative")
    public void verifyCalculator() {

    }

    @Test(groups = "positive")
    public void verifyCalculatorValidation() {

    }
}
