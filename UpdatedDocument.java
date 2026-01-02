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

public class UpdatedDocument {

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

        // ----------------------------------------------
        // 1️⃣ Click top-right button after launch
        // ----------------------------------------------
        WebElement launchButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]")
        ));
        launchButton.click();
        System.out.println("Top-right button clicked.");

        // ----------------------------------------------
        // 2️⃣ Click Update Documents
        // ----------------------------------------------
        WebElement updateDocs = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Update Documents")
        ));
        updateDocs.click();
        System.out.println("Update Documents opened.");

        // ----------------------------------------------
        // 3️⃣ Allow permission popup
      

        // ----------------------------------------------
        // 4️⃣ Click Upload Identification proofs
        // ----------------------------------------------
        WebElement uploadProofs = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Upload Identification proofs")
        ));
        uploadProofs.click();
        System.out.println("Identification proofs section opened.");

        // ----------------------------------------------
        // 5️⃣ View Aadhar Card (1st View)
        // ----------------------------------------------
        WebElement viewAadhar = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//android.view.View[@content-desc=\"View\"])[1]")
        ));
        viewAadhar.click();
        System.out.println("Aadhar viewed.");
        Thread.sleep(4000);

        // Close
        WebElement closeAadhar = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Close")
        ));
        closeAadhar.click();
        System.out.println("Aadhar closed.");

        // ----------------------------------------------
        // 6️⃣ View PAN Card (2nd View)
        // ----------------------------------------------
        WebElement viewPAN = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//android.view.View[@content-desc=\"View\"])[2]")
        ));
        viewPAN.click();
        System.out.println("PAN viewed.");
        Thread.sleep(4000);

       
        driver.navigate().back(); // Back
        System.out.println("Back from PAN view.");

        // ----------------------------------------------
        // 7️⃣ View Selfie (3rd View)
        // ----------------------------------------------
        WebElement viewSelfie = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//android.view.View[@content-desc=\"View\"])[3]")
        ));
        viewSelfie.click();
        System.out.println("Selfie viewed.");

        driver.navigate().back(); // Back
        System.out.println("Back from selfie.");

        // ----------------------------------------------
        // 8️⃣ Click Back (main back button)
        // ----------------------------------------------
        WebElement backBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Back")
        ));
        backBtn.click();
        System.out.println("Back clicked. Process completed!");
    }
}
