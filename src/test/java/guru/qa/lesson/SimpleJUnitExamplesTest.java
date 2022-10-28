package guru.qa.lesson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


// @Disabled отключает все тесты

public class SimpleJUnitExamplesTest {

    // @Disabled ("JAVASERVER-2345") отключает тест в скобках добавляются коментарии с ID бага
    @Test
    void simpleTest() {
//        Assertions.assertTrue(); проверяет состояние булеана если вернуло тру то тест зеленый
//        Assertions.assertFalse(); то же самое если вернулось фолс
//        Assertions.assertEquals(); обьекты или примитивы возвращает тру (эквивалентны)
//        Assertions.assertFall(); cпециально уронить тест
    }

    @DisplayName("Check that profile test...")    // нужно добавлять описание тестов, но не забывать нормально называть void понятным образом
    @Test
    void simpleTest1() {

    }

    @Test
    void simpleTest2() {
    }
}
