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
import java.util.List;

import static org.testng.Assert.assertTrue;

public class Login {

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
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    @Test(priority = 1)
    public void shouldLaunchApp() throws InterruptedException {

        Thread.sleep(3000); // wait for app to load

        System.out.println("App launched! Starting login flow...");

        // ---------------- PHONE NUMBER ----------------

        // Enter phone number
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.EditText")));
        phoneInput.sendKeys("7387984076");
        System.out.println("Phone number entered!");

        // Select checkbox
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.CheckBox")));
        checkbox.click();
        System.out.println("Checkbox selected!");

        // Click Login or Signup
        WebElement loginSignup = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.Button[@content-desc='Login Or Signup']")));
        loginSignup.click();
        System.out.println("Clicked Login/Signup!");

        // ---------------- OTP SECTION ----------------

        Thread.sleep(2000); // Wait for OTP screen

        List<WebElement> otpFields = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//android.widget.EditText")));

        otpFields.get(0).sendKeys("123456");
        System.out.println("OTP entered!");

        // Click Verify
        WebElement verifyBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.Button[@content-desc='Verify']")));
        verifyBtn.click();
        System.out.println("Clicked Verify!");

        // ---------------- PERMISSIONS ----------------

        Thread.sleep(1500);

        WebElement allowOnce = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.android.permissioncontroller:id/permission_allow_one_time_button")));
        allowOnce.click();
        System.out.println("Location permission granted!");
    }
}
