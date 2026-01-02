package partner_app.partner;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Hamburger1 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities dcap = new DesiredCapabilities();
        dcap.setCapability("platformName", "Android");
        dcap.setCapability("deviceName", "vivo Y21A");
        dcap.setCapability("automationName", "UiAutomator2");

        dcap.setCapability("appPackage", "com.partner.hv_partner_app");
        dcap.setCapability("appActivity", "com.partner.hv_partner_app.MainActivity");

        dcap.setCapability("noReset", true); // already logged in
        dcap.setCapability("ignoreHiddenApiPolicyError", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), dcap);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test(priority = 1)
    public void shouldLaunchApp() throws InterruptedException {

        // App launched check
        boolean appLaunched = driver.findElements(By.xpath("//android.view.View")).size() > 0;
        assertTrue(appLaunched, "App did not launch properly!");
        System.out.println("App launched!");

        // -------------------- CLICK HAMBURGER MENU --------------------
        WebElement hamburger = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]")
        ));
        hamburger.click();
        System.out.println("Hamburger menu clicked!");

        // -------------------- CLICK 'HELLO MANASI...' --------------------
        WebElement helloManasi = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Hello Manasi\nYou are a few steps away from completing your profile.")
        ));
        helloManasi.click();
        System.out.println("Clicked: Hello Manasi section!");

        // -------------------------------------------------------------
        // ------------------ PROFILE EDIT STARTS HERE ------------------
        // -------------------------------------------------------------

     // FIRST NAME EDIT (using index-based stable xpath)
     // ----------- UPDATE FIRST NAME -------------
        WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//android.widget.EditText)[1]")
        ));
        firstName.click();
        firstName.clear();
        Thread.sleep(600);
        firstName.sendKeys("Mana");
        System.out.println("First name updated!");

        // small wait so UI settles
        Thread.sleep(1200);

        // ----------- UPDATE LAST NAME -------------
        WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//android.widget.EditText)[2]")
        ));
        lastName.click();
        lastName.clear();
        Thread.sleep(600);
        lastName.sendKeys("Pawar");
        System.out.println("Last name updated!");



        // GENDER CHANGE - Select Male
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Female"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Male"))).click();
        System.out.println("Gender changed to Male!");

        // BIRTHDATE CLICK
     // -------------------- UPDATE DOB --------------------

     // Click DOB field
     WebElement dobField = wait.until(ExpectedConditions.elementToBeClickable(
             By.xpath("//android.view.View[@text='27-07-2002']")
     ));
     dobField.click();
     System.out.println("DOB field opened!");

     // Click Select Date button inside date picker
     WebElement selectDateBtn = wait.until(ExpectedConditions.elementToBeClickable(
             By.xpath("//android.view.View[@content-desc='Select date\nTue, Nov 25']/android.view.View/android.widget.Button")
     ));
     selectDateBtn.click();
     System.out.println("Date Picker select button clicked!");

     // Select DOB EditText and enter new date
     WebElement dobInput = wait.until(ExpectedConditions.elementToBeClickable(
             By.xpath("//android.widget.EditText[@text='11/25/2025']")
     ));
     dobInput.clear();
     dobInput.sendKeys("07/18/2002");
     System.out.println("New DOB entered!");

     // Click OK button
     WebElement okBtn = wait.until(ExpectedConditions.elementToBeClickable(
             AppiumBy.accessibilityId("OK")
     ));
     okBtn.click();
     System.out.println("DOB updated successfully!");


        // PROFILE PHOTO CLICK
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]")
        )).click();

        // SELECT GALLERY
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Gallery"))).click();

        // SELECT FIRST PHOTO
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//android.widget.ImageView[@resource-id='com.google.android.providers.media.module:id/icon_thumbnail'])[1]")
        )).click();

        // CLICK 'UPDATE NOW'
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Update Now")
        )).click();

        System.out.println("Profile updated successfully!");
     // -------------------- CLICK CLOSE BUTTON --------------------
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Close")
        ));
        closeBtn.click();
        System.out.println("Closed successfully!");
    }
}
