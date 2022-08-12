package ru.yandex.uitesting;

import org.junit.Assert;
import org.junit.Test;
import ru.yandex.uitesting.PageObject.*;


public class ScooterOrderTest extends BaseTest {

    String userFirstName = "Евгений";
    String userLastName = "Метила";
    String userAddress = "ул. Ленина";
    String userPhoneNumber = "89101234567";
    String userDeliveryDay = "01.01.2023";
    String placedOrderMessage = "Заказ оформлен";



    @Test
    public void testOrderScooterByTopButton() {

        MainPage mainPage = new MainPage(driver);
        FirstOrderPage firstOrderPage = mainPage.clickTopOrderButton();
        SecondOrderPage secondOrderPage = firstOrderPage.feelFirstOrderPage(userFirstName, userLastName,
                userAddress, userPhoneNumber);
        OrderConfirmationPage orderConfirmationPage = secondOrderPage.feelSecondOrderPage(userDeliveryDay);
        PlacedOrderPage placedOrderPage = orderConfirmationPage.clickConfirmationButton();
        Assert.assertTrue(placedOrderPage.shouldBePlacedOrderText().contains(placedOrderMessage));

    }

    @Test
    public void testOrderScooterByBottomButton(){

        MainPage mainPage = new MainPage(driver);
        FirstOrderPage firstOrderPage = mainPage.clickBottomOrderButton();
        SecondOrderPage secondOrderPage = firstOrderPage.feelFirstOrderPage(userFirstName, userLastName,
                userAddress, userPhoneNumber);
        OrderConfirmationPage orderConfirmationPage = secondOrderPage.feelSecondOrderPage(userDeliveryDay);
        PlacedOrderPage placedOrderPage = orderConfirmationPage.clickConfirmationButton();
        Assert.assertTrue(placedOrderPage.shouldBePlacedOrderText().contains(placedOrderMessage));

    }
}
