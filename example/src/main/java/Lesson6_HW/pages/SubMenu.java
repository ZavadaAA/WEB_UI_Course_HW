package Lesson6_HW.pages;

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

    public void createProject() {
        myProjects.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new NewProjectPage(driver).createProjectButtonLocator));
    }

}
