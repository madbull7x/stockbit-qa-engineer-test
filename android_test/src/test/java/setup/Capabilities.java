package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Capabilities {
    public AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void preparation() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "12");
            caps.setCapability("appium:deviceName", "emulator-5554");
            caps.setCapability("appium:automationName", "UiAutomator2");
            caps.setCapability("appium:appWaitPackage", "com.saucelabs.mydemoapp.android");
            caps.setCapability("appium:appWaitActivity", "com.saucelabs.mydemoapp.android.view.activities.MainActivity");
            caps.setCapability("appium:app", "https://github.com/saucelabs/my-demo-app-android/releases/download/1.0.13/mda-1.0.13-15.apk");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<>(url, caps);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        } catch (Exception e) {
            System.out.println("Cause : " + e.getCause());
            System.out.println("Message : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterTest
    public void teardown() {
        driver.closeApp();
        driver.quit();
    }
}
