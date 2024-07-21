package pages;

import decorators.TypeAheadDropdown;
import io.qameta.allure.Step;
import models.Shoe;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShoesPage extends BasePage {
    public final By shoeName = By.id("ShoeName");
    public final By shoeBrand = By.id("s2id_ShoeBrand");
    public final By shoeModel = By.id("ShoeModel");
    public final By shoeCost = By.id("ShoeCost");
    public final By datePurchased = By.id("ShoeDate");
    public final By shoeSize = By.id("ShoeSize");
    public final By startingDistance = By.id("StartDist");
    public final By alertDistance = By.id("DistAlert");
    public final By notes = By.id("ShoeNotes");
    public final By addShoeButton = By.id("saveButton");
    public final String editShoeButton = "//a[text()='%s']/ancestor::td/following-sibling::td//a";
    public final By deleteShoeButton = By.id("del-shoe2");
    public final By deleteConfirmButton = By.cssSelector("a[class='btn btn-primary']");
    public final By shoeLink = By.xpath("//table//strong/a");

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

    @Step
    public void createNewShoe(Shoe shoe) {
        logger.info("Creating new shoe of brand {}", shoe.getShoeBrand());
        if (shoe.getShoeName() != null) {
            driver.findElement(shoeName).sendKeys(shoe.getShoeName());
        }
        if (shoe.getShoeBrand() != null) {
            new TypeAheadDropdown(driver, shoeBrand).selectByVisibleText(shoe.getShoeBrand().getName());
        }
        if (shoe.getShoeModel() != null) {
            driver.findElement(shoeModel).sendKeys(shoe.getShoeModel());
        }
        if (shoe.getShoeCost() != null) {
            driver.findElement(shoeCost).sendKeys(shoe.getShoeCost());
        }
        if (shoe.getDatePurchased() != null) {
            driver.findElement(datePurchased).sendKeys(shoe.getDatePurchased());
        }
        if (shoe.getShoeSize() != null) {
            Select select = new Select(driver.findElement(shoeSize));
            select.selectByVisibleText(shoe.getShoeSize());
        }
        if (shoe.getStartingDistance() != null) {
            Actions action = new Actions(driver);
            WebElement distanceInput = driver.findElement(startingDistance);
            action.click(distanceInput)
                    .keyDown(Keys.CONTROL)
                    .sendKeys("a")
                    .keyUp(Keys.CONTROL)
                    .keyDown(Keys.CONTROL)
                    .sendKeys("x")
                    .keyUp(Keys.CONTROL)
                    .build().perform();
            distanceInput.sendKeys(shoe.getStartingDistance());
        }
        if (shoe.getAlertDistance() != null) {
            driver.findElement(alertDistance).sendKeys(shoe.getAlertDistance());
        }
        if (shoe.getNotes() != null) {
            driver.findElement(notes).sendKeys(shoe.getNotes());
        }
        clickAddShoeButton();
    }

    public Shoe getShoeInfo(String name) {
        Shoe resultShoe = Shoe.builder()
                .shoeName(this.getShoeName(name).getText())
                .build();
        return resultShoe;
    }

    private WebElement getShoeName(String value) {
        return this.getAllShoeNames().stream().filter(opt -> opt.getText().equals(value)).findFirst().orElse(null);
    }

    private List<WebElement> getAllShoeNames() {
        return driver.findElements(shoeLink);
    }

    public void deleteShoeByName(String name) {
        driver.findElement(By.xpath(String.format(editShoeButton, name))).click();
        driver.findElement(deleteShoeButton).click();
        driver.findElement(deleteConfirmButton).click();
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(addShoeButton));
    }
}
