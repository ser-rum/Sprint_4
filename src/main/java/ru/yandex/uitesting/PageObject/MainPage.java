package ru.yandex.uitesting.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    WebDriver driver;

    //Верхняя кнопка "Заказать"
    private final By topOrderButton = By.xpath("/html/body/div/div/div/div[1]/div[2]/button[1]");
    //Нижняя кнопка "Заказать"
    private final By bottomOrderButton = By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button");
    //Блок "Важные вопросы"
    private final By importantQuestionsBlock = By.xpath("/html/body/div/div/div/div[5]/div[2]/div");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public String shouldBeExactText(By importantQuestionSelector,
                                    By importantAnswerSelector){

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(importantQuestionsBlock));
        driver.findElement(importantQuestionSelector).click();
        return driver.findElement(importantAnswerSelector).getText();

    }

    public FirstOrderPage clickTopOrderButton() {

        driver.findElement(topOrderButton).click();
        return new FirstOrderPage(driver);

    }

    public FirstOrderPage clickBottomOrderButton() {

        WebElement element = driver.findElement(bottomOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(bottomOrderButton).click();
        return new FirstOrderPage(driver);

    }
}
