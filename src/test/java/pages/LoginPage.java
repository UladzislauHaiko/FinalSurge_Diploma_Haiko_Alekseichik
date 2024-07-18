package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.PropertyReader;

public class LoginPage extends BasePage {
    public final By logInLink = By.xpath("//span[contains(text(), 'Log In')]");
    public final By loginEmail = By.cssSelector("input[name=email]");
    public final By loginPassword = By.cssSelector("input[name=password]");
    public final By signInButton = By.xpath("//span[contains(text(), 'Sign In')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void openMainURL() {
        driver.get(PropertyReader.getProperty("base_url"));
    }
    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(logInLink));
    }

    @Step
    public void clickLogInLink() {
        driver.findElement(logInLink).click();
    }

    @Step
    public void setEmailValue(String email) {
        driver.findElement(loginEmail).sendKeys(email);
    }

    @Step
    public void setPasswordValue(String password) {
        driver.findElement(loginPassword).sendKeys(password);
    }

    @Step
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    @Step
    public void login(String email, String password) {
        logger.info("Log in with email = {}, password = {}", email, password);
        clickLogInLink();
        setEmailValue(email);
        setPasswordValue(password);
        clickSignInButton();
    }
}
