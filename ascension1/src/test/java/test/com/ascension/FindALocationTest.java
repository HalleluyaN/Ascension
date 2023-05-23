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

    @Test(priority = 1)
    public void testfindaLocation() throws InterruptedException {
        
        System.out.println("");
        System.out.println("🧪 Find A Location is Being Tested 🧪");
        System.out.println("");
        
        driver.get("https://healthcare.ascension.org/");
        driver.findElement(By.xpath("//a[@title='Find a Location']")).click();

        driver.findElement(By.xpath("//input[@class='location-type-ahead-input is-valid']")).click();
        driver.findElement(By.xpath("//input[@class='location-type-ahead-input is-valid']")).clear();
        driver.findElement(By.xpath("//input[@class='location-type-ahead-input is-valid']")).sendKeys(Keys.chord(Keys.COMMAND, "a")); // Select all text (for macOS)
        driver.findElement(By.xpath("//input[@class='location-type-ahead-input is-valid']")).sendKeys(Keys.DELETE); // Delete the selected text
        driver.findElement(By.xpath("//input[@class='location-type-ahead-input is-valid']")).sendKeys("Carol Stream, IL 60188");
        driver.findElement(By.xpath("//input[@class='location-type-ahead-input is-valid']")).sendKeys(Keys.ENTER);
//        driver.findElement(By.xpath("//a[contains(text(),'Physical Therapy')]")).click();
//Thread.sleep(2000);
//driver.findElement(By.xpath("//*[@id=\"locationsSearchContainer\"]/div/div[2]/div[1]/div/div/div/div/div[3]/div/input")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
//        Thread.sleep(2000);
//WebElement SubmitButton=(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Ascension Medical Group Illinois - Heart & Vascula')]")));
        driver.findElement(By.xpath("//*[@id=\"locationsSearchContainer\"]/div/div[2]/div[2]/div[2]/div[3]/ol/li[4]/div/div/div[2]/h2/a")).click();
        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("");
        System.out.println("✅ Find a Location is Tested! ✅");
        System.out.println("");
    }

}
