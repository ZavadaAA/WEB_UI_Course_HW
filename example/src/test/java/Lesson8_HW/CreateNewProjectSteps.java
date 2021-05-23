package Lesson8_HW;

import Lesson8_HW.Login;
import Lesson8_HW.MainPage;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Lesson8_HW.Configuration.LOGIN;
import static Lesson8_HW.Configuration.PASSWORD;

public class CreateNewProjectSteps {
    @Given("I am authorized")
    public void iAmAuthorized() {
        new Login().login(LOGIN, PASSWORD);
    }

    @Given("I am on create Project page")
    public void iAmOnProjectCreatePage() {
        new MainPage().navigationMenu.openNavigationMenuItem("Проекты");
        new SubMenu().createNewProject();
        new NewProjectCreatePage().createNewProject();
    }
    @When("I fill Project Name field")
    public void iFillProjectNameField() {
        new CreateNewProjectPage().fillProjectName("ACSP");
    }

    @When("I select Organization Name")
    public void iSelectOrganizationNameField() {
        new CreateNewProjectPage().OrganizationSelect("Bins-Haley");
    }

    @And("I select business unit")
    public void iSelectBusinessUnit() {
        new CreateNewProjectPage().selectBusinessUnit("Research & Development");
    }

    @And("I select Project Curator")
    public void iSelectProjectCurator() {
        new CreateNewProjectPage().selectCurator("Applanatest Applanatest Applanatest");
    }

    @And("I select Project Lead")
    public void iSelectProjectLead() {
        new CreateNewProjectPage().selectProjectLead("Applanatest Applanatest Applanatest");
    }

    @And("I select Project Administrator")
    public void iSelectProjectAdministrator() {
        new CreateNewProjectPage().selectProjectAdministrator("Applanatest Applanatest Applanatest");
    }

    @And("I select Project Manager")
    public void iSelectProjectManager() {
        new CreateNewProjectPage().selectProjectManager("Applanatest Applanatest Applanatest");
    }

    @And("I click save and close button")
    public void iClickSaveAndCloseButton() {
        new CreateNewProjectPage().saveAndCloseButton.click();
    }

    @Then("I see success message")
    public void iSeeSuccessMessage() {
        new CreateNewProjectPage().requestSuccess.shouldBe(Condition.visible);
    }

}
