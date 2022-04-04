package placelab.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import placelab.pages.*;
import placelab.utilities.WebDriverSetup;

public class SmokeTest {

    public WebDriver driver;
    private String host = System.getProperty("host");
    private String user = System.getProperty("user");
    private String username = System.getProperty("username");
    private String password = System.getProperty("password");
    private String homePageUrl = System.getProperty("homepage");
    private String userRole = System.getProperty("userrole");
    private String singlePlaceSearchUrl = System.getProperty("singlePlaceSearchUrl");
    private String queriesUrl = System.getProperty("homepagequeries");
    private String singlePlaceSearchReportName = System.getProperty("singlePlaceSearchReportName");
    private String placeName = "Sarajevo";
    private String placeAddress = "Trg međunarodnog prijateljstva, Sarajevo 71000, Bosnia and Herzegovina.";
    private Login login;
    private HomePage homePage;
    private SinglePlaceReportPage singlePlaceReportPage;
    private ReportsPage reportsPage;
    private MyReportPage myReportPage;
    private SoftAssert softAssert = new SoftAssert();

    @Parameters ({"browser"})

    @BeforeSuite (alwaysRun = true)
    public void initDriver (String browser) {
        driver = WebDriverSetup.getWebDriver(browser);
        login = new Login(driver);
        homePage = new HomePage(driver);
        singlePlaceReportPage = new SinglePlaceReportPage(driver);
        reportsPage = new ReportsPage(driver);
        myReportPage = new MyReportPage(driver);
    }
    @BeforeTest (alwaysRun = true,groups = {"Positive, Negative"}, description = "Verify that user is able to open" + "PlaceLab App.")
    public void openApp () {
        driver.navigate().to(host);
        login.verifyLoginPage(host);
    }
    @Test (priority = 1,groups = {"Positive"},description = "This test Verifies that user is able to log in to" + "PlaceLab with valid credentials.", suiteName = "Smoke Test")
    public void testLoginPositive (){
        login.enterUserName(username);
        login.enterPassword(password);
        login.logInButton();
        Assert.assertEquals(driver.getCurrentUrl(),homePageUrl);
        assert (homePage.getUserName().contains(user));
        softAssert.assertEquals(homePage.getUserRole(),userRole);
        softAssert.assertAll();
    }
    @Test (priority = 2,groups = {"Positive"},description = "This test Verifies that user is able to open input menu,enter inputs and create Single Place Search Report", suiteName = "Smoke Test")
    public void testDataExtractionReport() throws InterruptedException {
        homePage.openCreateReportMenu();
        homePage.waitForSinglePlaceSearchIsDisplayed();
        homePage.openSinglePlaceSearchReport();
        Assert.assertEquals(driver.getCurrentUrl(), singlePlaceSearchUrl);
        singlePlaceReportPage.getSinglePlaceSearchTitle().isDisplayed();
        singlePlaceReportPage.waitForSinglePlaceSearchIsOpen();
        singlePlaceReportPage.enterReportName(singlePlaceSearchReportName);
        singlePlaceReportPage.enterPlaceName(placeName);
        singlePlaceReportPage.openCategory();
        singlePlaceReportPage.chooseAccommodation();
        singlePlaceReportPage.enterAddress(placeAddress);
        singlePlaceReportPage.confirmYourAddress();
        singlePlaceReportPage.submit();
        Thread.sleep(6000);
    }
    @Test (priority = 3,groups = {"Positive"},description = "This test Verify that user is able to open Single Place Search report", suiteName = "Smoke Test")
    public void openReport (){
        reportsPage.waitUntilReportsPageIsOpen();
        reportsPage.openMyReport();
    }
    @Test (priority = 4,groups = {"Positive"}, description = "This test Verify widgets in Single Place Search report", suiteName = "Smoke Test")
    public void widgetsInMyReport (){
        myReportPage.waitUntilReportTitleIsDisplayed();
        myReportPage.getAnalysisInfoWidget().isDisplayed();
        myReportPage.getSimilarityScore().isDisplayed();
        myReportPage.getNameFrequency().isDisplayed();
        myReportPage.getNameSimilarityDegree().isDisplayed();
        myReportPage.getAttributeMatch().isDisplayed();
        myReportPage.getAttributeCompleteness().isDisplayed();
        myReportPage.getPhoneFrequency().isDisplayed();
        myReportPage.getWebsiteFrequency().isDisplayed();
        myReportPage.getCategoryFrequency().isDisplayed();
        myReportPage.getDistanceAnalysis().isDisplayed();
        myReportPage.getAddressFrequency().isDisplayed();
    }
    @AfterTest (alwaysRun = true)
    public void signOut () throws InterruptedException {
        reportsPage.queriesButton().click();
        Thread.sleep(4000);
        reportsPage.checkBoxOfReport().click();
        reportsPage.deleteButton().click();
        Thread.sleep(4000);
        reportsPage.confirmDeleteReport();
        Thread.sleep(5000);
        homePage.signOut();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(),host);
    }
    @AfterSuite(alwaysRun = true)
    public void quitDriver() {
        driver.close();
    }
}