package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.PropertyReader;

public class LoginPage extends BasePage {
    protected final By loginEmail = By.id("login_name");
    protected final By loginPassword = By.id("login_password");
    protected final By loginButton = By.xpath("//button[text()='Login']");
    protected final By classicOption = By.xpath("//span[contains(text(), 'Continue with Classic')]");
    protected final By errorMessage = By.cssSelector("label[class=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void openMainURL() {
        logger.debug("Opening Main URL");
        driver.get(PropertyReader.getProperty("base_url"));
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
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
        driver.findElement(loginButton).click();
    }

    @Step
    public void selectClassicOption() {
        logger.debug("Selecting Classic option");
        driver.findElement(classicOption).click();
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMessage).getText();
    }

    @Step
    public void login(String email, String password) {
        logger.info("Log in with email = {}, password = {}", email, password);
        setEmailValue(email);
        setPasswordValue(password);
        clickSignInButton();
    }
}
