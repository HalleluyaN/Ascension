/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com.ascension;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
public class MakeADonationTest {

    private static WebDriver driver;

    public MakeADonationTest() {
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
//        driver.manage().window().maximize();
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
    public void OpenBrowser() throws Exception {
        System.out.println("");
        System.out.println("🧪 Make a Donation is Being Tested 🧪");
        System.out.println("");

//        //Going to Ascensions Main HomePage
//        driver.get("https://healthcare.ascension.org/");

        //Going to Donate Page
//        driver.get("https://healthcare.ascension.org/donate?");

//        //Getting the web handle for homepage
//        String currentTabHandle = driver.getWindowHandle();

//        //Click on Donate
//        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[1]/div/div/div/div/div/div[1]/div/div/div/div[1]/div/div/div/div/ul/li[2]/div/a")).click();

        //Click on Illinois
        driver.findElement(By.xpath("//*[@id=\"facets-section__state\"]/li[4]/a/div/div/h3")).click();

        //Click on Foundation
        driver.findElement(By.xpath("//a[@href=\"https://www.ascensionillinoisfoundation.org/\"]")).click();

//        //Geting handles of all tabs - since a new tab was opened, and then swithcing to tne new tab
//        Thread.sleep(3000);
//        Set<String> allTabHandles = driver.getWindowHandles();
//
//        for (String tabHandle : allTabHandles) {
//            if (!tabHandle.equals(currentTabHandle)) {
//                driver.switchTo().window(tabHandle);
//                break;
//            }
//        }
        //Go to Second Tab
        ArrayList<String> tabList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));
        
        System.out.println("We're here");
        
        //Wait until element make a gift is visible and then clicking on it
        WebDriverWait wait = new WebDriverWait(driver, 20);  //20 sec
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"StylableButton2545352419__label wixui-button__label\"]"))).click();

        /*
        Switching to the "form" iframe in the donation page
         */
        Thread.sleep(5000);
        WebElement iframe = driver.findElement(By.xpath("//iFrame[@class=\"wuksD5\"]"));
        driver.switchTo().frame(iframe);

        //Scrolling down a little
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        // Waiting till the "other" donation box is visible and then clicking on it
        WebDriverWait wait2 = new WebDriverWait(driver, 20);  //20 sec
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bboxdonation_gift_rdlstGivingLevels\"]/div[6]/div/label/span")));
        driver.findElement(By.xpath("//*[@id=\"bboxdonation_gift_rdlstGivingLevels\"]/div[6]/div/label/span")).click();
        Thread.sleep(5000);

        //inputing $1 for dollar amount to be donated
        driver.findElement(By.xpath("//*[@id=\"bboxdonation_gift_txtOtherAmountButtons\"]")).sendKeys("1");

        System.out.println("");
        System.out.println("✅ Make a Donation is Tested! ✅");
        System.out.println("");

    }
}
