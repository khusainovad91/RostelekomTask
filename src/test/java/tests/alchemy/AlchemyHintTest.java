package tests.alchemy;

import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.junit.Test;
import pages.AlchemyPage;
import tests.BaseTest;

public class AlchemyHintTest extends BaseTest {
    public AlchemyHintTest() {
        super("com.ilyin.alchemy", "com.ilyin.app_google_core.GoogleAppActivity");
    }

    AlchemyPage alchemyPage = new AlchemyPage();
    @Test
    public void HintTest() throws InterruptedException {
        Configuration.timeout = 90_000;
        var hintsAmountStart = alchemyPage.playButtonClick().AddHintClick().GetHintsAmount();
        alchemyPage.showAddClick().closeAdd();
        var hintsAmountEnd = alchemyPage.GetHintsAmount();

        Assert.assertEquals(Integer.parseInt(hintsAmountStart), Integer.parseInt(hintsAmountEnd) - 2);
    }
}
