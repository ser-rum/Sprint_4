package ru.yandex.uitesting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.yandex.uitesting.PageObject.MainPage;


@RunWith(Parameterized.class)
public class ImportantQuestionsTest extends BaseTest {

    //Индекс для параметризации в локаторах
    private final int testIndex;
    //Тексты ожидаемых ответов на вопросы в блоке "Важные вопросы"
    private final String importantAnswerText;


    public ImportantQuestionsTest(int testIndex, String importantAnswerText) {
        this.testIndex = testIndex;
        this.importantAnswerText = importantAnswerText;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете " +
                        "просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                        "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                        "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому " +
                        "номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете " +
                        "кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. " +
                        "Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    @Test
    public void shouldBeTextInDropDownListTest(){

        //Селекторы вопросов в блоке "Важные вопросы"
        final By importantQuestionSelector = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div["
                + (testIndex + 1) + "]");
        //Селекторы ответов в блоке "Важные вопросы"
        final By importantAnswerSelector = By.cssSelector("#accordion__panel-" + testIndex + " > p");

        MainPage page = new MainPage(driver);
        Assert.assertEquals(importantAnswerText, page.shouldBeExactText(importantQuestionSelector,
                importantAnswerSelector));

    }
}
