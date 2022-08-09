package ru.yandex.uitesting.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstOrderPage {

    WebDriver driver;

    public FirstOrderPage(WebDriver driver) {
        this.driver = driver;
    }


    //Поле ввода "Имя"
    private final By firstName = By.cssSelector("[placeholder = '* Имя']");
    //Поле ввода "Фамилия"
    private final By lastName = By.cssSelector("[placeholder = '* Фамилия']");
    //Поле ввода "Адрес доставки"
    private final By address = By.cssSelector("[placeholder = '* Адрес: куда привезти заказ']");
    //Поле раскрытия выпадающего меню для выбора станции метро
    private final By openMetroStation = By.className("select-search__input");
    //Поле выбора станции метро
    private final By choseMetroStation = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[1]/button");
    //Поле ввода контактного номера телефона
    private final By phoneNumber = By.cssSelector("[placeholder = '* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private final By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public SecondOrderPage feelFirstOrderPage(String userFirstName, String userLastName, String userAddress,
                                              String userPhoneNumber) {

        driver.findElement(firstName).sendKeys(userFirstName);
        driver.findElement(lastName).sendKeys(userLastName);
        driver.findElement(address).sendKeys(userAddress);
        driver.findElement(openMetroStation).click();
        driver.findElement(choseMetroStation).click();
        driver.findElement(phoneNumber).sendKeys(userPhoneNumber);
        driver.findElement(nextButton).click();
        return new SecondOrderPage(driver);

    }
}
