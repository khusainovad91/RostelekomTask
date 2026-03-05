package pages;

import javax.annotation.OverridingMethodsMustInvokeSuper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class AlchemyPage {
    private final String playButton = "//*[@text='Играть']";
    private final String addHint = "//x2.f1/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[2]";
     private final String hintsAmount = "//*[@text='Ваши подсказки']/following-sibling::android.view.View/android.widget.TextView";
    private final String showAdd = "//android.widget.TextView[@text=\"Смотреть\"]";

    private final String skipAdd = "//android.widget.TextView[@resource-id=\"m-playable-skip\"]";
    private final String closeAdd = "//android.widget.TextView[@resource-id=\"m-playable-close\"]";

    public AlchemyPage playButtonClick() {
        $x(playButton).click();
        return this;
    }

    public AlchemyPage AddHintClick() throws InterruptedException {
        $x("//*[text()[contains(., 'Здравствуйте')]]").should(disappear);
        $x(addHint).shouldBe(visible).shouldBe(clickable).click();
        return this;
    }

    public String GetHintsAmount() { return $x(hintsAmount).getText(); }

    public AlchemyPage showAddClick() {
        $x(showAdd).shouldBe(interactable).click();
        return this;
    }

    public AlchemyPage closeAdd() {
        $x(skipAdd).shouldBe(visible, Duration.ofSeconds(90)).click();
        $x(closeAdd).shouldBe(visible, Duration.ofSeconds(90)).click();
        return this;
    }

}
