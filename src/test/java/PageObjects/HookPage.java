package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HookPage {

    protected WebDriver browser;

    public HookPage(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        if (browser == null) {
            this.browser = new ChromeDriver();
        } else {
            this.browser = browser;
        }
        //global time out
        //this.browser.manage().timeouts()
        //        .implicitlyWait(5, TimeUnit.SECONDS)
        //        .pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        this.browser.quit();
    }
}
