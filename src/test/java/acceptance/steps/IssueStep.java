package acceptance.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class IssueStep {

    @Given("I click on Report Issue button")
    public void openIssuePage(){
        Hooks.issuePage = Hooks.homePage.clickReportIssueLink();
    }

    @When("I select project")
    public void selectProject() {
        Hooks.issuePage.selectChooseProjectField("Tesrt");
        Hooks.issuePage.clickSelectProjectButton();
    }

    @When("I fill in the form with the necessary data")
    public void openHomePage() {
        Hooks.issuePage.fillDescriptionField("Descrição da Issue");
        Hooks.issuePage.selectCategoryIssueField("[All Projects] a");
        Hooks.issuePage.fillSummaryField("Cadastro Issue");
        Hooks.issuePage.clickSubmitReportButton();
    }

    @Then("I see Issues Page")
    public void waitIssuePageLoad() {
        Assert.assertEquals(Hooks.issuePage.getIssueTitlePage(), "View Issues - MantisBT");
    };

    @Then("I see the record in the first row of the table")
    public void waitSeeHomePega() {
        Assert.assertEquals("Cadastro Issue", Hooks.issuePage.checkingCreatedRecord());
    };

}
