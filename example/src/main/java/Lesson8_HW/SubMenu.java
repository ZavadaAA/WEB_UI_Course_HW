package Lesson8_HW;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SubMenu {

private SelenideElement newProjectCreateButton = $(By.xpath("//span[text()='Мои проекты']"));

    @Step("Клик на кнопку выпадающего меню {Мои проекты}")
    public void createNewProject() {
        newProjectCreateButton.click();
    }

    private SelenideElement newContactButton = $(By.xpath("//span[text()='Контактные лица']"));

    @Step("Клик на кнопку выпадающего меню {Контактные лица}")
    public void createNewContact() {
        newContactButton.click();

    }
}