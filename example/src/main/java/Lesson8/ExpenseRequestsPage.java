package Lesson8;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ExpenseRequestsPage {
    private SelenideElement createExpenseButton = $(By.xpath("//a[text()='Создать заявку на расход']"));

    public void createExpense() {
        createExpenseButton.click();
    }
}