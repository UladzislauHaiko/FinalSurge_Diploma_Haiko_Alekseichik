package tests;

import org.testng.annotations.Test;

public class ShoesTests extends BaseTest {
    @Test
    public void addNewShoe() {
        dashboardPage.isPageOpened();
        dashboardPage.navigateToShoesPage();
        shoesPage.isPageOpened();
        shoesPage.setShoeName("My krosovok");
        shoesPage.setShoeBrand("Mizuno");
        shoesPage.clickAddShoeButton();
    }

}
