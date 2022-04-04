package placelab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportsPage {
    public WebDriver driver;
    private String singlePlaceSearchReportName = System.getProperty("singlePlaceSearchReportName");

    public ReportsPage (WebDriver driver) {
        this.driver = driver;
    }
    public WebElement myReportXpath(){
        String path = "//div[@class='query_name']/a[text()='" + singlePlaceSearchReportName + "']";
        WebElement report = driver.findElement(By.xpath(path));
        return report;
    }
    public void openMyReport () {
        myReportXpath().click();
    }
    public void waitUntilReportsPageIsOpen () {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement reportsPage;
        reportsPage = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(("//div[@class='query_name']/a[text()='" + singlePlaceSearchReportName + "']")))));
    }
    public WebElement queriesButton (){
        WebElement queries = driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/a"));
        return queries;
    }
    public WebElement checkBoxOfReport () {
        WebElement checkBox = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[5]/table/tbody/tr[1]/td[2]/div"));
        return checkBox;
    }
    public WebElement deleteButton () {
        WebElement deleteReport = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[5]/div/ul/li[3]/a/i"));
        return deleteReport;
    }
    public WebElement confirmDeleteReport () {
        WebElement confirmDelete = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[1]/div[3]/a"));
        return confirmDelete;
    }
}
