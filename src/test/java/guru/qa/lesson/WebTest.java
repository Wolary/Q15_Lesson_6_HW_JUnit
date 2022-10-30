package guru.qa.lesson;

import com.codeborne.selenide.CollectionCondition;
import guru.qa.lesson.Data.Locale;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;


public class WebTest {

    //ТЕСТОВЫЕ ДАННЫЕ ["Selenide", "JUnit"]

    @ValueSource(strings = {"Selenide", "JUnit"}) //работает только со стрингами и примитивными типами данных
    @ParameterizedTest(name = "Проверка числа результатов поиска в яндексе для запроса {0}")
        //[test_data] == (String Data)
    void yaSearchCommonTest(String testData) {
        open("https://ya.ru");
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$("li.serp-item")
                .shouldHave(CollectionCondition.size(10))
                .first()
                .shouldHave(text(testData));
    }

    @CsvSource(value = {
            "Selenide | - Selenide - это фреймворк для автоматизированного тестирования",
            "JUnit | - JUnit is a unit testing framework for the Java"
    },
            delimiter = '|') // вводим разделитель по умолчанию запятая

    @ParameterizedTest(name = "Проверка числа результатов поиска в яндексе для запроса {0}")
    void yaSearchCommonTestDifferentExpectedText(String searchQuery, String expectedText) {
        open("https://ya.ru");
        $("#text").setValue(searchQuery);
        $("button[type='submit']").click();
        $$("li.serp-item")
                .shouldHave(CollectionCondition.size(10))
                .first()
                .shouldHave(text(expectedText));
    }


//    static Stream<Arguments> selenideSiteButtonTest() {
//        return Stream.of(
//                Arguments.of(List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes"), Locale.EN),
//                Arguments.of(List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"), Locale.RU)
//        );
//    }
//
//    @MethodSource()
//    @ParameterizedTest(name ="проверка отображения кнопок для локали : {1}")
//    void selenideSiteButtonTest(List<String> buttonsTest, Locale locale) {
//        open("https://selenide.org");
//        $$("#languages a").find(text(locale.name())).click();
//        $$(".main-menu-pages a").filter(visible)
//                .shouldHave(CollectionCondition.texts(buttonsTest));
//    }
//
//    @EnumSource(Locale.class)
//    @ParameterizedTest
//    void checkLocal(Locale locale){
//        open("https://selenide.org");
//        $$("#languages a").find(text(locale.name())).shouldHave(text(locale));
//    }



    // тесты до параметризированного
//    @Test
//    void yaSearchSelenideTest() {
//        open("https://ya.ru");
//        $("#text").setValue("selenide");
//        $("button[type='submit']").click();
//        $$("li.serp-item")
//                .shouldHave(CollectionCondition.size(10))
//                .first()
//                .shouldHave(text("selenide"));
//    }

//
//    @Test
//    void yaSearchJUnitTest() {
//        open("https://ya.ru");
//        $("#text").setValue("junit");
//        $("button[type='submit']").click();
//        $$("li.serp-item")
//                .shouldHave(CollectionCondition.size(10))
//                .first()
//                .shouldHave(text("junit"));
//    }
//
}

