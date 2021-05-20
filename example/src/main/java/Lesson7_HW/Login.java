package Lesson7_HW;

import Lesson6_HW.Configuration;
import Lesson6_HW.pages.BaseView;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Instant;

public class Login extends BaseView {
    private Instant webDriverWait;

    public Login(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "prependedInput")
    private WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    private WebElement inputPassword;

    @FindBy(id = "_submit")
    private WebElement buttonSubmit;


    @Step("Заполнение поля Логин {login}")
    public Login enterLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Заполнение поля Пароль {password}")
    public Login enterPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step(value = "Нажатие на кнопку {Войти} на странице входа")
    public Login clickSubmit() {
        buttonSubmit.click();
        return this;
    }

    public Login login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new Login(driver).geekBrainsHomeButtonLocator));
        return new Login(driver);
    }
}