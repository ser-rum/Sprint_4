package ru.yandex.uitesting.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SecondOrderPage {

    WebDriver driver;

    //Поле ввода даты доставки
    private final By deliveryDay = By.cssSelector("[placeholder = '* Когда привезти самокат']");
    //Поле раскрытия выпадающего меню для выбора срока аренды
    private final By rentalPeriodMenuOpener = By.className("Dropdown-placeholder");
    //Поле выбора суточного срока аренды
    private final By firstRentalPeriod = By.className("Dropdown-option");
    //Чекбокс выбора чёрного цвета самоката
    private final By scooterColor = By.id("black");
    //Кнопка "Заказать"
    private final By orderButton = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");


    public SecondOrderPage(WebDriver driver){
        this.driver = driver;
    }


    public OrderConfirmationPage feelSecondOrderPage(String userDeliveryDay) {

        driver.findElement(deliveryDay).sendKeys(userDeliveryDay);
        driver.findElement(deliveryDay).sendKeys(Keys.ENTER);
        driver.findElement(rentalPeriodMenuOpener).click();
        driver.findElement(firstRentalPeriod).click();
        driver.findElement(scooterColor).click();
        driver.findElement(orderButton).click();
        return new OrderConfirmationPage(driver);

    }
}
