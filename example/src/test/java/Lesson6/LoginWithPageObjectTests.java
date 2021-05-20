package Lesson6;

import io.qameta.allure.Feature;
import Lesson6.pages.CreateExpenseRequestPage;
import Lesson6.pages.ExpenseRequestsPage;
import Lesson6.pages.ExpensesSubMenu;
import Lesson6.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Lesson6.Configuration.BASE_URL;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Feature("Тестирование создания заявки на расход")
public class LoginWithPageObjectTests extends BaseTest {

    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL);
    }

    @Test
    void loginTest() {
        loginPage.inputLogin.sendKeys("Applanatest1");
        loginPage.inputPassword.sendKeys("Student2020!");
        loginPage.buttonSubmit.click();
    }

    @Test
    void loginTestWithFluentPage() {
        new LoginPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .submitLogin();
    }

    @Test
    void createNewExpenseRequest() {
        new LoginPage(driver).login("Applanatest1", "Student2020!")
                .navigationMenu.openNavigationMenuItem("Расходы");

        new ExpensesSubMenu(driver).createExpense();
        new ExpenseRequestsPage(driver).createExpense();

        new CreateExpenseRequestPage(driver)
                .fillDescription("test")
                .selectBusinessUnit("Research & Development")
                .selectExpense("01101 - ОС: вычислительная техника инфраструктуры")
                .fillSumPlan("123")
                .selectDate("24")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new CreateExpenseRequestPage(driver).requestSuccessLocator)));

        assertThat(new CreateExpenseRequestPage(driver).requestSuccess.isDisplayed(), equalTo(true));
    }

}