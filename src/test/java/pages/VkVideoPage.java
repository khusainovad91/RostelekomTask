package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class VkVideoPage {
    private final String subtitlesButton =
            "//android.widget.FrameLayout[@resource-id='com.vk.vkvideo:id/video_subtitles']";

    private final String pauseButton =
            "//android.widget.ImageView[@content-desc='Пауза']";

    private final String offlineText =
            "//android.widget.TextView[@text='Офлайн-режим']";

    public VkVideoPage waitForVideoPlayer() {
        $x(subtitlesButton).shouldBe(visible);
        return this;
    }

    public VkVideoPage videoClick() {
        $x(subtitlesButton).click();
        return this;
    }

    public boolean isVideoPlaying() {
        return $x(pauseButton).shouldBe(visible).exists();
    }

    public boolean getOfflineText() {
        return $x(offlineText).shouldBe(visible).exists();
    }
}
