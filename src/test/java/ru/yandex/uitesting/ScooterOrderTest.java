package ru.yandex.uitesting;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;     //Закомментировать для проверки на Firefox
//import org.openqa.selenium.firefox.FirefoxDriver; //Раскомментировать для проверки на Firefox
import ru.yandex.uitesting.PageObject.*;


public class ScooterOrderTest extends BaseTest {

    private WebDriver driver;

    String mainPageURL = "https://qa-scooter.praktikum-services.ru/";
    String userFirstName = "Евгений";
    String userLastName = "Метила";
    String userAddress = "ул. Ленина";
    String userPhoneNumber = "89101234567";
    String userDeliveryDay = "01.01.2023";
    String placedOrderMessage = "Заказ оформлен";


    public ScooterOrderTest() {
    }


    @Test
    public void testOrderScooterByTopButton() {

//        driver = new FirefoxDriver();     //Раскомментировать для проверки на Firefox
        driver = new ChromeDriver();        //Закомментировать для проверки на Firefox
        driver.get(mainPageURL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        FirstOrderPage firstOrderPage = mainPage.clickTopOrderButton();
        SecondOrderPage secondOrderPage = firstOrderPage.feelFirstOrderPage(userFirstName, userLastName,
                userAddress, userPhoneNumber);
        OrderConfirmationPage orderConfirmationPage = secondOrderPage.feelSecondOrderPage(userDeliveryDay);
        PlacedOrderPage placedOrderPage = orderConfirmationPage.clickConfirmationButton();
        Assert.assertTrue(placedOrderPage.shouldBePlacedOrderText().contains(placedOrderMessage));
        driver.quit();

    }

    @Test
    public void testOrderScooterByBottomButton(){

//        driver = new FirefoxDriver();     //Раскомментировать для проверки на Firefox
        driver = new ChromeDriver();        //Закомментировать для проверки на Firefox
        driver.get(mainPageURL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        FirstOrderPage firstOrderPage = mainPage.clickBottomOrderButton();
        SecondOrderPage secondOrderPage = firstOrderPage.feelFirstOrderPage(userFirstName, userLastName,
                userAddress, userPhoneNumber);
        OrderConfirmationPage orderConfirmationPage = secondOrderPage.feelSecondOrderPage(userDeliveryDay);
        PlacedOrderPage placedOrderPage = orderConfirmationPage.clickConfirmationButton();
        Assert.assertTrue(placedOrderPage.shouldBePlacedOrderText().contains(placedOrderMessage));
        driver.quit();

    }
}
