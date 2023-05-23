/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com.ascension;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author halleluyamengesha
 */
public class PriceTransparencyNoInsTest {

    private static WebDriver driver;

    public PriceTransparencyNoInsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
//        WebDriverManager.getInstance(SafariDriver.class).setup();
//        System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
//        SafariOptions options = new SafariOptions();
//        options.setCapability("locationContextEnabled", true);
//        driver = new SafariDriver(options);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        driver.quit();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {

    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(priority = 1)
    public void testAscensionHomepage() throws Exception {

        System.out.println("");
        System.out.println("🧪 Price Transparency Positive is Being Tested 🧪");
        System.out.println("");
        
        //Go to Homepage
        String apphomepageUrl = "https://healthcare.ascension.org/";
        driver.get(apphomepageUrl);

        //Verify Homepage by Title using IF statement
        String expectedtitleHomepage = "Healthcare | Ascension";
        String actualtitleHomepage = driver.getTitle();
        if (expectedtitleHomepage.equals(actualtitleHomepage)) {
            System.out.println("✔️ Homepage Verification Successful!");
        } else {
            System.out.println("❌ Homepage Verification Failed!");
        }

    }

    @Test(priority = 2)
    public void testPriceTransparencyPage() throws Exception {

        //Verify Price Transparency Link using isDisplayed() and isEnabled() methods
        WebElement pricetransparencyLink = driver.findElement(By.linkText("Price Transparency"));
        boolean pricetransparencyPresence = pricetransparencyLink.isDisplayed();
        System.out.println("");
        System.out.println("✔️ Price Transparency Link is Displayed!");
        boolean pricetransparencyEnabled = pricetransparencyLink.isEnabled();
        System.out.println("✔️ Price Transparency Link is Enabled!");

        //Click Link
        if (pricetransparencyPresence == true && pricetransparencyEnabled == true) {
            pricetransparencyLink.click();
        } else {
            System.out.println("");
            System.out.println("✔️ Price Transparency may not be displayed or enabled!");
        }

        //Verify Price Transparency Page by Title using IF statement
        String expectedtitlePriceTransparency = "Price Transparency | Ascension";
        String actualtitlePriceTransparency = driver.getTitle();
        if (expectedtitlePriceTransparency.equals(actualtitlePriceTransparency)) {
            System.out.println("");
            System.out.println("✔️ Price Transparency Page Verification Successful!");
        } else {
            System.out.println("");
            System.out.println("❌ Price Transparency Page Verification Failed!");
        }
    }

    @Test(priority = 3)
    public void testPriceEstimatorPage() throws Exception {
        //Verify Price Estimator Link using isDisplayed() and isEnabled() methods
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,500)", "");

        WebElement priceestimatorButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[2]/div/div/a"));
        boolean priceestimatorPresence = priceestimatorButton.isDisplayed();
        System.out.println("");
        System.out.println("✔️ Price Estimator Button is Displayed!");
        boolean priceestimatorEnabled = priceestimatorButton.isEnabled();
        System.out.println("✔️ Price Estimator Button is Enabled!");

        //Click Link
        if (priceestimatorPresence == true && priceestimatorEnabled == true) {
            priceestimatorButton.click();
        } else {
            System.out.println("");
            System.out.println("❌ Price Estimator may not be displayed or enabled!");
        }

        //Go to Second Tab
        ArrayList<String> tabList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));

        //Verify Price Estimator Page using Assertion
        String expectedtitlePriceEstimator = "Price Estimator";
        String actualtitlePriceEstimator = driver.getTitle();
        if (expectedtitlePriceEstimator.equals(actualtitlePriceEstimator)) {
            System.out.println("");
            System.out.println("✔️ Price Estimator Page Verification Successful!");
        } else {
            System.out.println("");
            System.out.println("❌ Price Estimator Page Verification Failed!");
        }
    }

    @Test(priority = 4)
    public void testPriceEstimator() throws Exception {

        //Verify Labs Link using isDisplayed() method
        WebElement labsLink = driver.findElement(By.linkText("Labs"));
        boolean labsPresence = labsLink.isDisplayed();
        System.out.println("");
        System.out.println("✔️ Labs link is Displayed!");

        //Click Labs Link
        if (labsPresence == true) {
            labsLink.click();
        } else {
            System.out.println("");
            System.out.println("❌ Labs link may not be displayed or enabled!");
        }

        //Verify Blood Link using isDisplayed() method
        WebElement bloodsampleLink = driver.findElement(By.linkText("Blood"));
        boolean bloodsamplePresence = bloodsampleLink.isDisplayed();
        System.out.println("");
        System.out.println("✔️ Blood sample link is Displayed!");

        //Click Blood sample Link
        if (bloodsamplePresence == true) {
            bloodsampleLink.click();
        } else {
            System.out.println("");
            System.out.println("❌ Blood sample link may not be displayed or enabled!");
        }

        //Verify Routine Lab Link using isDisplayed() method
        WebElement routinelabLink = driver.findElement(By.linkText("Routine lab testing"));
        boolean routinelabPresence = routinelabLink.isDisplayed();
        System.out.println("");
        System.out.println("✔️ Routine lab link is Displayed!");

        //Click Blood sample Link
        if (routinelabPresence == true) {
            routinelabLink.click();
        } else {
            System.out.println("");
            System.out.println("❌ Routine lab link may not be displayed or enabled!");
        }

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/div/div[2]/button/div/p[1]")).click();

        //Verify Location Search Bar using isDisplayed() method
        WebElement searchBar = driver.findElement(By.id("searchbar"));
        boolean searchbarPresence = searchBar.isDisplayed();
        System.out.println("");
        System.out.println("✔️ Search Bar is Displayed!");
        boolean searchbarEnabled = searchBar.isEnabled();
        System.out.println("✔️ Search Bar is Enabled!");
        if (searchbarPresence == true && searchbarEnabled == true) {
            searchBar.click();
        } else {
            System.out.println("");
            System.out.println("❌ Search Bar may not be displayed or enabled!");
        }
        searchBar.clear();
        searchBar.sendKeys("60194");
        searchBar.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div[2]/div/div[1]/div[1]/button/div/div/div[2]/p")).click();

        driver.findElement(By.id("insurance-provider-select")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/button/span[1]")).click();

        //Verify Results
        WebElement fullserviceCost = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div/div/div/h3"));
        assertEquals(fullserviceCost.getText(), "Full service cost");
        
        System.out.println("");
        System.out.println("✔️ Price is Estimated! ✔️");
        System.out.println("✅ Price Transparency Positive is Tested! ✅");
        System.out.println("");
    }
}
