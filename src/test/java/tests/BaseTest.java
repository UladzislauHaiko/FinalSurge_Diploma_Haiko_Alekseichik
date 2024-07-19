package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ShoesPage;
import utils.DriverFactory;
import utils.InvokedListener;
import utils.PropertyReader;
import utils.TestListener;


@Listeners({TestListener.class, InvokedListener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ShoesPage shoesPage;
    protected DashboardPage dashboardPage;



    @BeforeClass(alwaysRun = true)
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browserName, ITestContext testContext) throws Exception {
        driver = DriverFactory.getDriver(browserName);
        testContext.setAttribute("driver", driver);
        this.loginPage = new LoginPage(driver);
        this.shoesPage = new ShoesPage(driver);
        this.dashboardPage = new DashboardPage(driver);


        driver.get(PropertyReader.getProperty("base_url"));
        loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
        driver.findElement(By.xpath("//span[contains(text(), 'Continue with Classic')]")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}