package tests;

import com.github.javafaker.Faker;
import enums.ShoeBrand;
import models.Shoe;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoesTests extends BaseTest {
    Faker faker = new Faker();
    Shoe shoe = Shoe.builder()
            .shoeName(faker.harryPotter().character())
            .shoeBrand(ShoeBrand.NIKE)
            .shoeModel("Yeezy 350")
            .shoeCost("115.00")
            .datePurchased("7/25/2024")
            .shoeSize("8.5")
            .startingDistance("15")
            .alertDistance("77")
            .notes("My notes")
            .build();

    @Test
    public void addNewShoe() {
        dashboardPage.isPageOpened();
        dashboardPage.navigateToShoesPage();
        shoesPage.isPageOpened();
        shoesPage.createNewShoe(shoe);
        Shoe actualShoe = shoesPage.getShoeInfo(shoe.getShoeName());
        Assert.assertEquals(actualShoe, shoe);
    }

    @Test
    public void deleteShoe() {
        dashboardPage.isPageOpened();
        dashboardPage.navigateToShoesPage();
        shoesPage.isPageOpened();
        shoesPage.deleteShoeByName(shoe.getShoeName());
    }
}
