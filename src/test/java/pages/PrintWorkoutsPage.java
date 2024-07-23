package pages;

import org.openqa.selenium.By;
import pages.base.BasePage;

public class PrintWorkoutsPage extends BasePage {

    private final By iframe = By.cssSelector("iframe[id='PrintWorkoutsiFrame']");
    private final By img = By.cssSelector("img[src*='finalsurge_logo.png']");
    private final By printStartDate = By.cssSelector("input[id='PrintStartDate']");
    private final By printEndDate = By.cssSelector("input[id='PrintEndDate']");
    private final By printWorkoutsBtn = By.xpath("//input[@id='saveButtonPrint']");
    private final By error = By.xpath("//div[@class='alert alert-error']");

    public void print(String startDate, String endDate){
        switchToFrame();
        enterStartDate(startDate);
        enterEndDate(endDate);
        clickPrintWorkouts();
        switchToSecondWindow();
    }

    public String getErrorText(){
        return driver.findElement(error).getText();
    }

    private void switchToSecondWindow(){
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
    }
    private void switchToFrame(){
        driver.switchTo().frame(driver.findElement(iframe));
    }

    private void enterStartDate(String startDate){
        driver.findElement(printStartDate).sendKeys(startDate);
    }

    private void enterEndDate(String endDate){
        driver.findElement(printEndDate).sendKeys(endDate);
    }

    private void clickPrintWorkouts(){
        driver.findElement(printWorkoutsBtn).click();
    }

    public boolean isLogoDisplayed(){
        return driver.findElement(img).isDisplayed();
    }
    @Override
    public boolean isPageOpened() {
        return false;
    }
}
