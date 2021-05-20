package Lesson7_HW;

import Lesson6.pages.BaseView;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

@Feature("Создаем новый Проект")
public class CreateNewProjectPage extends BaseView {


    public CreateNewProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_project[name]")
    public WebElement projectName;

    @Step("Заполнение поля Наименование ")
    public CreateNewProjectPage fillProjectName(String name) {
        projectName.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement OrganizationName;

    @FindBy(xpath = "//*[@id='select2-drop']/div/input")
    public WebElement inputOrganization;

    @Step("Заполнение поля Организация ")
    public CreateNewProjectPage fillOrganization(String organization) {
        OrganizationName.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select2-drop']/div/input")));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(OrganizationName));
        OrganizationName.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputOrganization));
        inputOrganization.sendKeys(organization);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputOrganization));
        inputOrganization.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessUnitSelect;

    @Step("Выбор в поле Подразделение - Research & Development")
    public CreateNewProjectPage selectBusinessUnit(String businessUnit) {
        new Select(businessUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    public WebElement selectContact;

    @Step("Выбор в поле Куратор проекта - Applanatest Applanatest Applanatest")
    public CreateNewProjectPage selectContact (String contactPerson) {
        new Select(selectContact).selectByVisibleText(contactPerson);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    public WebElement curatorSelect;

    @Step("Выбор в поле Куратор проекта - Applanatest Applanatest Applanatest")
    public CreateNewProjectPage selectCurator (String curator) {
        new Select(curatorSelect).selectByVisibleText(curator);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement projectRPselect;

    @Step("Заполнить поле Руководитель проекта - Applanatest Applanatest Applanatest")
    public CreateNewProjectPage selectProjectLead (String projectLead) {
        new Select(projectRPselect).selectByVisibleText(projectLead);
        return this;
    }

    @FindBy(name = "crm_project[administrator]")
    public WebElement selectAdministrator;

    public CreateNewProjectPage selectAdministrator(String administrator) {
        new Select(selectAdministrator).selectByVisibleText(administrator);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement projectManagerSelect;

    @Step("Заполнение поля Менеджер - Митрофанов Никита")
    public CreateNewProjectPage selectProjectManager (String projectManager) {
        new Select(projectManagerSelect).selectByVisibleText(projectManager);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    @FindBy(xpath = requestSuccessLocator)
    public WebElement requestSuccess;

    public static final String requestSuccessLocator = "//*[text()='Проект сохранен']";

    public By createProjectPageLocator = By.xpath("//input[@name='crm_project[name]']");
}