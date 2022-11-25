package pages.mobile;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    @Step("Search Wikipedia by value {value}")
    public SearchPage searchContent(String value) {
        $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
        $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(value);
        return this;
    }

    @Step("Verify size of the searching result")
    public void checkContentIsNotEmpty() {
        $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    @Step("Keyword appears in search results")
    public void checkContentIsDisplayed() {
        $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                .findBy(Condition.text("Appium")).shouldBe(Condition.visible);
    }
}
