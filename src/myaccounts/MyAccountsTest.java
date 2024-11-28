package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    // create a method with the name "selectMyAccountOptions()" It has one parameter name "option" of type string and This method should click on the options of whatever name is passed as a parameter.
    public void selectMyAccountOptions(String option) {
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a"));
        for (WebElement element : options) {
            if (element.getText().equalsIgnoreCase(option)) {
                element.click();
                break;
            }
        }
    }
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        // 1.1 Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        // 1.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        // 1.3 Verify the text “Register Account”
        assertVerifyText("Register Account", By.xpath("//h1[normalize-space()='Register Account']"));
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        // 2.1 Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        // 2.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        // 2.3 Verify the text “Returning Customer”
        assertVerifyText("Returning Customer", By.xpath("//h2[normalize-space()='Returning Customer']"));
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        // 3.1 Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        // 3.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        // 3.3 Enter the First Name
        sendTextToElement(By.name("firstname"), "Urvi");
        // 3.4 Enter the Last Name
        sendTextToElement(By.name("lastname"), "P");
        // 3.5 Enter the Email
        sendTextToElement(By.name("email"), "999harsh@gmail.com");
        // 3.6 Enter the Telephone
        sendTextToElement(By.name("telephone"), "07123456789");
        // 3.7 Enter the Password
        sendTextToElement(By.name("password"), "123456");
        // 3.8 Enter the Password Confirm
        sendTextToElement(By.name("confirm"), "123456");
        // 3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        // 3.10 Click on the Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        // 3.11 Click on the Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        // 3.12 Verify the message “Your Account Has Been Created!”
        assertVerifyText("Your Account Has Been Created!", By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        // 3.13 Click on the Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        // 3.14 Click on the My Account Link.
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']"));
        // 3.15 Call the method “selectMyAccountOptions()” method and pass the parameter “Logout”
        //  selectMyAccountOptions("Logout");
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']"));
        // 3.16 Verify the text “Account Logout”
        assertVerifyText("Account Logout", By.xpath("//h1[normalize-space()='Account Logout']"));
        // 3.17 Click on the Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        // 4.1 Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        // 4.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        // 4.3 Enter the Email address
        sendTextToElement(By.name("email"), "999harsh@gmail.com");
        // 4.4 Enter the Last Name (There is no option for Last Name!)
        // 4.5 Enter the Password
        sendTextToElement(By.id("input-password"), "123456");
        // 4.6 Click on the Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        // 4.7 Verify text “My Account”
        assertVerifyText("My Account", By.xpath("//h2[normalize-space()='My Account']"));
        // 4.8 Click on the My Account Link.
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']"));
        // 4.9 Call the method “selectMyAccountOptions()” method and pass the parameter “Logout”
        // selectMyAccountOptions("Logout");
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']"));
        // 4.10 Verify the text “Account Logout”
        assertVerifyText("Account Logout", By.xpath("//h1[normalize-space()='Account Logout']"));
        // 4.11 Click on the Continue button
        clickOnElement(By.linkText("Continue"));
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
