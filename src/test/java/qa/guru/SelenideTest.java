package qa.guru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    @Feature("Issue в репозитории")
    @Story("Проверка Issue")
    @Owner("Yalalov")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Чистый Selenide (с Listener)")
    @Test
    public void searchIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("suzeyu1992/repo");
        $(".header-search-input").submit();
        $(By.linkText("suzeyu1992/repo")).click();
        $("#issues-tab").click();
        $(withText("#15")).should(Condition.exist);

    }


}

