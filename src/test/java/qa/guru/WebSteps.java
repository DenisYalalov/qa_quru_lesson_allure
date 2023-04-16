package qa.guru;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openingTheMainPage() {
        open("https://github.com/");

    }

    @Step("Ищем репозиторий {repo}")
    public void lookingForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();

    }
    @Step("Кликаем по ссылке репозитория{repo}")
    public void clickOnTheRepositoryLink(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("открываем таб issue")
    public void openTheIssueTab() {
        $("#issues-tab").click();
    }

    @Step("проверяем на наличие Issue с номером {issue}")
    public void checkForIssueNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }
}
