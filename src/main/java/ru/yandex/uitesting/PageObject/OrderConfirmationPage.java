package ru.yandex.uitesting.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {

    WebDriver driver;

    //Кнопка "Да" для подтверждения заказа
    private final By yesButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public PlacedOrderPage clickConfirmationButton() {

        driver.findElement(yesButton).click();
        return new PlacedOrderPage(driver);

    }
}
