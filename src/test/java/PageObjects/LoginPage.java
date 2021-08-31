package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends HookPage {

    static String url = "";

    public LoginPage(){
        super(null);
        browser.get(url);
    }

    public void fillCredentials(String username, String password) {
        browser.findElement(By.name("username")).sendKeys(username);
        browser.findElement(By.name("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        browser.findElement(By.cssSelector("input[type='submit']")).click();
    }

    public boolean erroMessageLoginVisible(String texto) {
        return browser.getPageSource().contains(texto);
    }

    public HomePage openingHomePage(String login, String senha) {
        browser.findElement(By.name("username")).sendKeys(login);
        browser.findElement(By.name("password")).sendKeys(senha);
        browser.findElement(By.cssSelector("input[type='submit']")).click();
        return new HomePage(browser);
    }


}
