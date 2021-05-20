package Lesson7_HW;

import Lesson6_HW.pages.LoginPage;
import static Lesson6_HW.Configuration.*;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;


public class CRM_Tests extends BaseTest {
    @BeforeEach
    @Step("Переход на страницу по заданному URL-у")
    public void goToPage() {
        driver.get(BASE_URL);
    }

    @Test
    @Feature("Login")
    @Step("Авторизация пользователя")
    void loginTestWithFluentPage() {
        new LoginPage(driver)
                .fillInputLogin(LOGIN)
                .fillInputPassword(PASSWORD)
                .submitLogin();
    }

    @Test
    @Feature("Тестирование процесса создания нового проекта с валидными данными")
    @Step("Создание проекта")
    void createNewProject() throws InterruptedException {
        new LoginPage(driver).login(LOGIN, PASSWORD)
                .navigationMenu.openNavigationMenuItem("Проекты");
        new SubMenu(driver).createProject();
        new CreateNewProjectPage(driver).CreateProject();

        new CreateNewProjectPage(driver)
                .fillProjectName("ACSP")
                .fillOrganization(COMPANY_NAME)
                .selectBusinessUnit("Research & Development")
                .selectCurator("Applanatest Applanatest Applanatest")
                .selectProjectLead("Applanatest Applanatest Applanatest")
                .selectAdministrator("Applanatest Applanatest Applanatest")
                .selectProjectManager("Митрофанов Никита")
                .selectContact("Maitz Peter")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id(new CreateNewProjectPage(driver).requestSuccessLocator)));

        assertThat(new CreateNewProjectPage(driver).requestSuccess, isDisplayed());
}


    @Test
    @Feature("Тестирование процесса создания нового контакта с валидными данными")
    @Step("Создание нового контакта")
    void createNewContact() {
        new LoginPage(driver).login(LOGIN, PASSWORD)
                .navigationMenu.openNavigationMenuItem("Контрагенты");
        new SubMenu(driver).createContact();
        new CreateNewContact(driver).createContact();

        new CreateNewContact(driver)
                .inputLastName("Maitz")
                .inputFirstName("Peter")
                .inputJobTitle("Project Manager")
                .chooseCompany(COMPANY_NAME)
                .saveAndCloseButtonContact.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CreateNewContact(driver).requestContactSuccessLocator));

        assertThat(new CreateNewContact(driver).createContactButton, isDisplayed());

    }
    }
