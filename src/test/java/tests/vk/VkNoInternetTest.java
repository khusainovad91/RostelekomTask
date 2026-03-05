package tests.vk;


import io.appium.java_client.android.connection.ConnectionStateBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.VkVideoPage;
import tests.BaseTest;

public class VkNoInternetTest extends BaseTest {

    public VkNoInternetTest() {
        super("com.vk.vkvideo", "com.vk.video.screens.main.MainActivity");
    }

    VkVideoPage videoPage = new VkVideoPage();

    @Before
    public void setUp() {
        super.setUp();
        driver.setConnection(new ConnectionStateBuilder().withAirplaneModeEnabled().build());
    }

    @Test
    public void testVideoOffline() {
        videoPage.getOfflineText();
    }

    @After
    public void tearDown() {
        driver.setConnection(new ConnectionStateBuilder().withAirplaneModeDisabled().build());
        super.tearDown();
    }

}
