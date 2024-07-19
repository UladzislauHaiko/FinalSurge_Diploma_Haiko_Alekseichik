package decorators;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TypeAheadDropdown extends BaseDecorator {

    private final By expandButton = By.id("s2id_ShoeBrand");
    private final By searchInput = By.cssSelector("input[class=select2-input]");
    private final By options = By.cssSelector("ul.select2-results li");

    public TypeAheadDropdown(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public void selectByVisibleText(String value) {
        expand();
        WebElement targetOption = this.getOptionByText(value);
        try {
            targetOption.click();
        } catch (ElementNotInteractableException exception) {
            setSearchValue(value);
            targetOption.click();
        }
    }

    private void setSearchValue(String value) {
        driver.findElement(searchInput).sendKeys(value);
    }

    private void expand() {
        this.element.click();
    }

    private WebElement getOptionByText(String value) {
        return this.getAllOptions().stream().filter(opt -> opt.getText().toLowerCase().equals(value.toLowerCase())).findFirst().orElse(null);
    }

    private List<WebElement> getAllOptions() {
        return driver.findElements(options);
    }
}
