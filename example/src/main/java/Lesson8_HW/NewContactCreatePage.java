package Lesson8_HW;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NewContactCreatePage {
    private SelenideElement newContactCreateButton = $(By.xpath(".//a[text()='Создать контактное лицо']"));

    public void createNewContact() {
        newContactCreateButton.click();
    }
}
