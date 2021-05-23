package Lesson8_HW;

import Lesson8_HW.Login;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Lesson8_HW.CreateNewContactPage;
import Lesson8_HW.NewContactCreatePage;
import Lesson8_HW.SubMenu;
import Lesson8_HW.MainPage;

import static Lesson8_HW.Configuration.LOGIN;
import static Lesson8_HW.Configuration.PASSWORD;


        public class CreateNewContactSteps {
        @Given("I am authorized")
        public void iAmAuthorized() {
        new Login().login(LOGIN, PASSWORD);
        }

        @Given("I am on Contact create page")
        public void iAmOnContactCreatePage() {
        new MainPage().navigationMenu.openNavigationMenuItem("Контрагенты");
        new SubMenu().createNewContact();
        new NewContactCreatePage().createNewContact();
        }

        @When("I fill Last Name field")
        public void iFillLastNameField() {
        new CreateNewContactPage().inputLastName("Maitz");
        }

        @And("I fill First Name field")
        public void iFillFirstNameField() {
        new CreateNewContactPage().inputFirstName("Peter");
        }

        @And("I select company name")
        public void iSelectCompanyName() {
        new CreateNewContactPage().selectCompany("Bins-Haley");
        }

        @And("I fill Job title")
        public void iFillJobTitle() {
        new CreateNewContactPage().inputJobTitle("Project Manager");
        }

        @And("I click save and close button")
        public void iClickSaveAndCloseButton() {
        new CreateNewContactPage().saveAndCloseButton.click();
        }

        @Then("I see success message")
        public void iSeeSuccessMessage() {
        new CreateNewContactPage().requestSuccess.shouldBe(Condition.visible);
        }

        }