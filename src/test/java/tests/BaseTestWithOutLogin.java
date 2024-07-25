package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.DashboardPage;
import pages.LoginPage;
import utils.DriverFactory;
import utils.InvokedListener;


@Listeners({InvokedListener.class})
public abstract class BaseTestWithOutLogin {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;


    @BeforeClass(alwaysRun = true)
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browserName, ITestContext testContext) throws Exception {
        driver = DriverFactory.getDriver(browserName);
        testContext.setAttribute("driver", driver);
        this.loginPage = new LoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}