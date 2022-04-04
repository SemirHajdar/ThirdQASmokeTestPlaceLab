package placelab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyReportPage {
    WebDriver driver;

    public MyReportPage (WebDriver driver){
        this.driver=driver;
    }
    public void waitUntilReportTitleIsDisplayed () {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement reportTitle;
        reportTitle = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/span[2]"))));
    }
    public WebElement getAnalysisInfoWidget (){
        WebElement analysisInfo = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[4]/div[1]/div[1]/div[1]/div/div[4]"));
        return analysisInfo;
    }
    public WebElement getSimilarityScore () {
        WebElement similarityScore = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[4]/div[1]/div[5]/div[1]/div"));
        return similarityScore;
    }
    public WebElement getNameSimilarityDegree () {
        WebElement nameSimilarityDegree = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[4]/div[1]/div[5]/div[2]/div"));
        return nameSimilarityDegree;
    }
    public WebElement getAttributeMatch () {
        WebElement attributeMath = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[4]/div[1]/div[9]/div[1]/div"));
        return attributeMath;
    }
    public WebElement getAttributeCompleteness (){
        WebElement attributeCompleteness = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[4]/div[1]/div[9]/div[2]/div"));
        return attributeCompleteness;
    }
    public WebElement getPhoneFrequency () {
        WebElement phoneFrequency = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[4]/div[1]/div[13]/div[1]/div"));
        return phoneFrequency;
    }
    public WebElement getWebsiteFrequency () {
        WebElement webSiteFrequency = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[4]/div[1]/div[13]/div[2]/div"));
        return webSiteFrequency;
    }
    public WebElement getCategoryFrequency () {
        WebElement categoryFrequency = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[4]/div[1]/div[17]/div[1]/div"));
        return categoryFrequency;
    }
    public WebElement getNameFrequency () {
        WebElement nameFrequency = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[4]/div[1]/div[17]/div[2]/div"));
        return nameFrequency;
    }
    public WebElement getDistanceAnalysis () {
        WebElement distanceAnalysis = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[4]/div[1]/div[25]/div[1]/div"));
        return distanceAnalysis;
    }
    public WebElement getAddressFrequency () {
        WebElement addressFrequency = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[4]/div[1]/div[25]/div[2]/div"));
        return addressFrequency;
    }
}