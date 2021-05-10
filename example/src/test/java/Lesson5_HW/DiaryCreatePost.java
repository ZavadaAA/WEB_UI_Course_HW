package Lesson5_HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

public class DiaryCreatePost {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://diary.ru/user/login";
    private static WebDriverWait webDriverWait;
    @BeforeSuite
    void setupDataBase() {
        System.out.println("Before suit setup database");
    }

    @BeforeTest
    void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get(LOGIN_PAGE_URL);
        login();
    }

    @Test
    void diaryLoginTestCase() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement authorization = driver.findElement(By.xpath("//h1[text()='Популярное']"));
        assertThat(authorization.getText(), containsString("Популярное"));

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@title,'Новая запись')]")));
        driver.findElement(By.xpath("//a[contains(@title,'Новая запись')]"));
        driver.findElement(By.xpath("//a[contains(@title,'Новая запись')]")).click();
        driver.findElement(By.name("BlogsPosts[title]")).sendKeys("One more test post");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'message_ifr')]")));
        driver.findElement(By.xpath("//body")).sendKeys("One more test post");

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//input[contains(@name,'rewrite')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='One more test post']")));
        driver.findElement(By.xpath("//a[text()='One more test post']"));
    }
    private static void login() throws InterruptedException {
        driver.get(LOGIN_PAGE_URL);
        Cookie sessionCookie = driver.manage().getCookieNamed("PHPSESSID");
        driver.manage().deleteCookie(sessionCookie);
        driver.findElement(By.id("loginform-username")).sendKeys("azavada");
        driver.findElement(By.id("loginform-password")).sendKeys("zavada");
        Cookie cookie = new Cookie("PHPSESSID", "3b37stu9l7inouglbt4e44lp3n");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        Thread.sleep(10000);
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}