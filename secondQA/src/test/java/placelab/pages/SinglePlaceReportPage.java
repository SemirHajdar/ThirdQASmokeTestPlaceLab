package placelab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SinglePlaceReportPage {
    public WebDriver driver;

    public SinglePlaceReportPage(WebDriver driver) {

        this.driver = driver;
    }
    public WebElement getSinglePlaceSearchTitle() {
        WebElement title = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[1]/div"));
        return title;
    }
    public void enterReportName(final String name) {
        WebElement reportName = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/form/div[1]/div/input"));
        reportName.sendKeys(name);
    }
    public void enterPlaceName (final String name) {
        WebElement placeName = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/form/div[2]/div/input"));
        placeName.sendKeys(name);
    }
    public void submit() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/form/button")).click();
        Thread.sleep(50000);
    }
    public void waitForSinglePlaceSearchIsOpen() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement singlePlace;
        singlePlace = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/form/div[1]/div/input"))));
    }
    public void openCategory () {
        driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/form/div[3]/div[2]/div/button/span")).click();
    }
    public void chooseAccommodation () {
        driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/form/div[3]/div[2]/div/ul/div/li[2]/a/label")).click();
    }
    public void enterAddress (String name) throws InterruptedException {
        WebElement locationName = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/form/div[4]/div[1]/div/input"));
        locationName.clear();
        locationName.sendKeys(name);
        Thread.sleep(5500);
        locationName.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
    }
    public void confirmYourAddress () throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[10]/div[3]/div/button[1]")).click();
        Thread.sleep(2000);
    }
}
