package pages.web;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class PricePage {

    @Step("Check that plan with name {name} is exist")
    public PricePage checkPlans(String name, String description) {
      $$(".plan-container")
              .findBy(Condition.text(name))
              .shouldHave(Condition.text(description));
      return this;
    }
}
