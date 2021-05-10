package Lesson5_HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class Ozon {
    WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://ozon.ru";

    @BeforeSuite
    void setupDataBase() {
        System.out.println("Before suite setup database");
    }

    @BeforeTest
    void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        Actions builder = new Actions(driver);

        driver.get("https://www.ozon.ru/");
        builder
                .moveToElement(driver.findElement(By.id("[@id=\"layoutPage\"]/div[1]/header/div[1]/div[4]/a[2]/span[2]")))
                .click()
                .build()
                .perform();

        Assertions.assertTrue(driver.findElement(By.className("emptyCart")).isEnabled());

        driver.quit();
    }
}
