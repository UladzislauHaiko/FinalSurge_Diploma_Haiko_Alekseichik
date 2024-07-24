package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.DriverFactory;
import utils.InvokedListener;
import utils.PropertyReader;


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
        this.shoesPage = new ShoesPage(driver);
        this.dashboardPage = new DashboardPage(driver);
        this.addWorkoutPage = new AddWorkoutPage(driver);
        this.importDataPage = new ImportDataPage(driver);
        this.printWorkoutsPage = new PrintWorkoutsPage(driver);
        this.calendarPage = new CalendarPage(driver);


        driver.get(PropertyReader.getProperty("base_url"));
        loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}