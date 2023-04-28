package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class AmazonTest extends Utility {

    @Before
    public void setUp() {
        openBrowser("https://www.amazon.co.uk/");
    }

    @Test

    public void amazonTest() {
        // Clicking on accept cookies
        clickOnElement(By.id("sp-cc-accept"));
        // Locating search bar and typing text
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");
        // Clicking on search field
        clickOnElement(By.id("nav-search-submit-button"));
        // Clicking on Dell check box
        clickOnElement(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));
        // Getting the list of items and storing in list type
        List<WebElement> dellList = driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//a/span[contains(text(),'Dell')]"));
        // Verify total number of items displayed is 30
        verifyNumberFromElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//a/span[contains(text(),'Dell')]"), 30);
        // Iterate the item list and print the product names
        for (WebElement d : dellList) {
            System.out.println(d.getText());
        }
        // Find and click Dell Latitude 5430
        clickOnElement(By.xpath("//span[normalize-space()='Dell Latitude 5430 14.0 inch FHD Business Laptop, Intel Core i7-1265U, 16GB RAM, 256GB SSD, Windows 11 Pro, Grey']"));
        // Verifying the product text
        verifyText(By.xpath("//span[@id='productTitle']"), "Dell Latitude 5430 14.0 inch FHD Business Laptop, Intel Core i7-1265U, 16GB RAM, 256GB SSD, Windows 11 Pro, Grey");
    }

    @After
    public void tearDown() {
        closeBrowser(); //close browser
    }
}
