package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.PropertyReader;


public class LoginTests extends BaseTestWithOutLogin {

    @Test(groups = "positive")
    @Description("User can be logged in")
    public void positiveLoginTest() {
        loginPage.openMainURL();
        loginPage.isPageOpened();
        loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
        Assert.assertTrue(dashboardPage.dashboardButtonIsDisplayed());
    }

    @Test(groups = "negative", dataProvider = "negativeLoginTestData")
    public void negativeLoginTest(String email, String password, String expectedErrorMessage) {
        loginPage.openMainURL();
        loginPage.isPageOpened();
        loginPage.login(email, password);
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage);
    }

    @DataProvider
    public Object[][] negativeLoginTestData() {
        return new Object[][]{
                {"testuser@test.com", "", "Please enter a password."},
                {"", "Password123", "Please enter your e-mail address."},
                {"standard_user", "qwerty", "Please enter a valid email address."},
        };
    }
}