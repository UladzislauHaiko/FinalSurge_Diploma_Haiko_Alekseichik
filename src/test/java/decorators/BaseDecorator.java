package decorators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class BaseDecorator implements WebElement {
    protected WebElement element;
    protected WebDriver driver;
    protected By locator;

    protected final Logger logger = LogManager.getLogger(this.getClass().getName());

    public BaseDecorator(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
        this.element = driver.findElement(locator);
    }


    //1 Cat: overwritten (decorated)
    public void click() {
        try {
            element.click();
        } catch (ElementNotInteractableException exception) {
            scrollIntoView();
            element.click();
        }
    }

    //2 Cat: new methods

    public void scrollIntoView() {
        ((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView(true);", this.element);
    }

    //3 Cat: rest of WebElement methods
    @Override
    public void submit() {
        element.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        element.clear();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return element.getLocation();
    }

    @Override
    public Dimension getSize() {
        return element.getSize();
    }

    @Override
    public Rectangle getRect() {
        return element.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return element.getScreenshotAs(target);
    }
}