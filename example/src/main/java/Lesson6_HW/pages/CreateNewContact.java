package Lesson6_HW.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewContact extends BaseView {

    public CreateNewContact(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_contact[lastName]")
    public WebElement contactLastName;
    public  CreateNewContact enterLastName(String description){
        contactLastName.sendKeys(description);
        return this;
    }

    @FindBy(name = "crm_contact[firstName]")
    public WebElement contactFirstName;
    public  CreateNewContact enterFirstName(String description){
        contactFirstName.sendKeys(description);
        return this;
    }

    @FindBy(xpath = "//*[@class='select2-chosen' and text()='Укажите организацию']")
    public WebElement clickDropDownMenu_organization;
    public CreateNewContact clickDropDownOrganization() {
        clickDropDownMenu_organization.click();
        return this;
    }

    @FindBy(xpath = "//div[@class='select2-result-label' and text()='1234']")
    public WebElement choiceDropDownMenu_organization;
    public CreateNewContact choiceDropDownOrganization() {
        choiceDropDownMenu_organization.click();
        return this;
    }

    @FindBy(name = "crm_contact[jobTitle]")
    public WebElement jobTitleDropInput;
    public CreateNewContact enterJobTitle(String description) {
        jobTitleDropInput.sendKeys(description);
        return this;
    }

    @FindBy(css = "button[class='btn btn-success action-button']")
    public WebElement submitButton;

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    @FindBy(xpath = requestSuccessLocator)
    public WebElement requestSuccess;

    public static final String requestSuccessLocator = "//*[text()='Контактное лицо сохранено']";
}