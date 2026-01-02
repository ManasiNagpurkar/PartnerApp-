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

public class DeleteAvailability {

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
    public void deleteAvailabilitySlot() throws Exception {

        System.out.println("App Launched!");

        // --------- STEP 1: Select weekly availability ---------
        WebElement weeklySlot = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.View[@content-desc='Wed, Nov 26 every week']")
        ));
        weeklySlot.click();
        System.out.println("Weekly slot opened.");

        // --------- STEP 2: Select specific time slot ---------
        WebElement timeSlot = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("1. 5:30 PM - 6:30 PM")
        ));
        timeSlot.click();
        System.out.println("Time slot selected.");

        // --------- STEP 3: Click delete button ---------
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Delete")
        ));
        deleteBtn.click();
        System.out.println("Delete clicked.");

        // --------- STEP 4: Confirm delete if popup appears ---------
        try {
            WebElement okConfirm = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.accessibilityId("OK")
            ));
            okConfirm.click();
            System.out.println("Delete confirmed.");
        } catch (Exception e) {
            System.out.println("No confirmation popup found.");
        }
    }
}
