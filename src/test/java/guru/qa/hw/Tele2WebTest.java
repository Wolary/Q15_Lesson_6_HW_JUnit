package guru.qa.hw;

import com.codeborne.selenide.Configuration;
import guru.qa.hw.Data.Local;
import guru.qa.lesson.Data.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Tele2WebTest {

    String site = "https://tele2.ru/";

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        //  Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Проверка доступности сайта")
    void tele2SiteOpen() {
        open(site);
        $("#darkLogoFill").shouldBe(visible);
    }

    @ValueSource(strings = {"Xiaomi", "Samsung", "iPhone"})
    @ParameterizedTest(name = "Проверка результатов поиска в строке запроса {0}")
    void tele2SearchTest(String searchData) {
        open(site);
        $(".header-navbar-search").click();
        $("#search-text").setValue(searchData).pressEnter();
        $(".search-results__items").shouldHave(text(searchData));
    }

    @CsvSource(value = {
            "Xiaomi | Как получить скидку 15% на товары на Xiaomi?",
            "Note | Чем отличаются серии смартфонов"
    },
            delimiter = '|')
    @ParameterizedTest(name = "Проверяем текст в плашке {0}")
    void tele2SearchTestCsv(String searchQuery, String expText) {
        open(site);
        $(".header-navbar-search").click();
        $("#search-text").setValue(searchQuery).pressEnter();
        $(".search-results__items").shouldHave(text(expText));
    }

    @EnumSource(Local.class)
    @ParameterizedTest
    void checkLocal(Local locale) {
        open("https://selenide.org");
        $$("#languages").find(text(locale.name())).shouldBe(visible);
    }
}