package Lesson6_HW.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateNewProject extends BaseView {

    public CreateNewProject(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_project[name]")
    public WebElement projectNameInput;
    public CreateNewProject ProjectName(String name) {
        projectNameInput.sendKeys(name);
        return this;
    }
        
    @FindBy(xpath = "//*[text()='Укажите организацию']")
    public WebElement clickDropDownMenu_organization;

    public CreateNewProject clickDropDownOrganization() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader-overlay")));
        By.className("loader-overlay");
        Thread.sleep(5000);
        clickDropDownMenu_organization.click();
        return this;
    }

    @FindBy(xpath = "//div[@class='select2-result-label' and text()='Bins-Haley']")
    public WebElement selectDropDownMenu_organization;
    public CreateNewProject choiceDropDownOrganization(String  nameCompany) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader-overlay")));
        By.className("loader-overlay");
        selectDropDownMenu_organization.click();
        selectDropDownMenu_organization.sendKeys(nameCompany);
        Thread.sleep(3000);
        return this;
        
    }

    @FindBy(xpath = "//*[@class='select2-container select2']")
    public WebElement clickDropDownMenu_ContactPerson;
    public CreateNewProject clickDropDownContactPerson() {
        clickDropDownMenu_ContactPerson.click();
        return this;
    }



    @FindBy(css = ".select2-focused")
    public WebElement sendDropDownMenu_ContactPerson;
    public CreateNewProject sendDropDownContactPerson(String nameContactPerson) {
        sendDropDownMenu_ContactPerson.sendKeys("Maitz Peter");
        return this;
    }

    @FindBy(css = ".select2-result-label")
    private WebElement choiceDropDownMenu_ContactPerson;
    public CreateNewProject choiceDropDownContactPerson() {
        choiceDropDownMenu_ContactPerson.click();
        return this;
    }

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessUnitDropDownSelect;

    public CreateNewProject selectBusinessUnit(String description){
        Select businessUnitDropDown = new Select(businessUnitDropDownSelect);
        businessUnitDropDown.selectByVisibleText(description);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    public WebElement curatorNameInput;

    public CreateNewProject enterCuratorName(String description) {
        curatorNameInput.sendKeys(description);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement projectAdministratorNameInput;

    public CreateNewProject enterProjectAdministratorName(String description) {
        projectAdministratorNameInput.sendKeys(description);
        return this;
    }


    @FindBy(name = "crm_project[manager]")
    public WebElement managerNameInput;

    public CreateNewProject enterManagerName(String description) {
        managerNameInput.sendKeys(description);
        return this;
    }

    @FindBy(css = "button[class='btn btn-success action-button']")
    public WebElement submitButtonP;

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    @FindBy(xpath = requestSuccessLocator)
    public WebElement requestSuccess;

    public static final String requestSuccessLocator = "//*[text()='Проект сохранен']";
}