package ru.yandex.uitesting.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlacedOrderPage {

    WebDriver driver;
    //Текст сообщения об успешном оформлении заказа
    private final By placedOrderText = By.cssSelector(".Order_ModalHeader__3FDaJ");

    public PlacedOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public String shouldBePlacedOrderText(){

        return driver.findElement(placedOrderText).getText();

    }
}
