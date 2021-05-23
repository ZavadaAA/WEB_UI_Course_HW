package Lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ExpensesSubMenu {

    private SelenideElement expensesRequestsButton = $(By.xpath("//span[text()='Заявки на расходы']"));

    @Step("Клик на кнопку создания расхода")
    public void createExpense() {
        expensesRequestsButton.click();
    }
}
