package tests.vk;

import org.junit.Assert;
import org.junit.Test;
import pages.VkVideoPage;
import tests.BaseTest;

public class VkTest extends BaseTest {
    public VkTest() {
        super("com.vk.vkvideo", "com.vk.video.screens.main.MainActivity");
    }
    VkVideoPage videoPage = new VkVideoPage();
    @Test
    public void videoShouldPlay() {
        boolean isPlaying = videoPage
                .waitForVideoPlayer()
                .videoClick()
                .videoClick()
                .isVideoPlaying();

        Assert.assertTrue(isPlaying);
    }
}
