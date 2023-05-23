/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com.ascension;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
public class CareerTest {

    private static WebDriver driver;

    public CareerTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
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
    public void testCareers() throws Exception {
        
        System.out.println("");
        System.out.println("🧪 Careers is Being Tested 🧪");
        System.out.println("");
        
        driver.get("https://jobs.ascension.org/careers-home/");

        driver.findElement(By.id("keyword-search")).click();
        driver.findElement(By.id("keyword-search")).clear();
        driver.findElement(By.id("keyword-search")).sendKeys("edward");
        driver.findElement(By.id("location-search")).click();
        driver.findElement(By.id("location-search")).clear();
        driver.findElement(By.id("location-search")).sendKeys("60586");
        driver.findElement(By.cssSelector(".job-search")).submit();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        
        driver.findElement(By.xpath("//a[contains(@class, 'apply-button')]//span[contains(text(), 'Apply Now')]")).click();

        System.out.println("");
        System.out.println("✅ Careers is Tested! ✅");
        System.out.println("");
    }
}
