package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php?";

    //Open Browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        // 1.1 Mouse hover on the Laptops & Notebooks Tab. and click
        mouseHoverAndClick(By.linkText("Laptops & Notebooks"));
        // 1.2 Click on “Show AllLaptops & Notebooks”
        clickOnElement(By.linkText("Show AllLaptops & Notebooks"));
        // 1.3 Select the Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        // 1.4 Verify the Product price will be arranged in High to Low orders.
        List<WebElement> priceList = driver.findElements(By.xpath("//div[@id='content']//div[contains(@class, 'price')]"));
        List<Double> actualPriceList = new ArrayList<>();
        for (WebElement e : priceList) {
            String price = e.getText().split("\n")[0].replace("$", "").replace(",", "").trim();
            actualPriceList.add(Double.parseDouble(price));
        }
        System.out.println("Actual Price List: " + actualPriceList);
        List<Double> expectedPriceList = new ArrayList<>(actualPriceList);
        Collections.sort(expectedPriceList, Collections.reverseOrder());

        System.out.println("Expected Price List (sorted): " + expectedPriceList);
        Assert.assertEquals(expectedPriceList, actualPriceList);
    }


    @Test
    public void verifyThatUserPlaceOrderSuccessfully()  {

        //  2.1 Mouse hover on the Laptops & Notebooks Tab and click
        mouseHoverAndClick(By.linkText("Laptops & Notebooks"));
        //  2.2 Click on the “Show AllLaptops & Notebooks”
        clickOnElement(By.linkText("Show AllLaptops & Notebooks"));
        //  2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        //  2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//body//div[@id='product-category']//div[@class='row']//div[@class='row']//div[4]//div[1]//div[2]//div[1]//h4[1]//a[1]"));
        // 2.5 Verify the text “MacBook”
        assertVerifyText("MacBook", By.xpath("//h1[normalize-space()='MacBook']"));
        // 2.6 Click on the ‘Add To Cart’ button
        clickOnElement(By.id("button-cart"));
        // 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        assertVerifyText("Success: You have added MacBook to your shopping cart!\n×", By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        // 2.8 Click on the link “shopping cart” display into the success message
        clickOnElement(By.linkText("shopping cart"));
        // 2.9 Verify the text "Shopping Cart"
        assertVerifyText("Shopping Cart  (0.00kg)", By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        // 2.10 Verify the Product name "MacBook"
        assertVerifyText("MacBook", By.linkText("MacBook"));
        // 2.11 Change the Quantity "2"
        WebElement qtyField = driver.findElement(By.cssSelector("input[value='1']"));
        qtyField.clear();
        qtyField.sendKeys("2");
        // 2.12 Click on the “Update” Tab
        clickOnElement(By.xpath("//button[@type='submit']"));
        // 2.13 Verify the message “Success: You have modified your shopping cart!”
        assertVerifyText("Success: You have modified your shopping cart!\n×", By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        // 2.14 Verify the Total £737.45
        mouseHoverAndClick(By.xpath("//span[normalize-space()='Currency']"));
        mouseHoverAndClick(By.name("GBP"));
        assertVerifyText("£737.45", By.xpath("//tbody//tr//td[6]"));
        // 2.15 Click on the “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
        // 2.16 Verify the text “Checkout”
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
