package Lesson3;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class Start {

        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\maven\\helloworld\\example\\src\\main\\java\\resources\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.get("https://google.com");
            Thread.sleep(5000);
            driver.close();

            WebDriverManager.firefoxdriver().setup();
            WebDriver firefoxDriver = new FirefoxDriver();
            firefoxDriver.get("https://ya.ru");
            Thread.sleep(5000);
            firefoxDriver.close();
        }
    }
