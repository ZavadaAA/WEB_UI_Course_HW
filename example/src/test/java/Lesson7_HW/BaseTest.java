package Lesson7_HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import Lesson6.pages.LoginPage;
import Lesson7.listeners.CustomLogger;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BaseTest {
    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;
    LoginPage loginPage;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupBrowser() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new CustomLogger());
        webDriverWait = new WebDriverWait(driver, 5);
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    @Step("Сбор информации по логам и закрытие браузера")
    void tearDown() {
        List<LogEntry> logs=driver.manage().logs().get(LogType.BROWSER).getAll();
        driver.manage().logs().get(LogType.BROWSER).getAll().forEach(System.out::println);
        driver.quit();
    }
}