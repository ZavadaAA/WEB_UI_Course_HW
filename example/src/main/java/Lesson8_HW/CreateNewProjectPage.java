package Lesson8_HW;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import static com.codeborne.selenide.Selenide.$;


@Feature("Создаем новый Проект")
public class CreateNewProjectPage {

    private SelenideElement requestDescription = $(By.name("crm_project[name]"));
    public CreateNewProjectPage fillProjectName(String projectName) {
        requestDescription.sendKeys(projectName);
        return this;
    }

    private SelenideElement OrganizationSelect = $(By.xpath("//span[text()='Укажите организацию']"));
    public CreateNewProjectPage OrganizationSelect(String organizationName) {
        new Select(OrganizationSelect).selectByVisibleText(organizationName);
        return this;
    }

    private SelenideElement businessUnitSelect = $(By.name("crm_project[businessUnit]"));
    public CreateNewProjectPage selectBusinessUnit(String businessUnit) {
        new Select(businessUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }

    private SelenideElement curatorSelect = $(By.name("crm_project[curator]"));
    public CreateNewProjectPage selectCurator(String curator) {
        new Select(curatorSelect).selectByVisibleText(curator);
        return this;
    }

    private SelenideElement projectLeadSelect = $(By.name("crm_project[rp]"));
    public CreateNewProjectPage selectProjectLead(String projectLead) {
        new Select(projectLeadSelect).selectByVisibleText(projectLead);
        return this;
    }

    private SelenideElement projectAdministratorSelect = $(By.name("crm_project[administrator]"));
    public CreateNewProjectPage selectProjectAdministrator(String projectAdministrator) {
        new Select(projectAdministratorSelect).selectByVisibleText(projectAdministrator);
        return this;
    }

    private SelenideElement projectManagerSelect = $(By.name("crm_project[manager]"));
    public CreateNewProjectPage selectProjectManager(String projectManager) {
        new Select(projectManagerSelect).selectByVisibleText(projectManager);
        return this;
    }

    public SelenideElement saveAndCloseButton = $(By.xpath("//button[contains(text(),'Сохранить и закрыть')]"));

    public SelenideElement requestSuccess = $(By.xpath("//*[text()='Проект сохранен']"));

}