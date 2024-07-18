package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.DriverFactory;
import utils.InvokedListener;
import utils.PropertyReader;
import utils.TestListener;


@Listeners({TestListener.class, InvokedListener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;


    @BeforeClass(alwaysRun = true)
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browserName, ITestContext testContext) throws Exception {
        driver = DriverFactory.getDriver(browserName);
        testContext.setAttribute("driver", driver);
        this.loginPage = new LoginPage(driver);


        driver.get(PropertyReader.getProperty("base_url"));
        loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }

    @BeforeMethod(alwaysRun = true)
    public void openMainURL() {
        driver.get(PropertyReader.getProperty("base_url"));
    }
}