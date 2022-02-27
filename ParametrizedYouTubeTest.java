package guru.qa;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ParametrizedYouTubeTest {

    @BeforeEach
    void precondition() {
        Selenide.open("https://youtube.com/");
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @CsvSource(value = {
            "rick roll, Never Gonna Give You Up (Official Music Video)",
            "за себя и за сашку, [BadComedian] - Движение Вверх"
    })
    @ParameterizedTest(name = "Проверка отображения поисковых результатов в YouTube для запроса \"{0}\"")
    void YouTubeSearchTest(String testData, String expectedText) {
        Selenide.$("#search").click();
        Selenide.$("#search").setValue(testData).pressEnter();
        Selenide.$$("#contents").find(text(expectedText)).shouldBe(visible);
    }

}