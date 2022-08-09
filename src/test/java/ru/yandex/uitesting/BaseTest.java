package ru.yandex.uitesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;         //Закомментировать для проверки на Firefox
//import org.openqa.selenium.firefox.FirefoxDriver;     //Раскомментировать для проверки на Firefox

import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    @Before
    public void setup(){

//        WebDriverManager.firefoxdriver().setup();     //Раскомментировать для проверки на Firefox
//        driver = new FirefoxDriver();                 //Раскомментировать для проверки на Firefox
        WebDriverManager.chromedriver().setup();        //Закомментировать для проверки на Firefox
        driver = new ChromeDriver();                    //Закомментировать для проверки на Firefox
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void tearDown(){

        driver.quit();

    }
}
