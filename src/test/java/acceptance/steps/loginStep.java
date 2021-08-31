package acceptance.steps;

import PageObjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class loginStep {

    @Given("I am on the login page")
    public void openLoginPage(){
        Hooks.loginPage = new LoginPage();
    }

    @When("I enter wrong credentials")
    public void enterWrongCredentials() {
        Hooks.loginPage.fillCredentials("login", "senha");
    }

    @When("I click on Login button")
    public void clickLoginButton() {
        Hooks.loginPage.clickLoginButton();
    }

    @Then("{string} should be shown")
    public void eMostradoMensagemDeErro(String msg) {
        Assert.assertTrue(Hooks.loginPage.erroMessageLoginVisible(msg));
    };

    @When("I enter correct credentials")
    public void openHomePage() {
        Hooks.homePage = Hooks.loginPage.openingHomePage("login", "senha");
    }

    @Then("Home page should be shown")
    public void waitSeeHomePage() {
        Assert.assertEquals(Hooks.homePage.getHomePageTitle(), "My View - MantisBT");
    };

}
