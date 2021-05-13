package Lesson6_HW.pages;

import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewProjectPage extends BaseView {
    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Создать проект']")
    public WebElement createProjectButton;

    public void createProject() {
        createProjectButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.id(new CreateNewProject(driver).requestSuccessLocator)));
    }

    public By createProjectButtonLocator = By.xpath("//a[text()='Создать проект']");
}