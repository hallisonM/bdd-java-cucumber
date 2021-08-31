package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends HookPage {

    public HomePage(WebDriver browser) {
        super(browser);
    }

    public String getHomePageTitle()  {
        return new WebDriverWait(browser, 10)
                .until(browser -> browser.getTitle());
    }

    public IssuePage clickReportIssueLink() {
        browser.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/a[3]")).click();
        return new IssuePage(browser);
    }

}
