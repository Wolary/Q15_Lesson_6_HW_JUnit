package guru.qa.lesson;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WebTest {

    //ТЕСТОВЫЕ ДАННЫЕ ["Selenide", "JUnit"]

    @ValueSource(strings = {"Selenide", "JUnit"})
    @ParameterizedTest (name = "Проверка числа результатов поиска в яндексе для запроса {0}")
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

