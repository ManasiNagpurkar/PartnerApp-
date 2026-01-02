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

public class SetyourAvailability {

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
        dcap.setCapability("noReset", true);
        dcap.setCapability("ignoreHiddenApiPolicyError", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), dcap);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void editAvailability() throws Exception {

        System.out.println("App launched!");

        // --------- Open Availability Section ---------
        WebElement availabilitySection = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//android.widget.ScrollView/android.view.View[7]")
                ));
        availabilitySection.click();
        System.out.println("Availability section opened.");

        // --------- Select Date: Thursday, November 27, 2025 ---------
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Thursday, November 27, 2025")
        )).click();
        System.out.println("Selected date.");

        // --------- Click Start Time ---------
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Start time")
        )).click();
        System.out.println("Clicked Start time.");

        // --------- Confirm Start Time ---------
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK")
        )).click();
        System.out.println("Start time saved.");

        // --------- Click End Time ---------
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("End time")
        )).click();
        System.out.println("Clicked End time.");

        // --------- Click Dismiss (first button inside popup) ---------
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.View[@content-desc='Dismiss']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[1]")
        )).click();
        System.out.println("Dismiss clicked.");

        // --------- Update Hour (dynamic locator) ---------
        WebElement hourField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.EditText[contains(@text,'5')]")
        ));
        hourField.clear();
        hourField.sendKeys("6");
        System.out.println("Hour updated.");

        // --------- Update Minute (dynamic locator → picks ANY minute value) ---------
        WebElement minuteField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.EditText[@index='2']")
        ));
        minuteField.clear();
        minuteField.sendKeys("35"); // change as needed
        System.out.println("Minute updated.");

        // --------- Confirm End Time ---------
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK")
        )).click();
        System.out.println("End time saved.");

        // --------- Save Availability ---------
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Save Availability")
        )).click();
        System.out.println("Save Availability clicked.");

        // --------- Submit ---------
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Submit")
        )).click();
        System.out.println("Submit clicked.");

        // --------- Close ---------
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Close")
        )).click();
        System.out.println("Close clicked.");
    }
}
