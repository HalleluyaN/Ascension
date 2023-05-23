/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.com.ascension.pageobject;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author halleluyamengesha
 */
public class PriceTransparencyNoInsPO {
    public WebDriver driver;
    private WebDriverWait wait;

    public PriceTransparencyNoInsPO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    String apphomepageUrl = "https://healthcare.ascension.org/";

    
    @FindBy(linkText = "Price Transparency")
    private WebElement pricetransparencyLink;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[2]/div/div/a")
    private WebElement priceestimatorButton;

    @FindBy(linkText = "Labs")
    private WebElement labsLink;

    @FindBy(linkText = "Blood")
    private WebElement bloodsampleLink;

    @FindBy(linkText = "Routine lab testing")
    private WebElement routinelabLink;

    @FindBy(id = "searchbar")
    private WebElement searchBar;
    
    @FindBy (xpath = "//*[@id=\"root\"]/div/section/section/div/div[2]/button/div/p[1]")
    private WebElement searchserviceResult;
    
    @FindBy (id = "insurance-provider-select")
    private WebElement insuranceSelect;

    public void priceTransparencyNoIns(int zipCode) throws Exception {
        
        driver.get(apphomepageUrl);
        System.out.println("We're here");
        wait.until(ExpectedConditions.elementToBeClickable(pricetransparencyLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(priceestimatorButton)).click();


        //Go to Second Tab
        ArrayList<String> tabList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));
        
        labsLink.click();
        bloodsampleLink.click();
        routinelabLink.click();
        searchserviceResult.click();
        
        searchBar.click();
        searchBar.clear();
        
        String stringzipCode = String.valueOf(zipCode);
        searchBar.sendKeys(stringzipCode);
        searchBar.sendKeys(Keys.ENTER);
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div/section/div[2]/div/div[1]/div[1]/button/div/div/div[2]/p"))).click();
        insuranceSelect.click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu-']/div[3]/ul/li[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div/div[2]/button/span[1]"))).click();

    }
}
