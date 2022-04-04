package placelab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    public WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }
    public String getUserName () {
        return driver.findElement(By.id("user-name")).getText();
    }
    public String getUserRole () {
        return driver.findElement(By.id("user-role")).getText();
    }
    public void signOut () {
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/ul[2]/li/ul/li[4]/a")).click();
    }
    public void openCreateReportMenu () {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/ul[1]/li[1]/a")).click();
    }
    public void openSinglePlaceSearchReport() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/li[2]/a/label")).click();
    }
    public void waitForSinglePlaceSearchIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement singlePlaceSearch;
        singlePlaceSearch = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[1]/div"))));
    }
}