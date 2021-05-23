package Lesson8;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreateExpenseRequestPage {

    private SelenideElement requestDescription = $(By.name("crm_expense_request[description]"));

    public CreateExpenseRequestPage fillDescription(String description) {
        requestDescription.sendKeys(description);
        return this;
    }

    private SelenideElement businessUnitSelect = $(By.name("crm_expense_request[businessUnit]"));

    public CreateExpenseRequestPage selectBusinessUnit(String businessUnit) {
        new Select(businessUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }

    private SelenideElement expenseSelect = $(By.name("crm_expense_request[expenditure]"));

    public CreateExpenseRequestPage selectExpense(String expenseName) {
        new Select(expenseSelect).selectByVisibleText(expenseName);
        return this;
    }

    private SelenideElement sumPlanInput = $(By.name("crm_expense_request[sumPlan]"));

    public CreateExpenseRequestPage fillSumPlan(String sum) {
        sumPlanInput.sendKeys(sum);
        return this;
    }

    private SelenideElement calendar = $(By.xpath("//label[@class='required']//ancestor::div[contains(@class,'control')]" +
            "//input[@placeholder='Укажите дату']"));

    private List<SelenideElement> dates = $$(By.xpath("//td[@data-handler='selectDay']"));

    public CreateExpenseRequestPage selectDate(String date) {
        calendar.click();
        dates.stream().filter(element -> element.getText().equals(date)).findFirst().get().click();
        return this;
    }

    public SelenideElement saveAndCloseButton = $(By.xpath("//button[contains(text(),'Сохранить и закрыть')]"));

    public SelenideElement requestSuccess = $(By.xpath("//*[text()='Заявка на расход сохранена']"));
}