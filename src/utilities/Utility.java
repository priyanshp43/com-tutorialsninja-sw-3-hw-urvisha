package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    // This method will click on element

    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();

    }

    /**
     * This Method will get text from element
     */

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * this method will send text on element
     */

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    // selectByVisibleTextFromDropDown(By by , String text)
    public static void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    //mouseHoverToELementAndClick(By by){}
    public void mouseHoverAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).click().perform();

    }

    /**
     * This method will compare actual result and expected result
     */
    public void assertVerifyText(String expectedText, By by) {
        Assert.assertEquals(expectedText, driver.findElement(by).getText());
    }
}
