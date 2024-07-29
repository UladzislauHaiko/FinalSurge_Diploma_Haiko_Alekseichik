package tests;

import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.InvokedListener;
import utils.PropertyReader;


@Listeners({InvokedListener.class})
public abstract class BaseTestWithLogin extends BaseTest {
    @BeforeClass(alwaysRun = true)
    @Parameters({"browserName"})
    @Override
    public void setUp(@Optional("chrome") String browserName, ITestContext testContext) throws Exception {
        super.setUp(browserName, testContext);
        driver.get(PropertyReader.getProperty("base_url"));
        loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
    }

    @AfterClass(alwaysRun = true)
    @Override
    public void tearDown() {
        super.tearDown();
    }
}