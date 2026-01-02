package partner_app.partner;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class AppTest {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities dcap = new DesiredCapabilities();
        dcap.setCapability("platformName", "Android");
        dcap.setCapability("deviceName", "vivo Y21A");
        dcap.setCapability("appium:automationName", "UiAutomator2");

        dcap.setCapability("appium:appPackage", "com.partner.hv_partner_app");
        dcap.setCapability("appium:appActivity", "com.partner.hv_partner_app.MainActivity");

        dcap.setCapability("noReset", true);
        dcap.setCapability("ignoreHiddenApiPolicyError", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), dcap);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test(priority = 1)
    public void shouldLaunchApp() {

        boolean appLaunched = driver.findElements(AppiumBy.accessibilityId("Sign In")).size() > 0;

        assertTrue(appLaunched, "Partner App did not launch properly!");
        System.out.println("Partner App launched successfully!");
    }
}