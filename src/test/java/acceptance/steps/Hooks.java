package acceptance.steps;

import PageObjects.HomePage;
import PageObjects.IssuePage;
import PageObjects.LoginPage;
import io.cucumber.java.After;

public class Hooks {

    public static LoginPage loginPage;
    public static HomePage homePage;
    public static IssuePage issuePage;

    @After
    public void close(){
        loginPage.closeBrowser();
    }

}
