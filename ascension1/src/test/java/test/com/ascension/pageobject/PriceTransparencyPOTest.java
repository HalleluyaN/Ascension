/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com.ascension.pageobject;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
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
public class PriceTransparencyPOTest {

    private static WebDriver driver;
    private String baseUrl;

    public PriceTransparencyPOTest() {
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
    public void executePriceTransparencyPOModule() throws Exception {
        System.out.println("");
        System.out.println("🧪 Page Object Price Transparency Negative is Being Tested 🧪");
        System.out.println("");
        
        PriceTransparencyNoInsPO pricetransparencynoinspo = PageFactory.initElements(driver, PriceTransparencyNoInsPO.class);
        pricetransparencynoinspo.priceTransparencyNoIns(FileUtil.getData().getZipCode());

        //Verify Results
        WebElement fullserviceCost = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div/div/div/h3"));
        assertEquals(fullserviceCost.getText(), "Full service cost");
        System.out.println("");
        System.out.println(" ✅ Price is Estimated! ✅ ");
        System.out.println("");
    }
}
