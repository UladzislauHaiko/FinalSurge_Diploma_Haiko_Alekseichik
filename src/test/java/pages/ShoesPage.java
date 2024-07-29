package pages;

import decorators.TypeAheadDropdown;
import io.qameta.allure.Step;
import models.Shoe;
import org.openqa.selenium.*;
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
    public final String createdShoePurchased = "//a[text()='%s']/../following-sibling::span/strong[text()='Purchased: ']/..";
    public final String createdShoeCost = "//a[text()='%s']/../following-sibling::span/strong[text()='Cost: ']/..";
    public final String createdShoeSize = "//a[text()='%s']/../following-sibling::span/strong[text()='Size: ']/..";

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

    @Step("Creating new Shoe '{shoe.shoeName}' full scenario")
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
            WebElement distanceInput = driver.findElement(startingDistance);
            clearInput(distanceInput);
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
        Shoe.ShoeBuilder result = Shoe.builder();
        result.shoeName(this.getShoeName(name).getText());
        try {
            result.datePurchased(this.getShoeDate(name));
        } catch (NoSuchElementException exception) {
        }
        try {
            result.shoeCost(this.getShoeCost(name));
        } catch (NoSuchElementException exception) {
        }
        try {
            result.shoeSize(this.getShoeSize(name));
        } catch (NoSuchElementException exception) {
        }
        return result.build();
    }

    private WebElement getShoeName(String value) {
        return this.getAllShoeNames().stream().filter(opt -> opt.getText().equals(value)).findFirst().orElse(null);
    }
    public boolean shoeFound(String value) {
        return this.getAllShoeNames().stream().anyMatch(opt -> opt.getText().equals(value));
    }

    private String getShoeDate(String name) {
        return driver.findElement(By.xpath(String.format(createdShoePurchased, name))).getText().substring(11);
    }

    private String getShoeCost(String name) {
        return driver.findElement(By.xpath(String.format(createdShoeCost, name))).getText().substring(7);
    }

    private String getShoeSize(String name) {
        return driver.findElement(By.xpath(String.format(createdShoeSize, name))).getText().substring(6);
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
