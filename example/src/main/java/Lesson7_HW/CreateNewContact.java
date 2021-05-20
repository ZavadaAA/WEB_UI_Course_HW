package Lesson7_HW;

import Lesson6_HW.Configuration;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewContact extends Configuration {

    @FindBy (xpath = ".//a[text()='Создать контактное лицо']")
    private WebElement createNewContactButton;

    public CreateNewContact(WebDriver driver) {
        super(driver);
    }

    @Step("Нажатие на кнопку {Создать контактное лицо}")
    public CreateNewContact createNewContact() {
        createNewContactButton.click();
        return this;
    }

    @FindBy (name = "crm_contact[lastName]")
    private WebElement lastName;
    @Step("Заполнение поля Фамилия {lastName}")
    public CreateNewContact inputLastName(String name) {
        lastName.sendKeys(name);
        return this;
    }

    @FindBy (name = "crm_contact[firstName]")
    private WebElement firstName;
    @Step("Заполнение поля Имя {firstName}")
    public CreateNewContact inputFirstName(String name) {
        firstName.sendKeys(name);
        return this;
    }


    @FindBy (xpath = ".//span[text()='Укажите организацию']")
    private WebElement selectCompany;
    @Step(value = "Заполнение поля Организация {companyName}")
    public CreateNewContact chooseCompany(String companyName) {
        selectCompany.click();
        inputCompanyName.sendKeys(companyName);
        clickCompanyName.click();
        return this;
    }

    @FindBy (xpath = "//input[@class='select2-input select2-focused']")
    private WebElement inputCompanyName;

    @FindBy (xpath = "//span[@class='select2-match' and text()='" + COMPANY_NAME + "']")
    private WebElement clickCompanyName;

    @FindBy (name = "crm_contact[jobTitle]")
    private WebElement JobTitle;
    @Step(value = "Заполнение поля Должность {jobTitle}")
    public CreateNewContact inputJobTitle(String job) {
        JobTitle.sendKeys(job);
        return this;
    }

    @FindBy (xpath = ".//button[@class='btn btn-success action-button']")
    private WebElement submit;

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButtonContact;

    @FindBy(xpath = "//*[text()='Контактное лицо сохранено']")
    public WebElement createContactButton;


    public By requestContactSuccessLocator = By.xpath("//*[text()='Контактное лицо сохранено']");
}