/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com.ascension;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
public class FindALocationTest {

    private static WebDriver driver;

    public FindALocationTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        //        WebDriverManager.getInstance(SafariDriver.class).setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1400,800");
        WebDriverManager.chromedriver().setup();
//        driver = new SafariDriver();
        driver = new ChromeDriver(options);
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
    public void testfindaLocation() throws InterruptedException {

        System.out.println("");
        System.out.println("🧪 Find A Location is Being Tested 🧪");
        System.out.println("");

        driver.get("https://healthcare.ascension.org/locations");
        driver.findElement(By.xpath("//input[@class='location-type-ahead-input is-valid' and @placeholder='City and State, or ZIP Code']")).click();
        driver.findElement(By.xpath("//input[@class='location-type-ahead-input is-valid' and @placeholder='City and State, or ZIP Code']")).clear();
        driver.findElement(By.xpath("//input[@class='location-type-ahead-input is-valid' and @placeholder='City and State, or ZIP Code']")).sendKeys(Keys.chord(Keys.COMMAND, "a"));
        driver.findElement(By.xpath("//input[@class='location-type-ahead-input is-valid' and @placeholder='City and State, or ZIP Code']")).sendKeys(Keys.DELETE);
        driver.findElement(By.xpath("//input[@class='location-type-ahead-input is-valid' and @placeholder='City and State, or ZIP Code']")).sendKeys("Carol Stream, IL");
        driver.findElement(By.xpath("//input[@class='location-type-ahead-input is-valid' and @placeholder='City and State, or ZIP Code']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//input[@type='submit' and @class='fal-search-button']")).click();

        driver.findElement(By.linkText("Ascension Medical Group Illinois - Heart & Vascular Care Bartlett")).click();

        System.out.println("");
        System.out.println("✅ Find a Location is Tested! ✅");
        System.out.println("");
    }

}
