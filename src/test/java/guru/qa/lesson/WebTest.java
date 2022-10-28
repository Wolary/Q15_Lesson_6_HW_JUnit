package guru.qa.lesson;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

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

