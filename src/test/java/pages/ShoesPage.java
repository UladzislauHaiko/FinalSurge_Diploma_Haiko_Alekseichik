package pages;

import decorators.TypeAheadDropdown;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ShoesPage extends BasePage {
    public final By shoeName = By.id("ShoeName");
    public final By shoeBrand = By.id("s2id_ShoeBrand");
    public final By addShoeButton = By.id("saveButton");

    public ShoesPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void setShoeName(String name) {
        driver.findElement(shoeName).sendKeys(name);
    }
    @Step
    public void setShoeBrand(String brand) {
        new TypeAheadDropdown(driver, shoeBrand).selectByVisibleText(brand);
    }
    @Step
    public void clickAddShoeButton() {
        driver.findElement(addShoeButton).click();
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(addShoeButton));
    }
}
