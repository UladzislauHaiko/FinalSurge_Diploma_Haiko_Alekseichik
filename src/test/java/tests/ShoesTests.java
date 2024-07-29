package tests;

import com.github.javafaker.Faker;
import enums.ShoeBrand;
import models.Shoe;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoesTests extends BaseTestWithLogin {
    Faker faker = new Faker();
    Shoe shoe = Shoe.builder()
            .shoeName(faker.number().randomDigit() + faker.app().name() + faker.number().randomDigit())
            .shoeBrand(ShoeBrand.NIKE)
            .shoeModel("Yeezy 350")
            .shoeCost("115.00")
            .datePurchased("7/25/2024")
            .shoeSize("8.5")
            .startingDistance("15")
            .alertDistance("77")
            .notes("My notes")
            .build();

    @Test(groups = "positive")
    public void addNewShoe() {
        dashboardPage.isPageOpened();
        dashboardPage.navigateToShoesPage();
        shoesPage.isPageOpened();
        shoesPage.createNewShoe(shoe);
        Shoe actualShoe = shoesPage.getShoeInfo(shoe.getShoeName());
        Assert.assertEquals(actualShoe, shoe);
    }

    @Test(groups = "positive")
    public void deleteShoe() {
        dashboardPage.isPageOpened();
        dashboardPage.navigateToShoesPage();
        shoesPage.isPageOpened();
        shoesPage.deleteShoeByName(shoe.getShoeName());
        Assert.assertFalse(shoesPage.shoeFound(shoe.getShoeName()));
    }
}
