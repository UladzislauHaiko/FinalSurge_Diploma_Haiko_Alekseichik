package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected static WebDriver driver;
    protected WebDriverWait wait;
    protected final Logger logger = LogManager.getLogger(this.getClass().getName());


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void moveToElement(By locator) {
        logger.debug("moving to element");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(locator)).build().perform();
    }
    public void switchToFrame(By locator) {
        logger.debug("switching to iframe");
        driver.switchTo().frame(driver.findElement(locator));
    }
    public void switchToDefaultContent() {
        logger.debug("switching from iframe to default content");
        driver.switchTo().defaultContent();
    }

    public void clearInput(WebElement element) {
        logger.debug("Clearing input");
        Actions action = new Actions(driver);
        action.click(element)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL)
                .sendKeys("x")
                .keyUp(Keys.CONTROL)
                .build().perform();
    }

    public abstract void isPageOpened();
}