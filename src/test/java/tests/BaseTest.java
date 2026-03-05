package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.MobileDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    protected String appPackage;
    protected String appActivity;

    protected AndroidDriver driver;

    public BaseTest(String appPackage, String appActivity) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
    }

    @Before
    public void setUp() {
        Configuration.browser = new MobileDriverProvider(appPackage, appActivity).getClass().getName();
        Configuration.timeout = 10000;

        driver = new MobileDriverProvider(appPackage, appActivity).createDriver(null);
        WebDriverRunner.setWebDriver(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.terminateApp(appPackage);
        }
        Selenide.closeWebDriver();
    }
}
