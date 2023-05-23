/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com.ascension;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
public class PriceTransparencyInsTest {

    private static WebDriver driver;

    public PriceTransparencyInsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
//        WebDriverManager.getInstance(SafariDriver.class).setup();
        WebDriverManager.chromedriver().setup();
//        driver = new SafariDriver();
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

    @Test
    public void testAscensionHomepage() throws Exception {

        System.out.println("");
        System.out.println("🧪 Price Transparency Negative is Being Tested 🧪");
        System.out.println("");
        
        //Go to Homepage
        String apphomepageUrl = "https://healthcare.ascension.org/";
        driver.get(apphomepageUrl);

        WebElement pricetransparencyLink = driver.findElement(By.linkText("Price Transparency"));
        pricetransparencyLink.click();

        WebElement priceestimatorButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[2]/div/div/a"));
        priceestimatorButton.click();

        //Go to Second Tab
        ArrayList<String> tabList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));

        WebElement labsLink = driver.findElement(By.linkText("Labs"));
        labsLink.click();

        WebElement bloodsampleLink = driver.findElement(By.linkText("Blood"));
        bloodsampleLink.click();

        WebElement routinelabLink = driver.findElement(By.linkText("Routine lab testing"));
        routinelabLink.click();

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/div/div[2]/button/div/p[1]")).click();

        WebElement searchBar = driver.findElement(By.id("searchbar"));
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys("60194");
        searchBar.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div[2]/div/div[1]/div[1]/button/div/div/div[2]/p")).click();
        driver.findElement(By.id("insurance-provider-select")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"insurance-plan-select\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[3]/button/span[1]")).click();

        //Verify Results
        WebElement fullserviceCost = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div/div/div/h3"));
        String servicecostOutput = "Full service cost";
        if (fullserviceCost.getText() == servicecostOutput) {
            System.out.println("");
            System.out.println("✅ Price is Estimated! ✅ ");
            System.out.println("✅ Price Transparency Negative is tested! ✅");
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("❌ Price is not Estimated! ❌ ");
            System.out.println("✅ Price Transparency Negative is tested! ✅");
            System.out.println("");
        }

    }
}
