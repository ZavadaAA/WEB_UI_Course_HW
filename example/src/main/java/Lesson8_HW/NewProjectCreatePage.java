package Lesson8_HW;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class NewProjectCreatePage {
    private SelenideElement newProjectCreateButton = $(By.xpath("//a[text()='Создать проект']"));

    public void createNewProject() {
        newProjectCreateButton.click();
    }
}