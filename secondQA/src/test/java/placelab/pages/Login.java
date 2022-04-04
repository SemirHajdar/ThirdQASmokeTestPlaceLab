package placelab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Login {

    private WebDriver driver;

    public Login (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLoginPage(String host) {
        Assert.assertEquals(driver.getCurrentUrl(),host);
        Assert.assertEquals(driver.getTitle(),"PlaceLab");
        getPlaceLabLogo().isDisplayed();
    }
    private WebElement getPlaceLabLogo () {
        WebElement logo = driver.findElement(By.xpath("/html/body/div/div[1]/div/img"));
        return logo;
    }
    public void enterUserName (final String username) {
        WebElement userName = driver.findElement(By.name("email"));
        userName.sendKeys(username);
    }
    public void enterPassword (final String password) {
        WebElement userPassword = driver.findElement(By.name("password"));
        userPassword.sendKeys(password);
    }
    public void logInButton (){
        WebElement logInButton = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/form/input[4]"));
        logInButton.click();
    }
}
