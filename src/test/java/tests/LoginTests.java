package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;


public class LoginTests extends BaseTestWithLogin {

    @Test
    public void positiveLoginTest() {
        loginPage.openMainURL();
        loginPage.isPageOpened();
        loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
//        Assert.assertTrue(dashboardPage.isDashboardLinkDisplayed());
    }
}