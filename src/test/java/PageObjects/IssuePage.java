package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IssuePage extends HookPage {

    public IssuePage(WebDriver browser){
        super(browser);
    }

    public void fillSummaryField(String texto) {
        browser.findElement(By.name("summary")).sendKeys(texto);
    }

    public void selectChooseProjectField(String projeto) {
        new Select(browser.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[2]/td[2]/select")))
                .selectByVisibleText(projeto);
    }

    public void clickSubmitReportButton() {
        browser.findElement(By.cssSelector("table.width90 input[type='submit']")).click();
    }

    public void clickSelectProjectButton() {
        browser.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[4]/td/input")).click();
    }

    public void selectCategoryIssueField(String categoria) {
        new Select(browser.findElement(By.cssSelector("table.width90 select[name='category_id']")))
                .selectByVisibleText(categoria);
    }

    public void fillDescriptionField(String descricao) {
        new WebDriverWait(browser, 10)
                .until(browser -> browser.findElement(By.name("description"))).sendKeys(descricao);
    }

    public String checkingCreatedRecord() {
       try {
           Thread.sleep(1000);
           WebElement linhaTabela = this.browser.findElement(By.cssSelector("#buglist tbody tr:nth-child(4)"));
           String nomeColuna = linhaTabela.findElement(By.cssSelector("td:nth-child(11)")).getText();
           return nomeColuna;
       } catch (NoSuchElementException | InterruptedException e) {
           return null;
       }
    }

    public String getIssueTitlePage() {
        try {
            Thread.sleep(5000);
            String titulo =  browser.getTitle();
            return titulo;
        } catch (InterruptedException e) {
            return null;
        }
    }

    /*
    public boolean sameURL(String url) {
        return browser.getCurrentUrl().equals(url);
    }
    public boolean visibleMessage() {
        String pageSource = browser.getPageSource();
        return pageSource.contains("campos obrigatorios")
                && pageSource.contains("campo summary é obrigatorio")
                && pageSource.contains("campo data é obrigatorio");
    }
     */
}
