package archive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex10StringLengthTest {

    @Test
    /* В рамках этой задачи с помощью JUnit необходимо написать тест, который проверяет длину переменной типа String
     с помощью любого выбранного метода assert.
    Если текст длиннее 15 символов, то тест должен проходить успешно. Иначе падать с ошибкой.*/
    public void testStringLength() {
        String testString = "length < 15";
        assertTrue(testString.length() > 15, "Unexpected string length: " + testString.length());
    }
}
