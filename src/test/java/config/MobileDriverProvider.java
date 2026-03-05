package config;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;

import javax.annotation.Nonnull;
import java.net.URI;

public class MobileDriverProvider implements WebDriverProvider {
    private final String appPackage;
    private final String appActivity;

    public MobileDriverProvider(String appPackage, String appActivity) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
    }

    @Override
    public AndroidDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "13");
        caps.setCapability("deviceName", "Samsung S23 FE");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("udid", "RZCX92433ND");
        caps.setCapability("appPackage", appPackage);
        caps.setCapability("appActivity", appActivity);
        caps.setCapability("appWaitActivity", "*");
        caps.setCapability("noReset", false);
        caps.setCapability("autoGrantPermissions", true);

        try {
            return new AndroidDriver(URI.create("http://127.0.0.1:4723").toURL(), caps);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
