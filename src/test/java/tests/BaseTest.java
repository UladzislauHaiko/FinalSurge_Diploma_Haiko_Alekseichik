package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.DriverFactory;
import utils.InvokedListener;

import java.time.Duration;


@Listeners({InvokedListener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ShoesPage shoesPage;
    protected DashboardPage dashboardPage;
    protected AddWorkoutPage addWorkoutPage;
    protected ImportDataPage importDataPage;
    protected PrintWorkoutsPage printWorkoutsPage;
    protected CalendarPage calendarPage;


    @BeforeClass(alwaysRun = true)
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browserName, ITestContext testContext) throws Exception {
        driver = DriverFactory.getDriver(browserName);
        testContext.setAttribute("driver", driver);
        this.loginPage = new LoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);
        this.shoesPage = new ShoesPage(driver);
        this.addWorkoutPage = new AddWorkoutPage(driver);
        this.importDataPage = new ImportDataPage(driver);
        this.printWorkoutsPage = new PrintWorkoutsPage(driver);
        this.calendarPage = new CalendarPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}