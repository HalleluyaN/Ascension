/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com.ascension;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
public class SpecialtyCareTest {
    
    private static WebDriver driver;
    
    public SpecialtyCareTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    @Test
    public void testSpecialtyCare() throws Exception {
        
        System.out.println("");
        System.out.println("🧪 Specialty Care is Being Tested 🧪");
        System.out.println("");
        
        driver.get("https://healthcare.ascension.org/");
        driver.findElement(By.xpath("//header/div[@id='header']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).click();
        String expectedtitle = "Specialty Care | Ascension";
        String actualtitle = driver.getTitle();
        Assert.assertEquals(actualtitle, expectedtitle);

        //searchbox on specialty care page
        driver.findElement(By.name("get-care-now-filter-location")).click();
        driver.findElement(By.name("get-care-now-filter-location")).clear();
        driver.findElement(By.name("get-care-now-filter-location")).sendKeys("post-acute care");
        driver.findElement(By.linkText("Post-acute care")).click();

        driver.findElement(By.xpath("//div[@id='content']/div/div[3]/div/div/div/div/div/div/div/p[5]/a")).click();

        System.out.println("");
        System.out.println("✅ Specialty Care is Tested! ✅");
        System.out.println("");
    }
    
}
