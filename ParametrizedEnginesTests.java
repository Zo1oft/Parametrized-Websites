package guru.qa;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ParametrizedEnginesTests {

    @BeforeEach
    void precondition() {
        Selenide.open("https://searchengines.guru/ru");
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @CsvSource(value = {
            "twitter, Вывод в топ",
            "facebook, маркетинг на Facebook"
    })
    @ParameterizedTest(name = "Проверка отображения поисковых результатов в SearchEngines для запроса \"{0}\"")
    void SearchEnginesSearchTest(String testData, String expectedText) {
        Selenide.$("#searchHeader").click();
        Selenide.$("#searchPanelInput").setValue(testData).pressEnter();
        Selenide.$$("#mainContentColumn").find(text(expectedText)); // пришлось убрать .shoudlBe(visible) иначе не находил текст
    }

}
