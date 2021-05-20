package Lesson6_HW.pages;


import Lesson7_HW.CreateNewContact;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SubMenu extends BaseView {
    public SubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Мои проекты']")
    public WebElement myProjects;

    @Step("Клик на кнопку выпадающего меню {Мои проекты}")
    public void createProject() {
        myProjects.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new NewProjectPage(driver).createProjectButtonLocator));
    }

    @FindBy(xpath = "//span[text()='Контактные лица']")
    public WebElement myContactButton;


    @Step("Клик на кнопку выпадающего меню {Контактные лица}")
    public void createContact() {
        myContactButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CreateNewContact(driver).createContactButtonLocator));
    }

}
