/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com.ascension;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
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
public class BillPayTest {

    private static WebDriver driver;

    public BillPayTest() {
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
    public void testBillPay() throws InterruptedException {

        System.out.println("");
        System.out.println("🧪 Bill Pay is Being Tested 🧪");
        System.out.println("");
        
        driver.get("https://healthcare.ascension.org/");
        driver.findElement(By.linkText("Bill Pay"));

//        System.out.println("Before switchint title is =" + driver.getTitle());
        driver.findElement(By.linkText("PAY A HOSPITAL BILL - VISITPAY PORTAL")).click();

        Set<String> handler = driver.getWindowHandles();
        Iterator<String> it = handler.iterator();

        String parentWindowId = it.next();
//        System.out.println("parent window id"+parentWindowId);

        String childWindowId = it.next();
//        System.out.println("child window id"+childWindowId);

        driver.switchTo().window(childWindowId);
        System.out.println("chid window Title" + driver.getTitle());

        driver.findElement(By.xpath("//a[contains(text(),'Make a one-time payment')]")).click();

        driver.findElement(By.xpath("//input[@id='AuthenticationId0']")).click();
        driver.findElement(By.id("AuthenticationId0")).sendKeys("test");
        driver.findElement(By.id("LastName")).click();
        driver.findElement(By.id("LastName")).sendKeys("test1234");
        Select mon = new Select(driver.findElement(By.id("DateOfBirthMonth")));
        mon.selectByVisibleText("Jan");
        driver.findElement(By.id("DateOfBirthDay")).sendKeys("01");
        driver.findElement(By.id("DateOfBirthYear")).sendKeys("1986");
        driver.findElement(By.xpath("//label[@id='rbNotPatientLabel']")).click();
        Select month = new Select(driver.findElement(By.id("PatientDateOfBirthMonth")));
        month.selectByVisibleText("Jul");
        driver.findElement(By.id("PatientDateOfBirthDay")).sendKeys("04");
        driver.findElement(By.id("PatientDateOfBirthYear")).sendKeys("2000");

        driver.findElement(By.xpath("//label[@id='GuestPayAgreeTermsOfUseLabel']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("guestAuthenticationSubmitButton")).click();

        System.out.println("");
        System.out.println("✅ Bill Pay is Tested! ✅");
        System.out.println("");
    }
}
