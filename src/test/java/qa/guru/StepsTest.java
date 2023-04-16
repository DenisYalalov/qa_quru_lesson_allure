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
import static io.qameta.allure.Allure.step;

public class StepsTest {


    private static final String REPOSITORY = "suzeyu1992/repo";
    private static final int ISSUE = 15;

    @Feature("Issue в репозитории")
    @Story("Проверка Issue")
    @Owner("Yalalov")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Чистый Selenide (с Listener)")
    @Test
    public void testSteps() {


        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Opening the main page", () -> {
            open("https://github.com/");
        });
        step("Looking for a repository" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Click on the repository link" + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Open the Issue tab", () -> {
            $("#issues-tab").click();
        });
        step("check for Issue number" + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });


    }
    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openingTheMainPage();
        steps.lookingForRepository(REPOSITORY);
        steps.clickOnTheRepositoryLink(REPOSITORY);
        steps.openTheIssueTab();
        steps.checkForIssueNumber(ISSUE);
    }


}

