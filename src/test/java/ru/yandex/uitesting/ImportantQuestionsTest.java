package ru.yandex.uitesting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;         //Закомментировать для проверки на Firefox
//import org.openqa.selenium.firefox.FirefoxDriver;     //Раскомментировать для проверки на Firefox
import ru.yandex.uitesting.PageObject.MainPage;


@RunWith(Parameterized.class)
public class ImportantQuestionsTest extends BaseTest {

    WebDriver driver;


    String mainPageURL = "https://qa-scooter.praktikum-services.ru/";
    //Селекторы вопросов в блоке "Важные вопросы"
    private final By importantQuestionSelector;
    //Селекторы ответов в блоке "Важные вопросы"
    private final By importantAnswerSelector;
    //Тексты ожидаемых ответов на вопросы в блоке "Важные вопросы"
    private final String importantAnswerText;


    public ImportantQuestionsTest(By importantQuestionSelector, By importantAnswerSelector,
                                  String importantAnswerText) {
        this.importantQuestionSelector = importantQuestionSelector;
        this.importantAnswerSelector = importantAnswerSelector;
        this.importantAnswerText = importantAnswerText;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                {By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[1]"),
                        By.cssSelector("#accordion__panel-0 > p"), "Сутки — 400 рублей. Оплата курьеру — " +
                        "наличными или картой."},
                {By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[2]"),
                        By.cssSelector("#accordion__panel-1 > p"), "Пока что у нас так: один заказ — один " +
                        "самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — " +
                        "один за другим."},
                {By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[3]"),
                        By.cssSelector("#accordion__panel-2 > p"), "Допустим, вы оформляете заказ на 8 мая. " +
                        "Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, " +
                        "когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная " +
                        "аренда закончится 9 мая в 20:30."},
                {By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[4]"),
                        By.cssSelector("#accordion__panel-3 > p"), "Только начиная с завтрашнего дня. " +
                        "Но скоро станем расторопнее."},
                {By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[5]"),
                        By.cssSelector("#accordion__panel-4 > p"), "Пока что нет! Но если что-то срочное — " +
                        "всегда можно позвонить в поддержку по красивому номеру 1010."},
                {By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[6]"),
                        By.cssSelector("#accordion__panel-5 > p"), "Самокат приезжает к вам с полной зарядкой. " +
                        "Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. " +
                        "Зарядка не понадобится."},
                {By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[7]"),
                        By.cssSelector("#accordion__panel-6 > p"), "Да, пока самокат не привезли. Штрафа " +
                        "не будет, объяснительной записки тоже не попросим. Все же свои."},
                {By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[8]"),
                        By.cssSelector("#accordion__panel-7 > p"), "Да, обязательно. Всем самокатов! " +
                        "И Москве, и Московской области."}
        };
    }

    @Test
    public void shouldBeTextInDropDownListTest(){

//        driver = new FirefoxDriver();         //Раскомментировать для проверки на Firefox
        driver = new ChromeDriver();            //Закомментировать для проверки на Firefox
        driver.get(mainPageURL);
        MainPage page = new MainPage(driver);
        page.clickCookieButton();
        Assert.assertEquals(importantAnswerText, page.shouldBeExactText(importantQuestionSelector,
                importantAnswerSelector));
        driver.quit();

    }
}
