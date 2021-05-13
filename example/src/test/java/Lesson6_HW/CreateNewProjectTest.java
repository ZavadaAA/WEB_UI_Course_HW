package Lesson6_HW;

import Lesson6_HW.pages.LoginPage;
import Lesson6_HW.pages.NewProjectPage;
import Lesson6_HW.pages.SubMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Lesson6_HW.Configuration.LOGIN;
import static Lesson6_HW.Configuration.PASSWORD;
import static Lesson6_HW.Configuration.BASE_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class CreateNewProjectTest extends BaseTest {

    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL);
    }
        @Test
        @DisplayName("Создание проекта")
        public void createNewProjectPositiveTest() {
            new LoginPage(driver).login(LOGIN, PASSWORD)
              .navigationMenu.openNavigationMenuItem("Проекты");

            new SubMenu(driver).createProject();
            new NewProjectPage(driver).createProject();

            new NewProjectPage(driver)
                    .nameCompany("PMR")
                    .openListOrganization()
                    .selectOrganization("Bins-Haley")
                    .selectBusinessUnit("Research & Development")
                    .selectCurator("Applanatest Applanatest Applanatest")
                    .selectrp("Applanatest1 Applanatest1 Applanatest1")
                    .selectAdministrator("Applanatest2 Applanatest2 Applanatest2")
                    .selectManager("Митрофанов Никита")
                    .openListContacts()
                    .selectContact("Peter Maitz")
                    .buttonSaveAndClose.click();

            webDriverWait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.xpath(new NewProjectPage(driver).requestSuccessLocator)));

            assertThat(new NewProjectPage((driver).requestSuccess, isDisplayed()));
        }
}