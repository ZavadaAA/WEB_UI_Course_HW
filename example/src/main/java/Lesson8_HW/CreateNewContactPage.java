package Lesson8_HW;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Feature("Создаем новое Контактное лицо")
public class CreateNewContactPage {


    //@Step("Заполнение поля Фамилия {lastName}")
    private SelenideElement lastNameInput = $(By.name("crm_contact[lastName]"));
    public CreateNewContactPage inputLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    //@Step("Заполнение поля Имя {firstName}")
    private SelenideElement firstNameInput = $(By.name("crm_contact[firstName]"));
    public CreateNewContactPage inputFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    //@Step(value = "Заполнение поля Организация {companyName}")
    private SelenideElement companySelect = $(By.xpath(".//span[text()='Укажите организацию']"));
    public CreateNewContactPage selectCompany(String companyName) {
        new Select(companySelect).selectByVisibleText(companyName);
        return this;
    }

    //@Step(value = "Заполнение поля Должность {jobTitle}")
    private SelenideElement JobTitleInput = $(By.name("crm_contact[firstName]"));
    public CreateNewContactPage inputJobTitle(String JobTitle) {
        JobTitleInput.sendKeys(JobTitle);
        return this;
    }

        public SelenideElement saveAndCloseButton = $(By.xpath("//button[contains(text(),'Сохранить и закрыть')]"));

        public SelenideElement requestSuccess = $(By.xpath("//*[text()='Контактное лицо сохранено']"));
    }
