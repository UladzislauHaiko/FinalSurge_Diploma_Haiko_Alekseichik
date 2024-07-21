package tests.gearAndRoutes.shoes;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DashboardPage;
import pages.base.BaseTest;
import pages.gearAndRoutes.shoes.ShoesPage;
import utils.PropertyReader;

public class ShoesTests extends BaseTest {

    @Test
    public void addNewShoe() {
        DashboardPage dashboardPage = loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
        ShoesPage shoesPage = dashboardPage.navigateToShoesPage();
        shoesPage.setShoeName("My krosovok");
        shoesPage.setShoeBrand("Mizuno");
        shoesPage.clickAddShoeButton();
    }
}
